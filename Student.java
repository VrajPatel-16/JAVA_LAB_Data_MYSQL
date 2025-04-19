// This class represents a Student with a name and a PRN (Permanent Registration Number).
 public class Student {
     private String name;  // Stores the student's name
     private long prn;     // Stores the student's PRN 
 
     // Constructor: Initializes a new Student object with the given name and PRN.
     public Student(String name, long prn) {
         setName(name);  // Set the student's name using the setter method
         setPRN(prn);    // Set the student's PRN using the setter method
     }
 
 }