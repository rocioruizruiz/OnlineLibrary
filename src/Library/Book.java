package Library;

public class Book {
	
	private String title, isbn, author;
	private boolean booked;
	public int stock;
	private int maxStock;
	
	public Book(String isbn, String title, String author, int stock) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.booked = false;
		this.stock = stock;
		this.maxStock = stock;
	}
	public Book() {};

	public Book(String isbn, String title, String author, boolean booked) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.booked = booked;
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
			}else{	
				//lo devuelve
				if(stock == (this.maxStock - 1)) {
					this.booked = bookedd;
					stock = stock + 1;
					System.out.println("All stock of this book is now available.");
				}else {
					this.booked = false;
				}
			}
		}else if(stock <= 1){
			if(bookedd == true){
				// lo alquila y no hay mas
				stock = stock - 1;
				this.booked = bookedd;
			}else {
				//lo devuelve
				if(stock == (this.maxStock - 1)) {
					// si va a alcanzar el maximo stock
					this.booked = bookedd;
					stock = stock + 1;
					System.out.println("All stock of this book is now available.");
				}else {
					this.booked = true;
					stock = stock + 1;
				}				
			}	 
		}
	}
}
