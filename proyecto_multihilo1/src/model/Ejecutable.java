package model;

import java.util.Random;

public class Ejecutable {
	public static void main(String[] args) {
		Banco banco = new Banco();

		int tminllegadaP = 1;//tiempo minimo para la llegada de un cliente
		int tmaxllegadaP = 2;//tiempo Maximo para la llegada de un cliente
		
		
		int minCita = 10;//Duracion minima de la cita
		int maxCita = 50;//Duracion maxima de la cita
		
		int minSaldo = 40;//cantidad minima que se extrae
		int maxSaldo = 120;//cantidad maxima que se extrae

		System.out.println("<<<<Inicio simulacion banco>>>>>\n\n");
		Random r = new Random();
		int numpersona = 1;
		int contador = 3;
		//el programa funciona con un maximo de citas para emular el sistema actual en el cual para ser atendido tienes que pedir cita previa y cada dia hay un numero previsto
		while (contador!=0) {
			//generar el tiempo para la siguiente cita aleatoriamente
			int tParaNuevaCieta = tminllegadaP + r.nextInt(tmaxllegadaP - tminllegadaP + 1);
			//cantidad que el cliente va a extraer
			int saldoP = minSaldo + r.nextInt(maxSaldo + minSaldo + 1);
			System.out.printf("Siguiente persona en %d segundos.\nQueda%s %d persona%s \n\n", tParaNuevaCieta, contador!=1? "n":"", contador, contador!=1? "s":"");
			
			//espera a tiempo real para que llegue el siguiente cliente
			try {
				Thread.sleep(1000 * tParaNuevaCieta);
			} catch (InterruptedException ex) {
				System.out.println("**ERROR**");
			}
			Thread hilo = new Thread(new ClienteBanco(banco, ""+numpersona, saldoP, minSaldo, maxSaldo));
			hilo.start();
			numpersona++;
			contador--;
		}
	}
}
