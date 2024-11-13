/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplikasi_kasir;



import function.LoginController;
import function.User;
import java.awt.event.KeyListener;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.awt.event.KeyEvent;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import unused.Functions_log;
import function.koneksi_database;
import unused.Profile;
import javax.swing.JFrame;
import java.util.Arrays;

@SuppressWarnings("serial")
public class Admin_Page extends javax.swing.JFrame {
    
    private User user;
    LoginController loginController = new LoginController();
    String loggedInUsername;

    Profile p;
    static DefaultTableModel m, mod_p;

    /**
     * Creates new form AdminPage
     */
    public Admin_Page() {
    initComponents();
    
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    txtKey.addKeyListener(new KeyListener() {
    boolean isDeleting = false;

    @Override
    public void keyTyped(KeyEvent e) {
        if (isDeleting) {
            String key = txtKey.getText();
            String where = "WHERE "
                    + "Nama LIKE '%" + key + "%' OR "
                    + "Username LIKE '%" + key + "%' OR "
                    + "Level_Akses LIKE '%" + key + "%'";
            viewData(where);
//            function.log.savelog("\n User data filtered with key: " + key);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
            isDeleting = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
            isDeleting = false;
        }
    }
});
    
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        txtCariProduk.addKeyListener(new KeyListener() {
        boolean isDeleting = false;

        @Override
        public void keyTyped(KeyEvent e) {
            if (isDeleting) {
                String key = txtCariProduk.getText();
                String where = "WHERE "
                    + "Kode_Produk LIKE ? OR "
                    + "Nama_Produk LIKE ? OR "
                    + "Stok LIKE ? OR "
                    + "Kategori LIKE ?";

                try (Connection K = koneksi_database.getConnection();
                     PreparedStatement P = K.prepareStatement("SELECT * FROM produk " + where)) {

                    P.setString(1, "%" + key + "%");
                    P.setString(2, "%" + key + "%");

                    if (isNumericColumn("produk", "Stok")) {
                        try {
                            int stok = Integer.parseInt(key);
                            P.setInt(3, stok);
                        } catch (NumberFormatException ex) {
                            P.setString(3, "");
                        }
                    } else {
                        P.setString(3, "%" + key + "%");
                    }
                    P.setString(4, "%" + key + "%");

                    try (ResultSet R = P.executeQuery()) {
                        viewDataProduct(R); 
//                        function.Log.savelog("\n Product data filtered with key: " + key);
                    }
                } catch (SQLException ex) {
                    function.Log.savelog("\n Error filtering product data: " + ex.getMessage());
                    function.Log.savelog("\n" + Arrays.toString(ex.getStackTrace()));
                    // Handle exceptions
                    
                    JOptionPane.showMessageDialog(Admin_Page.this, "Terjadi kesalahan saat memproses data. Silakan coba lagi.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
                isDeleting = true;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
                isDeleting = false;
            }
        }
    });
        
        
        
        settingTable();        
        viewData("");
        viewDataProduct("");
        function.Log.savelog("\n Admin page initialized with user profile"); // Log initialization
        
    }

    public Admin_Page(Profile P) {
        initComponents();

        
        this.p = P;
        labelUser.setText(p.getFullname() + "(" + p.getLevel() + ")");
        settingTable();   
        viewData("");
        function.Log.savelog("\n Admin page initialized "); // Log initialization
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelUser = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtKey = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbluser = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnTambahProdun = new javax.swing.JButton();
        btnUbahProduk = new javax.swing.JButton();
        btnHapusProduk = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCariProduk = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDataProduk = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 255, 102));

        labelUser.setText(" ");

        jButton5.setText("MENU UTAMA");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("WELCOME BACK!!");

        jButton6.setText("LOGOUT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(labelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(194, 194, 194))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jButton6)))
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton6)
                                .addComponent(jButton5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelUser)))
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(0, 102, 51));
        jPanel5.setPreferredSize(new java.awt.Dimension(680, 70));

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        jButton2.setText("Ubah");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Refresh");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, 40));

        txtKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKeyActionPerformed(evt);
            }
        });
        txtKey.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKeyKeyReleased(evt);
            }
        });
        jPanel6.add(txtKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 230, 38));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search-icon-24.png"))); // NOI18N
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, 40));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnTambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        tbluser.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tbluser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO", "ID USER", "NAMA LENGKAP", "USERNAME", "PASSWORD", "LEVEL AKSES"
            }
        ));
        tbluser.setRowHeight(30);
        jScrollPane1.setViewportView(tbluser);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Data User", jPanel2);

        jPanel3.setLayout(new java.awt.BorderLayout());

        btnTambahProdun.setText("Tambah");
        btnTambahProdun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahProdunActionPerformed(evt);
            }
        });

        btnUbahProduk.setText("Ubah");
        btnUbahProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahProdukActionPerformed(evt);
            }
        });

        btnHapusProduk.setText("Hapus");
        btnHapusProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusProdukActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, 36));

        txtCariProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariProdukActionPerformed(evt);
            }
        });
        txtCariProduk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariProdukKeyReleased(evt);
            }
        });
        jPanel8.add(txtCariProduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 6, 280, 36));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search-icon-24.png"))); // NOI18N
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, 30));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnTambahProdun)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUbahProduk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHapusProduk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambahProdun)
                    .addComponent(btnUbahProduk)
                    .addComponent(btnHapusProduk)
                    .addComponent(btnRefresh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        tblDataProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO", "ID", "KODE PRODUK", "NAMA PRODUK", "CATEGORY", "HARGA JUAL", "HARGA BELI", "STOK"
            }
        ));
        jScrollPane2.setViewportView(tblDataProduk);

        jPanel3.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Data Produk", jPanel3);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("ADMIN PAGE");
        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    // 1. Dapatkan username user yang sedang login
    String username = Login_Page.loggedInUsername;

    // 2. Ambil data user dari database
    LoginController loginController = new LoginController();
    User user = loginController.getProfil(username);

    // 3. Buat objek Menu_Utama dan teruskan objek user
    Menu_Utama menuUtama = new Menu_Utama(user); 
    menuUtama.setVisible(true);
    this.dispose();
    function.Log.savelog("Navigated to main menu");

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin logout?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION){
        // Tutup form saat ini
        this.dispose(); 

        // Tampilkan form login 
        Login_Page loginForm = new Login_Page();
        loginForm.setVisible(true); 
        String username = Login_Page.loggedInUsername; // Ambil username dari objek Profile
        function.Log.savelog("\n User logged out: " + username);
        User user = loginController.getProfil(username);
        
        if (user != null) {
            function.Log.savelog("\n User logged out information: " + user.toString()); // Gunakan toString() dari objek User
        } else {
            function.Log.savelog("\n User logged out (Profile not found for " + username + ")");
        }
    }     // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        viewDataProduct("");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnTambahProdunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahProdunActionPerformed
        Tambah_Produk TP = new Tambah_Produk(this, true);
        TP.setVisible(true);
    }//GEN-LAST:event_btnTambahProdunActionPerformed

    private void txtKeyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyKeyReleased
    String key = txtKey.getText();
    if (!key.isEmpty()) {
        String where = "WHERE "
                + "Nama LIKE '%" + key + "%' OR "
                + "Username LIKE '%" + key + "%' OR "
                + "Level_Akses LIKE '%" + key + "%'";
        viewData(where);
    }

    }//GEN-LAST:event_txtKeyKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        viewData("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        int n = tbluser.getSelectedRow();
        if(n != -1){
        int id = Integer.parseInt(tbluser.getValueAt(n, 1).toString());
        String fullname = tbluser.getValueAt(n, 2).toString();

        int opsi = JOptionPane.showConfirmDialog(this, 
                "Apakah Anda yakin ingin menghapus data "+fullname+"?", 
                "Hapus Data", 
                JOptionPane.YES_NO_OPTION);

        if(opsi == 0){
            String Q = "DELETE FROM pengguna WHERE ID_User=?"; 

            try (Connection K = koneksi_database.getConnection();
     PreparedStatement S = K.prepareStatement(Q)) {
    K.setAutoCommit(false);
    S.setInt(1, id);
    S.executeUpdate();
    K.commit(); // Delete the user first

    // Now fetch and log the deleted user details
    User userToDelete = loginController.getProfilById(id);
    if (userToDelete != null) {
        function.Log.savelog("\n User deleted: " + userToDelete.toString());
    } else {
        function.Log.savelog("\n User with ID " + id + " deleted (Profile not found)");
    }

    viewData("");
    JOptionPane.showMessageDialog(this, "Data " + fullname + " telah terhapus");

} catch (SQLException e) {
    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    function.Log.savelog("\n Error deleting user: " + e.getMessage()); // Log the error
}
        }

    }else {
        JOptionPane.showMessageDialog(this, "Anda belum memilih data");
    }

    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int n = tbluser.getSelectedRow();
        if(n != -1){
            int id = Integer.parseInt(tbluser.getValueAt(n, 1).toString());
            String Nama = tbluser.getValueAt(n, 2).toString();
            String Username = tbluser.getValueAt(n, 3).toString();
            String Password = tbluser.getValueAt(n, 4).toString();
            String Level_Akses = tbluser.getValueAt(n, 5).toString();
            Update_Data U = new Update_Data(this, true);
            U.setIdUser(id);
            U.setFullname(Nama);
            U.setUsername(Username);
            U.setPassword(Password);
            U.setLevel(Level_Akses);
            U.setVisible(true);

        }else {
            JOptionPane.showMessageDialog(this, "Anda belum memilih data");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        Tambah_Data T = new Tambah_Data(this, true);
        T.setVisible(true);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void txtKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKeyActionPerformed
     // TODO add your handling code here:
    String key = txtKey.getText();
    String where = "WHERE "
            + "Nama LIKE '%" + key + "%' OR "
            + "Username LIKE '%" + key + "%' OR "
            + "Level_Akses LIKE '%" + key + "%'";
    viewData(where); 
    }//GEN-LAST:event_txtKeyActionPerformed

    private void txtCariProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariProdukActionPerformed
    
    }//GEN-LAST:event_txtCariProdukActionPerformed

    private boolean isNumericColumn(String tableName, String columnName) {
    try (Connection K = koneksi_database.getConnection();
         Statement S = K.createStatement();
         ResultSet R = S.executeQuery("SELECT DATA_TYPE FROM INFORMATION_SCHEMA.COLUMNS "
                 + "WHERE TABLE_NAME = '" + tableName + "' AND COLUMN_NAME = '" + columnName + "'")) {
        if (R.next()) {
            String dataType = R.getString("DATA_TYPE");
            return dataType.equals("INT") || dataType.equals("DECIMAL") || dataType.equals("NUMERIC");
        }
    } catch (SQLException e) {
        // Handle the exception (e.g., print stack trace)
    }
    return false; // Default to non-numeric if there's an error
}
    
    
    
    
    private void btnHapusProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusProdukActionPerformed
        int n = tblDataProduk.getSelectedRow();
        if(n != -1){
        int id = Integer.parseInt(tblDataProduk.getValueAt(n, 1).toString());
        String namaproduk = tblDataProduk.getValueAt(n, 2).toString();

        int opsi = JOptionPane.showConfirmDialog(this, 
                "Apakah Anda yakin ingin menghapus data "+namaproduk+"?", 
                "Hapus Data", 
                JOptionPane.YES_NO_OPTION);

        if(opsi == 0){
            String Q = "DELETE FROM produk WHERE ID_Produk=?"; 

            try (Connection K = koneksi_database.getConnection();
                 PreparedStatement S = K.prepareStatement(Q)) {

                S.setInt(1, id);
                S.executeUpdate();
                viewData(""); 
                JOptionPane.showMessageDialog(this, "Data "+namaproduk+" telah terhapus");

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }

    }else {
        JOptionPane.showMessageDialog(this, "Anda belum memilih data");
    }        // TODO add your handling code here:
    }//GEN-LAST:event_btnHapusProdukActionPerformed

    private void btnUbahProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahProdukActionPerformed
    int n = tblDataProduk.getSelectedRow(); 
    if (n != -1) {
        int id = Integer.parseInt(tblDataProduk.getValueAt(n, 1).toString());
        String Kode_Produk = tblDataProduk.getValueAt(n, 2).toString();
        String Nama_Produk = tblDataProduk.getValueAt(n, 3).toString();
        String Kategori = tblDataProduk.getValueAt(n, 4).toString();
        Update_Produk U = new Update_Produk(this, true);
        U.setIdProduk(id);
        U.setKodeProduk(Kode_Produk);
        U.setNamaProduk(Nama_Produk);
        // Assuming you have a method to convert the string to Image
        U.setKategori(Kategori);
        U.setVisible(true);

    } else {
        JOptionPane.showMessageDialog(this, "Anda belum memilih data");
    }
