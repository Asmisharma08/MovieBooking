testdatabaseconn.java


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testdatabaseconn {
    public static void main(String[] args) {
        // Database credentials and URL
        String url = "jdbc:mysql://localhost:3306/movieticketbookingsystem?useSSL=false&allowPublicKeyRetrieval=true";
        String user = "root";
        String pass = "AS4086@4086"; // Replace with your actual MySQL password

        Connection conn = null;
        try {
            // Explicitly load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection successful!");

            // You can now use conn to perform database operations

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found! Make sure the .jar file is added to the classpath.");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        } finally {
            // Close the connection in the finally block to ensure it's always closed
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
