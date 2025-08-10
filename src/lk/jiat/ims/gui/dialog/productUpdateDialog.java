
package lk.jiat.ims.gui.dialog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import lk.jiat.ims.connection.MySQL;
import raven.toast.Notifications;

public class productUpdateDialog extends javax.swing.JDialog {

    String id;
    
    public productUpdateDialog(java.awt.Frame parent, boolean modal, Object productId) {
        super(parent, modal);
        initComponents();
        productload(productId);
        loadCategory(productId);
        loadSupplier(productId);
        id = String.valueOf(productId);
    }

    private void productload(Object productId) {
        String id = String.valueOf(productId);

        try {
            ResultSet rs = MySQL.execute("SELECT * FROM products\n"
                    + "INNER JOIN category ON category.id = products.category_id\n"
                    + "INNER JOIN suppliers ON suppliers.id = products.suppliers_id\n"
                    + "INNER JOIN users ON users.id = products.users_id \n"
                    + "WHERE products.id = '" + id + "'");

            if (rs.next()) {
                productName.setText(rs.getString("product_name"));
                quantity.setText(rs.getString("quantity"));
                unitPrice.setText(rs.getString("unit_price"));
                description.setText(rs.getString("description"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    private void loadSupplier(Object productId) {
        String id = String.valueOf(productId);
        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `suppliers`\n"
                    + "                    INNER JOIN products ON products.suppliers_id = suppliers.id\n"
                    + "                    WHERE products.id = '" + id + "'");

            while (rs.next()) {
                Vector<String> data = new Vector();
                data.add(rs.getString("supplier_name"));
                supplierComboBox.setModel(new DefaultComboBoxModel(data));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void loadCategory(Object productId) {
        String id = String.valueOf(productId);

        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `category`\n"
                    + "INNER JOIN products ON products.category_id = category.id\n"
                    + "WHERE products.id = '" + id + "'");

            while (rs.next()) {
                Vector<String> data = new Vector();
                data.add(rs.getString("category_name"));
                categoryComboBox.setModel(new DefaultComboBoxModel(data));
            }

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
        setTitle("Products Details Updater");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Product Details Updater");

        jPanel2.setLayout(new java.awt.GridLayout(12, 2, 5, 5));

        jLabel2.setText("Product Name");
        jPanel2.add(jLabel2);
        jPanel2.add(productName);

        jLabel3.setText("Supplier");
        jPanel2.add(jLabel3);

        supplierComboBox.setEnabled(false);
        jPanel2.add(supplierComboBox);

        jLabel4.setText("Quantity");
        jPanel2.add(jLabel4);
        jPanel2.add(quantity);

        jLabel5.setText("Unit Price");
        jPanel2.add(jLabel5);

        unitPrice.setEnabled(false);
        jPanel2.add(unitPrice);

        jLabel6.setText("Description");
        jPanel2.add(jLabel6);

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        jPanel2.add(jScrollPane1);

        jLabel7.setText("Category");
        jPanel2.add(jLabel7);

        categoryComboBox.setEnabled(false);
        jPanel2.add(categoryComboBox);

        registerBtn.setBackground(new java.awt.Color(0, 0, 255));
        registerBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        registerBtn.setForeground(new java.awt.Color(255, 255, 255));
        registerBtn.setText("Update");
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 322, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        try {
            ResultSet rs = MySQL.execute("UPDATE `products` SET "
                    + "`product_name` = '" + productName.getText() + "', "
                    + "`description` = '" + description.getText() + "' "
                    + "WHERE `id` = '" + id + "'");

            Notifications.getInstance().show(
                    Notifications.Type.SUCCESS,
                    Notifications.Location.TOP_CENTER,
                    3000,
                    "Product Updated Successfully");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_registerBtnActionPerformed

    /**
     * @param args the command line arguments
     */

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
