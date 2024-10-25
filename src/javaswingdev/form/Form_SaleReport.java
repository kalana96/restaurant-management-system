package javaswingdev.form;

import Restaurant.DAO.ExpenseDAO;
import Restaurant.DAO.SalesDAO;
import Restaurant.DTO.SalesDTO;
import Restaurant.Database.ConnectionFactory;
import static java.lang.String.format;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Form_SaleReport extends javax.swing.JPanel {
//    NumberFormat formatter = new DecimalFormat("#,000.00");
    java.sql.Connection conn = null;

    public Form_SaleReport() {
        initComponents();
//        loadDataSet();
//        loadCombobox();
        try {
            conn = new ConnectionFactory().getConn();
        } catch (Exception ex) {
        }
        btnPrint.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        roundPanel1 = new javaswingdev.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lb3 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        txtTotalSales = new javax.swing.JTextField();
        lb5 = new javax.swing.JLabel();
        jDateChooserFrom = new com.toedter.calendar.JDateChooser();
        lb7 = new javax.swing.JLabel();
        txtCount = new javax.swing.JTextField();
        jDateChooserTo = new com.toedter.calendar.JDateChooser();
        lb4 = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();
        txtExpense = new javax.swing.JTextField();
        lb6 = new javax.swing.JLabel();
        txtIncom = new javax.swing.JTextField();
        lb8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setOpaque(false);

        lb1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lb1.setForeground(new java.awt.Color(125, 125, 125));
        lb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1.setText("Sales Report");

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

        lb3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lb3.setForeground(new java.awt.Color(125, 125, 125));
        lb3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb3.setText("From");

        btnSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        txtTotalSales.setEditable(false);
        txtTotalSales.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTotalSales.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalSalesActionPerformed(evt);
            }
        });

        lb5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb5.setForeground(new java.awt.Color(125, 125, 125));
        lb5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb5.setText("Total Sale   Rs:");

        lb7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb7.setForeground(new java.awt.Color(125, 125, 125));
        lb7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb7.setText("Invoice Count:");

        txtCount.setEditable(false);
        txtCount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtCount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCountActionPerformed(evt);
            }
        });

        lb4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lb4.setForeground(new java.awt.Color(125, 125, 125));
        lb4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb4.setText("To");

        btnPrint.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        txtExpense.setEditable(false);
        txtExpense.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtExpense.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtExpense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExpenseActionPerformed(evt);
            }
        });

        lb6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb6.setForeground(new java.awt.Color(125, 125, 125));
        lb6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb6.setText("Total Expense   Rs:");

        txtIncom.setEditable(false);
        txtIncom.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtIncom.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIncom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIncomActionPerformed(evt);
            }
        });

        lb8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb8.setForeground(new java.awt.Color(125, 125, 125));
        lb8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb8.setText("Total Income   Rs:");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel1Layout.createSequentialGroup()
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb3)
                                    .addComponent(jDateChooserFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb4)
                                    .addComponent(jDateChooserTo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 197, Short.MAX_VALUE))
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(roundPanel1Layout.createSequentialGroup()
                                        .addComponent(lb6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(roundPanel1Layout.createSequentialGroup()
                                        .addComponent(lb8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIncom, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(lb7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCount, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalSales, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25))))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(lb3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooserFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(lb4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooserTo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalSales, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb5)
                    .addComponent(txtCount, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIncom, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb8))
                .addGap(18, 18, 18))
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

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
//         TODO add your handling code here:

        if (jDateChooserFrom.getDate()==null || jDateChooserFrom.getDate()==null){
            JOptionPane.showMessageDialog(this, "Please select dates you want to filter.");
        }else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fromDate = jDateChooserFrom.getDate();
            Date toDate = jDateChooserTo.getDate();
            
            SalesDTO salesDTO = new SalesDTO();
            salesDTO.setDateFrom(sdf.format(fromDate));
            salesDTO.setDateto(sdf.format(toDate)); 
            
            searchData(salesDTO);
            txtExpense.setText(String.valueOf(format("%.2f",new ExpenseDAO().getTotalExpenseByDate(salesDTO))));
            getIncome();
            btnPrint.setEnabled(true);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
//         new CategoryDAO().getCategoryDAO(catTable.getValueAt(catTable.getSelectedRow(),0).toString());
    }//GEN-LAST:event_tableMouseClicked

    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed
        // TODO add your handling code here:   
    }//GEN-LAST:event_tableMousePressed

    private void txtTotalSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalSalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalSalesActionPerformed

    private void txtCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCountActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//              //bill print
        Date fromDate =  jDateChooserFrom.getDate();
        Date toDate = jDateChooserTo.getDate();
        
        SalesDTO salesDTO = new SalesDTO();
        salesDTO.setDateFrom(sdf.format(fromDate));
        salesDTO.setDateto(sdf.format(toDate)); 
            
        
