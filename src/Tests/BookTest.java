package Tests;

import static org.junit.Assert.*;
import Practicas.Book;

import org.junit.Test;


public class BookTest {

	@Test
	public void testGetIsbn() {
		Book libro = new Book("34567h","titulo","autor");
		assertEquals("34567h", libro.getIsbn());
		assertEquals("titulo", libro.getTitle());
		assertEquals("autor", libro.getAuthor());
		
	}

}
