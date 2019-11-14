package tests;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import library.*;


public abstract class InterfaceTest {
    public abstract SearchBy createInstance();
    
	@Test
    public final void test(){
    	SearchBy instance = createInstance();
    	Book libro = new Book("34567h","titulo","autor", 2);
		assertEquals(libro, instance.searchByIsbn("34567h"));
    	assertEquals(libro, instance.searchByTitle("titulo"));


    	User u = new User("51146931Z","name0","surname0", "male", 19, 28006, 2);
		assertEquals(u, instance.searchById("34567h"));
	}
}
