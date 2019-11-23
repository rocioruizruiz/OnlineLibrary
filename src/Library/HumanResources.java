package library;

public class HumanResources extends Employee{

private static String password = "ship9";
	
	

	public HumanResources(String nif, String name, String surname, int hiredyear, double retribution) {
		super(nif, name, surname, hiredyear, retribution);
	}

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
		String data = "DNI: " + this.getNIF() + "\nName: " + this.getName() + " " + this.getSurname() +"\nHired Year: " + this.getHiredYear() + "\nRetribution: " + this.getRetribution();
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
		}
	}
}
