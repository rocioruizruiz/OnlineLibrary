package library;

import java.util.ResourceBundle;

public class Buy extends Thread { 
	
	private Account cuenta;
	private int transacciones; 
	private double importe;
	private static ResourceBundle messages;

	
	public Buy(Account cuenta, int transacciones, double importe) { 
		this.cuenta = cuenta;
		this.transacciones = transacciones;
		this.importe = importe;
		messages = Biblioteca.getLocale();
	}
	

	public void run() {
		for(int i = 1; i <= this.transacciones; i++) {
			synchronized (this.cuenta) {
				while(this.cuenta.getSaldo() < 10) {
					try {
						this.cuenta.wait();
					} catch (InterruptedException ie)
					{
						System.err.println(ie.getMessage()); 
					}
				}
				this.cuenta.retiro(this.importe); 
			}
		} 
	}
}