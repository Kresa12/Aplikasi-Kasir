/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package function;

/**
 *
 * @author rifial
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserController {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/aplikasi_kasir";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public String ubahFotoProfil(String username, String imagePath) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             FileInputStream fileInputStream = new FileInputStream(imagePath);
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE pengguna SET foto = ? WHERE Username = ?")) {

            statement.setBinaryStream(1, fileInputStream, fileInputStream.available());
            statement.setString(2, username);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                return "Foto profil berhasil diubah!";
            } else {
                return "Gagal mengubah foto profil.";
            }

        } catch (SQLException | IOException e) {
            System.err.println("Error: " + e.getMessage());
            return "Error: " + e.getMessage();
        }
    }
}