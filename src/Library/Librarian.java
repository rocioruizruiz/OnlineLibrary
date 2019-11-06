package Library;

public class Librarian extends Employee {

	
	public Librarian(String nif, String name, String surname, int hiredyear, double retribution) {
		super(nif, name, surname, hiredyear, retribution);
		// TODO Auto-generated constructor stub
	}

	public double getSalaryIncrease() {
		// TODO Auto-generated method stub
		double currentSalary =  super.getRetribution();
		if(super.getAntiquity() >= 5) {
			return (currentSalary*2/100);
		}
		else {
			return (currentSalary * 0.015);
		}
	}
	public String getData() {
		String data = "DNI: " + this.getNIF() + "\nName: " + this.getName() + " " + this.getSurname() +"\nHired Year: " + this.getHiredYear() + "\nRetribution: " + this.getRetribution();
		return data;
	}
}
