package library;

public class Contable extends Employee {

	private static String password = "pays9";
	public Contable(String nif, String name, String surname, int hiredyear, double retribution) {
		super(nif, name, surname, hiredyear, retribution);
	}

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
		String data = "DNI: " + this.getNIF() + "\nName: " + this.getName() + " " + this.getSurname() +"\nHired Year: " + this.getHiredYear() + "\nRetribution: " + this.getRetribution();
		return data;
	}
	
	public static String getPassword() {
		return password;
	}
}
