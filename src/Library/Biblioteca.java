package Library;
import java.util.*;
import java.io.*;


public class Biblioteca {
	
	public Biblioteca(String name) {
		this.name = name;
		allBooks = new ArrayList<Book>();
		movements = new ArrayList<Movements>();
		users = new ArrayList<User>();
		employees = new ArrayList<Employee>();
	}
	public Biblioteca() {}
	
	
	private String name;
	private static List<Book> allBooks;
	private List<Movements> movements;
	private List<User> users;
	private List<Employee> employees;
	public int totalstock;
	
	
//------------ Movements Methods --------------------
	
	void newMovement(User thisUser, Book theIsbnBook, boolean b) {
		Movements m = new Movements(thisUser, theIsbnBook);
		movements.add(m);
			m.setBooked(b);
	}
	
	void printMovements() {
		for(Movements m: movements) {
			m.getDatos();
		}
	}
	
//------------ Employees Methods -----------------------
	
	void newEmployee(Employee em) {
		employees.add(em);
	}
	void printEmployees() {
		for(Employee e: employees) {
			e.getData();
		}
	}
	
//--------------- Books Methods -------------------------
	
	Book searchByIsbn(String anIsbn) {
		for(Book b: allBooks) {
			if(b.getIsbn().equals(anIsbn)) {
				System.out.println("El libro con ese isbn es: " + b.getTitle());
				return b;
			}
		}
		System.out.println("No lo he encontrado!");
		return null;
	}
	Book searchByTitle(String anTitle) {
		for(Book b: allBooks) {
			if(b.getTitle().equals(anTitle)) {
			System.out.println("El libro con ese titulo es de " + b.getAuthor() + " y tiene como isbn: " + b.getIsbn());
				return b;
			}
		}
		System.out.println("No lo he encontrado!");
		return null;
	}
	
// ----------------- USER Methods ------------------------
	
	User searchById(String anId) {
		for(User u: users) {
			if(u.getId().equals(anId))
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
	void addUser(String id, String firstName, String lastName, String gender, int age, long cp, int booksBooked) {
		User e = new User(id, firstName, lastName, gender, age, cp, booksBooked);
		users.add(e);
	}
	
		//======================            =====================//
		//====================== READ FILES =====================//
		//======================            =====================//
	
	void readBooksFile() {
		String csvFile = "/Users/rocioruizruiz/Documentos/Segundo/AmpliacionProgramacion/WorkspaceJava/PracticasProgramacion/Libros.csv";
        BufferedReader br = null;
        String line = ""; 
        String cvsSplitBy = ";";
        String isbn, title, author, stock;

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use dot-comma as separator
                String[] booksfile = line.split(cvsSplitBy);
                //System.out.println(booksfile);
                
                isbn = booksfile[0];
                title = booksfile[1];
                author = booksfile[2];
                stock = booksfile[3];
                
                System.out.println(isbn + ", " + title + ", " + author);
                
                int stocky = Integer.parseInt(stock);
                
                Book e = new Book(isbn, title, author, stocky);
                //Contador c = new Contador(e, stocky);
                System.out.println("\n-----------------------\n");
                allBooks.add(e); 
                totalstock++;
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
		String csvFile2 = "/Users/rocioruizruiz/Documentos/Segundo/AmpliacionProgramacion/WorkspaceJava/PracticasProgramacion/Users.csv";
        BufferedReader br2 = null;
        String line2 = ""; 
        String cvsSplitBy2 = ";";
        String id, firstName,  lastName, gender, ag,  c,  booksBook;
        try {

            br2 = new BufferedReader(new FileReader(csvFile2));
            while ((line2 = br2.readLine()) != null) {

                // use comma as separator
                String[] usersfile = line2.split(cvsSplitBy2);
                //System.out.println(usersfile);
                
                id = usersfile[0];
                firstName = usersfile[1];
                lastName = usersfile[2];
                gender = usersfile[3];
                ag = usersfile[4];
                c = usersfile[5];
                booksBook = usersfile[6];
                System.out.println(id + "; " + ag + "; " + c + "; " + booksBook + ";" );
                System.out.println("\n----------------------------\n");
                int age = Integer.parseInt(ag); 
                long cp = Long.parseLong(c);
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
	void readEmployeesFile() {
		String csvFile3 = "/Users/rocioruizruiz/Documentos/Segundo/AmpliacionProgramacion/WorkspaceJava/PracticasProgramacion/Employees.csv";
        BufferedReader br3 = null;
        String line3 = ""; 
        String cvsSplitBy3 = ";";
        String employeeType, employeeNIF, employeeName, employeeSurame, employeeHireYear, employeeRetribution;

        try {

            br3 = new BufferedReader(new FileReader(csvFile3));
            while ((line3 = br3.readLine()) != null) {

                // use dot-comma as separator
                String[] employeesfile = line3.split(cvsSplitBy3);
                //System.out.println(employeesfile);
                
                employeeType = employeesfile[0];
                employeeNIF = employeesfile[1];
                employeeName = employeesfile[2];
                employeeSurame = employeesfile[3];
                employeeHireYear = employeesfile[4];
                employeeRetribution = employeesfile[5];
                
                String a = "";
                if (employeeType.equals("1")){
                	a = "Ingeniero";
                }else if(employeeType.equals("2")) {
                	a = "Contable";
                }
                
                System.out.println(a + ", " + employeeNIF + ", " + employeeHireYear + ", " + employeeRetribution);
                System.out.println("\n-----------------------------------\n");
                int employeeType_ = Integer.parseInt(employeeType);
                int employeeHireyear = Integer.parseInt(employeeHireYear);
                double employeeRetribution_ = Double.parseDouble(employeeRetribution);
                if(employeeType_ == 1) {
                	Employee e = new Librarian(employeeNIF, employeeName, employeeSurame, employeeHireyear, employeeRetribution_);
                	employees.add(e); 
                }else if(employeeType_ == 2) {
                	Employee e = new Contable(employeeNIF, employeeName, employeeSurame, employeeHireyear, employeeRetribution_);
                	employees.add(e); 
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br3 != null) {
                try {
                    br3.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}