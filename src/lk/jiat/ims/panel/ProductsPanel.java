/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.jiat.ims.panel;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import lk.jiat.ims.gui.connection.MySQL;
import lk.jiat.ims.gui.dialog.productRegistrationDialog;
import lk.jiat.ims.gui.dialog.productUpdateDialog;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Ayoma
 */
public class ProductsPanel extends javax.swing.JPanel {

    ResultSet user;

    public ProductsPanel(ResultSet admin) {
        initComponents();
        loadTabelData();
        init();
        user = admin;
    }

    private static final Logger loggers = Logger.getLogger(ProductsPanel.class.getName());

    static {
        try {
            FileHandler handler = new FileHandler("app.log", 0, 1, true);
            handler.setFormatter(new SimpleFormatter());
            loggers.addHandler(handler);
            loggers.setUseParentHandlers(false); // prevent console + duplicate logging
        } catch (Exception e) {
            loggers.log(Level.SEVERE, e.toString());
        }
    }

    private void loadTabelData() {
        try {

            ResultSet rs = MySQL.execute("SELECT * FROM products\n"
                    + "INNER JOIN category ON category.id = products.category_id\n"
                    + "INNER JOIN suppliers ON suppliers.id = products.suppliers_id\n"
                    + "INNER JOIN users ON users.id = products.users_id");

            DefaultTableModel dtm = (DefaultTableModel) productsTable.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector<String> data = new Vector();
                data.add(rs.getString("id"));
                data.add(rs.getString("product_name"));
                data.add(rs.getString("quantity"));
                data.add(rs.getString("unit_price"));
                data.add(rs.getString("description"));
                data.add(rs.getString("category_name"));
                data.add(rs.getString("supplier_name"));
                data.add(rs.getString("username"));

                dtm.addRow(data);

            }

            loggers.info("Loaded product data successfully into the table");

        } catch (SQLException e) {
            loggers.log(Level.SEVERE, "Failed to load product data", e);
        }
    }

    private void init() {
        reportBtn.setIcon(new FlatSVGIcon("lk/jiat/ims/img/printer.svg", 20, 20));

        TableColumn actionColumn = productsTable.getColumn("Action");
        actionColumn.setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                JPanel panel = new JPanel();
                panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
                panel.setBackground(Color.WHITE);

                // Edit Button
                JButton editBtn = new JButton();
                editBtn.setIcon(new FlatSVGIcon("lk/jiat/ims/img/pencil.svg", 20, 20));
                editBtn.setBackground(Color.WHITE);
                editBtn.setBorder(null);
                editBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                editBtn.setFocusPainted(false);

                // Delete Button
                JButton deleteBtn = new JButton();
                deleteBtn.setIcon(new FlatSVGIcon("lk/jiat/ims/img/delete.svg", 20, 20));
                deleteBtn.setBackground(Color.WHITE);
                deleteBtn.setBorder(null);
                deleteBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                deleteBtn.setFocusPainted(false);

                panel.add(editBtn);
                panel.add(deleteBtn);

                return panel;
            }
        });

        actionColumn.setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            JButton button = new JButton();
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
            JButton editBtn = new JButton(new FlatSVGIcon("lk/jiat/ims/img/pencil.svg", 25, 25));
            JButton deleteBtn = new JButton(new FlatSVGIcon("lk/jiat/ims/img/delete.svg", 25, 25));

            {
                for (JButton btn : new JButton[]{editBtn, deleteBtn}) {
                    btn.setBackground(Color.WHITE);
                    btn.setBorder(null);
                    btn.setFocusPainted(false);
                    btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }

                panel.setBackground(Color.WHITE);
                panel.add(editBtn);
                panel.add(deleteBtn);

                // Edit button action
                editBtn.addActionListener(e -> {
                    int row = productsTable.getSelectedRow();
                    Frame parentFrame = (Frame) SwingUtilities.getWindowAncestor(ProductsPanel.this);
                    Object productId = productsTable.getValueAt(row, 0);

                    loggers.info("Edited product with ID: " + productId);

                    productUpdateDialog productDialog = new productUpdateDialog(parentFrame, true, productId);
                    productDialog.setVisible(true);
                    fireEditingStopped();
                });

                // Delete button action
                deleteBtn.addActionListener(e -> {
                    int row = productsTable.getSelectedRow();
                    Object productId = productsTable.getValueAt(row, 0);

                    int confirm = JOptionPane.showConfirmDialog(productsTable,
                            "Are you sure you want to delete product ID " + productId + "?",
                            "Confirm Delete", JOptionPane.YES_NO_OPTION);

                    if (confirm == JOptionPane.YES_OPTION) {
                        loggers.info("Deleted product with ID: " + productId);
                        try {
                            ResultSet rs = MySQL.execute("DELETE FROM `products` WHERE `id` = '" + productId + "'");
                        } catch (SQLException ex) {
                            loggers.info("User not deleted" + ex);
                        }
                    }

                    fireEditingStopped();
                });
            }

            @Override
            public Component getTableCellEditorComponent(JTable table, Object value,
                    boolean isSelected, int row, int column) {
                return panel;
            }
        });

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
        jScrollPane1 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();
        addNewProductBtn = new javax.swing.JButton();
        reportBtn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Products");

        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Quantity", "Price", "Description", "Category", "Supplier", "User", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productsTable.setRowHeight(40);
        jScrollPane1.setViewportView(productsTable);

        addNewProductBtn.setBackground(new java.awt.Color(0, 0, 255));
        addNewProductBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addNewProductBtn.setForeground(new java.awt.Color(255, 255, 255));
        addNewProductBtn.setText("+ Add new products");
        addNewProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewProductBtnActionPerformed(evt);
            }
        });

        reportBtn.setBackground(new java.awt.Color(255, 0, 0));
        reportBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        reportBtn.setForeground(new java.awt.Color(255, 255, 255));
        reportBtn.setText("Report");
        reportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reportBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addNewProductBtn)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(addNewProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(reportBtn)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addNewProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewProductBtnActionPerformed

        loggers.info("Add new product button clicked");

        Frame parent = (Frame) SwingUtilities.getWindowAncestor(ProductsPanel.this);
        productRegistrationDialog productRegistrationDialog = new productRegistrationDialog(parent, true, user);
        productRegistrationDialog.setVisible(true);
    }//GEN-LAST:event_addNewProductBtnActionPerformed

    private void reportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportBtnActionPerformed

        loggers.info("Report button clicked");

        try {
            InputStream filePath = getClass().getClassLoader().getResourceAsStream("reports/product_report.jasper");

            HashMap<String, Object> parameters = new HashMap<>();

            JRTableModelDataSource jrTableModelDataSource = new JRTableModelDataSource(productsTable.getModel());
            JasperPrint fileReport = JasperFillManager.fillReport(filePath, parameters, jrTableModelDataSource);
            JasperViewer.viewReport(fileReport, false);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String reportFileName = timestamp + "_products_report.pdf";

            JasperExportManager.exportReportToPdfFile(fileReport, reportFileName);

            loggers.info("Generated and exported report: " + reportFileName);

        } catch (JRException e) {
            loggers.log(Level.SEVERE, "Report generation failed", e);
        }

    }//GEN-LAST:event_reportBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewProductBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productsTable;
    private javax.swing.JButton reportBtn;
    // End of variables declaration//GEN-END:variables
}
