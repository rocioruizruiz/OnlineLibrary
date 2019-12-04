package tests;

import static org.junit.Assert.*;
import library.User.UserBuilder;

import org.junit.Test;
import library.User;

public class UserBuilderTest {

	@Test
	public void test() {
		User u = new UserBuilder("id","name","lname","gender").setAge(1).setCp(28006).setBooksBooked(2).build();
		assertEquals("id", u.getId());
		assertEquals(1, u.getAge());
		assertEquals(2, u.getBooksBooked());
		
	}
}
