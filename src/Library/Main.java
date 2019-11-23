
package library;

import java.util.*;




public class Main {


	
	
//====================== MAIN =========================//
	
	public static void main(String[] args) throws MyException {

		try{
			
			Biblioteca biblio = new Biblioteca("Nebrix");
			
			//-------------- READING FILES
			biblio.readBooksFile();
	    	biblio.readUsersFile();
	    	biblio.readEmployeesFile();
		
	    	
	    	//-------------- INTERNATIONALITATION
	    	Locale currentLocale = Locales.setLocale();
	    	ResourceBundle messages;
	        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
	        
	        //------------------------------------------------------
	    	Scanner sn = new Scanner(System.in);
	    	Scanner num = new Scanner(System.in);

	    	int op;
	    	int option = 1;
	        System.out.println(messages.getString("chooseMenu"));
	        //Choose between employee and user
	        op = num.nextInt();
	        if(op == 1) {
		        String tryPassword;
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
	        	int choosen = 0;
	        	System.out.println(messages.getString("menuEmployees"));
	        	choosen = num.nextInt();
	        	if(choosen == 1) {
	        		
	        	}else if(choosen == 2) {
	        		
	        	}else if(choosen == 3) {
	        		Employee e = new Contable("sdfghjk7","pepo", "ruiz", 4567, 5678);
	        		HumanResources.hireEmployee(e);
	        	}

	        	switch(choosen) {
	        		case 1:
	        			//funciones de librero
	        			int a; 
	        			messages.getString("");
	        			a = num.nextInt();
	        			if(a == 1){
	        				int b;
	        			}else if(a == 2){
	        				
	        			}
	        				
	        			break;
	        		case 2:
	        			//funciones de contable
	        				
	        			break;
	        	}

	        	
	        }
	        else if(op == 2) {
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
						 User theUser = new User(id, firstName, lastName, gender, age, cp, 0);
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
							 System.out.println(messages.getString("userNotFound"));
						 }
						 
						 break;
						 
					 case 5:
						 
						 biblio.printMovements();
						 
						 Table table = new Table();
					    	List<Book> boo = biblio.getAllBooks();
					    	System.out.println(boo.size());
					    	
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
	        
        }catch(MyException e){
            System.out.println(e.rango());
            System.out.println(e.incompatible("Invalid"));
	}
	}
}


