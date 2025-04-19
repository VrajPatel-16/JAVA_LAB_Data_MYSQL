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
 
     // Searches for students whose names contain the given string (case-insensitive)
     public void searchByName(String name) {
         String sql = "SELECT * FROM students WHERE name LIKE ?";
         // Establishes a database connection and prepares a SQL statement using try-with-statements.
         try (Connection con = DBConnection.getConnection();
              PreparedStatement ps = con.prepareStatement(sql)) {
             // Use wildcard % for partial matches
             ps.setString(1, "%" + name + "%");
             ResultSet rs = ps.executeQuery();
             // Print each matching student
             while (rs.next()) {
                 System.out.println("Name: " + rs.getString("name") + ", PRN: " + rs.getLong("prn"));
             }
         } catch (SQLException e) {
             System.out.println("Error: " + e.getMessage());
         }
     }
 
     // Searches for a student based on their position in the sorted list (by PRN)
     public void searchByPosition(int position) {
         String sql = "SELECT * FROM students ORDER BY prn ASC LIMIT 1 OFFSET ?";
         // Establishes a database connection and prepares a SQL statement using try-with-statements.
         try (Connection con = DBConnection.getConnection();
              PreparedStatement ps = con.prepareStatement(sql)) {
             // Set the offset (position - 1 because SQL OFFSET is 0-based)
             ps.setInt(1, position - 1);  // position is 1-based; OFFSET is 0-based
             ResultSet rs = ps.executeQuery();
             // If found, print student details
             if (rs.next()) {
                 System.out.println("Name: " + rs.getString("name") + ", PRN: " + rs.getLong("prn"));
             } else {
                 System.out.println("No student found at position " + position + ".");
             }
         } catch (SQLException e) {
             System.out.println("Error: " + e.getMessage());
         }
     }
     // Updates the name of a student identified by PRN
     public void updateStudent(long prn, String newName) {
         String sql = "UPDATE students SET name=? WHERE prn=?";
         // Establishes a database connection and prepares a SQL statement using try-with-statements.
         try (Connection con = DBConnection.getConnection();
              PreparedStatement ps = con.prepareStatement(sql)) {
             // Set the new name and the PRN
             ps.setString(1, newName);
             ps.setLong(2, prn);
             // Execute the update and check if any row was updated
             int rows = ps.executeUpdate();
             if (rows > 0) {
                 System.out.println("Student updated successfully.");
             } else {
                 System.out.println("Student not found.");
             }
         } catch (SQLException e) {
             System.out.println("Error: " + e.getMessage());
         }
     }
 
     // Deletes a student from the database based on PRN
     public void deleteStudent(long prn) {
         String sql = "DELETE FROM students WHERE prn=?";
         // Establishes a database connection and prepares a SQL statement using try-with-statements.
         try (Connection con = DBConnection.getConnection();
              PreparedStatement ps = con.prepareStatement(sql)) {
             // Set the PRN of the student to delete
             ps.setLong(1, prn);
             // Execute deletion and check if any row was deleted
             int rows = ps.executeUpdate();
             if (rows > 0) {
                 System.out.println("Student deleted successfully.");
             } else {
                 System.out.println("Student not found.");
             }
         } catch (SQLException e) {
             System.out.println("Error: " + e.getMessage());
         }
     }
 
 }