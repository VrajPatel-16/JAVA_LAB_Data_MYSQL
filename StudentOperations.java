import java.sql.*;
 
 // This class provides CRUD operations for the 'students' table in the database
 public class StudentOperations {
 
     // Adds a new student to the database
     public void addStudent(Student student) {
         String sql = "INSERT INTO students (name, prn) VALUES (?, ?)";
         // Establishes a database connection and prepares a SQL statement using try-with-resources.
         try (Connection con = DBConnection.getConnection();
              PreparedStatement ps = con.prepareStatement(sql)) {
 
             // Set values for name and PRN in the query
             ps.setString(1, student.getName());
             ps.setLong(2, student.getPRN());
 
             // Execute the insert operation
             ps.executeUpdate();
             System.out.println("Student added successfully.");
         } catch (SQLException e) {
             System.out.println("Error: " + e.getMessage());
         }
     }
 }