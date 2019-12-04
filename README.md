# Practicas
## This is a program based on a international library. 

## PROGRAM:

        1. User:
            You can search, book or return a book.
                        1. Search a book by its ISBN
                        2. Search a book by its title
                        3. Register a new user
                        4. Search user by ID
                        5. Library register (show all the movements made by users, and predict the return date of the books booked)
                        6. Table and order table (this function is thought to future statistics. It give you each book bokeed in order of its number of uses.)
                        0. Exit
                        
        2. Employee:
            Is a private area for employees to manage their own data, such as  their salary. And to work.
                        1. Librarian
                                The person in charge of demanding the necessary stock of each book, and leave the contable pending to pay.
                        2. Contable
                                The person in charge of paying the librarian's demands and also in charge of depositing money tu the library account.
                                This functions are executed paralelly using Threads.
                        3. Human Resources
                        The person in charge of hiring the necessary employees: librarians, contables or human resources'.



## Highlight of this program

            -  Heritages: 
                I have implemented a heritage of employees to manage their retribution/salary increase depending on their antiquity on the library and their salary.
                
            - Interfaces: 
                I have implemented four interfaces. 
                    1. An interface for searches.
                    2. An interface for each employeeID
                    3. An interface for employee' s work functions;
                    4. An interface for setting up tables.
                    
            - Tests:
                I have implemented several tests, which i found very useful for making quicker the error detection, and for checking the entire correctly functioning.
                You can find test of almost every class, including interfaces and heritages mentioned before, and also internationalization, threads, synchronitation, etc...
                
            - Exceptions:
                I have implemented my own exceptions class. It throws exceptions for range and incompatibility error.
                
            - Data Base:
                It is connected to a database with 3 tables: books, users and employees.
                It read the data from csv's. I used MySQL and MySQL Workbench.
     

## Discussions(Client Oriented)

### 1. Interface Enhacement / Code Refactoring :
#### In this moment there are some interfaces of the application that are useless because there are some functions that need a reformulation due to some updates in the rest of the app. 
#### In consequence, we are refactoring the code to be able to give the users all the functionality in a short period time.

## CONCLUSION:

Doing this program I have learnt a lot of things related with java, including testing my program, creating menus with different options, or internationalize my program. I also have learnt to use Sonar Lint, which is a programm that indicates you ways of optimizating your code.
