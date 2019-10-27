package Practicas;

import java.util.Locale;
import javax.swing.JOptionPane;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Internationalitation {
	static Scanner sn = new Scanner(System.in);
    private static Locale locale;
    static Locale spLocale = new Locale("sp", "ES");
    static Locale enLocale = new Locale("en", "US");
    static Locale frLocale = new Locale("fr", "FR");

    public static String getString() {
	String cin = sn.nextLine();
    	return cin;
    }
    public static int getInt() {
    	int cin = sn.nextInt();
        return cin;
    }
    
    public static Locale setLocale() {
    	//System.out.println("Choose your lenguage:\n 1. En_US.\n 2. Sp_ES\n 3. Fr_FR");
		// user choice
    	//String option = getString();
    	System.out.println("Choose your lenguage:\n 1. English.\n 2. Spanish\n 3. French");
    	int option = sn.nextInt();
    	switch(option) {
    		case 1:
    			locale = Internationalitation.enLocale;
    			break;
    		case 2:
    			locale = Internationalitation.spLocale;
    			break;
    		case 3:
    			locale = Internationalitation.frLocale;
    		default:
    			locale = Internationalitation.enLocale;
    	}  
    	return locale;
    }

    public static String getString(String key) {
        return ResourceBundle.getBundle("MessagesBundle", locale).getString(key);
    }
}