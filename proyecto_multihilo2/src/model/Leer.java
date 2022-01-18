package model;

import Metodos.LeeFichero;

public class Leer extends Thread {
	private Cuaderno cuaderno;
	private LeeFichero lf = new LeeFichero();

	public Leer(Cuaderno cuaderno) {
		this.cuaderno = cuaderno;
	}

	public void run() {
		//cuando se llama al hilo se ejecuta el siguiente bucle

		for (int i = 0; i <=5; i++) {
			//este bucle se ejecuta siempre mas beses que la escritura para ver el resultado final
			cuaderno.leer(i);
			
			
		}
	}
}
