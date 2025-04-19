import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.SQLException;
 
 // This class is responsible for creating a connection to the MySQL database

 public class DBConnection {

     // This method establishes and returns a connection to the MySQL database

     public static Connection getConnection() throws SQLException {
         // JDBC URL for connecting to the database
         String url = "jdbc:mysql://localhost:3306/studentdb";
         // Username for the MySQL database
         String user = "root";
         // Password for the MySQL user account
         String password = "********"; // update this
 
         // Return a connection object using the provided URL, username, and password
         return DriverManager.getConnection(url, user, password);
     }
 }