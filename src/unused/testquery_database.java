package unused;


import function.koneksi_database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class testquery_database {
    public static void main(String[] args) {
        try (Connection connection = koneksi_database.getConnection()) {
            String sql = "INSERT INTO Pengguna (Nama, Username, Password, Level_Akses) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "Rifyal");
            statement.setString(2, "rifyal1");
            statement.setString(3, "1234");
            statement.setString(4, "admin");
            statement.executeUpdate();
            System.out.println("Data user berhasil ditambahkan!");
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}