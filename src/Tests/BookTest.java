package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import library.Book;


public class BookTest {

	@Test
	public void test() {
		Book libro = new Book("34567h","titulo","autor", 2);
		assertEquals("34567h", libro.getIsbn());
		assertEquals("titulo", libro.getTitle());
		assertEquals("autor", libro.getAuthor());
		//Para comprobar el control del stock, meto un alquilar d mas(no lo hace) y un return de mas (no lo hace)
		//Mantiene el maximo y el minimo stock posible.
		libro.setBookedStatus(true);
		libro.setBookedStatus(true);
		libro.setBookedStatus(true);
		libro.setBookedStatus(false);
		libro.setBookedStatus(false);
		libro.setBookedStatus(false);
		assertEquals(2, libro.getStock());
		
		
		
		
	}

}
