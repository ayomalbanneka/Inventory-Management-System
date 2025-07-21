package lk.jiat.ims.gui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import javax.swing.ImageIcon;
import raven.toast.Notifications;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import lk.jiat.ims.loggers.CustomLoggers;
import lk.jiat.ims.util.AppIconUtil;
import lk.jiat.ims.util.validate.Validator;

/**
 *
 * @author Ayoma
 */
public class LoginScreen extends javax.swing.JFrame {

    public LoginScreen() {
        initComponents();
        init();
    }

    private void init() {

        AppIconUtil.applyIcon(this);

        logo.setIcon(new ImageIcon(getClass().getResource("/lk/jiat/ims/img/inventory.png")));
        loginImage.setIcon(new FlatSVGIcon("lk/jiat/ims/img/login_screen.svg", loginImage.getWidth(), loginImage.getHeight()));

        signInBtn.putClientProperty(FlatClientProperties.STYLE, "arc:999");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        logo = new javax.swing.JLabel();
        loginImage = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        usernameInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        passwordInput = new javax.swing.JPasswordField();
        signInBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inventura Warehouse Inventory Management System");
        setResizable(false);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        logo.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Inventura Warehouse");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Username");

        usernameInput.setText("ayomal111");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Password");

        passwordInput.setText("Ayomal@123");

        signInBtn.setBackground(new java.awt.Color(0, 0, 0));
        signInBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        signInBtn.setForeground(new java.awt.Color(255, 255, 255));
        signInBtn.setText("Sign In");
        signInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Inventory Management System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 284, Short.MAX_VALUE))
                    .addComponent(loginImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addComponent(usernameInput)
                        .addComponent(jLabel5)
                        .addComponent(passwordInput)
                        .addComponent(signInBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addGap(63, 63, 63)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(signInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loginImage, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 112, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInBtnActionPerformed
        String username = usernameInput.getText().trim();
        String password = String.valueOf(passwordInput.getPassword());

        if (!Validator.isPasswordValid(password)) {
            return;
        }

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/inventory_management",
                    "root",
                    "Ayomalkaus#2k23");

            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `users` WHERE `username`='" + username + "' && `password`='" + password + "'");

            if (rs.next()) {
                if (rs.getInt("status_id") == 0) {
                    Notifications.getInstance().show(
                            Notifications.Type.SUCCESS,
                            Notifications.Location.TOP_CENTER,
                            3000,
                            "Login Success");

                    new HomeScreen(rs).setVisible(true);
                    LoginScreen.this.dispose();

                    CustomLoggers.logger.info("Logging success");

                } else if (rs.getInt("status_id") == 3) {
                    Notifications.getInstance().show(
                            Notifications.Type.WARNING,
                            Notifications.Location.TOP_CENTER,
                            3000,
                            "Activation is pending. Please Try Again Later");
                } else {
                    Notifications.getInstance().show(
                            Notifications.Type.ERROR,
                            Notifications.Location.TOP_CENTER,
                            3000,
                            "You account has been suspended");
                }
            } else {
                Notifications.getInstance().show(
                        Notifications.Type.ERROR,
                        Notifications.Location.TOP_CENTER,
                        3000,
                        "Please check the login cardential");
            }

        } catch (ClassNotFoundException | SQLException e) {
            CustomLoggers.logger.log(Level.SEVERE, "Logging failed", e);
        }


    }//GEN-LAST:event_signInBtnActionPerformed

    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        new LoginScreen().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel loginImage;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JButton signInBtn;
    private javax.swing.JTextField usernameInput;
    // End of variables declaration//GEN-END:variables
}
