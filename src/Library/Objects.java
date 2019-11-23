package library;

public class Objects {
	
	private String isbn;
	private int uses;
	public Objects(Book b, int a) {
		this.isbn = b.getIsbn();
		this.uses = a;
	}
	public String getIsbn() {
		return this.isbn;
	}
	public int getUses() {
		return this.uses;
	}

}
