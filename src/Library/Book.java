package library;

import java.util.ResourceBundle;

public class Book {
	
	private String title, isbn, author;
	private boolean booked;
	public int stock;
	private int maxStock;
	private int nUses;
	private static ResourceBundle messages;
	
	public Book(String isbn, String title, String author, int stock) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.booked = false;
		this.stock = stock;
		this.maxStock = stock;
		this.nUses = 0;
		messages = Biblioteca.getLocale();
	}
	
	public Book() {};

	public Book(String isbn, String title, String author, boolean booked) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.booked = booked;
	}
	
	public int getUses() {
		return this.nUses;
	}
	
	public int getStock() {
		return this.stock;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	public String getTitle() {
		return this.title;
	}
	
	public boolean getOcupacy() {
		return this.booked;
	}
	 
	public void setBookedStatus(boolean bookedd) {
		if(stock > 1) {
			if(bookedd == true) {
				//lo alquila
				this.booked = false;
				stock = stock - 1;
				this.nUses = nUses + 1;
			}else{	
				//lo devuelve
				if(stock == (this.maxStock - 1)) { //lo devuelve y es el max stock posible
					this.booked = bookedd;
					stock = stock + 1;
				}else {
					this.booked = false;
				}
			}
		}else if(stock <= 1){
			if(bookedd == true){
				// lo alquila y ES EL ULTIMO
				stock = stock - 1;
				this.booked = bookedd;
				this.nUses = nUses + 1; 
				//stock = 0;
				
			}else {
				//lo devuelve
				if(stock == (this.maxStock - 1)) {
					// si va a alcanzar el maximo stock
					this.booked = bookedd;
					stock = stock + 1;
				}else {
					this.booked = true;
					stock = stock + 1;
				}				
			}	 
		}
	}
}
