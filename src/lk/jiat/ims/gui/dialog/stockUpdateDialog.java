
package lk.jiat.ims.gui.dialog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.jiat.ims.connection.MySQL;
import raven.toast.Notifications;

public class stockUpdateDialog extends javax.swing.JDialog {

    String id;
    
    public stockUpdateDialog(java.awt.Frame parent, boolean modal, Object productId) {
        super(parent, modal);
        initComponents();
        productLoad(productId);
        id = String.valueOf(productId);
    }
    
    private void productLoad(Object productId){
        String id = String.valueOf(productId);
        try {
            ResultSet rs = MySQL.execute("SELECT * FROM products\n"
                    + "INNER JOIN category ON category.id = products.category_id "
                    + "INNER JOIN suppliers ON suppliers.id = products.suppliers_id "
                    + "INNER JOIN users ON users.id = products.users_id "
                    + "WHERE products.id = '" + id + "'");

            if (rs.next()) {
                product_id.setText(rs.getString("id"));
                productName.setText(rs.getString("product_name"));
                qty.setText(rs.getString("quantity"));
                price.setText(rs.getString("unit_price"));
                remarks.setText(rs.getString("remarks"));
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        product_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        productName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        remarks = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        qty = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Product Stock Updater");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Product Stock Updater");

        jPanel2.setLayout(new java.awt.GridLayout(10, 2, 5, 5));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Product ID");
        jPanel2.add(jLabel2);

        product_id.setEnabled(false);
        jPanel2.add(product_id);

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Product Name");
        jPanel2.add(jLabel3);

        productName.setEnabled(false);
        jPanel2.add(productName);

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Remarks");
        jPanel2.add(jLabel6);
        jPanel2.add(remarks);

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Quantity");
        jPanel2.add(jLabel4);
        jPanel2.add(qty);

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Price");
        jPanel2.add(jLabel5);

        price.setEnabled(false);
        jPanel2.add(price);

        jButton1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 300, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jButton1)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            ResultSet rs = MySQL.execute("UPDATE products SET quantity = '" + qty.getText() + "', remarks = '"+remarks.getText()+"' "
                    + "WHERE products.id = '" + id + "'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

            Notifications.getInstance().show(
                    Notifications.Type.SUCCESS,
                    Notifications.Location.TOP_CENTER,
                    3000,
                    "stock Updated Successfully");
    }//GEN-LAST:event_jButton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField price;
    private javax.swing.JTextField productName;
    private javax.swing.JTextField product_id;
    private javax.swing.JTextField qty;
    private javax.swing.JTextField remarks;
    // End of variables declaration//GEN-END:variables
}
