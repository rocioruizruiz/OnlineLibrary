package tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import library.*;
import library.User.UserBuilder;

public class MovementsTests {
	
	@Test
	public void test() {
		//Biblioteca biblio = new Biblioteca("Testing");
		User u = new UserBuilder("id", "name", "lname", "gender").build();
		Book b = new Book("34567h", "titulo", "autor", 2);
		Movements m = new Movements(u,b);
		
		m.setBooked(true);
		assertEquals("34567h", m.getIsbn());
		assertEquals("id", m.getId());
		m.setBooked(false);
		assertEquals(false, m.getBookedStatus());

		
	}

}
