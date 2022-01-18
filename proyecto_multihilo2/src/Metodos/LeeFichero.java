package Metodos;

import java.io.*;

public class LeeFichero {

	public  void leer() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder hacer una
			// lectura comoda (disponer del metodo readLine()).
			
            archivo = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\prueba.txt");
            //en caso de no existir un fichero con ese nombre se crea uno y se muestra por pantalla lo siguiente
            if(!archivo.exists()) {
    			System.out.println("+------------+");
            	System.out.println("|            |");
            	System.out.println("|            |");
    			System.out.println("+------------+");

            }else {
            	fr = new FileReader(archivo);
    			br = new BufferedReader(fr);
    			// Lectura del fichero
    			String linea;
    			System.out.println("+------------+");
    			while ((linea = br.readLine()) != null)
    				System.out.println("| "+linea+" |");
    			System.out.println("+------------+\n\n");
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos que se cierra tanto si
			// todo va bien como si salta una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
}