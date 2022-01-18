package Metodos;

import java.io.*;

public class EscribeFichero
{
	
	public  void escribir(String texto, int vueltas) {
		    FileWriter fichero = null;
	        PrintWriter pw = null;
	        try
	        {//busca el fichero para escribir en el
	            fichero = new FileWriter("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\prueba.txt");
	        	pw = new PrintWriter(fichero);
	        	//escribe incrementado en numero el texto introducido, 
	            for (int i = 0; i <= vueltas; i++)
	                pw.println(texto +i+"\n          ");

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           // Nuevamente aprovechamos el finally para 
	           // asegurarnos que se cierra el fichero.
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
	}
   
       
    
}
