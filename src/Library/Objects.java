package library;

import java.util.ResourceBundle;

public class Objects {
	
	private String isbn;
	private int uses;
	private static ResourceBundle messages;
	
	public Objects(Book b, int a) {
		this.isbn = b.getIsbn();
		this.uses = a;
		messages = Biblioteca.getLocale();
	}
	public String getIsbn() {
		return this.isbn;
	}
	public int getUses() {
		return this.uses;
	}

}
