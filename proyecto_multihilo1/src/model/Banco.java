package model;

public class Banco {
	private static int CantidadMax=400;
	private static int maxClientes=2;
	private int cantidad=0;
	private int numClientes=0;

	synchronized public int getCantidad() {
		return cantidad;
	}
	
	synchronized public int getNumClientes() {
		return numClientes;
	}
	
	synchronized public boolean expulsarDinero(ClienteBanco cliente) {
		boolean result=false;
		
		if(this.cantidad+cliente.getCantidad()<=Banco.CantidadMax && this.numClientes<Banco.maxClientes) {
			this.numClientes++;
			this.cantidad+= cliente.getCantidad();
			result=true;
		}else {
			result=false;
		}
		
		return result;
	}
	
	synchronized public void finOperacion(ClienteBanco cliente) {
		this.cantidad -= cliente.getCantidad();
		this.numClientes--;
	}
}
