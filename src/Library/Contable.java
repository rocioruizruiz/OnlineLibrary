package library;

import java.util.*;

public class Contable extends Employee implements Worker{

	private static String password = "pays9";
	private static ResourceBundle messages;


	public Contable(String nif, String name, String surname, int hiredyear, double retribution) {
		super(nif, name, surname, hiredyear, retribution);
		messages = Biblioteca.getLocale();
	}
	
	public Contable() {
		messages = Biblioteca.getLocale();
	};

	public double getSalaryIncrease() {
		double currentSalary =  super.getRetribution();
		if(super.getAntiquity() >= 5) {
			return Math.abs((currentSalary*1.5/100));
		}
		else {
			return Math.abs((currentSalary * 0.015));
		}
	}

	public String getData() {
		String data = messages.getString("id") + this.getNIF() + messages.getString("name") + this.getName() + " " 
				+ this.getSurname() + messages.getString("hiredyear")+ this.getHiredYear() 
				+ messages.getString("retribution")+ " " + this.getRetribution();
		return data;
	}

	public static String getPassword() {
		return password;
	}



	public void work(List<Double> b, List<Double> d, Account cuenta) {
		int n = 0;
		int bIndex = 0;
		int dIndex = 0;
		Thread[] procesos = new Thread[b.size() + d.size()];
		while(bIndex < b.size() || dIndex < d.size()) {

			if(b.size() > 0 && bIndex < b.size()) {
				procesos[n] = new Buy(cuenta, 1, b.get(bIndex));
				bIndex++;
				n++;
			}

			if(d.size() > 0 && dIndex < d.size()) {
				procesos[n] = new Deposit(cuenta, 1, d.get(dIndex));
				dIndex++;
				n++;
			}
		}
		for(int i = 0; i < procesos.length; i++) { 

			procesos[i].start();

		}
		for(int i = 0; i < procesos.length; i++) { 

			try {
				procesos[i].join();
			} catch(InterruptedException ie) {
				System.err.println(ie.getMessage()); 
			} finally {
				System.out.println(messages.getString("endTransaction") + (i+1)); 
			}
		}

		System.out.println(messages.getString("final") + " " + cuenta.getSaldo() + " eur.");
	}
	
	public void work() {}
	
}
