package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import Practicas.User;

public class UserTest {

	@Test
	public void test() {
		User u = new User("id","name","lname","gender", 1, 28006, 2);
		assertEquals("id", u.getId());
		assertEquals(1, u.getAge());
		assertEquals(2, u.getBooksBooked());
	}

}
