package Library;

import java.util.Calendar;

public class Movements {
	
	private String id, isbn;
	private boolean booked;
	private int startDate;
	Calendar returnDate = Calendar.getInstance();
	Calendar moveDate = Calendar.getInstance();
	
	
	
	public Movements(User u, Book b) {
		this.id = u.getId();
		this.isbn = b.getIsbn();
		this.startDate = Calendar.DATE;
		returnDate.add(Calendar.DAY_OF_MONTH, 20);
		this.booked = false;
	}
	public Movements() {}
	
	public void getDatos() {
		System.out.print("The book " + this.isbn);
		if(booked) {
			System.out.println(" is booked since " + moveDate.getTime() + " and should be returned " + returnDate.getTime());
		}else
			System.out.println(" was returned on " + returnDate.getTime());
		System.out.println();
	}
	
	public void setBooked(boolean a) {
		this.booked = a;
		moveDate.getInstance();		
	}

	public int getstartDate() {
		return startDate;
	}

	public void setstartDate(int startDate) {
		this.startDate = startDate;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
}
