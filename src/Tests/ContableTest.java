package tests;


import library.Contable;
import static org.junit.Assert.*;
import org.junit.Test;


public class ContableTest {

	@Test
	public void Test() {
		Contable u = new Contable("12345678Z", "Pepe", "Ruiz", 2014, 20000);
		assertEquals("pays9", Contable.getPassword());
		assertEquals("12345678Z", u.getNIF());
		assertEquals("Pepe", u.getName());
		assertEquals("Ruiz", u.getSurname());
		assertEquals(2014, u.getHiredYear());
		assertEquals(5, u.getAntiquity());
		
	}

}
