package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import library.*;

public class ThreadTest {

	@Test
	public void test() {
		// TODO Auto-generated constructor stub
		Account cuenta = new Account(20000);
		Buy mateote = new Buy(cuenta, 1, 20);
		mateote.start();
		assertNotNull(mateote);
	}

}
