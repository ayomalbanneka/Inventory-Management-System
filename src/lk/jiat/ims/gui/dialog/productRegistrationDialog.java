/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package lk.jiat.ims.gui.dialog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import lk.jiat.ims.connection.MySQL;
import raven.toast.Notifications;

/**
 *
 * @author Ayoma
 */
public class productRegistrationDialog extends javax.swing.JDialog {

    ResultSet user;

    public productRegistrationDialog(java.awt.Frame parent, boolean modal, ResultSet user) {
        super(parent, modal);
        initComponents();
        loadCategory();
        loadSupplier();
        this.user = user;
    }

    private void loadSupplier() {
        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `suppliers`");

            Vector<String> data = new Vector();
            while (rs.next()) {
                data.add(rs.getString("supplier_name"));
            }
            supplierComboBox.setModel(new DefaultComboBoxModel(data));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void loadCategory() {

        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `category`");

            Vector<String> data = new Vector();
            while (rs.next()) {
                data.add(rs.getString("category_name"));
            }
            categoryComboBox.setModel(new DefaultComboBoxModel(data));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        productName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        supplierComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        unitPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        categoryComboBox = new javax.swing.JComboBox<>();
        registerBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Product Registration");

        jPanel2.setLayout(new java.awt.GridLayout(12, 2, 5, 5));

        jLabel2.setText("Product Name");
        jPanel2.add(jLabel2);
        jPanel2.add(productName);

        jLabel3.setText("Supplier");
        jPanel2.add(jLabel3);

        jPanel2.add(supplierComboBox);

        jLabel4.setText("Quantity");
        jPanel2.add(jLabel4);
        jPanel2.add(quantity);

        jLabel5.setText("Unit Price");
        jPanel2.add(jLabel5);
        jPanel2.add(unitPrice);

        jLabel6.setText("Description");
        jPanel2.add(jLabel6);

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        jPanel2.add(jScrollPane1);

        jLabel7.setText("Category");
        jPanel2.add(jLabel7);

        jPanel2.add(categoryComboBox);

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
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(registerBtn)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registerBtn)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed

        String product_name = productName.getText();
        String qty = quantity.getText();
        String price = unitPrice.getText();
        String desc = description.getText();
        Integer category = Integer.valueOf(categoryComboBox.getSelectedIndex() + 1);
        Integer supplier = Integer.valueOf(supplierComboBox.getSelectedIndex() + 1);

        try {

            MySQL.execute("INSERT INTO `products` (\n"
                    + "`product_name`,\n"
                    + "`quantity`,\n"
                    + "`unit_price`,\n"
                    + "`description`,\n"
                    + "`category_id`,\n"
                    + "`suppliers_id`,\n"
                    + "`users_id`) "
                    + "VALUES ( '" + product_name + "','" + qty + "','" + price + "',"
                    + "'" + desc + "','" + category + "','" + supplier + "',"
                    + "'" + user.getString("id") + "')");

            Notifications.getInstance().show(
                    Notifications.Type.SUCCESS,
                    Notifications.Location.TOP_CENTER,
                    3000,
                    "Product Updated Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_registerBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JTextArea description;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField productName;
    private javax.swing.JTextField quantity;
    private javax.swing.JButton registerBtn;
    private javax.swing.JComboBox<String> supplierComboBox;
    private javax.swing.JTextField unitPrice;
    // End of variables declaration//GEN-END:variables
}
