package library;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyException extends Exception {
	private static ResourceBundle messages;
	
	
    public MyException(String msg) {
    	messages = Biblioteca.getLocale();
    }
    public MyException() {}
    
    public String rango() throws MyException{
           return messages.getString("IncorrectRange");
    }
    
    public String incompatible(String as) throws MyException{
        return messages.getString("IncompatibleString");
 }
}
