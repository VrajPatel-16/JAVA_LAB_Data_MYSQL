import java.util.Scanner;
 
 class InvalidChoiceException extends Exception {
     public InvalidChoiceException(String message) {
         super(message);
     }
 }
 
 public class Main {
     public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
         StudentOperations operations = new StudentOperations();
         int choice;
 
         do {
             // Displaying menu options for user interaction
             System.out.println("\n--- Student Management System ---");
             System.out.println("1. Add Student");
             System.out.println("2. Display All Students");
             System.out.println("3. Search by PRN");
             System.out.println("4. Search by Name");
             System.out.println("5. Search by Position");
             System.out.println("6. Update Student");
             System.out.println("7. Delete Student");
             System.out.println("8. Exit");
             System.out.print("Enter your choice: ");
             try {
                 choice = scan.nextInt(); // Taking user input for menu selection
                 scan.nextLine(); // Clear buffer
 
                 //Custom validation: Check if the choice is within valid range
                 if (choice < 1 || choice > 8) {
                     throw new InvalidChoiceException("Invalid choice! Please enter a number between 1 and 8.");
                 }
                 //Perform actions based on user's menu choice
                 switch (choice) {
                     case 1:
                         // Add a new student
                         System.out.print("Enter Name: ");
                         String name = scan.nextLine();
                         System.out.print("Enter PRN: ");
                         long prn = scan.nextLong();
                         operations.addStudent(new Student(name, prn));
                         break;
                     case 2:
                         // Display all students
                         operations.displayStudents();
                         break;
                     case 3:
                         // Search student by PRN
                         System.out.print("Enter PRN to search: ");
                         long searchPrn = scan.nextLong();
                         operations.searchByPRN(searchPrn);
                         break;
                     case 4:
                         // Search student by Name
                         System.out.print("Enter Name to search: ");
                         String searchName = scan.nextLine();
                         operations.searchByName(searchName);
                         break;
                     case 5:
                         // Search student by Position
                         System.out.print("Enter Position to search: ");
                         int pos = scan.nextInt();
                         operations.searchByPosition(pos);
                         break;
                     case 6:
                         // Update student's name using PRN
                         System.out.print("Enter PRN to update: ");
                         long updatePrn = scan.nextLong();
                         scan.nextLine();
                         System.out.print("Enter New Name: ");
                         String newName = scan.nextLine();
                         operations.updateStudent(updatePrn, newName);
                         break;
                     case 7:
                         // Delete student using PRN
                         System.out.print("Enter PRN to delete: ");
                         long deletePrn = scan.nextLong();
                         operations.deleteStudent(deletePrn);
                         break;
                     case 8:
                         // Exit the program
                         System.out.println("Exiting... Thank you!");
                         break;
                 }
             } catch (InvalidChoiceException e) {
                 // Catch and display custom exception message for invalid menu choice
                 System.out.println("Invalid Choice Error: " + e.getMessage());
                 choice = 0; // Prevents accidental exit from loop
             } catch (Exception e) {
                 // Handle other exceptions gracefully
                 System.out.println("General Error: " + e.getMessage());
                 choice = 0;
                 scan.nextLine(); // Clear buffer to prevent input skipping
             }
         } while (choice != 8); 
 
         scan.close(); 
     }
 }