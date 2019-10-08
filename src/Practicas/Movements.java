package Practicas;

public class Movements {
	
	private int dayIniDate, monthIniDate, dayEndDate, monthEndDate;
	private String id, isbn;
	private boolean booked;
	
	
	public Movements(String id, String isbn, int dayIniDate, int monthIniDate, int dayEndDate, int monthEndDate) {
		this.id = id;
		this.isbn = isbn;
		this.dayIniDate = dayIniDate;
		this.monthIniDate = monthIniDate;
		this.dayEndDate = dayEndDate;
		this.monthEndDate = monthEndDate;
		this.booked = false;
	}
	public Movements() {}
	
	public void getDatos() {
		System.out.print("The book " + this.id);
		if(booked) {
			System.out.println(" is still booked:	 " + dayIniDate + "/" + monthIniDate );
		}else
			System.out.println(" returned booked" + dayEndDate + "/" + monthEndDate);
		System.out.println();
	}
	
	public void setBooked(boolean a) {
		this.booked = a;
	}

	public int getDayIniDate() {
		return dayIniDate;
	}

	public void setDayIniDate(int dayIniDate) {
		this.dayIniDate = dayIniDate;
	}

	public int getMonthIniDate() {
		return monthIniDate;
	}

	public void setMonthIniDate(int monthIniDate) {
		this.monthIniDate = monthIniDate;
	}

	public int getDayEndDate() {
		return dayEndDate;
	}

	public void setDayEndDate(int dayEndDate) {
		this.dayEndDate = dayEndDate;
	}

	public int getMonthEndDate() {
		return monthEndDate;
	}

	public void setMonthEndDate(int monthEndDate) {
		this.monthEndDate = monthEndDate;
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
