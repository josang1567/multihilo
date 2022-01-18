package model;

import java.util.Scanner;

public class Mesa {

	public static void main(String[] args) {
		System.out.println();
		Cuaderno c1 = new Cuaderno();
		Leer l = new Leer(c1);
		Escribir e = new Escribir(c1);
		
		
		l.start();
		e.start();

	}
}
