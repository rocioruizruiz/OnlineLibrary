package library;

import java.util.ResourceBundle;

public class User {
	
	private String id, firstName, lastName, gender;
	private int booksBooked, age;
	private long cp;
	private static ResourceBundle messages;
	
	// constructor
	
	private User(UserBuilder usuario) { 
		this.id = usuario.id;
		this.firstName = usuario.firstName;
		this.lastName = usuario.lastName;
		this.gender =  usuario.gender;
		this.age = usuario.age;
		this.cp = usuario.cp;
		this.booksBooked = usuario.booksBooked;	
		messages = Biblioteca.getLocale();
	}
	
	public String getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public int getBooksBooked() {
		return booksBooked;
	}
	
	public int getAge() {
		return age;
	}



//------------------CLASE ANIDADA------------------------//
		public static class UserBuilder{
			
			private String id, firstName, lastName, gender;
			private int booksBooked, age;
			private long cp;
			private static ResourceBundle messages = Biblioteca.getLocale();
			
		//constructor para los datos oblgatoerios
		public UserBuilder(String id, String firstName, String lastName, String gender) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public User build() {
			User usuario = new User(this);
			
			return new User(this);
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
		
		public UserBuilder setGender(String gender) {
			this.gender = gender;
			return this;
		}
	
		public int getBooksBooked() {
			return booksBooked;
		}
	
		public UserBuilder setBooksBooked(int booksBooked) {
			this.booksBooked = booksBooked;
			return this;
		}
	
		public long getCp() {
			return cp;
		}
	
		public UserBuilder setCp(long cp2) {
			this.cp = cp2;
			return this;
		}
	
		public int getAge() {
			return age;
		}
	
		public UserBuilder setAge(int age) {
			this.age = age;
			return this;
		}
	}
		
}
	
		