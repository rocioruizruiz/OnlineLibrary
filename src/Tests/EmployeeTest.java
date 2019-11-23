package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import library.Employee;
import library.Librarian;

public class EmployeeTest {

	@Test
	public void test() {
		String nif = "12345678Z"; 
		String name = "Pepe"; 
		String surname = "Ruiz"; 
		int hiredyear = 2014; 
		double retribution = 20000;
		Employee u = new Librarian(nif, name, surname, hiredyear, retribution);
		assertEquals("12345678Z", u.getNIF());
		assertEquals("Pepe", u.getName());
		assertEquals("Ruiz", u.getSurname());
		assertEquals(2014, u.getHiredYear());
		assertEquals(5, u.getAntiquity());
		//assertEquals(400, u.getSalaryIncrease());	
	}
}
