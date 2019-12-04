package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import library.Book;


public class BookTest {

	@Test
	public void test() {
		Book libro = new Book("34567h","titulo","autor", 2);
		Book libro2 = new Book();
		Book libro3 = new Book("34567h","titulo","autor", true);
		assertEquals("34567h", libro.getIsbn());
		assertEquals("titulo", libro.getTitle());
		assertEquals("autor", libro.getAuthor());
		assertEquals(0, libro.getUses());
		//Para comprobar el control del stock, meto un alquilar d mas(no lo hace) y un return de mas (no lo hace)
		//Mantiene el maximo y el minimo stock posible.
		libro.setBookedStatus(true);
		libro.setBookedStatus(true);
		assertEquals(true, libro.getOcupacy());
		
		libro.setBookedStatus(true);
		assertEquals(3, libro.getUses());
		
		libro.setBookedStatus(false);
		libro.setBookedStatus(false);
		libro.setBookedStatus(false);
		assertEquals(false, libro.getOcupacy());
		
		assertEquals(2, libro.getStock());
		
		
		
		
	}

}

