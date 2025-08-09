package lk.jiat.ims.gui.panel;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Frame;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.ResultSet;
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
import lk.jiat.ims.connection.MySQL;
import lk.jiat.ims.gui.dialog.stockUpdateDialog;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import lk.jiat.ims.loggers.CustomLoggers;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;

public class stockPanel extends javax.swing.JPanel {

    public stockPanel() {
        initComponents();
        loadStockInTabelData();
        stockIninit();
        stockOutInit();
    }

    private void stockIninit() {

        //Stock In Tabel
        TableColumn actionColumn = stockInTable.getColumn("Action");
        actionColumn.setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JButton btn = new JButton();
                btn.setIcon(new FlatSVGIcon("lk/jiat/ims/img/pencil.svg", 25, 25));
                btn.setForeground(Color.BLACK);
                btn.setBackground(Color.WHITE);
                btn.setBorder(null);
                btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btn.setFocusPainted(false);
                return btn;
            }
        });

        actionColumn.setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            JButton button = new JButton();

            {
                button.setIcon(new FlatSVGIcon("lk/jiat/ims/img/pencil.svg", 25, 25));
                button.addActionListener(e -> {
                    int row = stockInTable.getSelectedRow();
                    Frame parentFrame = (Frame) SwingUtilities.getWindowAncestor(stockPanel.this);
                    Object productId = stockInTable.getValueAt(row, 0);

                    CustomLoggers.logger.info("Stock in table updated product ID: " + productId);

                    stockUpdateDialog stockUpdateDialog = new stockUpdateDialog(parentFrame, true, productId);
                    stockUpdateDialog.setVisible(true);
                    fireEditingStopped();
                });
            }

            @Override
            public Component getTableCellEditorComponent(JTable table, Object value,
                    boolean isSelected, int row, int column) {
                return button;
            }
        });
    }

    private void stockOutInit() {
        TableColumn actionColumn = stockOutTable.getColumn("Action");
        actionColumn.setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JButton btn = new JButton();
                btn.setIcon(new FlatSVGIcon("lk/jiat/ims/img/pencil.svg", 25, 25));
                btn.setForeground(Color.BLACK);
                btn.setBackground(Color.WHITE);
                btn.setBorder(null);
                btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btn.setFocusPainted(false);
                return btn;
            }
        });

        actionColumn.setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            JButton button = new JButton();

            {
                button.setIcon(new FlatSVGIcon("lk/jiat/ims/img/pencil.svg", 25, 25));
                button.addActionListener(e -> {
                    int row = stockOutTable.getSelectedRow();
                    Frame parentFrame = (Frame) SwingUtilities.getWindowAncestor(stockPanel.this);
                    Object productId = stockOutTable.getValueAt(row, 0);

                    CustomLoggers.logger.info("Stock in table updated product ID: " + productId);

                    stockUpdateDialog stockUpdateDialog = new stockUpdateDialog(parentFrame, true, productId);
                    stockUpdateDialog.setVisible(true);
                    fireEditingStopped();
                });
            }

            @Override
            public Component getTableCellEditorComponent(JTable table, Object value,
                    boolean isSelected, int row, int column) {
                return button;
            }
        });
    }

    private void loadStockInTabelData() {
        try {
            ResultSet rs1 = MySQL.execute("SELECT * FROM products "
                    + "INNER JOIN category ON category.id =  products.category_id "
                    + "INNER JOIN suppliers ON suppliers.id = products.suppliers_id "
                    + "INNER JOIN users ON users.id = products.users_id "
                    + "WHERE quantity = 0");

            ResultSet rs2 = MySQL.execute("SELECT * FROM products "
                    + "INNER JOIN category ON category.id =  products.category_id "
                    + "INNER JOIN suppliers ON suppliers.id = products.suppliers_id "
                    + "INNER JOIN users ON users.id = products.users_id "
                    + "WHERE quantity > 0");

            DefaultTableModel dtm1 = (DefaultTableModel) stockOutTable.getModel();
            while (rs1.next()) {
                Vector<String> data = new Vector();
                data.add(rs1.getString("id"));
                data.add(rs1.getString("product_name"));
                data.add(rs1.getString("quantity"));
                data.add(rs1.getString("unit_price"));
                data.add(rs1.getString("username"));
                data.add(rs1.getString("remarks"));

                dtm1.addRow(data);
            }

            CustomLoggers.logger.info("Stock out table data loaded successfully");

            DefaultTableModel dtm2 = (DefaultTableModel) stockInTable.getModel();
            while (rs2.next()) {
                Vector<String> data2 = new Vector();
                data2.add(rs2.getString("id"));
                data2.add(rs2.getString("product_name"));
                data2.add(rs2.getString("quantity"));
                data2.add(rs2.getString("unit_price"));
                data2.add(rs2.getString("username"));
                data2.add(rs2.getString("remarks"));

                dtm2.addRow(data2);

            }

            CustomLoggers.logger.info("Stock out table data loaded successfully");

        } catch (SQLException e) {
            CustomLoggers.logger.log(Level.SEVERE, "Failed to load stock table data: {0}", e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockInTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        stockOutTable = new javax.swing.JTable();
        stockInReportBtn = new javax.swing.JButton();
        stockOutReportBtn = new javax.swing.JButton();

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Stock Management");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Stock In Table");

        stockInTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product Name", "Quantity", "Price", "User", "Remarks", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(stockInTable);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Stock Out Table");

        stockOutTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product Name", "Quantity", "Price", "User", "Remarks", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(stockOutTable);

        stockInReportBtn.setBackground(new java.awt.Color(255, 0, 0));
        stockInReportBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        stockInReportBtn.setForeground(new java.awt.Color(255, 255, 255));
        stockInReportBtn.setText("Report");
        stockInReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockInReportBtnActionPerformed(evt);
            }
        });

        stockOutReportBtn.setBackground(new java.awt.Color(255, 0, 0));
        stockOutReportBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        stockOutReportBtn.setForeground(new java.awt.Color(255, 255, 255));
        stockOutReportBtn.setText("Report");
        stockOutReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockOutReportBtnActionPerformed(evt);
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
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stockInReportBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stockOutReportBtn)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(stockInReportBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stockOutReportBtn)
                        .addGap(197, 197, 197))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void stockInReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockInReportBtnActionPerformed
        try {
            InputStream filePath = getClass().getClassLoader().getResourceAsStream("reports/stock_in_report.jasper");

            HashMap<String, Object> parameters = new HashMap<>();

            JRTableModelDataSource jrTableModelDataSource = new JRTableModelDataSource(stockInTable.getModel());
            JasperPrint fileReport = JasperFillManager.fillReport(filePath, parameters, jrTableModelDataSource);
            JasperViewer.viewReport(fileReport, false);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String reportFileName = timestamp + "_stock_in_report.pdf";

            JasperExportManager.exportReportToPdfFile(fileReport, reportFileName);
            CustomLoggers.logger.info("Generated and exported report: " + reportFileName);

        } catch (JRException e) {
            CustomLoggers.logger.log(Level.SEVERE, "stock in report generation failed", e);
        }
    }//GEN-LAST:event_stockInReportBtnActionPerformed

    private void stockOutReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockOutReportBtnActionPerformed
        try {
            InputStream filePath = getClass().getClassLoader().getResourceAsStream("reports/stock_out_report.jasper");

            HashMap<String, Object> parameters = new HashMap<>();

            JRTableModelDataSource jrTableModelDataSource = new JRTableModelDataSource(stockOutTable.getModel());
            JasperPrint fileReport = JasperFillManager.fillReport(filePath, parameters, jrTableModelDataSource);
            JasperViewer.viewReport(fileReport, false);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String reportFileName = timestamp + "_stock_out_report.pdf";

            JasperExportManager.exportReportToPdfFile(fileReport, reportFileName);
            CustomLoggers.logger.info("Generated and exported report: " + reportFileName);

        } catch (JRException e) {
            CustomLoggers.logger.log(Level.SEVERE, "Report generation failed", e);
        }
    }//GEN-LAST:event_stockOutReportBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton stockInReportBtn;
    private javax.swing.JTable stockInTable;
    private javax.swing.JButton stockOutReportBtn;
    private javax.swing.JTable stockOutTable;
    // End of variables declaration//GEN-END:variables
}
