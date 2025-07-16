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
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import lk.jiat.ims.gui.connection.MySQL;
import lk.jiat.ims.gui.dialog.userRegistrationDialog;
import lk.jiat.ims.gui.dialog.userUpdateDialog;

/**
 *
 * @author Ayoma
 */
public class UsersPanel extends javax.swing.JPanel {

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

    private String userId;

    public UsersPanel() {
        initComponents();
        loadTabelData();
        init();
    }

    private void loadTabelData() {
        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `users`");

            DefaultTableModel dtm = (DefaultTableModel) userTable.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector<String> data = new Vector();

                userId = rs.getString("id");

                data.add(rs.getString("id"));
                data.add(rs.getString("username"));
                data.add(rs.getString("password"));
                data.add(rs.getString("full_name"));
                data.add(rs.getString("role"));

                dtm.addRow(data);

            }

            loggers.info(" users data loaded successfully into the table");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void init() {

        TableColumn actionColumn = userTable.getColumn("Action");
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
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
            JButton editButton = new JButton(new FlatSVGIcon("lk/jiat/ims/img/pencil.svg", 20, 20));
            JButton deleteButton = new JButton(new FlatSVGIcon("lk/jiat/ims/img/delete.svg", 20, 20));
            JButton button = new JButton();

            {

                panel.setBackground(Color.WHITE);
                panel.add(editButton);
                panel.add(deleteButton);

                // Edit action
                editButton.addActionListener(e -> {
                    int row = userTable.getSelectedRow();
                    Frame parentFrame = (Frame) SwingUtilities.getWindowAncestor(UsersPanel.this);
                    Object userID = userTable.getValueAt(row, 0);
                    loggers.info("Edited user with ID: " + userID);

                    userUpdateDialog dialog = new userUpdateDialog(parentFrame, true, userID);
                    dialog.setVisible(true);
                    fireEditingStopped();
                });

                // Delete action
                deleteButton.addActionListener(e -> {
                    int row = userTable.getSelectedRow();
                    Object userID = userTable.getValueAt(row, 0);
                    int confirm = JOptionPane.showConfirmDialog(userTable, "Delete user ID " + userID + "?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        loggers.info("Deleted user with ID: " + userID);
                        try {
                            ResultSet rs = MySQL.execute("DELETE FROM `users` WHERE `id` = '" + userID + "'");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Username", "Password", "Full Name", "Role", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("User Management");

        addBtn.setBackground(new java.awt.Color(0, 0, 255));
        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("+ Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(addBtn)))
                .addGap(0, 22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        Frame parent = (Frame) SwingUtilities.getWindowAncestor(UsersPanel.this);
        userRegistrationDialog productRegistrationDialog = new userRegistrationDialog(parent, true);
        productRegistrationDialog.setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
