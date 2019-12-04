package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import library.Objects;
import library.Book;

public class ObjectsTest {

	@Test
	public void Test() {
		Book b = new Book("34567h","titulo","autor", 2);
		int uses = 2;
		Objects o = new Objects(b, uses);
		
		assertEquals("34567h", o.getIsbn());
		assertEquals(2, o.getUses());
		
	}

}
