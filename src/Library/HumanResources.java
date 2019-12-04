package library;

import java.util.ResourceBundle;

public class HumanResources extends Employee{

	private static String password = "ship9";
	private static ResourceBundle messages;
	

	public HumanResources(String nif, String name, String surname, int hiredyear, double retribution) {
		super(nif, name, surname, hiredyear, retribution);
		messages = Biblioteca.getLocale();
	}
	
	public HumanResources() {
		messages = Biblioteca.getLocale();
	};

	public double getSalaryIncrease() {

		double currentSalary =  super.getRetribution();
		if(super.getAntiquity() >= 5) {
			return Math.abs((currentSalary*1/100));
		}
		else {
			return Math.abs((currentSalary * 0.010));
		}
	}
	
	public String getData() {
		String data = messages.getString("id") + this.getNIF() + messages.getString("name") + this.getName() 
				+ " " + this.getSurname() + messages.getString("hiredyear")+ this.getHiredYear() 
				+ messages.getString("retribution")+ " " + this.getRetribution();
		return data;
	}
	
	public static String getPassword() {
		return password;
	}
	
	public static void hireEmployee(Employee e) {
		if(e.getClass() == Contable.class) {
			e = new Contable(e.getNIF(), e.getName(), e.getSurname(), e.getHiredYear(), e.getRetribution());
			Employee.addEmployee(e);
		}else if(e.getClass() == Librarian.class) {
			e = new Librarian(e.getNIF(), e.getName(), e.getSurname(), e.getHiredYear(), e.getRetribution());
			Employee.addEmployee(e);
		}else if(e.getClass() == HumanResources.class) {
			e = new HumanResources(e.getNIF(), e.getName(), e.getSurname(), e.getHiredYear(), e.getRetribution());
			Employee.addEmployee(e);
		}
	}
}
