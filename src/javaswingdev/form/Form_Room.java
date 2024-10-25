package javaswingdev.form;

import Restaurant.DAO.GenarateCodeDAO;
import Restaurant.DAO.RoomDAO;
import Restaurant.DTO.RoomDTO;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Form_Room extends javax.swing.JPanel {

    public Form_Room() {
        initComponents();
        loadDataSet();
        loadCode();
//        loadCombobox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        roundPanel1 = new javaswingdev.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtCode = new javax.swing.JTextField();
        lb2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lb3 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        txtFB = new javax.swing.JTextField();
        lb5 = new javax.swing.JLabel();
        txtHB = new javax.swing.JTextField();
        lb6 = new javax.swing.JLabel();
        txtBB = new javax.swing.JTextField();
        lb7 = new javax.swing.JLabel();
        txtRO = new javax.swing.JTextField();
        lb8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setOpaque(false);

        lb1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lb1.setForeground(new java.awt.Color(125, 125, 125));
        lb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1.setText("Room Master");

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table.setRowHeight(25);
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        txtCode.setEditable(false);
        txtCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lb2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lb2.setForeground(new java.awt.Color(125, 125, 125));
        lb2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb2.setText("Room Code");

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lb3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lb3.setForeground(new java.awt.Color(125, 125, 125));
        lb3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb3.setText("Room Name");

        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        txtFB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFBKeyTyped(evt);
            }
        });

        lb5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lb5.setForeground(new java.awt.Color(125, 125, 125));
        lb5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb5.setText("Full Board");

        txtHB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHBKeyTyped(evt);
            }
        });

        lb6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lb6.setForeground(new java.awt.Color(125, 125, 125));
        lb6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb6.setText("Half Board");

        txtBB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBBKeyTyped(evt);
            }
        });

        lb7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lb7.setForeground(new java.awt.Color(125, 125, 125));
        lb7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb7.setText("Bed and Breakfast");

        txtRO.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtRO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtROKeyTyped(evt);
            }
        });

        lb8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lb8.setForeground(new java.awt.Color(125, 125, 125));
        lb8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb8.setText("Room Only");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb7)
                            .addComponent(txtBB, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb8)
                            .addComponent(txtRO, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb3)
                                    .addComponent(lb2)
                                    .addGroup(roundPanel1Layout.createSequentialGroup()
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(roundPanel1Layout.createSequentialGroup()
                                            .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lb5)
                                                .addComponent(txtFB, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(lb6)
                                                .addComponent(txtHB, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 243, Short.MAX_VALUE)))
                        .addGap(25, 25, 25))))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lb2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(lb5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(lb6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(lb7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                        .addComponent(lb8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lb1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lb1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if (table.getSelectedRow()<0)
            JOptionPane.showMessageDialog(this, "Select a Room from the table.");
        else {
            if (txtCode.getText().equals("") || txtName.getText().equals("") ){
                JOptionPane.showMessageDialog(this, "Please enter Room Name");
            }else {
                RoomDTO roomDTO = new RoomDTO();
                roomDTO.setRoomCode(txtCode.getText().trim());
                roomDTO.setRoomName(txtName.getText().trim());

                roomDTO.setFBPrice(convertToDouble(txtFB.getText().trim()));
                roomDTO.setHBPrice(convertToDouble(txtHB.getText().trim()));
                roomDTO.setBBPrice(convertToDouble(txtBB.getText().trim()));
                roomDTO.setROPrice(convertToDouble(txtRO.getText().trim()));
                
                new RoomDAO().editRoomDAO(roomDTO);
                loadDataSet();
                reset();
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if (txtCode.getText().equals("") || txtName.getText().equals("") ){
            JOptionPane.showMessageDialog(this, "Please enter Room Name");
        }else {
            //roomDTO.setCategoryCode(new CategoryDAO().getCategoryCode(cmbCategory.getSelectedItem().toString()));

            RoomDTO roomDTO = new RoomDTO();
            roomDTO.setRoomCode(txtCode.getText().trim());
            roomDTO.setRoomName(txtName.getText().trim());

            roomDTO.setFBPrice(convertToDouble(txtFB.getText().trim()));
            roomDTO.setHBPrice(convertToDouble(txtHB.getText().trim()));
            roomDTO.setBBPrice(convertToDouble(txtBB.getText().trim()));
            roomDTO.setROPrice(convertToDouble(txtRO.getText().trim()));

            new RoomDAO().addRoomDAO(roomDTO);
            loadDataSet();
            reset();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if (table.getSelectedRow()<0)
            JOptionPane.showMessageDialog(this, "Select a Room from the table.");
        else {
            int opt = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to delete this Room?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (opt==JOptionPane.YES_OPTION) {
                new RoomDAO().deleteRoomDAO(table.getValueAt(table.getSelectedRow(),0).toString());
                loadDataSet();
                reset();
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
//         new CategoryDAO().getCategoryDAO(catTable.getValueAt(catTable.getSelectedRow(),0).toString());
    }//GEN-LAST:event_tableMouseClicked

    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed
        // TODO add your handling code here:
        JTable table =(JTable) evt.getSource();
        Point point = evt.getPoint();
        int row = table.rowAtPoint(point);
        if (evt.getClickCount() == 2 && table.getSelectedRow() != -1) {
            txtCode.setText(table.getValueAt(table.getSelectedRow(),0).toString());
            txtName.setText(table.getValueAt(table.getSelectedRow(),1).toString());
            
            NumberFormat formatter = new DecimalFormat("0.00");
            txtFB.setText(formatter.format(Double.parseDouble(String.valueOf(table.getValueAt(table.getSelectedRow(),2).toString()))));
            txtHB.setText(formatter.format(Double.parseDouble(String.valueOf(table.getValueAt(table.getSelectedRow(),3).toString()))));
            txtBB.setText(formatter.format(Double.parseDouble(String.valueOf(table.getValueAt(table.getSelectedRow(),4).toString()))));
            txtRO.setText(formatter.format(Double.parseDouble(String.valueOf(table.getValueAt(table.getSelectedRow(),5).toString()))));
        }
        
        
//        int row = productTable.getSelectedRow();
//        int col = productTable.getColumnCount();
//
//        Object[] data = new Object[col];
//        for (int i=0; i<col; i++)
//            data[i] = productTable.getValueAt(row, i);
//
//        codeText.setText(data[0].toString());
//        nameText.setText(data[1].toString());
//        costText.setText(data[2].toString());
//        sellText.setText(data[3].toString());
//        brandText.setText(data[4].toString());
        
        
    }//GEN-LAST:event_tableMousePressed

    private void txtFBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFBKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE ) || (c==KeyEvent.VK_DELETE) || (c==KeyEvent.VK_PERIOD) ) ){
                evt.consume();
        }
    }//GEN-LAST:event_txtFBKeyTyped

    private void txtHBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHBKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE ) || (c==KeyEvent.VK_DELETE) || (c==KeyEvent.VK_PERIOD) ) ){
                evt.consume();
        }
    }//GEN-LAST:event_txtHBKeyTyped

    private void txtBBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBBKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE ) || (c==KeyEvent.VK_DELETE) || (c==KeyEvent.VK_PERIOD) ) ){
                evt.consume();
        }
    }//GEN-LAST:event_txtBBKeyTyped

    private void txtROKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtROKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE ) || (c==KeyEvent.VK_DELETE) || (c==KeyEvent.VK_PERIOD) ) ){
                evt.consume();
        }
    }//GEN-LAST:event_txtROKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    private javax.swing.JLabel lb8;
    private javaswingdev.swing.RoundPanel roundPanel1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtBB;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtFB;
    private javax.swing.JTextField txtHB;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtRO;
    // End of variables declaration//GEN-END:variables

    private void loadDataSet() {
        try {
            RoomDAO roomDAO = new RoomDAO();
            table.setModel(roomDAO.buildTableModel(roomDAO.getQueryResult()));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(roundPanel1, e);
        }
        
    }
    

    private void reset() {
        txtName.setText("");
        txtBB.setText("");
        txtHB.setText("");
        txtFB.setText("");
        txtRO.setText("");
        table.getSelectionModel().clearSelection();
        loadCode();
    }

    
    private void loadCode() {
        int lstNo = new GenarateCodeDAO().getRoomCode();
        if (lstNo==0) {
            txtCode.setText("RM-1");
        }else{
            lstNo++;
            txtCode.setText("RM-"+lstNo);
        }
    }
    
    
    //Converting String values to Double
    private static Double convertToDouble(String textValue) {
        double doubleValue;
        try {
            doubleValue = Double.parseDouble(textValue);    
        } catch (NumberFormatException e) {
            doubleValue = 0.0;
        }
        return doubleValue;
    }
    

//    private void loadCombobox() {
//        try {
//            CategoryDAO categoryDAO = new CategoryDAO();
//            cmbCategory.setModel(categoryDAO.setComboItems(categoryDAO.getQueryResult()));
//            cmbCategory.setSelectedItem(null);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
