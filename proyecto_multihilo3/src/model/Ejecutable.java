package model;

public class Ejecutable {
	public static void main(String[] args) {
		Thread c1 = new Thread(new Hilo(), "1");
		Thread c2 = new Thread(new Hilo(), "2");
		Thread c3 = new Thread(new Hilo(), "3");
		// Iniciar el primer hilo inmediatamente
		c1.start();
		//El segundo cliente entra cuando el primer cliente ha terminado 
		try {

			c1.join();

		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		c2.start();
		//El tercer cliente entra cuando el segundo cliente ha terminado 
		try {

			c2.join();

		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

		c3.start();
		//Se muestra un mensaje cuando el tercer cliente termina
		try {

			c3.join();

		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

		//
		System.out.println("Los tres clientes han terminado su ejecución");
	}

}
