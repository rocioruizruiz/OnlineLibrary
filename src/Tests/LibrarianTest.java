package tests;
import library.Librarian;
import static org.junit.Assert.*;
import org.junit.Test;


public class LibrarianTest {

	@Test
	public void Test() {
		Librarian u = new Librarian("12345678Z", "Pepe", "Ruiz", 2014, 20000);
		assertEquals("ship9", Librarian.getPassword());
		assertEquals("12345678Z", u.getNIF());
		assertEquals("Pepe", u.getName());
		assertEquals("Ruiz", u.getSurname());
		assertEquals(2014, u.getHiredYear());
		assertEquals(5, u.getAntiquity());
		
	}

}
