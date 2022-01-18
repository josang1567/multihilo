package model;

import Metodos.EscribeFichero;

public class Escribir extends Thread {
	private Cuaderno cuaderno;
	private EscribeFichero ef= new EscribeFichero();
	public Escribir(Cuaderno cuaderno) {
		this.cuaderno = cuaderno;
	}

	public void run() {
		//cuando se llama al hilo se ejecuta el siguiente bucle
		for (int i = 0; i <5; i++) {
			cuaderno.escribir(i);
			
		}
	}

	
}
