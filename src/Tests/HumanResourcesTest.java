package tests;

import library.Employee;
import library.Librarian;
import library.Contable;
import library.HumanResources;
import java.util.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class HumanResourcesTest {

	@Test
	public void Test() {
		Employee e = new Librarian("12345678Z", "Pepe", "Ruiz", 2014, 20000);
		Employee i = new Contable("12345678Z", "Pepe", "Ruiz", 2014, 20000);
		Employee o = new HumanResources("12345678Z", "Pepe", "Ruiz", 2014, 20000);
		
		//human resources who is gonna do de hires
		
		HumanResources main = new HumanResources();
		HumanResources.hireEmployee(e); 
		HumanResources.hireEmployee(i); 
		HumanResources.hireEmployee(o);
		System.out.println(main.getEmployees().size());
		assertEquals(1, main.getEmployees().size());
		
		
		
	}

}
