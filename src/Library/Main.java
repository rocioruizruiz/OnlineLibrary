
package library;

import java.util.*;

import library.User.UserBuilder;



public class Main {


	
	
//====================== MAIN =========================//
	
	public static void main(String[] args) throws MyException {

		try{
			
			
			Calendar today = Calendar.getInstance();
			Biblioteca biblio = new Biblioteca("Nebrix");
			
			Account cuenta = new Account(20000);
			
			
			//-------------- READING FILES
			biblio.readBooksFile();
	    	biblio.readUsersFile();
	    	biblio.readEmployeesFile();
		
	    	
	    	//-------------- INTERNATIONALITATION
	    	Locale currentLocale = Locales.setLocale();
	    	ResourceBundle messages;
	        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
	        biblio.setLocale(ResourceBundle.getBundle("MessagesBundle", currentLocale));
	        
	        //------------------------------------------------------
	    	Scanner sn = new Scanner(System.in);
	    	Scanner num = new Scanner(System.in);

	    	int op;
	    	int option = 1;
	    	int finalEnd = 1;
	    	while(finalEnd == 1) {
		        System.out.println(messages.getString("chooseMenu"));
		        //Choose between employee and user
		        op = num.nextInt();
	//------------------------------ EMPLOYEE ------------------------------------//
		        if(op == 1) {
			        String tryPassword;
			        // verifico la password hasta 3 veces.
			        for(int i = 0; i < 3; i++) {
			        	System.out.println(messages.getString("password"));
			        	tryPassword = sn.nextLine();
			        	if(tryPassword.equals(Employee.getPassword())) {
			        		System.out.println(messages.getString("correct"));
			        		break;
			        	}else if(tryPassword.length() != 5){
			        		throw new MyException();
			        	}
			        	System.out.println(messages.getString("nicetry"));
			        }
		        	int chosen = 0;
		        	System.out.println(messages.getString("menuEmployees"));
		        	chosen = num.nextInt();
		        	
		        	// es contable
		        	if(chosen == 1) { 
		        		
		        		Contable a = new Contable();
		        		
		        		System.out.println(messages.getString("nIngresos"));
		        		int n = num.nextInt();
		        		double dep;
		        		List<Double> deposit = new ArrayList<Double>();
		        		for(int i = 0; i < n; i++) {
		        			System.out.println(messages.getString("deposit") + " " + (i + 1) );
		        			dep = num.nextDouble();
		        			deposit.add(dep);
		        		}
		        		
		        		a.work(Librarian.getBuy(), deposit, cuenta);
		        		Librarian.initializeBuy();
		        		deposit.clear();
		        		
		        		//es librero
		        	}else if(chosen == 2) { 
		        		Librarian l = new Librarian();
		        		l.work();
		        		
		        		// es de recursos humanos
		        	}else if(chosen == 3) { 
		        		System.out.println(messages.getString("hireEmployee"));
		        		int x = num.nextInt();
		        		String id, name, surname; int hiredYear = today.YEAR; double retribution = 0;
		        		System.out.println(messages.getString("id"));
		        		id = sn.nextLine();
		        		System.out.println(messages.getString("name"));
		        		name = sn.nextLine();
		        		System.out.println(messages.getString("surname"));
		        		surname = sn.nextLine();
		        		
		        		if (x == 1) {
		        			Employee e = new Contable(id, name, surname, hiredYear, retribution);
			        		HumanResources.hireEmployee(e);
		        		}else if(x == 2) {
		        			Employee e = new Librarian(id, name, surname, hiredYear, retribution);
			        		HumanResources.hireEmployee(e);
		        		}else if(x == 3) {
		        			Employee e = new HumanResources(id, name, surname, hiredYear, retribution);
			        		HumanResources.hireEmployee(e);
		        		}
		        		
		        	}
	   //------------------------------ USER ------------------------------------//     
		        }else if(op == 2) {
		        	
		        	while(option != 0) {
		        
		    		System.out.println(messages.getString("menu1"));
		    		option = num.nextInt();
		    		
		    		
		    		switch(option) {
		    			
						case 1:
							 //Search by isbn
							String cin;
							System.out.println(messages.getString("isbn"));
							cin = sn.nextLine();
							System.out.println(cin);
							Book theIsbnBook = biblio.searchByIsbn(cin);
							if(theIsbnBook != null) {
							 
								System.out.println(messages.getString("menu2"));
					    		int opcion = num.nextInt();
								if(opcion == 1) {
								//1. Book this book
								 
									 
									 String id;
									 if(theIsbnBook.getOcupacy()) {   //ya esta pillao el libro
										 System.out.println(messages.getString("alreadyBooked"));
										 
									 }else {
										 theIsbnBook.setBookedStatus(true); 
										 
										// Register movements
										 
										 System.out.println(messages.getString("id"));
										 id = sn.nextLine();
										 User thisUser = biblio.searchById(id);
										 
										 biblio.newMovement(thisUser, theIsbnBook, true);
										 							 
										 System.out.println(messages.getString("bookBooked"));
										 biblio.totalstock--;
									 }
								 
							 }else if(opcion == 2) { 
								 //2. Return this book to the library
						
								 if(!theIsbnBook.getOcupacy()) {    //excepcion de que no estuviera
									 System.out.println(messages.getString("alreadyLibrary"));
								 }
								 else {
									 String id;
									 theIsbnBook.setBookedStatus(false); 
									 
										// Register movements
										 
									 System.out.println(messages.getString("id"));
									 id = sn.nextLine();
									 User thisUser = biblio.searchById(id);
									 if (thisUser == null) {
										 throw new MyException();
									 }
										 
									 biblio.newMovement(thisUser, theIsbnBook, false);
									 							 
									 System.out.println(messages.getString("bookReturned"));
									 biblio.totalstock++;
								}
							}	 
						}
							 break;
						 
						 case 2:
							 //Search by title
							 System.out.println(messages.getString("title"));
							 cin = sn.nextLine();
							 Book theTitleBook = biblio.searchByTitle(cin);
							 if(theTitleBook != null) {
								 System.out.println(messages.getString("menu2"));
								 int opcion = num.nextInt();
								 if(opcion == 1) { //1. Book this book
									 if(theTitleBook.getOcupacy()) {
										 System.out.println(messages.getString("alreadyBooked"));
									 }else {
										 String id;
										 theTitleBook.setBookedStatus(true); 
										 
											// Register movements
											 
										 System.out.println(messages.getString("id"));
										 id = sn.nextLine();
										 
										 User thisUser = biblio.searchById(id);
											 
										 biblio.newMovement(thisUser, theTitleBook, true);
										 							 
										 System.out.println(messages.getString("bookBooked"));
										 biblio.totalstock--;
									 }
								 }else if(opcion == 2) { //2. Return this book to the library
									 if(!theTitleBook.getOcupacy()) {
										 System.out.println(messages.getString("alreadyLibrary"));
									 }
									 else {
										 String id;
										 theTitleBook.setBookedStatus(false); 
										 
										 // Register movements
											 
										 System.out.println(messages.getString("id"));
										 id = sn.nextLine();
										 User thisUser = biblio.searchById(id);
										 
										 biblio.newMovement(thisUser, theTitleBook, false);
									 
										 System.out.println(messages.getString("bookReturned"));
										 biblio.totalstock++;
									 }
								 }
							 }	 
						     break;
						 case 3:
							 String id;
							 String firstName;
							 String lastName;
							 String gender;
							 int age;
							 long cp;
							 //Register new user
							 System.out.println(messages.getString("id"));
							 id = sn.nextLine();
							 System.out.println(messages.getString("name"));
							 firstName = sn.nextLine();
							 System.out.println(messages.getString("surname"));
							 lastName = sn.nextLine();
							 System.out.println(messages.getString("gender"));
							 gender = sn.nextLine();
							 System.out.println(messages.getString("age"));
							 age = sn.nextInt();
							 System.out.println(messages.getString("postcode"));
							 cp = num.nextLong();
							 User theUser = new UserBuilder(id, firstName, lastName, gender).setAge(age).setCp(cp).build();
							 
							 System.out.println(theUser.getId() + messages.getString("registered"));
							 
							 break;
						 case 4:
							 //Search user by id
							 System.out.println(messages.getString("id"));
							 cin = sn.nextLine();
							 User theIdUser = biblio.searchById(cin);
							 if(theIdUser != null) {
								 System.out.println(messages.getString("searchresult1") + theIdUser.getFirstName() + " " + theIdUser.getLastName());
								 System.out.println(messages.getString("ask4delete"));
								 cin = sn.nextLine();
								 if(cin.equals("si")) { 
									 //delete user
									 biblio.deleteUser(theIdUser);
									 System.out.println(messages.getString("Deleted!"));
								 }
							 }else {
								 System.out.println(messages.getString("notFound"));
							 }
							 
							 break;
							 
						 case 5:
							 
							 biblio.printMovements();
							 
							 
						    	
							 
							 
							 break;
						 case 6:
							 
							Table<List<Book>> table = new Table<List<Book>>();
						    table.create_table(biblio.getAllBooks());
						    table.cuantityOrder();
						    break;
							 
						 default:
							 //Exit
							 option = 0;
							 break;
						}
		        	}
		        } 
	    	}
	        
        }catch(MyException e){
            System.out.println(e.rango());
            System.out.println(e.incompatible("Invalid"));
	}
	}
}


