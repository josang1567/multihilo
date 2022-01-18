package model;

import java.util.Random;

public class ClienteBanco implements Runnable {

	private Banco banco;
	private String nombre;
	private int cantidad;
	private int cMin, cMax;

	public int getCantidad() {
		return cantidad;
	}

	public ClienteBanco(Banco banco, String nombre, int cantidad, int cMin, int cMax) {
		this.banco = banco;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.cMin = cMin;
		this.cMax = cMax;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf(
				"+------------------------------------------------------------------------------------------------------------%s%s+\n",
				banco.getNumClientes() >= 99  ? "" : "-", banco.getCantidad()>=99 ? "" : "-");				
		System.out.printf(
				"| Cliente: %s quiere sacar %d de su cuenta | credito preparandose en banco= %d euros | En espera: %d Cliente%s. %s|\n",
				this.nombre, this.cantidad, banco.getCantidad(), banco.getNumClientes(),
				banco.getNumClientes() != 1 ? "s" : "", banco.getNumClientes() >= 9 ? "" : " ");
		System.out.printf(
				"+------------------------------------------------------------------------------------------------------------%s%s+\n",
				banco.getNumClientes() >= 99 ? "" : "-", banco.getCantidad()>=99 ? "" : "-");

		// esperar a ser atendido
		boolean atendido = false;
		//si atendido es falso el cliente no puede ser atendido y debera esperar x segundos a que se le atienda
		while (!atendido) {
			synchronized (this.banco) {
				atendido = this.banco.expulsarDinero(this);
				if (!atendido) {
					try {
						System.out.println("+---------------+");
						System.out.printf("|%s debe esperar |\n", this.nombre);
						System.out.println("+---------------+\n\n");

						this.banco.wait();
					} catch (InterruptedException ex) {
						System.out.printf("Interrupcion mientras %s espera para ser atendido\n\n", this.nombre);
					}
				}
			}
		}

		System.out.printf(
				"-%s Quiere sacar %d es atendido, El banco esta preparando %d euros, hay %d cliente%s siendo atendido%s.\n\n",
				this.nombre, this.getCantidad(), this.banco.getCantidad(), this.banco.getNumClientes(),
				this.banco.getNumClientes() != 1 ? "s" : "", this.banco.getNumClientes() != 1 ? "s" : "");
		// pasar a ser atendido y terminar consulta
		Random r = new Random();
		int tiempo = this.cMin + r.nextInt(this.cMax - this.cMin - 1);

		try {
			System.out.printf("+---------------------------------------------%s+\n",tiempo >= 9 ? "" : "-");
			System.out.printf("| %s va a tardar %d segundos en ser atendido. %s|\n", this.nombre, tiempo,
					tiempo >= 99 ? "" : " ");
			System.out.printf("+---------------------------------------------%s+\n",tiempo >= 9 ? "" : "-");

			Thread.sleep(100 * tiempo);
		} catch (InterruptedException ex) {
			// TODO: handle exception
			System.out.printf("Interrupcion mientras %s sale.\n\n", this.nombre);
		}

		// sale del banco

		synchronized (this.banco) {
			this.banco.finOperacion(this);
			System.out.printf("-%s sale del banco, el banco puede dar %d euros, hay %d cliente%s siendo atendido%s.\n\n ",
					this.nombre, this.banco.getCantidad(), this.banco.getNumClientes(),
					this.banco.getNumClientes() != 1 ? "s" : "", this.banco.getNumClientes() != 1 ? "s" : "");
			banco.notifyAll();
		}

	}

}
