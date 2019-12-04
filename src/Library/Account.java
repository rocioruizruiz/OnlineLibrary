package library;

import java.util.ResourceBundle;

public class Account {
	private double saldo;
	private static ResourceBundle messages;
	
	public Account(double saldo) { 
		this.saldo = saldo;
		messages = Biblioteca.getLocale();
	}
	
	public synchronized double getSaldo() { 
		return this.saldo;
	}
	
	public synchronized void retiro(double importe) { 
		while(this.saldo < importe) {
			try {
			wait(); // espera a que la cuenta tenga fondos
			}catch(InterruptedException ie) {
				
				System.err.println(ie.getMessage());
				
			}
		}
		
		double nuevoSaldo = this.saldo;
		nuevoSaldo = nuevoSaldo - importe;
		
		try {
			Thread.sleep(200); // simula el tiempo de la transacción
			
		} catch (InterruptedException ie) { 
			
			System.err.println(ie.getMessage());
			
		}
		
		
		System.out.println("afterRetirement" + " " + nuevoSaldo);
		
		this.saldo = nuevoSaldo; 
		
		
	}

	public synchronized void deposito(double importe) { 
		
		double nuevoSaldo = this.saldo;
		nuevoSaldo = nuevoSaldo + importe;
		
		try {
			Thread.sleep(300); // simula el tiempo de la transacción
		} catch (InterruptedException ie) { 
			System.err.println(ie.getMessage());
		}
		
		System.out.println("afterDeposit" + " " + nuevoSaldo);
		this.saldo = nuevoSaldo;
		
		notify();

		
			
	}
		
}

