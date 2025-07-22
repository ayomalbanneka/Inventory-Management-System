
package lk.jiat.ims.gui.dialog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.jiat.ims.connection.MySQL;
import raven.toast.Notifications;

public class supplierDialog extends javax.swing.JDialog {


    public supplierDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        mobile = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        registerBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Supplier Registration");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Supplier Registration");

        jPanel2.setLayout(new java.awt.GridLayout(8, 2, 5, 5));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Name");
        jPanel2.add(jLabel1);

        name.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(name);

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Mobile Number");
        jPanel2.add(jLabel3);

        mobile.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(mobile);

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Email Address");
        jPanel2.add(jLabel4);

        email.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(email);

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Adress");
        jPanel2.add(jLabel5);

        address.setColumns(20);
        address.setRows(5);
        jScrollPane1.setViewportView(address);

        jPanel2.add(jScrollPane1);

        registerBtn.setBackground(new java.awt.Color(0, 0, 255));
        registerBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        registerBtn.setForeground(new java.awt.Color(255, 255, 255));
        registerBtn.setText("Register");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 262, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(registerBtn)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(registerBtn)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        try {
            ResultSet rs = MySQL.execute("INSERT INTO `suppliers` "
                    + "(`supplier_name`,`phone`,`email`,`address`)"
                    + "VALUES('"+name.getText()+"','"+mobile.getText()+"','"+email.getText()+"','"+address.getText()+"')");
            
            Notifications.getInstance().show(
                    Notifications.Type.SUCCESS,
                    Notifications.Location.TOP_CENTER,
                    3000,
                    "Supplier Registered Successfully");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_registerBtnActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea address;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField mobile;
    private javax.swing.JTextField name;
    private javax.swing.JButton registerBtn;
    // End of variables declaration//GEN-END:variables
}
