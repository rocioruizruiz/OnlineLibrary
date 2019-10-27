package Practicas;

public class Book {
	
	private String title;
	private String isbn;
	private String author;
	private boolean booked;
	
	public Book(String isbn, String title, String author) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.booked = false;
	}
	public Book() {};

	public Book(String isbn, String title, String author, boolean booked) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.booked = booked;
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
	
	boolean getOcupacy() {
		return this.booked;
	}
	
	void setBookedStatus(boolean bookedd) {
		this.booked = bookedd; // si es true, es que esta ocupado
	}

}
