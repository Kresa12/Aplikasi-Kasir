package function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/aplikasi_kasir";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public String authenticate(String username, String password) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("Koneksi database berhasil!");

            String sql = "SELECT * FROM pengguna WHERE Username = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String storedPassword = resultSet.getString("Password");

                        if (password.equals(storedPassword)) {
                            return "success"; // Login berhasil
                        } else {
                            return "Password salah!";
                        }
                    } else {
                        return "Username tidak ditemukan!";
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error database: " + e.getMessage());
                return "Error koneksi database: " + e.getMessage();
            }
        } catch (SQLException e) {
            System.err.println("Error koneksi database: " + e.getMessage());
            return "Error koneksi database: " + e.getMessage();
        }
    }

    public User getProfil(String username) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "SELECT * FROM pengguna WHERE Username = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                System.out.println("Query yang dijalankan: " + sql); // Debug
                System.out.println("Username di query: " + username); // Debug

                try (ResultSet resultSet = statement.executeQuery()) {
                    
                    if (resultSet.next()) {
                        // 1. Buat objek User dengan nilai default
                        User user = new User();

                        // 2. Isi atribut User dengan data dari ResultSet
                        user.setIdUser(resultSet.getInt("ID_User"));
                        user.setNama(resultSet.getString("Nama"));
                        user.setUsername(username); // Pastikan username diisi
                        user.setPassword(resultSet.getString("Password"));
                        user.setLevelAkses(resultSet.getString("Level_Akses"));

                        System.out.println("Isi ResultSet:"); // Debug
                        System.out.println("ID_User: " + resultSet.getInt("ID_User"));
                        System.out.println("Nama: " + resultSet.getString("Nama"));
                        // ... Anda bisa menambahkan  System.out.println() untuk kolom lain ...

                        // 3. Kembalikan objek User
                        return user;
                    } else {
                        // Handle jika user tidak ditemukan
                        System.err.println("User tidak ditemukan di database!");
                        return null;
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error database: " + e.getMessage());
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Error koneksi database: " + e.getMessage());
            return null;
        }
    }
    // In LoginController class
public User getProfilById(int id) {
    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
        String sql = "SELECT * FROM pengguna WHERE ID_User = ?"; // Use ID_User in the query
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id); // Set the ID parameter

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    User user = new User();
                    user.setIdUser(resultSet.getInt("ID_User"));
                    user.setNama(resultSet.getString("Nama"));
                    user.setUsername(resultSet.getString("Username"));
                    user.setPassword(resultSet.getString("Password"));
                    user.setLevelAkses(resultSet.getString("Level_Akses"));
                    return user;
                } else {
                    // Handle if user not found
                    System.err.println("User with ID " + id + " not found in the database!");
                    return null;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error database: " + e.getMessage());
            return null;
        }
    } catch (SQLException e) {
        System.err.println("Error koneksi database: " + e.getMessage());
        return null;
    }
    
}
}