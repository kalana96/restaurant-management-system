package javaswingdev.form;

import Restaurant.DAO.ExpenseDAO;
import Restaurant.DAO.SalesDAO;
import Restaurant.Database.ConnectionFactory;
import java.awt.HeadlessException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javaswingdev.card.ModelCard;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.YearMonth;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.table.DefaultTableCellRenderer;

public class Form_Dashboard extends javax.swing.JPanel {
    NumberFormat formatter = new DecimalFormat("#,000.00");
    java.sql.Connection conn = null;
//    PreparedStatement prepStatement = null;
    YearMonth ym = YearMonth.now();
    LocalDate firstOfThisMonth = ym.atDay( 1 );
    LocalDate firstOfNextMonth = ym.plusMonths( 1 ).atDay( 1 );
    

    public Form_Dashboard() {
        initComponents();
        try {
            conn = new ConnectionFactory().getConn();
        } catch (Exception ex) {
        }
        init();
        tableLoad();
    }

    private void init() {
//        table.fixTable(jScrollPane1);
//        table.addRow(new Object[]{"1", "Mike Bhand", "mikebhand@gmail.com", "Admin", "25 Apr,2018"});
//        table.addRow(new Object[]{"2", "Andrew Strauss", "andrewstrauss@gmail.com", "Editor", "25 Apr,2018"});
//        table.addRow(new Object[]{"3", "Ross Kopelman", "rosskopelman@gmail.com", "Subscriber", "25 Apr,2018"});
//        table.addRow(new Object[]{"4", "Mike Hussy", "mikehussy@gmail.com", "Admin", "25 Apr,2018"});
//        table.addRow(new Object[]{"5", "Kevin Pietersen", "kevinpietersen@gmail.com", "Admin", "25 Apr,2018"});
//        table.addRow(new Object[]{"6", "Andrew Strauss", "andrewstrauss@gmail.com", "Editor", "25 Apr,2018"});
//        table.addRow(new Object[]{"7", "Ross Kopelman", "rosskopelman@gmail.com", "Subscriber", "25 Apr,2018"});
//        table.addRow(new Object[]{"8", "Mike Hussy", "mikehussy@gmail.com", "Admin", "25 Apr,2018"});
//        table.addRow(new Object[]{"9", "Kevin Pietersen", "kevinpietersen@gmail.com", "Admin", "25 Apr,2018"});
//        table.addRow(new Object[]{"10", "Kevin Pietersen", "kevinpietersen@gmail.com", "Admin", "25 Apr,2018"});
//        table.addRow(new Object[]{"11", "Andrew Strauss", "andrewstrauss@gmail.com", "Editor", "25 Apr,2018"});
//        table.addRow(new Object[]{"12", "Ross Kopelman", "rosskopelman@gmail.com", "Subscriber", "25 Apr,2018"});
//        table.addRow(new Object[]{"13", "Mike Hussy", "mikehussy@gmail.com", "Admin", "25 Apr,2018"});
//        table.addRow(new Object[]{"14", "Kevin Pietersen", "kevinpietersen@gmail.com", "Admin", "25 Apr,2018"});
        
        double sale = new SalesDAO().getMonthlySales();
        double expense = new ExpenseDAO().getMonthlyExpense();
        double income = sale - expense;
        

        //  init card data
        card1.setData(new ModelCard(null, null, null, "Rs" + " " + formatter.format(new SalesDAO().getMonthlySales()) , "Report Sales Monthly"));
        card2.setData(new ModelCard(null, null, null, "Rs" + " " + formatter.format(new ExpenseDAO().getMonthlyExpense()), "Report Expense Monthly"));
        card3.setData(new ModelCard(null, null, null, "Rs" + " " + formatter.format(income), "Report Income Monthly"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        card1 = new javaswingdev.card.Card();
        card2 = new javaswingdev.card.Card();
        card3 = new javaswingdev.card.Card();
        roundPanel1 = new javaswingdev.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javaswingdev.swing.table.Table();
        jSeparator1 = new javax.swing.JSeparator();
        lb1 = new javax.swing.JLabel();

        setOpaque(false);

        card2.setColor1(new java.awt.Color(95, 211, 226));
        card2.setColor2(new java.awt.Color(26, 166, 170));
        card2.setIcon(javaswingdev.GoogleMaterialDesignIcon.PIE_CHART);

        card3.setColor1(new java.awt.Color(95, 243, 140));
        card3.setColor2(new java.awt.Color(3, 157, 27));
        card3.setIcon(javaswingdev.GoogleMaterialDesignIcon.RING_VOLUME);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice", "Date", "Type", "Total Amount", "Service Charge", "Net Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));

        lb1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lb1.setForeground(new java.awt.Color(125, 125, 125));
        lb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1.setText("MONTHLY SALES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lb1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(lb1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(43, 43, 43))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javaswingdev.card.Card card1;
    private javaswingdev.card.Card card2;
    private javaswingdev.card.Card card3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lb1;
    private javaswingdev.swing.RoundPanel roundPanel1;
    private javaswingdev.swing.table.Table table;
    // End of variables declaration//GEN-END:variables
    private void tableLoad() {
        try {
            table.fixTable(jScrollPane1);
            java.sql.Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT Inv_No, Date, Trans_Type, Total_Amount, Service_Charge, Net_Amount FROM t10invoice_resturent WHERE Status='A' and Date >= '"+firstOfThisMonth+"' AND Date < '"+firstOfNextMonth+"' ORDER BY Inv_No DESC");
            while(rs.next())
            {
                String inv = rs.getString("Inv_No");
                String date = rs.getString("Date");
                String type = rs.getString("Trans_Type");
                String total = rs.getString("Total_Amount");
                String sc = rs.getString("Service_Charge");
                String net = rs.getString("Net_Amount");
                table.addRow(new Object[]{inv, date, type, total, sc, net});
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(roundPanel1, e);
        }
        
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
        
//        table.getColumnModel().getColumn(0).setCellRenderer(leftRender);
//        table.getColumnModel().getColumn(1).setCellRenderer(leftRender);
//        table.getColumnModel().getColumn(2).setCellRenderer(leftRender);
//        table.getColumnModel().getColumn(3).setCellRenderer(rightRender);
//        table.getColumnModel().getColumn(4).setCellRenderer(rightRender);
//        table.getColumnModel().getColumn(5).setCellRenderer(rightRender);
    }

}
