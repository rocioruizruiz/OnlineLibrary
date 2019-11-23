package library;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyException extends Exception {
	ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", Locales.getLocale());
	
	
    public MyException(String msg) {}
    public MyException() {}
    
    public String rango() throws MyException{
           return messages.getString("IncorrectRange");
    }
    
    public String incompatible(String as) throws MyException{
        return messages.getString("Incompatible String");
 }
}
