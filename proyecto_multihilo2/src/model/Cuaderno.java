package model;

import Metodos.EscribeFichero;
import Metodos.LeeFichero;

public class Cuaderno {
	private boolean listo = true;
	private LeeFichero lf = new LeeFichero();
	private EscribeFichero ef = new EscribeFichero();

	public synchronized void escribir(int i) {
		//la funcion espera a la funcion leer para escribir en el fichero
		while (listo == true) {
			try { // Esperar a escribir
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Escribiendo: " + i + "\n");//se muestra por pantalla para saber que accion se esta realizando
		ef.escribir("Articulo ", i);
		listo = true;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notifyAll();
	}

	public synchronized void leer(int i) {
		//la funcion espera a que se termine de escribir para poder leer lo escrito
		while (listo == false) {
			try {
				// Esperar a leer
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("leyendo " + i + ":\n");//se muestra por pantalla para saber que accion se esta realizando
		lf.leer();
		listo = false;
		notifyAll();
	}

}
