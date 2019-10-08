package Practicas;

import java.util.Scanner;

public class Main {
	public Scanner sn = new Scanner(System.in);
	int menu(){	
		
		int opcion; // user choice
		
		System.out.println("1. Search a book by its ISBN");
		System.out.println("2. Search a book by its title");
		System.out.println("3. Register a new user");
		System.out.println("4. Search user by ID");
		System.out.println("5. Library register");
		System.out.println("0. Exit");
		
	    opcion = sn.nextInt();
	    return opcion;	
	}
	int menu2() {
		
		int opcion; // user choice
		System.out.println("1. Book this book");
		System.out.println("2. Return this book to the library");
		System.out.println("3. Exit. ");
		
		opcion = sn.nextInt();
		return opcion;	
	}
	
//======================= MAIN =========================//
	
	public static void main(String[] args) {
		Biblioteca biblio = new Biblioteca("Nebrix");
    	Main menus = new Main();
    	Scanner sn = new Scanner(System.in);
    	String cin;
    	biblio.readBooksFile();
    	biblio.readUsersFile();
    	int option = 1;
    	while(option != 0) {
    		option = menus.menu();
    		switch(option) {
				 case 1:
					 //Search by isbn
				 System.out.println("ISBN: ");
				 cin = sn.nextLine();
				 Book theIsbnBook = biblio.searchByIsbn(cin);
				 if(theIsbnBook != null) {
					 
					 int opcion = menus.menu2();
					 if(opcion == 1) {
						//1. Book this book
						 
						 int iniday, inimonth, endday, endmonth;
						 String cin2;
						 if(theIsbnBook.getOcupacy() == true) {   //ya esta pillao el libro
							 System.out.println("Its already booked. ");
							 
						 }else {
							 theIsbnBook.setBookedStatus(true);
							 
							 
							// Register movements
							 
							 System.out.println("Dime tu id de usuario: ");
							 cin2 = sn.nextLine();
							 System.out.println("Introduce the start day of your reserve(number)");
							 iniday = sn.nextInt();
							 System.out.println("Introduce the month of your reserve(number)");
							 inimonth = sn.nextInt();
							 System.out.println("Introduce the end day of your reserve(number)");
							 endday = sn.nextInt();
							 System.out.println("Introduce the month of your devolution(number)");
							 endmonth = sn.nextInt();
							 
							 biblio.newMovement(cin2, cin, iniday, inimonth, endday, endmonth, true);
							 							 
							 System.out.println("Book booked!");
						 }
						 
					 }else if(opcion == 2) { 
						 //2. Return this book to the library
						 int iniday, inimonth, endday, endmonth;
						 String cin2;
						 if(theIsbnBook.getOcupacy() == false) {    //excepcion de que no estuviera
							 System.out.println("Its already in the library. ");
						 }
						 else
							 theIsbnBook.setBookedStatus(false);
						 
						 //Movements
						 System.out.println("Dime tu id de usuario: ");
						 cin2 = sn.nextLine();
						 System.out.println("Introduce the start day of your reserve(number)");
						 iniday = sn.nextInt();
						 System.out.println("Introduce the month of your reserve(number)");
						 inimonth = sn.nextInt();
						 System.out.println("Introduce the end day of your reserve(number)");
						 endday = sn.nextInt();
						 System.out.println("Introduce the month of your devolution(number)");
						 endmonth = sn.nextInt();
						 
						 biblio.newMovement(cin2, cin, iniday, inimonth, endday, endmonth, false);
						 							 
						 System.out.println("Book returned!");
						
						 }	 
					 }
					 break;
					 
				 case 2:
					 //Search by title
					 System.out.println("Title: ");
					 cin = sn.nextLine();
					 Book theTitleBook = biblio.searchByTitle(cin);
					 if(theTitleBook != null) {
						 int opcion = menus.menu2();
						 if(opcion == 1) { //1. Book this book
							 if(theTitleBook.getOcupacy() == true) {
								 System.out.println("Its already booked. ");
							 }else {
								 theTitleBook.setBookedStatus(true);
								 
								//Movements
								 int iniday, inimonth, endday, endmonth;
								 String cin2;
								 System.out.println("Dime tu id de usuario: ");
								 cin2 = sn.nextLine();
								 System.out.println("Introduce the start day of your reserve(number)");
								 iniday = sn.nextInt();
								 System.out.println("Introduce the month of your reserve(number)");
								 inimonth = sn.nextInt();
								 System.out.println("Introduce the end day of your reserve(number)");
								 endday = sn.nextInt();
								 System.out.println("Introduce the month of your devolution(number)");
								 endmonth = sn.nextInt();
								 
								 biblio.newMovement(cin2, cin, iniday, inimonth, endday, endmonth, true);
								 							 
								 System.out.println("Book booked!");
							 }
						 }else if(opcion == 2) { //2. Return this book to the library
							 if(theTitleBook.getOcupacy() == false) {
								 System.out.println("Este libro ya está en la biblioteca");
							 }
							 else {
								 theTitleBook.setBookedStatus(false);
								 
								 //Movements
								 int iniday, inimonth, endday, endmonth;
								 String cin2;
								 System.out.println("Dime tu id de usuario: ");
								 cin2 = sn.nextLine();
								 System.out.println("Introduce the start day of your reserve(number)");
								 iniday = sn.nextInt();
								 System.out.println("Introduce the month of your reserve(number)");
								 inimonth = sn.nextInt();
								 System.out.println("Introduce the end day of your reserve(number)");
								 endday = sn.nextInt();
								 System.out.println("Introduce the month of your devolution(number)");
								 endmonth = sn.nextInt();
								 
								 biblio.newMovement(cin2, cin, iniday, inimonth, endday, endmonth, true);
								 							 
								 System.out.println("Book booked!");
							 }
						 }
					 }
    		
					 
				    		 
				     break;
				 case 3:
					 String id, firstName, lastName, gender;
					 int age;
					 double cp;
					 //Register new user
					 System.out.println("DNI: ");
					 id = sn.nextLine();
					 System.out.println("Nombre: ");
					 firstName = sn.nextLine();
					 System.out.println("Apellido: ");
					 lastName = sn.nextLine();
					 System.out.println("Genero: ");
					 gender = sn.nextLine();
					 System.out.println("Edad: ");
					 age = sn.nextInt();
					 System.out.println("Codigo postal: ");
					 cp = sn.nextDouble();
					 User theUser = new User(id, firstName, lastName, gender, age, cp, 0);
					 System.out.println("Usuario registrado!");
					 System.out.println("El usuario" + theUser.getId() + "ha sido registrado!");
					 
					 break;
				 case 4:
					 //Search user by id
					 System.out.println("ID: ");
					 cin = sn.nextLine();
					 User theIdUser = biblio.searchById(cin);
					 if(theIdUser != null) {
						 String opcion = "";
						 System.out.println("Do you want to delete this user? ");
						 if(opcion.equals("si")) { //1. Book this book
							 biblio.deleteUser(theIdUser);
						 }
					 }
					 
					 break;
					 
				 case 5:
					 biblio.printMovements();
					 System.out.println("ya");
					 
					 break;
				 default:
					 //Exit
					 option = 0;
					 break;
			}
    	}
    }
}