//        String fromDate = String.valueOf(jDateChooserFrom.getDate());
//        String toDate = String.valueOf(jDateChooserTo.getDate());
//        String f = sdf.format(fromDate);
//        String t = sdf.format(toDate);
        double expense = Double.parseDouble(txtExpense.getText());
        double income = Double.parseDouble(txtIncom.getText());
        
        HashMap hasgmap = new HashMap();
//        HashMap m = new HashMap();
        hasgmap.put("fromDate", salesDTO.getDateFrom());
        hasgmap.put("toDate", salesDTO.getDateto());
        hasgmap.put("totExpense", expense);
        hasgmap.put("income", income);
//        hasgmap.put("income", income);
        
        try {
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\kalan\\JaspersoftWorkspaceV2\\Restaurant\\Sales_Report.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,hasgmap,conn);

            JasperViewer.viewReport(jasperPrint,false);
//                JasperPrintManager.printReport(jprint, false);               
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex);
           // Logger.getLogger(POS.class.getName()).log(Level.SEVERE, null, ex);
        }
        reset();
    }//GEN-LAST:event_btnPrintActionPerformed

    private void txtExpenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExpenseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExpenseActionPerformed

    private void txtIncomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIncomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIncomActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private com.toedter.calendar.JDateChooser jDateChooserFrom;
    private com.toedter.calendar.JDateChooser jDateChooserTo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    private javax.swing.JLabel lb8;
    private javaswingdev.swing.RoundPanel roundPanel1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtCount;
    private javax.swing.JTextField txtExpense;
    private javax.swing.JTextField txtIncom;
    private javax.swing.JTextField txtTotalSales;
    // End of variables declaration//GEN-END:variables

    private void loadDataSet() {
        try {
            SalesDAO salesDAO = new SalesDAO();
            table.setModel(salesDAO.buildTableModel(salesDAO.getQueryResult()));
            txtCount.setText(Integer.toString(table.getRowCount()));
            getTotalNetAmount();
            txtExpense.setText(String.valueOf(format("%.2f",new ExpenseDAO().getTotalExpense())));
            getIncome();
//            txtIncom.setText(String.valueOf(getIncome()));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(roundPanel1, e);
        }
        
    }
    

    private void reset() {
        DefaultTableModel model1 =(DefaultTableModel)table.getModel();
        while(model1.getRowCount() > 0){
            for(int i=0; i< model1.getRowCount(); i++){
                model1.removeRow(i);
            }
        }
//        table.getSelectionModel().clearSelection();
        jDateChooserFrom.setDate(null);
        jDateChooserTo.setDate(null);
        btnPrint.setEnabled(false);
        txtCount.setText("");
        txtExpense.setText("");
        txtIncom.setText("");
        txtTotalSales.setText("");
//        loadDataSet();
    }


    private void searchData(SalesDTO salesDTO) {
        try {
            SalesDAO salesDAO = new SalesDAO();
            table.setModel(salesDAO.buildTableModel(salesDAO.getSalesSearch(salesDTO)));
            txtCount.setText(Integer.toString(table.getRowCount()));
            getTotalNetAmount();
            setAlignment();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(roundPanel1, e);
        }
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

    private void getTotalNetAmount() {
        try {
            double total = 0;
            for (int i = 0; i < table.getRowCount(); i++){
                double amount = Double.parseDouble(String.valueOf(table.getValueAt(i, 6)));
                total += amount;
            }
            txtTotalSales.setText(String.valueOf(format("%.2f",total)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(roundPanel1, e);
        }
    }

    private void getIncome(){
        double sale=Double.parseDouble(String.valueOf(txtTotalSales.getText()));
        double expense = Double.parseDouble(String.valueOf(txtExpense.getText()));
        
        double invome = sale-expense;
        txtIncom.setText(String.valueOf(format("%.2f",invome)));
    }

    private void setAlignment() {
        DefaultTableCellRenderer rightRender = new DefaultTableCellRenderer();
        rightRender.setHorizontalAlignment(RIGHT);
        DefaultTableCellRenderer leftRender = new DefaultTableCellRenderer();
        leftRender.setHorizontalAlignment(LEFT);
//        table.getColumnModel().getColumn(0).setHeaderRenderer(leftRender);
//        table.getColumnModel().getColumn(1).setHeaderRenderer(leftRender);
//        table.getColumnModel().getColumn(2).setHeaderRenderer(leftRender);
//        table.getColumnModel().getColumn(3).setHeaderRenderer(rightRender);
//        table.getColumnModel().getColumn(4).setHeaderRenderer(rightRender);
//        table.getColumnModel().getColumn(5).setHeaderRenderer(rightRender);
        
        table.getColumnModel().getColumn(0).setCellRenderer(leftRender);
        table.getColumnModel().getColumn(1).setCellRenderer(leftRender);
        table.getColumnModel().getColumn(2).setCellRenderer(leftRender);
        table.getColumnModel().getColumn(3).setCellRenderer(leftRender);
        table.getColumnModel().getColumn(4).setCellRenderer(rightRender);
        table.getColumnModel().getColumn(5).setCellRenderer(rightRender);
        table.getColumnModel().getColumn(6).setCellRenderer(rightRender);
    }



}