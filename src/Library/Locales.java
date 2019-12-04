package library;

import java.util.Locale;
import javax.swing.JOptionPane;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Locales {
	
    private static Locale locale;
    static Locale spLocale = new Locale("sp", "ES");
    static Locale enLocale = new Locale("en", "US");
    static Locale frLocale = new Locale("fr", "FR");
    
    public Locales(Locale thisLocale) {
    	Locales.locale = thisLocale;
    }
    public static Locale getLocale() {
		return locale;
	}
	public static String getString() {
    Scanner sn = new Scanner(System.in);
	String cin = sn.nextLine();
    	return cin;
    }
    public static int getInt() {
    	Scanner num = new Scanner(System.in);
    	int cin = num.nextInt();
        return cin;
    }
    
    public static Locale setLocale() {
    	
    	System.out.println("Choose your lenguage:\n 1. English \n 2. Spanish\n 3. French");
    	int option = getInt();
    	switch(option) {
    		case 1:
    			locale = Locales.enLocale;
    			break;
    		case 2:
    			locale = Locales.spLocale;
    			break;
    		case 3:
    			locale = Locales.frLocale;
    		default:
    			locale = Locales.enLocale;
    	}  
    	return locale;
    }

    public static String getString(String key) {
        return ResourceBundle.getBundle("MessagesBundle", locale).getString(key);
    }
}