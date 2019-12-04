package tests;
import java.util.*;

import static org.junit.Assert.*;
import org.junit.Test;

import library.*;

public class TableTest {

	@Test
	public void test() {
		Biblioteca biblio = new Biblioteca("Nebrix");
		Book libro = new Book("34567h","titulo","autor", 2);
		Book libro2 = new Book("34567i","titulo2","autor2", 1);
		Book libro3 = new Book("34567j","titulo3","autor3", 3);
		
		biblio.addBook(libro);
		biblio.addBook(libro2);
		biblio.addBook(libro3);
		
		Table table = new Table();
		List<Book> a = new ArrayList<Book>();
		a.add(libro);
		a.add(libro2);
		a.add(libro3);
		
    	assertEquals(a,biblio.getAllBooks());
		
		
	}	
}
