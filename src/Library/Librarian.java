package library;

import java.util.*;

public class Librarian extends Employee implements Worker {

	private static String password = "ship9";
	private static ResourceBundle messages;
	private static List<Double> buy = new ArrayList<Double>();


	public Librarian(String nif, String name, String surname, int hiredyear, double retribution) {
		super(nif, name, surname, hiredyear, retribution);
		messages = Biblioteca.getLocale();
	}
	
	public Librarian() {
		messages = Biblioteca.getLocale();
	};

	public double getSalaryIncrease() {

		double currentSalary =  super.getRetribution();
		if(super.getAntiquity() >= 5) {
			return Math.abs((currentSalary*2/100));
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
	
	public void work(){
		List<Double> buyaux = new ArrayList<Double>();
		Scanner sn = new Scanner(System.in);
		Scanner num = new Scanner(System.in);
		int stop = 0;
		
		while(stop == 0) {
			System.out.println(messages.getString("bookNeeded"));
			String cin = sn.nextLine();
			double price = Math.floor(Math.random()*(20-10+1)+10);
			System.out.println(messages.getString("price") + " " + price);
			System.out.println(messages.getString("howMany"));
			int n = num.nextInt();
			buyaux.add(price*n);
			
			System.out.println(messages.getString("moreMovements"));
			stop = num.nextInt();
		}
		buy = buyaux;
		System.out.println(messages.getString("tramited"));
	}
	
	public static List<Double> getBuy(){
		return buy;
	}
	
	public static void initializeBuy() {
		buy.clear();
	}
		
}