//    
    }//GEN-LAST:event_btnUbahProdukActionPerformed

    private void txtCariProdukKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariProdukKeyReleased
    String key = txtCariProduk.getText();
    String where = "WHERE "
            + "Kode_Produk LIKE '%" + key + "%' OR "
            + "Nama_Produk LIKE '%" + key + "%' OR "
            + "Stok LIKE '%" + key + "%' OR "
            + "Kategori LIKE '%" + key + "%'";
    viewDataProduct(where);
    }//GEN-LAST:event_txtCariProdukKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapusProduk;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTambahProdun;
    private javax.swing.JButton btnUbahProduk;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelUser;
    private javax.swing.JTable tblDataProduk;
    private javax.swing.JTable tbluser;
    private javax.swing.JTextField txtCariProduk;
    private javax.swing.JTextField txtKey;
    // End of variables declaration//GEN-END:variables

    public static void viewData(String where) {
        try {
            //kode kita Bersama
            for (int i = m.getRowCount()-1; i >=0; i--) {
                m.removeRow(i);
            }

            Connection K = koneksi_database.getConnection();
            Statement S = K.createStatement();
            String Q = "SELECT * FROM pengguna " + where;
//            System.out.println(Q);
            ResultSet R = S.executeQuery(Q);
            int no = 1;
            while (R.next()) {
                int ID_User = R.getInt("ID_User");
                String Nama = R.getString("Nama");
                String Username = R.getString("Username");
                String Password = R.getString("Password");
                String Level_Akses = R.getString("Level_Akses");

                Object[] D = {no, ID_User, Nama, Username, Password, Level_Akses};
                m.addRow(D);

                no++;
            }
        } catch (SQLException e) {
            //error handling
        }
    }
    
        public static void viewDataProduct(String where) {
        try {
            System.out.println("Entering viewDataProduct() method");
            //kode kita
            for (int i = mod_p.getRowCount()-1; i >=0; i--) {
                mod_p.removeRow(i);
            }
            
             for (int i = 0; i < mod_p.getRowCount(); i++) {
                mod_p.removeRow(i);
            }

            Connection K = koneksi_database.getConnection();
            Statement S = K.createStatement();
            String Q = "SELECT * FROM produk " + where;
            System.out.println(Q);
            ResultSet R = S.executeQuery(Q);
            int no = 1;
            while (R.next()) {
                int id = R.getInt("ID_Produk");
                String p_code = R.getString("Kode_Produk");
                String p_name = R.getString("Nama_Produk");
                String p_category  = R.getString("Kategori");
                String p_price_s = R.getString("Harga_jual");
                String p_price_b = R.getString("Harga_beli");
                String p_stock = R.getString("Stok");

                Object[] D = {
                    no, id, p_code,p_name, 
                    p_category, p_price_s, p_price_b, p_stock};
                mod_p.addRow(D);

                no++;
            }
            function.Log.savelog("\n Sukses mengambil data produk"); 
        } catch (SQLException e) {
            //error handling
            function.Log.savelog("\n Gagal menampilkan data produk. "+e.getMessage()); 
        }
         System.out.println("\n Exiting viewDataProduct() method");
    }
        
        
    public static void viewDataProduct(ResultSet R) { // Modified to accept ResultSet
    try {
        for (int i = mod_p.getRowCount() - 1; i >= 0; i--) {
            mod_p.removeRow(i);
        }

        int no = 1;
        while (R.next()) {
            int id = R.getInt("ID_Produk");
            String p_code = R.getString("Kode_Produk");
            String p_name = R.getString("Nama_Produk");
            String p_category = R.getString("Kategori");
            String p_price_s = R.getString("Harga_jual");
            String p_price_b = R.getString("Harga_beli");
            String p_stock = R.getString("Stok");

            Object[] D = {no, id, p_code, p_name, p_category, p_price_s, p_price_b, p_stock};
            mod_p.addRow(D);

            no++;
        }
        function.Log.savelog("\n Sukses mengambil data produk");
    } catch (SQLException e) {
        function.Log.savelog("\n Gagal menampilkan data produk. " + e.getMessage());
    }
}
    

    private void settingTable() {
        m = (DefaultTableModel) tbluser.getModel();        
        tbluser.getColumnModel().getColumn(0).setMinWidth(50);
        tbluser.getColumnModel().getColumn(0).setMaxWidth(70);

        tbluser.getColumnModel().getColumn(1).setMinWidth(0);
        tbluser.getColumnModel().getColumn(1).setMaxWidth(0);

        tbluser.getColumnModel().getColumn(2).setMinWidth(350);
        tbluser.getColumnModel().getColumn(2).setMaxWidth(500);
    
        
        mod_p = (DefaultTableModel) tblDataProduk.getModel();        
        tblDataProduk.getColumnModel().getColumn(0).setMinWidth(50);
        tblDataProduk.getColumnModel().getColumn(0).setMaxWidth(70);

        tblDataProduk.getColumnModel().getColumn(1).setMinWidth(0);
        tblDataProduk.getColumnModel().getColumn(1).setMaxWidth(0);      
    
    }

}
