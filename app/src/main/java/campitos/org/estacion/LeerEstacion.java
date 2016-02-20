package campitos.org.estacion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



/**
 * Created by campitos on 10/02/16.
 */
public class LeerEstacion {

    public String leer()throws Exception{

        String informacion="nada";
        boolean encontrada=false;

        URL url=new URL("http://www.weatherlink.com/user/sierraguadalupe/index.php?view=summary&headers=0");
        HttpURLConnection con= (HttpURLConnection) url.openConnection();
         InputStreamReader in= new InputStreamReader(con.getInputStream());
        BufferedReader reader=new BufferedReader(in);


        StringBuilder builder=new StringBuilder();
        int ch;
        int lineas=0;
        String lineaActual;
        String lineaBuscada="nada";
        while ((lineaActual=reader.readLine())!=null){


            if(encontrada && lineas<=1){
                lineas++;
                lineaBuscada=lineaActual;
            }
            if(lineaActual.contains("Outside Temp")){
                encontrada=true;
                System.out.println("encontrada!!!");


            }
        }
        informacion="Lineas:"+lineas;
        System.out.println("maloooo"+lineaBuscada);
        return informacion;
    }
}
