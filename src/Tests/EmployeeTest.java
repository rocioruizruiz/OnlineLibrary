package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import library.Contable;
import library.Employee;
import library.HumanResources;
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
		Employee e = new Contable("sdfghjk7","pepo", "ruiz", 2014, 20000);
		assertEquals("sdfghjk7", e.getNIF());
		assertEquals("pepo", e.getName());
		assertEquals("ruiz", e.getSurname());
		assertEquals(2014, e.getHiredYear());
		assertEquals(5, e.getAntiquity());
		
		
		assertEquals(400, (int) u.getSalaryIncrease());	
	}
}
