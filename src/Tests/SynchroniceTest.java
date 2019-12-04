package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import library.Account;
import library.Buy;
import library.Deposit;

public class SynchroniceTest {

	@Test
	public void test() {
		Account cuenta = new Account(20000);
		Buy mateote = new Buy(cuenta, 1, 20);
		Deposit mateito = new Deposit(cuenta, 1, 40);
		mateote.start();
		mateito.start();
		//Cuando llamamos a la función start de cada uno de los dos hilos, cada uno de ellos en su ejecución, accede 
		//a una función synchronized, y al ser el resultado del test válido, nos indica que el thread que no está
		//ejecutando esa función, no accede a ella hasta que el otro terminó de realizarla.
	}

}
