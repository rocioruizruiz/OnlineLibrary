package tests;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import library.*;
import library.User.UserBuilder;



public abstract class InterfaceTest {
	
	@Test
    public abstract SearchBy createInstance();
    
	@Test
    public void test(){
		
    	SearchBy instance = createInstance();
    	Book libro = new Book("34567h","titulo","autor", 2);
		assertEquals(libro, instance.searchByIsbn("34567h"));
    	assertEquals(libro, instance.searchByTitle("titulo"));


    	User u = new UserBuilder("51146931Z","name0","surname0", "Male").build();
		assertEquals(u, instance.searchById("34567h"));
	}
}
