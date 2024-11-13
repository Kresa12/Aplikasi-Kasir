/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package function;

/**
 *
 * @author rifial
 */
public class User {
    public User() {
        // Inisialisasi atribut dengan nilai default jika diperlukan
        this.ID_User = 0; 
        this.Nama = "";
        this.Username = "";
        this.Password = "";
        this.Level_Akses = ""; 
    }
    private int ID_User;
    private String Nama;
    private String Username;
    private String Password;
    private String Level_Akses;
    private byte[] foto;

    public User(int id_user, String nama, String username, String password, String level_akses) {
        this.ID_User = ID_User;
        this.Nama = Nama;
        this.Username = Username;
        this.Password = Password;
        this.Level_Akses = level_akses;
    }
     @Override
    public String toString() {
        return "User{" +
                "ID_User=" + ID_User +
                ", Nama='" + Nama + '\'' +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", levelAkses='" + Level_Akses + '\'' +
                '}';
    }
    // Getter
    public int getIdUser() {
        return ID_User;
    }
    
    public byte[] getFoto() {
        return foto;
    }

    public String getNama() {
        return Nama;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getLevelAkses()
 {
        return Level_Akses;
    }

    // Setter
    
    public void setIdUser(int ID_User) {
        this.ID_User = ID_User;
    }
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setLevelAkses(String Level_Akses) {
        this.Level_Akses = Level_Akses;
    }
 
}
