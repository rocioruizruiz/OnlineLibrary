package Practicas;
import java.util.*;
import java.io.*;


public class Biblioteca {
	
	public Biblioteca(String name) {
		this.name = name;
		allBooks = new ArrayList<Book>();
		movements = new ArrayList<Movements>();
		users = new ArrayList<User>();
	}
	public Biblioteca() {}
	
	
	private String name;
	private static List<Book> allBooks;
	private List<Movements> movements;
	private List<User> users;
	
	
	//------------Movements Methods--------------------
	void newMovement(String id, String isbn, int iniday, int inimonth, int endday, int endmonth, boolean b) {
		Movements m = new Movements(id, isbn, iniday, inimonth, endday, endmonth);
		movements.add(m);
			m.setBooked(b);
	}
	
	void printMovements() {
		for(Movements m: movements) {
			m.getDatos();
		}
	}
	
	
	
	
	//-------- Books Methods --------------------
	
	Book searchByIsbn(String anIsbn) {
		for(Book b: allBooks) {
			if(b.getIsbn().equals(anIsbn)) {
				System.out.println("El libro con ese isbn es: " + b.getTitle());
				return b;
			}
		}
		System.out.println("NO lo he encontrado!");
		return null;
	}
	Book searchByTitle(String anTitle) {
		for(Book b: allBooks) {
			if(b.getTitle().equals(anTitle)) {
			System.out.println("El libro con ese titulo es de " + b.getAuthor() + " y tiene como isbn: " + b.getIsbn());
				return b;
			}
		}
		System.out.println("NO lo he encontrado!");
		return null;
	}
	
	// ----------- USER Methods -------------------
	
	User searchById(String anId) {
		for(User u: users) {
			if(u.getId() == anId)
				return u;
		}
		return null;
	}
	void registerUser(User a) {
		users.add(a);
	}
	
	void deleteUser(User e) {
		users.remove(e);
	}
	void addUser(String id, String firstName, String lastName, String gender, int age, double cp, int booksBooked) {
		User e = new User(id, firstName, lastName, gender, age, cp, booksBooked);
		users.add(e);
	}
	
		//======================            =====================//
		//====================== READ FILES =====================//
		//======================            =====================//
	
	void readBooksFile() {
		String csvFile = "/Users/rocioruizruiz/Documentos/Segundo/Ampli de programación/Practicas/Libros.csv";
        BufferedReader br = null;
        String line = ""; 
        String cvsSplitBy = ";";
        String isbn, title, author;

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use dot-comma as separator
                String[] booksfile = line.split(cvsSplitBy);
                System.out.println(booksfile);
                
                isbn = booksfile[0];
                title = booksfile[1];
                author = booksfile[2];
                
                System.out.println(isbn + ", " + title + ", " + author);
                
                Book e = new Book(isbn, title, author);
                System.out.println("------" + e.getIsbn());
                allBooks.add(e);                
                

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	void readUsersFile() {
		String csvFile2 = "/Users/rocioruizruiz/Documentos/Segundo/Ampli de programación/Practicas/Users.csv";
        BufferedReader br2 = null;
        String line2 = ""; 
        String cvsSplitBy2 = ";";
        String id, firstName,  lastName, gender, ag,  c,  booksBook;
        try {

            br2 = new BufferedReader(new FileReader(csvFile2));
            while ((line2 = br2.readLine()) != null) {

                // use comma as separator
                String[] usersfile = line2.split(cvsSplitBy2);
                System.out.println(usersfile);
                
                id = usersfile[0];
                firstName = usersfile[1];
                lastName = usersfile[2];
                gender = usersfile[3];
                ag = usersfile[4];
                c = usersfile[5];
                booksBook = usersfile[6];
                System.out.println(id + "; " + ag + "; " + c + "; " + booksBook + ";" );
                int age = Integer.parseInt(ag); 
                double cp = Double.parseDouble(c);
                int booksBooked = Integer.parseInt(booksBook);
                
                this.addUser(id, firstName, lastName, gender, age, cp, booksBooked);
                
                
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br2 != null) {
                try {
                    br2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}