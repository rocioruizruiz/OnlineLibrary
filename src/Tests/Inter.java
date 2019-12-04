package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import library.Book;

import java.util.Locale;
import java.util.ResourceBundle;


public class Inter {

	@Test
	public void test() {


		Locale enLocale = new Locale("en", "US");
		ResourceBundle messages;
	    messages = ResourceBundle.getBundle("MessagesBundle", enLocale);
		
		assertEquals("Try again!", messages.getString("nicetry"));
		
		
		Locale spLocale = new Locale("sp", "ES");
		ResourceBundle messages2;
	    messages2 = ResourceBundle.getBundle("MessagesBundle", spLocale);
		
		assertEquals("Intentelo de nuevo!", messages2.getString("nicetry"));
		
	
		
		
	}

}