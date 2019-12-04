package library;

import java.util.Calendar;
import java.util.ResourceBundle;

public class Movements {
	
	private String id, isbn;
	private boolean booked;
	Calendar returnDate = Calendar.getInstance();
	Calendar moveDate = Calendar.getInstance();
	private static ResourceBundle messages;
	
	
	
	public Movements(User u, Book b) {
		this.id = u.getId();
		this.isbn = b.getIsbn();
		returnDate.add(Calendar.DAY_OF_MONTH, 20);
		this.booked = false;
		messages = Biblioteca.getLocale();
	}
	public Movements() {
		messages = Biblioteca.getLocale();
	}
	
	public void getDatos() {
		System.out.print(this.isbn);
		if(booked) {
			System.out.println(" " + messages.getString("booked") + " " + moveDate.getTime() + " " + messages.getString("return") + " " + returnDate.getTime());
		}else
			System.out.println(" was returned on " + returnDate.getTime());
		System.out.println();
	}
	
	public void setBooked(boolean a) {
		this.booked = a;
		moveDate.getInstance();		
	}
	
	public boolean getBookedStatus() {
		return this.booked;
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
