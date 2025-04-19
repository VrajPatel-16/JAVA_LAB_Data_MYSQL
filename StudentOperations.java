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
 
     // Displays all students from the database
     public void displayStudents() {
         String sql = "SELECT * FROM students";
         // Establishes a database connection and prepares a SQL statement using try-with-statements.
         try (Connection con = DBConnection.getConnection();
              Statement st = con.createStatement();
              ResultSet rs = st.executeQuery(sql)) {
 
             // Iterate over the result set and print student details
             while (rs.next()) {
                 System.out.println("Name: " + rs.getString("name") + ", PRN: " + rs.getLong("prn"));
             }
         } catch (SQLException e) {
             System.out.println("Error: " + e.getMessage());
         }
     }
 
     // Searches for a student by their PRN
     public void searchByPRN(long prn) {
         String sql = "SELECT * FROM students WHERE prn=?";
         // Establishes a database connection and prepares a SQL statement using try-with-statements.
         try (Connection con = DBConnection.getConnection();
              PreparedStatement ps = con.prepareStatement(sql)) {
             // Set the PRN parameter
             ps.setLong(1, prn);
             ResultSet rs = ps.executeQuery();
             // If student found, print their details
             if (rs.next()) {
                 System.out.println("Name: " + rs.getString("name") + ", PRN: " + rs.getLong("prn"));
             } else {
                 System.out.println("Student not found.");
             }
         } catch (SQLException e) {
             System.out.println("Error: " + e.getMessage());
         }
     }
 
 }