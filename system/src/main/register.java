package main;

import config.config;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author USER16
 */
public class register extends javax.swing.JFrame {

    public register() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); 
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("REGISTRATION");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 180, 40));

        jLabel4.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); 
        jLabel4.setText("Full Name:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, 20));

        txtFullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFullNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 230, 30));

        jLabel5.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); 
        jLabel5.setText("Email:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, -1, -1));

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 230, 30));

        jLabel6.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); 
        jLabel6.setText("Password:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, -1, 30));

        btnPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(btnPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 230, 30));

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); 
        jButton1.setText("Enter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 70, 30));

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); 
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("STUDENT INFORMATION SYSTEM");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        jButton2.setBackground(new java.awt.Color(153, 153, 255));
        jButton2.setFont(new java.awt.Font("Palatino Linotype", 1, 13)); 
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, 70, 30));

        jLabel10.setText("jLabel10");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, 0, 450, 490));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {}                                           

    private void btnPasswordActionPerformed(java.awt.event.ActionEvent evt) {}                                              

    private void txtFullNameActionPerformed(java.awt.event.ActionEvent evt) {}                                              

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        config con = new config();
        String name = txtFullName.getText().trim();
        String email = txtEmail.getText().trim();
        String pass = new String(btnPassword.getPassword());

        if (name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill up all fields!");
            return;
        }

        if (!email.toLowerCase().endsWith("@gmail.com")) {
            JOptionPane.showMessageDialog(this, "Invalid Email! Use @gmail.com only.");
            return;
        }

        try {
            Connection conn = config.connectDB();
            String checkSql = "SELECT email FROM tbl_user WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(checkSql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Email is already registered!");
                conn.close();
                return; 
            }
            
            rs.close();
            pstmt.close();
            conn.close();

            String sql = "INSERT INTO tbl_user (fullname, email, password, role, status) VALUES (?, ?, ?, ?, 'Pending')";
            con.addRecord(sql, name, email, pass, "Student");
            
            JOptionPane.showMessageDialog(null, "Successfully Registered! Status is PENDING.");
            new login().setVisible(true);
            this.dispose();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage());
        }
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new landing().setVisible(true);
        this.dispose();
    }                                        

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new register().setVisible(true));
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPasswordField btnPassword;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    // End of variables declaration                   
}