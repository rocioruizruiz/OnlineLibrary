package Library;

import java.util.Calendar;

public abstract class Employee {
	private String nif;
	private String name;
	private String surname;
	private int hiredyear; 
	private double retribution;
	public Employee(String nif, String name, String surname, int hiredyear, double retribution) {
		this.name = name;
		this.nif = nif;
		this.surname = surname;
		this.hiredyear = hiredyear;
		this.retribution = retribution;
	}
	public String getNIF() {
		return nif;
	}
	public String getName() {
		return name;
	}
	public String getSurname() { 
		return surname;
	}
	public int getHiredYear() {
		return hiredyear;
	}
	public int getAntiquity() {
		Calendar cal= Calendar.getInstance();
		return cal.get(Calendar.YEAR) - hiredyear;
	}
	public double getRetribution() {
		return retribution;
	}
	abstract public double getSalaryIncrease();
	public String getData() {
		return this.getData();
	}
}

