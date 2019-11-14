package tests;

import static org.junit.Assert.*;
import org.junit.Test;


import java.util.Locale;
import java.util.ResourceBundle;


class InternationalizationTest {
	
	@Test
	public void test() {

		
		ResourceBundle ref = ResourceBundle.getBundle("Languages", new Locale("en", "US"));
		assertEquals(ref.getString("nicetry"), "Try again!");
		
		
		ResourceBundle ref1 = ResourceBundle.getBundle("Languages", new Locale("es", "ES"));
		assertEquals(ref1.getString("nicetry"), "Intentelo de nuevo!");
		/*
		@Test
		ResourceBundle ref2 = ResourceBundle.getBundle("Languages", new Locale("fr", "FR"));
		assertEquals(ref2.getString("nicetry"), "Choisissez une option:");
		*/
	}
}