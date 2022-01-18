package model;

public class Hilo implements Runnable {

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("Cliente: " + t.getName() + " ha entrado");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		System.out.println("\nEl cliente:" + t.getName() + " esta siendo atendido\n");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		
		System.out.println("El cliente: " + t.getName() + " ha salido\n");
		
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

	}
}
