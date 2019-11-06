package Library;

public class User {
	
	private String id, firstName, lastName, gender;
	private int booksBooked, age;
	private long cp;
	
	
	public User(String id, String firstName, String lastName, String gender, int age, long cp, int booksBooked) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender =  gender;
		this.age = age;
		this.cp = cp;
		this.booksBooked = booksBooked;	
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getBooksBooked() {
		return booksBooked;
	}

	public void setBooksBooked(int booksBooked) {
		this.booksBooked = booksBooked;
	}

	public long getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

	