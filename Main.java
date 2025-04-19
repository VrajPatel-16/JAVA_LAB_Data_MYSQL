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