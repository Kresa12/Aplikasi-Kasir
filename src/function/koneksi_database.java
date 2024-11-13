package function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi_database {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/aplikasi_kasir"; 
            String user = "root"; 
            String password = ""; 
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return connection;
    }
}