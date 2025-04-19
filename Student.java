// This class represents a Student with a name and a PRN (Permanent Registration Number).
 public class Student {
     private String name;  // Stores the student's name
     private long prn;     // Stores the student's PRN (unique identifier)
 
     // Constructor: Initializes a new Student object with the given name and PRN.
     public Student(String name, long prn) {
         setName(name);  // Set the student's name using the setter method
         setPRN(prn);    // Set the student's PRN using the setter method
     }
     // Setter method to update the student's name
     public void setName(String name){
         this.name = name;  // Assigns the given name to the instance variable
     }
 
     // Getter method to retrieve the student's name
     public String getName() {
         return name;  // Returns the student's name
     }
     
     // Setter method to update the student's PRN
     public void setPRN(long prn){
         this.prn = prn;  // Assigns the given PRN to the instance variable
     }
 
     // Getter method to retrieve the student's PRN
     public long getPRN() {
         return prn;  // Returns the student's PRN
     }
 
 }