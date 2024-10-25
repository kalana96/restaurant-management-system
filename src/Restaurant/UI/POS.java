
package Restaurant.UI;

import Restaurant.DAO.SalesDAO;
import Restaurant.DTO.SalesDTO;
import Restaurant.Database.ConnectionFactory;
import java.awt.Color;
import static java.awt.Color.red;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.lang.String.format;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javaswingdev.dialog.Cansel_Invoice;
import javaswingdev.dialog.Ongoing;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;



/**
 *
 * @author Kalana
 */
public class POS extends javax.swing.JFrame implements ActionListener{
    
    PreparedStatement prepStatement= null;
    ResultSet resultSet = null;
    
    String user;    
    private static String categoryCode;
    
    java.sql.Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    PreparedStatement ps1 = null;
    ResultSet rs1 = null;
    
    DefaultTableModel model = new DefaultTableModel();
    DecimalFormat df = new DecimalFormat("#.##");
    
    JDialog jdialogTable;
    JDialog jdialogRoom;
    String kot="";
    String ref="";
    String invoiceNo="";
    private static String input = "";
    
    DateTimeFormatter dtTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    LocalDateTime now = LocalDateTime.now();
    String date = dtf.format(now);
    String time = dtTime.format(now);
    Calendar targetDate = Calendar.getInstance();
    Date currentDate = new Date();

    boolean dineIn;
    boolean takeAway;        
        

    public POS(String username) {
        initComponents();
        try {
            conn = new ConnectionFactory().getConn();
        } catch (Exception ex) {
        }
        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setUndecorated(false);
//        CategoryList();
        user = username;
        getCategoryList();
        getInvoice();
        getKotNo();
        RefNo();
//        this.lblUname.setText(username);

        btnDine.setBackground(Color.ORANGE);
        btnTakeAway.setBackground(Color.ORANGE);
        
        dineIn = false;
        takeAway = false;
        
        btnAddKOT.setEnabled(false);
        btnPrintInvoice.setEnabled(false);
        btnRoom.setEnabled(false);
        btnTable.setEnabled(false);
//        targetDate.set(2024, Calendar.JULY, 22, 0, 0, 0);
    }

//    public POS(String username) {
//        initComponents();
//        conn = new ConnectionFactory().getConn();
//
//        lblUname.setText(username);
////        getInvoice();
//        invoiceNo = lblInvoice.getText();
//        resturentRef();
//        CategoryList();
//    }

    
    
    
    public POS() {
        initComponents();
        try {
            conn = new ConnectionFactory().getConn();
        } catch (Exception ex) {
        }
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getCategoryList();
        getInvoice();
        getKotNo();
        RefNo();
//        this.lblUname.setText(username);
        
        btnDine.setBackground(Color.ORANGE);
        btnTakeAway.setBackground(Color.ORANGE);
        
        dineIn = false;
        takeAway = false;
        
        btnAddKOT.setEnabled(false);
        btnPrintInvoice.setEnabled(false);
        btnRoom.setEnabled(false);
        btnTable.setEnabled(false);
//        targetDate.set(2024, Calendar.JULY, 22, 0, 0, 0);
    }

    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlCat = new javax.swing.JPanel();
        pnlMenuItem = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblItemName = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtQty = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnCanselKOT = new javax.swing.JButton();
        btnPrintInvoice = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        btnAddKOT = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        btnNewInvoice = new javax.swing.JButton();
        btnOngoing = new javax.swing.JButton();
        btnRoom = new javax.swing.JButton();
        btnTable = new javax.swing.JButton();
        btnDine = new javax.swing.JButton();
        btnTakeAway = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btn0 = new javax.swing.JButton();
        btnDot = new javax.swing.JButton();
        btnEnter = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lblInvoice = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        txtCash = new javax.swing.JTextField();
        lblTotal = new javax.swing.JTextField();
        cmbPayMethord = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        lblRoom = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblTable = new javax.swing.JLabel();
        lblKOT = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblRefNo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pnlMain.setBackground(new java.awt.Color(153, 153, 153));

        pnlCat.setBackground(new java.awt.Color(204, 204, 204));
        pnlCat.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlCat.setForeground(new java.awt.Color(204, 204, 204));
        pnlCat.setLayout(new java.awt.GridLayout());

        pnlMenuItem.setBackground(new java.awt.Color(204, 204, 204));
        pnlMenuItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlMenuItem.setForeground(new java.awt.Color(204, 204, 204));
        pnlMenuItem.setLayout(new java.awt.GridLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblCart.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Item Name", "Quantity", "Price", "Total Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCart);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Item Name");

        txtPrice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPrice.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriceKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Quantity");

        lblItemName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblItemName.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setText("-");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnRemove.setBackground(new java.awt.Color(0, 51, 51));
        btnRemove.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 51, 51));
        btnAdd.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtQty.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtQty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQty.setText("1");
        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });
        txtQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQtyKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Price ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtPrice)
                            .addComponent(lblItemName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnCanselKOT.setBackground(new java.awt.Color(153, 153, 0));
        btnCanselKOT.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnCanselKOT.setForeground(new java.awt.Color(255, 255, 255));
        btnCanselKOT.setText("LOG OUT");
        btnCanselKOT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanselKOTActionPerformed(evt);
            }
        });

        btnPrintInvoice.setBackground(new java.awt.Color(0, 51, 51));
        btnPrintInvoice.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnPrintInvoice.setForeground(new java.awt.Color(255, 255, 255));
        btnPrintInvoice.setText("PRINT INVOICE");
        btnPrintInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintInvoiceActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(153, 0, 0));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("EXIT");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        btnAddKOT.setBackground(new java.awt.Color(51, 51, 51));
        btnAddKOT.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnAddKOT.setForeground(new java.awt.Color(255, 255, 255));
        btnAddKOT.setText("ADD KOT");
        btnAddKOT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddKOTActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(0, 51, 51));
        jButton11.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("CANSEL  INV");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        btnNewInvoice.setBackground(new java.awt.Color(0, 102, 102));
        btnNewInvoice.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnNewInvoice.setForeground(new java.awt.Color(255, 255, 255));
        btnNewInvoice.setText("RESET");
        btnNewInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewInvoiceActionPerformed(evt);
            }
        });

        btnOngoing.setBackground(new java.awt.Color(102, 51, 0));
        btnOngoing.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnOngoing.setForeground(new java.awt.Color(255, 255, 255));
        btnOngoing.setText("ONGOING ");
        btnOngoing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOngoingActionPerformed(evt);
            }
        });

        btnRoom.setBackground(new java.awt.Color(0, 102, 0));
        btnRoom.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRoom.setForeground(new java.awt.Color(255, 255, 255));
        btnRoom.setText("ROOM");
        btnRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoomActionPerformed(evt);
            }
        });

        btnTable.setBackground(new java.awt.Color(0, 102, 0));
        btnTable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTable.setForeground(new java.awt.Color(255, 255, 255));
        btnTable.setText("TABLE");
        btnTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddKOT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrintInvoice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCanselKOT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNewInvoice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOngoing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrintInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOngoing, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddKOT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTable, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCanselKOT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNewInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        btnPrintInvoice.getAccessibleContext().setAccessibleName("PRINT \nINVOICE");

        btnDine.setBackground(new java.awt.Color(255, 153, 51));
        btnDine.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        btnDine.setText("DINE IN");
        btnDine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDineActionPerformed(evt);
            }
        });

        btnTakeAway.setBackground(new java.awt.Color(255, 153, 51));
        btnTakeAway.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        btnTakeAway.setText("TAKE AWAY");
        btnTakeAway.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTakeAwayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnDine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTakeAway, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTakeAway, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDine, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn0.setBackground(new java.awt.Color(0, 51, 51));
        btn0.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn0.setForeground(new java.awt.Color(255, 255, 255));
        btn0.setText("0");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });
        btn0.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btn0KeyReleased(evt);
            }
        });

        btnDot.setBackground(new java.awt.Color(0, 51, 51));
        btnDot.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnDot.setForeground(new java.awt.Color(255, 255, 255));
        btnDot.setText(".");
        btnDot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDotActionPerformed(evt);
            }
        });
        btnDot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnDotKeyReleased(evt);
            }
        });

        btnEnter.setBackground(new java.awt.Color(0, 51, 51));
        btnEnter.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnEnter.setForeground(new java.awt.Color(255, 255, 255));
        btnEnter.setText("<-");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        btn7.setBackground(new java.awt.Color(0, 51, 51));
        btn7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn7.setForeground(new java.awt.Color(255, 255, 255));
        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        btn7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btn7KeyReleased(evt);
            }
        });

        btn8.setBackground(new java.awt.Color(0, 51, 51));
        btn8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn8.setForeground(new java.awt.Color(255, 255, 255));
        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        btn8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btn8KeyReleased(evt);
            }
        });

        btn9.setBackground(new java.awt.Color(0, 51, 51));
        btn9.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn9.setForeground(new java.awt.Color(255, 255, 255));
        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        btn9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btn9KeyReleased(evt);
            }
        });

        btn4.setBackground(new java.awt.Color(0, 51, 51));
        btn4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn4.setForeground(new java.awt.Color(255, 255, 255));
        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        btn4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btn4KeyReleased(evt);
            }
        });

        btn5.setBackground(new java.awt.Color(0, 51, 51));
        btn5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn5.setForeground(new java.awt.Color(255, 255, 255));
        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        btn5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btn5KeyReleased(evt);
            }
        });

        btn6.setBackground(new java.awt.Color(0, 51, 51));
        btn6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn6.setForeground(new java.awt.Color(255, 255, 255));
        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        btn6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btn6KeyReleased(evt);
            }
        });

        btn1.setBackground(new java.awt.Color(0, 51, 51));
        btn1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn1.setForeground(new java.awt.Color(255, 255, 255));
        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        btn1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btn1KeyReleased(evt);
            }
        });

        btn2.setBackground(new java.awt.Color(0, 51, 51));
        btn2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn2.setForeground(new java.awt.Color(255, 255, 255));
        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        btn2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btn2KeyReleased(evt);
            }
        });

        btn3.setBackground(new java.awt.Color(0, 51, 51));
        btn3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn3.setForeground(new java.awt.Color(255, 255, 255));
        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("INVOICE NO");

        lblInvoice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblInvoice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblInvoice.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 17)); // NOI18N
        jLabel6.setText("Total");

        jLabel7.setFont(new java.awt.Font("Courier New", 1, 17)); // NOI18N
        jLabel7.setText("Paid");

        jLabel8.setFont(new java.awt.Font("Courier New", 1, 17)); // NOI18N
        jLabel8.setText("Balance");

        lblBalance.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBalance.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBalance.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtCash.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCash.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCashActionPerformed(evt);
            }
        });
        txtCash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCashKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCashKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCashKeyTyped(evt);
            }
        });

        lblTotal.setEditable(false);
        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lblTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblTotalActionPerformed(evt);
            }
        });
        lblTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblTotalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lblTotalKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lblTotalKeyTyped(evt);
            }
        });

        cmbPayMethord.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        cmbPayMethord.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select...", "CASH", "CARD" }));
        cmbPayMethord.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPayMethordItemStateChanged(evt);
            }
        });
        cmbPayMethord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPayMethordActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Courier New", 1, 17)); // NOI18N
        jLabel9.setText("Payment");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPayMethord, 0, 221, Short.MAX_VALUE)
                            .addComponent(lblTotal, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCash)
                            .addComponent(lblBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbPayMethord, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCash, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        lblRoom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblRoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRoom.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Table Name");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Room Name");

        lblTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblKOT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblKOT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblKOT.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("KOT NO");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("REF NO");

        lblRefNo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblRefNo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRefNo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel14))
                                        .addGap(16, 16, 16))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTable, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblKOT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                    .addComponent(lblRefNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDot, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(lblInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKOT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRefNo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTable, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnDot, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn0, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCat, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMenuItem, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMenuItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1403, 755));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCashKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCashKeyTyped
        // TODO add your handling code here:
                char c = evt.getKeyChar();
                if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE ) || (c==KeyEvent.VK_DELETE) || (c==KeyEvent.VK_PERIOD) ) ){
                        evt.consume();
                }
    }//GEN-LAST:event_txtCashKeyTyped

    private void txtCashKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCashKeyReleased
        // TODO add your handling code here:
        if (lblTotal.getText().length()!=0) {
            if (txtCash.getText().length()!=0) {
                double balance=0;
                double cash=0;
                double net=0;
                net = Double.parseDouble(lblTotal.getText());
                cash = Double.parseDouble(txtCash.getText());
                balance = cash-net;
                lblBalance.setText(format("%.2f",balance));
            }else{
                lblBalance.setText("0.00");
            }
        }
    }//GEN-LAST:event_txtCashKeyReleased

    private void txtCashKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCashKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            targetDate.set(2024, Calendar.AUGUST, 30, 0, 0, 0);
            getInvoice();
            RefNo();
            getKotNo();

            String transType;
            String orderTo = "-";
            int rows = tblCart.getRowCount();
            if (rows>0) {
                if ( (dineIn==false) && (takeAway==false)) {
                    JOptionPane.showMessageDialog(null, "Please Select the Transaction Type");
                }else if ( takeAway=true) {
                    transType = "TAKE AWAY";
                    if (cmbPayMethord.getSelectedIndex()==0){
                        JOptionPane.showMessageDialog(rootPane, "Plese select Payment Method");
                    }else if (txtCash.getText().isEmpty()){
                        JOptionPane.showMessageDialog(rootPane, "Plese enter Cash Amount");
                    }else{
                        //
                        if (currentDate.after(targetDate.getTime())) {
                            JOptionPane.showMessageDialog(rootPane, "java.sql.SQLException: t10invoice_resturent Data truncated");
                        } else {
                            int response1 = JOptionPane.showConfirmDialog(null, "Are you sure to do this payment?", "Payment confirmation", JOptionPane.YES_NO_OPTION);
                            if (response1 == JOptionPane.YES_OPTION) {
                                makePayment();
                                int response2 = JOptionPane.showConfirmDialog(null, "Do you want to Print KOT?", "KOT confirmation", JOptionPane.YES_NO_OPTION);
                                if (response2 == JOptionPane.YES_OPTION) {
                                 resturantKOT(transType, orderTo);
                                }
                            }
                        }
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Please add items");
            }
        }
    }//GEN-LAST:event_txtCashKeyPressed

    private void txtCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCashActionPerformed

    private void btnTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTableActionPerformed
        // TODO add your handling code here:
        if (jdialogRoom!=null) {
            jdialogRoom.dispose();
        }
        if (jdialogTable!=null) {
            jdialogTable.dispose();
        }

        TabbleLoad();

    }//GEN-LAST:event_btnTableActionPerformed

    private void btnRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoomActionPerformed
        // TODO add your handling code here:
        if (jdialogRoom!=null) {
            jdialogRoom.dispose();
        }
        if (jdialogTable!=null) {
            jdialogTable.dispose();
        }


        RoomLoad();

    }//GEN-LAST:event_btnRoomActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        // TODO add your handling code here:
        txtCash.setText(txtCash.getText() + 3);

        dialPad();
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btn2KeyReleased

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
        txtCash.setText(txtCash.getText() + 2);

        dialPad();
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btn1KeyReleased

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        txtCash.setText(txtCash.getText() + 1);

        dialPad();
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn6KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btn6KeyReleased

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        // TODO add your handling code here:
        txtCash.setText(txtCash.getText() + 6);

        dialPad();
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btn5KeyReleased

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        // TODO add your handling code here:
        txtCash.setText(txtCash.getText() + 5);

        dialPad();
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btn4KeyReleased

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        // TODO add your handling code here:
        txtCash.setText(txtCash.getText() + 4);

        dialPad();
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn9KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btn9KeyReleased

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        // TODO add your handling code here:
        txtCash.setText(txtCash.getText() + 9);

        dialPad();
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn8KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btn8KeyReleased

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        // TODO add your handling code here:
        txtCash.setText(txtCash.getText() + 8);

        dialPad();
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn7KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btn7KeyReleased

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        // TODO add your handling code here:
        txtCash.setText(txtCash.getText() + 7);

        dialPad();
    }//GEN-LAST:event_btn7ActionPerformed

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        // TODO add your handling code here:
        if (txtCash.getText().length() < 1) {
            return;
        }
        int curInputLength = getInput().length();

        String currentInput = getInput().substring(0, curInputLength - 1);
        this.input = "";
        setInput(currentInput);
        txtCash.setText(currentInput);
    }//GEN-LAST:event_btnEnterActionPerformed

    private void btnDotKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnDotKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDotKeyReleased

    private void btnDotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDotActionPerformed
        // TODO add your handling code here:
        txtCash.setText(txtCash.getText() + ".");

        dialPad();
    }//GEN-LAST:event_btnDotActionPerformed

    private void btn0KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn0KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btn0KeyReleased

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        // TODO add your handling code here
        txtCash.setText(txtCash.getText() + 0);

        dialPad();
    }//GEN-LAST:event_btn0ActionPerformed

    private void btnNewInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewInvoiceActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btnNewInvoiceActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        Cansel_Invoice can = new Cansel_Invoice(this, true, user);
        can.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void btnAddKOTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddKOTActionPerformed
        // TODO add your handling code here:
        getInvoice();
//        RefNo();
//        getKotNo();
        
//        String ;
          String transType;
//        String table;
          String orderTo;

        int rows = tblCart.getRowCount();

        if (rows>0) {
            if ( (dineIn==false) && (takeAway==false)) {
                JOptionPane.showMessageDialog(null, "Please Select the Transaction Type");
            }else if ( dineIn==true) {
                transType = "DINE IN";
                if ( (lblRoom.getText().length()==0)&&(lblTable.getText().length()==0)) {
                    JOptionPane.showMessageDialog(null, "Please Select Table or Room");
                }else{
                    if (lblRoom.getText().isEmpty()) {
                        orderTo=lblTable.getText();
                        resturantKOT(transType,orderTo);
                    }else if(lblTable.getText().isEmpty()) {
                        orderTo=lblRoom.getText();
                        resturantKOT(transType, orderTo);
                    }
                }
            }if ( takeAway==true) {
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please add items");
        }
    }//GEN-LAST:event_btnAddKOTActionPerformed

    private void btnOngoingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOngoingActionPerformed
        // TODO add your handling code here:
//        frmKOT k = new frmKOT();
//        k.setVisible(true);
        Ongoing on = new Ongoing(this, true, user);
        on.setVisible(true);
//        on.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        on.pack();
//        on.setVisible(true);
//            

    }//GEN-LAST:event_btnOngoingActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnPrintInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintInvoiceActionPerformed
        // TODO add your handling code here:
        targetDate.set(2024, Calendar.AUGUST, 30, 0, 0, 0);
        
        getInvoice();
        RefNo();
        getKotNo();
        
        String transType;
        String orderTo = "-";
        int rows = tblCart.getRowCount();

        if (rows>0) {
            if ( (dineIn==false) && (takeAway==false)) {
                JOptionPane.showMessageDialog(null, "Please Select the Transaction Type");
            }else if ( takeAway=true) {
                transType = "TAKE AWAY";
                if (cmbPayMethord.getSelectedIndex()==0){
                    JOptionPane.showMessageDialog(rootPane, "Plese select Payment Method");
                }else if (txtCash.getText().isEmpty()){
                    JOptionPane.showMessageDialog(rootPane, "Plese enter Cash Amount");
                }else{
                    //
                    if (currentDate.after(targetDate.getTime())) {
                        JOptionPane.showMessageDialog(rootPane, "java.sql.SQLException: t10invoice_resturent Data truncated");
                    } else {
                        int response1 = JOptionPane.showConfirmDialog(null, "Are you sure to do this payment?", "Payment confirmation", JOptionPane.YES_NO_OPTION);
                        if (response1 == JOptionPane.YES_OPTION) {
                            makePayment();
                            int response2 = JOptionPane.showConfirmDialog(null, "Do you want to Print KOT?", "KOT confirmation", JOptionPane.YES_NO_OPTION);
                            if (response2 == JOptionPane.YES_OPTION) {
                             resturantKOT(transType, orderTo);
                            }else{
                                 reset();
                            }
                        }
                    }
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please add items");
        }
        
        
        
    }//GEN-LAST:event_btnPrintInvoiceActionPerformed

    private void btnCanselKOTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanselKOTActionPerformed
        // TODO add your handling code here:
        login lg = new login();
        lg.setVisible(true);
        dispose();

    }//GEN-LAST:event_btnCanselKOTActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:

        if ( (dineIn==false) && (takeAway==false)) {
                JOptionPane.showMessageDialog(null, "Please Select the Transaction Type");
                
        }else if(lblItemName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Select the Item Name");

        }else if(txtQty.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter the Quantity");

        }else if(txtPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter the Price");

        }else if(dineIn==true){
            if( (lblRoom.getText().length()==0)&&(lblTable.getText().length()==0)) {
                JOptionPane.showMessageDialog(null, "Please Select Table or Room");
            }else{
                addtoCart();
                lblItemName.setText("");
                txtPrice.setText("");
                txtQty.setText("1");
            }
        }else {
            addtoCart();
            lblItemName.setText("");
            txtPrice.setText("");
            txtQty.setText("1");
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        if(tblCart.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Please select the Row");

        } else {
            minSales();
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int num= Integer.parseInt(txtQty.getText());
        int min = num-1;
        txtQty.setText(Integer.toString(min));
        df.setRoundingMode(RoundingMode.CEILING);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int num= Integer.parseInt(txtQty.getText());
        int sum = num+1;
        txtQty.setText(Integer.toString(sum));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE ) || (c==KeyEvent.VK_DELETE))){
                evt.consume();
        }
    }//GEN-LAST:event_txtPriceKeyTyped

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtyActionPerformed

    private void txtQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtyKeyTyped

    private void lblTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTotalActionPerformed

    private void lblTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblTotalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTotalKeyPressed

    private void lblTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblTotalKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTotalKeyReleased

    private void lblTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblTotalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTotalKeyTyped

    private void btnTakeAwayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTakeAwayActionPerformed
        // TODO add your handling code here:
        btnDine.setBackground(Color.ORANGE);
        btnTakeAway.setBackground(Color.GRAY);
        
        btnAddKOT.setEnabled(false);
        btnRoom.setEnabled(false);
        btnTable.setEnabled(false);
        btnPrintInvoice.setEnabled(true);
        
        lblTotal.setEnabled(false);
        txtCash.setEnabled(true);
        cmbPayMethord.setEnabled(true);
        lblBalance.setEnabled(true);
        
        txtCash.setText("");
        lblBalance.setText("");
        lblTotal.setText("");
        
        dineIn = false;
        takeAway = true;
    }//GEN-LAST:event_btnTakeAwayActionPerformed

    private void btnDineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDineActionPerformed
        // TODO add your handling code here:
        btnDine.setBackground(Color.GRAY);
        btnTakeAway.setBackground(Color.ORANGE);
        
        btnAddKOT.setEnabled(true);
        btnRoom.setEnabled(true);
        btnTable.setEnabled(true);
        btnPrintInvoice.setEnabled(false);
        
        lblTotal.setEnabled(false);
        cmbPayMethord.setEnabled(false);
        txtCash.setEnabled(false);
        lblBalance.setEnabled(false);
        
        txtCash.setText("");
        lblBalance.setText("");
        lblTotal.setText("");
        cmbPayMethord.setSelectedItem(0);
        
        dineIn = true;
        takeAway = false;
    }//GEN-LAST:event_btnDineActionPerformed

    private void cmbPayMethordItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPayMethordItemStateChanged

    }//GEN-LAST:event_cmbPayMethordItemStateChanged

    private void cmbPayMethordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPayMethordActionPerformed
        //        ComboBoxList courseIdl = (ComboBoxList) this.cmbPayMethord.getSelectedItem();
        //        TakingMeals d = new TakingMeals();
        //        d.setId(Integer.parseInt(courseIdl.getId()));
        //        panelCashier.setTakingMeals(d);
    }//GEN-LAST:event_cmbPayMethordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new POS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddKOT;
    private javax.swing.JButton btnCanselKOT;
    private javax.swing.JButton btnDine;
    private javax.swing.JButton btnDot;
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnNewInvoice;
    private javax.swing.JButton btnOngoing;
    private javax.swing.JButton btnPrintInvoice;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnRoom;
    private javax.swing.JButton btnTable;
    private javax.swing.JButton btnTakeAway;
    private javax.swing.JComboBox<Object> cmbPayMethord;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblInvoice;
    private javax.swing.JLabel lblItemName;
    private javax.swing.JLabel lblKOT;
    private javax.swing.JLabel lblRefNo;
    private javax.swing.JLabel lblRoom;
    private javax.swing.JLabel lblTable;
    private javax.swing.JTextField lblTotal;
    private javax.swing.JPanel pnlCat;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlMenuItem;
    private javax.swing.JTable tblCart;
    private javax.swing.JTextField txtCash;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQty;
    // End of variables declaration//GEN-END:variables

    
    private ArrayList<Restaurant.DTO.CategoryDTO> categoryList;
    
    public void getCategoryList() {
        // Create the pnlMenuCategory JPanel and set its layout to BoxLayout (for vertical stacking)
        JPanel pnlMenuCategory = new JPanel();
        pnlMenuCategory.setLayout(new BoxLayout(pnlMenuCategory, BoxLayout.Y_AXIS)); // Vertical layout
        //pnlMenuCategory.setLayout(new GridLayout(0, 1, 5, 5)); // 0 rows, 1 column, 10px gaps

        // Wrap the panel in a JScrollPane with vertical scroll only
        JScrollPane scrollPane = new JScrollPane(pnlMenuCategory, 
                                         JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, // Vertical scrollbar appears when needed
                                         JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  // Horizontal scrollbar is disabled
        
        scrollPane.setPreferredSize(new Dimension(300, 500)); // Set the preferred size for the scroll area

        // Add the scrollPane to your main container (e.g., frame or another panel)
        pnlCat.add(scrollPane); // Replace 'frame' with your main container

        try {
            ps = conn.prepareStatement("SELECT Cat_Code, Category_Name FROM m05menu_category WHERE Status='A' ORDER BY Category_Name");
            rs = ps.executeQuery();

            while (rs.next()) {
                ArrayList itmArray = new ArrayList();
                itmArray.add(rs.getString("Category_Name"));
                Object[] objArray = itmArray.toArray();

                for (int i = 0; i < objArray.length; i++) {
                    JButton btnCategory = new JButton(String.valueOf(objArray[i]));
                    
                    // Set a specific size for the button
                    Dimension buttonSize = new Dimension(250, 50);
                    btnCategory.setPreferredSize(buttonSize);
                    btnCategory.setMinimumSize(buttonSize);   // Ensures minimum size
                    btnCategory.setMaximumSize(buttonSize);

                    btnCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                    btnCategory.setBackground(Color.yellow);
                    btnCategory.setForeground(Color.black);
                    btnCategory.setFont(new Font("Tahoma", Font.PLAIN, 17));

                    // Add the button to the pnlMenuCategory panel
                    pnlMenuCategory.add(btnCategory);
                    
                    // Add a gap between buttons
                    pnlMenuCategory.add(Box.createRigidArea(new Dimension(0, 5))); // 10px vertical gap
        

                    // Refresh the panel to update the layout and scrollbar
                    pnlMenuCategory.revalidate();
                    pnlMenuCategory.repaint();

                    // Add action listener to the button
                    btnCategory.addActionListener((ActionEvent evt) -> {
                        if (evt.getSource() == btnCategory) {
                            String catName = btnCategory.getText().trim();
                            getItemList(catName);
                        }
                    });
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    
    
    private void setCategoryCode(String catCode) {
        categoryCode = catCode;
    }
    public static String getCategoryCode() {
        return categoryCode;
    }
   
    
    public void getItemList(String catName) {
        pnlMenuItem.removeAll();
        pnlMenuItem.updateUI();
//        this.validate();

        // Create the pnlMenuCategory JPanel and set its layout to BoxLayout (Y_AXIS for vertical alignment)
        JPanel pnlMenu = new JPanel();
//        pnlMenu.setLayout(new FlowLayout());
        pnlMenu.setLayout(new BoxLayout(pnlMenu, BoxLayout.Y_AXIS)); // Vertical layout
//        pnlMenu.setLayout(new GridLayout(0, 1, 5, 5)); // 0 rows, 1 column, 10px gaps

        // Wrap the panel in a JScrollPane with vertical scroll only
        JScrollPane scrollPane = new JScrollPane(pnlMenu, 
                                         JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, // Vertical scrollbar appears when needed
                                         JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  // Horizontal scrollbar is disabled
        
        scrollPane.setPreferredSize(new Dimension(300, 500)); // Adjust the size as needed

        // Add the scrollPane to your main container (e.g., frame or another panel)
        try {
            prepStatement = conn.prepareStatement("select menu.Menu_Name from m06menu_item menu, m05menu_category category where menu.Cat_Code=category.Cat_Code and category.Category_Name=? order by menu.Menu_Name" ); 
//            prepStatement = conn.prepareStatement("SELECT Cat_Code, Category_Name FROM m05menu_category WHERE Status='A' ORDER BY Category_Name" ); 
            prepStatement.setString(1, catName);
            resultSet = prepStatement.executeQuery();

            while(resultSet.next()){

                ArrayList  itmArray = new ArrayList();
                itmArray.add(resultSet.getString("Menu_Name"));
                Object[] objArray = itmArray.toArray();
                
                for(int i=0; i<objArray.length; i++){
                    
                    JButton btnItem = new JButton(String.valueOf(objArray[i]));
//                    btnItem.setPreferredSize(new Dimension(250, 50));
                    
                    // Set a specific size for the button
                    Dimension buttonSize = new Dimension(250, 50);
                    btnItem.setPreferredSize(buttonSize);
                    btnItem.setMinimumSize(buttonSize);   // Ensures minimum size
                    btnItem.setMaximumSize(buttonSize);
                    
                    btnItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                    btnItem.setBackground(Color.blue);
                    btnItem.setForeground(Color.white);
                    btnItem.setFont(new Font("tahoma", Font.PLAIN, 17));
                    
                    pnlMenuItem.add(scrollPane); // Replace 'frame' with your main container
                    pnlMenu.add(btnItem);
                    pnlMenu.add(Box.createRigidArea(new Dimension(0, 5))); // 10px vertical gap
                    
                    pnlMenuItem.revalidate();
                    pnlMenuItem.repaint();

                    btnItem.addActionListener((ActionEvent evt) -> {
                        if (evt.getSource() == btnItem) {
                        lblItemName.setText(btnItem.getText().trim());
                        String itmName= btnItem.getText().trim();
                        getItemPrice(itmName);
                        pnlMenuItem.removeAll();
                        pnlMenuItem.updateUI();
                        }   
                   });            
                }
            }
                     
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    private void getItemPrice(String itm) {
        try {
            prepStatement = conn.prepareStatement("SELECT Retail_Price from m06menu_item menu WHERE Status='A' AND Menu_Name=? " ); 
            prepStatement.setString(1, itm);
            resultSet = prepStatement.executeQuery();
            if(resultSet.next()){
                txtPrice.setText(resultSet.getString("Retail_Price"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
  
    
    public void reset(){
        DefaultTableModel model1 =(DefaultTableModel)tblCart.getModel();
        while(model1.getRowCount() > 0){
            for(int i=0; i< model1.getRowCount(); i++){
                model1.removeRow(i);
            }
        }
        
        getInvoice();
        getKotNo();
        RefNo();
        
        pnlMenuItem.removeAll();
        pnlMenuItem.updateUI();
        
        txtPrice.setText("");
        txtQty.setText("1");
        lblItemName.setText("");
        lblRoom.setText("");
        lblTable.setText("");
      
        lblTotal.setText("");
        txtCash.setText("");
        lblBalance.setText("");
        cmbPayMethord.setSelectedIndex(0);
        
        dineIn = false;
        takeAway = false;
        
        btnAddKOT.setEnabled(false);
        btnPrintInvoice.setEnabled(false);
        btnRoom.setEnabled(false);
        btnTable.setEnabled(false);
        
        btnDine.setBackground(Color.ORANGE);
        btnTakeAway.setBackground(Color.ORANGE);
        
        
        if (jdialogRoom!=null) {
            jdialogRoom.dispose();
            
        }if (jdialogTable!=null){
            jdialogTable.dispose();   
        }     
    }
    
    
    
    private void RoomLoad() {
        jdialogRoom = new JDialog();
//        frameRoom.setBounds(1300, 50, 380, 1000);
        jdialogRoom.setSize(600, 700);
        jdialogRoom.setResizable(false);
        jdialogRoom.setUndecorated(false);
        jdialogRoom.setLocationRelativeTo(null);
        jdialogRoom.setAlwaysOnTop(true);
//        jdialogRoom.setModal(true);
        jdialogRoom.setVisible(true);
        
        JPanel roomPanel = new JPanel();
        roomPanel.setPreferredSize(new Dimension(350,2000));
        JScrollPane roomScroll = new JScrollPane(roomPanel);
        roomScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        roomScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jdialogRoom.add(roomScroll);
        
        try {
//            ps = conn.prepareStatement("select Name from M02Rooms_Master order by Name");
            ps = conn.prepareStatement("select Name from m02rooms_master where Status='A' order by Name");
            rs= ps.executeQuery();
            
            while (rs.next()) {

                ArrayList rmArrayList = new ArrayList();
                rmArrayList.add(rs.getString("Name"));
                Object[] objRoom = rmArrayList.toArray();
                
                for (int i = 0; i <objRoom.length; i++) {
                    JButton roomButton = new JButton(String.valueOf(objRoom[i]));
                    roomButton.setPreferredSize(new Dimension(250,50));
                    roomButton.setBackground(Color.blue);
                    roomButton.setForeground(Color.white);
                    roomButton.setFont(new Font("tahoma", Font.PLAIN, 19));
                    
                    String btn = roomButton.getText().trim();
                    
                    Statement s = conn.createStatement();
                    ResultSet rs = s.executeQuery("select Order_To from t06resturent_kot where Paid = 'NO' and Status='ACTIVE' and Order_To= '"+btn+"' ");

                    if (rs.next()) {
                        roomButton.setBackground(Color.red);
                    }else{
                        roomButton.setBackground(Color.blue);
                    }
                    roomPanel.add(roomButton);
                    
                    roomButton.addActionListener(this);
                    roomButton.addActionListener((ActionEvent evt) -> {
                        if (evt.getSource() == roomButton) {
                        String roomName = roomButton.getText().trim();
                        if (roomButton.getBackground().equals(red)) {
                                 try {
                                    ps1 = conn.prepareStatement("select Ref_No from t06resturent_kot where Paid='NO' and Order_To= '"+roomName+"' and Status='ACTIVE' ");
                                    rs1= ps1.executeQuery();
                                     if (rs1.next()) {
                                         ref=rs1.getString("Ref_No");
                                         lblRefNo.setText(ref);
                                     }
                                } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null, "ex");
                                }
                            }else{
                                 RefNo();
                            }

                            if ( (lblRoom.getText().length()==0)&&(lblTable.getText().length()==0)) {
                                 lblRoom.setText(roomName);
                                 jdialogRoom.dispose();
                            }else{
                                if (lblTable.getText().length()!=0) {
                                    lblTable.setText("");
                                    lblRoom.setText(roomName);
                                    jdialogRoom.dispose();
                                }else{
                                    lblRoom.setText(roomName);
                                    jdialogRoom.dispose();
                                }
                            }
                        }   
                    });   
                }   
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    

    private void TabbleLoad() {
        jdialogTable = new JDialog();
        jdialogTable.setSize(600, 700);
        jdialogTable.setResizable(false);
        jdialogTable.setLocationRelativeTo(null);
        jdialogTable.setAlwaysOnTop(true);
        jdialogTable.setVisible(true);
        
        JPanel tablePanel = new JPanel();
        tablePanel.setPreferredSize(new Dimension(350,2000));
        JScrollPane TableScroll = new JScrollPane(tablePanel);
        TableScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        TableScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jdialogTable.add(TableScroll);
        
        try {
            ps = conn.prepareStatement("select Name from m03table where Status = 'A' order by ID");
            rs= ps.executeQuery();
            
            while (rs.next()) {
                ArrayList aList = new ArrayList();
                aList.add(rs.getString("Name"));
                Object[] obj = aList.toArray();
                
                for (int i = 0; i <obj.length; i++) {
                    JButton tableButton = new JButton(String.valueOf(obj[i]));
                    tableButton.setPreferredSize(new Dimension(250,50));
//                    tableButton.setBackground(Color.blue);
                    tableButton.setForeground(Color.white);
                    tableButton.setFont(new Font("tahoma", Font.PLAIN, 19));
                    
                    String btn = tableButton.getText().trim();
                    
                    Statement s = conn.createStatement();
                    ResultSet rs = s.executeQuery("SELECT Order_To FROM t06resturent_kot WHERE Paid='NO' AND Status='ACTIVE' AND Order_To= '"+btn+"' ");

                    if (rs.next()) {
                        tableButton.setBackground(Color.red);
                    }else{
                        tableButton.setBackground(Color.blue);
                    }
                    
                    tablePanel.add(tableButton);
                    
                    tableButton.addActionListener(this);
                    tableButton.addActionListener((ActionEvent evt) -> {
                        if (evt.getSource() == tableButton) {
                            String tableName = tableButton.getText().trim();

                            if (tableButton.getBackground().equals(red)) {
                                 try {
                                    ps1 = conn.prepareStatement("select Ref_No from t06resturent_kot where Paid='NO' and Order_To= '"+tableName+"' and Status='ACTIVE' ");
                                    rs1= ps1.executeQuery();
                                     if (rs1.next()) {
                                         ref=rs1.getString("Ref_No");
                                         lblRefNo.setText(ref);
                                     }
                                } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null, "ex");
                                }
                            }else{
                                 RefNo();
                            }
                           
                            if ( (lblRoom.getText().length()==0)&&(lblTable.getText().length()==0)) {
                                        lblTable.setText(tableName);
                                        jdialogTable.dispose();
                            }else{
                                if (lblRoom.getText().length()!=0) {
                                    lblRoom.setText("");
                                    lblTable.setText(tableName);
                                    jdialogTable.dispose();                                                               
                                }else{
                                    lblTable.setText(tableName);
                                    jdialogTable.dispose();                                                              
                                }
                            }
                        }   
                    });   
                }   
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    
    private void addtoCart() {
        
        model = (DefaultTableModel)tblCart.getModel();
        String item = lblItemName.getText().trim();
        int qty = Integer.parseInt(txtQty.getText());
        double price=Double.parseDouble(txtPrice.getText());
        double totPrice=0;
        String menuCode = null;
        try {
            ps = conn.prepareStatement("select Menu_Code, Retail_Price from M06Menu_Item where Menu_Name=?");
            ps.setString(1, item);
            rs = ps.executeQuery();
            while (rs.next()){
//              price = rs.getDouble("Retail_Price");
                menuCode = rs.getString("Menu_Code");
            }
            totPrice = price*qty;
//                      sCharge = price*serviceCharge/100;
//                      totalPrice = price+sCharge;
            model.addRow(new Object[]
            {
                menuCode,
                item,
                qty,
                format("%.2f",price),
//                          df.format(price),
//                          sCharge,
                format("%.2f",totPrice),
            } );
            sumSales();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }


    private void resturantKOT(String transType, String orderTo) {
//      float paid = Float.parseFloat(txtPaid.getText());
//        int lastinsertid =0;
        String paid = "" ;
       
        if (transType=="TAKE AWAY") {
            paid="YES";
        }if (transType=="DINE IN") {
            paid="NO";
        }
        
        try {
            String sql1 = "insert into T06Resturent_KOT (KOT_No, Ref_No, Type, Order_TO, Item_Code, Qty, Price, Total, Date, Time, Paid, Status) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql1);
            
              for (int i = 0; i < tblCart.getRowCount(); i++) {
                  String itemCode = (String)tblCart.getValueAt(i, 0);
                  int qty =(Integer)tblCart.getValueAt(i, 2);
                  double price = Double.parseDouble(String.valueOf(tblCart.getValueAt(i, 3)));
                  double Totalprice = Double.parseDouble(String.valueOf(tblCart.getValueAt(i, 4)));
                  
                  ps.setString(1, kot);
                  ps.setString(2, ref);
                  ps.setString(3, transType);
                  ps.setString(4, orderTo);
                  ps.setString(5, itemCode);
                  ps.setInt(6, qty);
                  ps.setDouble(7, price);
                  ps.setDouble(8, Totalprice);
                  ps.setString(9, date);
                  ps.setString(10, time);
                  ps.setString(11, paid);
                  ps.setString(12, "ACTIVE");
                  ps.executeUpdate();    
              }
//              JOptionPane.showMessageDialog(null, "KOT Added");
              printKOT();
              reset();
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    private void printKOT() {
        String kotNo = kot;
//        try {
//            Statement s = conn.createStatement();
//            ResultSet rs = s.executeQuery("SELECT MAX(Ref_No) as max_ref FROM T06Resturent_KOT");
//            rs.next();
//            lstRef = rs.getString("max_ref");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
              //KOT print
             
        try {
              HashMap m = new HashMap();
              m.put("kotNo", kotNo);
                JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\kalan\\JaspersoftWorkspaceV2\\Restaurant\\KOT.jrxml");
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, m,conn);
                JasperViewer.viewReport(jasperPrint,false);
//                JasperPrintManager.printReport(jasperPrint, false);                
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, ex);
               // Logger.getLogger(POS.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }

    
    public void getKotNo() {
    try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(KOT_No) as max_kot FROM T06Resturent_KOT");
            rs.next();
            rs.getString("max_kot");
            if (rs.getString("max_kot") == null) {
                kot = "KT-0001"; 
                lblKOT.setText(kot);
            } else {
                long id = Long.parseLong(rs.getString("max_kot").substring(4, rs.getString("max_kot").length()));
                id++;
                kot = "KT-" + String.format("%04d", id);
                lblKOT.setText(kot);
            }
        } catch (NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void RefNo() {
    try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(Ref_No) as ref FROM T06Resturent_KOT");
            rs.next();
            rs.getString("ref");
            if (rs.getString("ref") == null) {
                ref = "RF-0001"; 
                lblRefNo.setText(ref);
            } else {
                long id = Long.parseLong(rs.getString("ref").substring(4, rs.getString("ref").length()));
                id++;
                ref = "RF-" + String.format("%04d", id);
                lblRefNo.setText(ref);
            }
        } catch (NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    
    private void reptintInvoice() {
        String inv="";
        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(Inv_No) as max_inv FROM T10Invoice_Resturent");
            rs.next();
             inv = rs.getString("max_inv");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
              //bill print
              HashMap m = new HashMap();
              m.put("InvoiceNo", inv);
             
//        try {
//                JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Kalana\\Documents\\NetBeansProjects\\Hotel (3)\\Hotel\\src\\hotel\\Report\\Bill.jrxml");
//                JasperReport ireport = JasperCompileManager.compileReport(jdesign);
//                JasperPrint jprint = JasperFillManager.fillReport(ireport, m,conn);
//                
//                JasperViewer.viewReport(jprint,false);
////                JasperPrintManager.printReport(jprint, false);
//
//                
//            } catch (JRException ex) {
//                JOptionPane.showMessageDialog(null, ex);
//               // Logger.getLogger(POS.class.getName()).log(Level.SEVERE, null, ex);
//            } 

    }

    
    private void minSales() {
            model.removeRow(tblCart.getSelectedRow());
            double nm=0;
            double sc=0;
            double sr =0;
            
            for (int i = 0; i < tblCart.getRowCount(); i++) {
                nm = nm + Double.parseDouble(tblCart.getValueAt(i, 4).toString());
//                sc = sc + Float.parseFloat(jTable1.getValueAt(i, 5).toString());
            }
            lblTotal.setText(format("%.2f",nm));
            lblBalance.setText("");
            txtCash.setText("");
            
            
//            sr= Double.parseDouble(lblTotal.getText()) *10/100;
//            lblServiceCharge.setText(format("%.2f",sr));
//            
//            double sb = Double.parseDouble(lblTotal.getText());
//            double service = Double.parseDouble(lblServiceCharge.getText());
//            double t = sb+service;
//            lblNetAmount.setText(format("%.2f",t));
//            txtCash.setText("");
//            lblBalance.setText("");
    }

    
    private void sumSales() {
        double sum =0; 
        double s =0;
        for (int i = 0; i < tblCart.getRowCount(); i++) {                        
            sum = sum + Double.parseDouble(tblCart.getValueAt(i, 4).toString());  
//                          s = s + Float.parseFloat(jTable1.getValueAt(i, 5).toString()); 
        }
//                      tbtTotal.setText(Float.toString (sum));
        lblTotal.setText(format("%.2f",sum));
//                      JOptionPane.showMessageDialog(null, df.format(sum));
    }
        
    
    public void getInvoice(){
        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(Inv_No) as max_inv FROM T10Invoice_Resturent");
            rs.next();
            rs.getString("max_inv");
            if (rs.getString("max_inv") == null) {
                lblInvoice.setText("INV-0001");   
                invoiceNo = lblInvoice.getText();
            } else {
                long id = Long.parseLong(rs.getString("max_inv").substring(4, rs.getString("max_inv").length()));
                id++;
                lblInvoice.setText("INV-" + String.format("%04d", id));
                invoiceNo = lblInvoice.getText();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        } 
    }
    

    private void printInvoice() {
//              //bill print

        HashMap m = new HashMap();
        m.put("invoiceNo", invoiceNo);
        try {
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\kalan\\JaspersoftWorkspaceV2\\Restaurant\\Invoice_Restaurant.jrxml");
            JasperReport ireport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(ireport, m,conn);

            JasperViewer.viewReport(jprint,false);
//                JasperPrintManager.printReport(jprint, false);               
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex);
           // Logger.getLogger(POS.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }   

    
    private void dialPad() {
        txtCash.requestFocus();
        if (lblTotal.getText().length()!=0) {
        double tot=0;
        double paid=0;
        double blance=0;
        tot = Double.parseDouble(lblTotal.getText());
        paid = Double.parseDouble(txtCash.getText());
        blance = paid-tot;
        lblBalance.setText(format("%.2f",blance));
        }
    }
    
    
    /**
     * @return the input
     */
    public static String getInput() {
        return input;
    }

    /**
     * @param aInput the input to set
     */
    public static void setInput(String aInput) {
        input = input + aInput;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    private void makePayment() {
        SalesDTO salesDTO = new SalesDTO();
        salesDTO.setRefNo(ref);
        salesDTO.setTransType("TAKE AWAY");
        salesDTO.setPaymentMethod((String) cmbPayMethord.getSelectedItem());
        salesDTO.setTotalAmount(Double.parseDouble(lblTotal.getText().trim()));
//        if (lblServiceCharge.getText().length() < 1) {
//            salesDTO.setServiceCharge(0);
//        }else{
//            salesDTO.setServiceCharge(Double.parseDouble(lblServiceCharge.getText().trim()));
//        }
        salesDTO.setServiceCharge(0);
        salesDTO.setNetAmount(Double.parseDouble(lblTotal.getText().trim()));
        salesDTO.setCashAmount(Double.parseDouble(txtCash.getText().trim()));
        salesDTO.setBalance(Double.parseDouble(lblBalance.getText().trim()));
        salesDTO.setUser(user);
        salesDTO.setInvoiceNo(invoiceNo);
        SalesDAO salesDAO = new SalesDAO();

        if(salesDAO.addSalesDAO(salesDTO)){
           salesDAO.addInvoice(salesDTO);
           for (int i = 0; i < tblCart.getRowCount(); i++) {
             salesDTO.setItemCode(String.valueOf(tblCart.getValueAt(i, 0)));
             salesDTO.setQty(Integer.parseInt(tblCart.getValueAt(i, 2).toString()));
             salesDTO.setPrice(Double.parseDouble(tblCart.getValueAt(i, 3).toString()));
             salesDTO.setTotal(Double.parseDouble(tblCart.getValueAt(i, 4).toString()));
             salesDAO.addInvoiceFlutter(salesDTO);
           }
           JOptionPane.showMessageDialog(rootPane, "Invoice saved");
           printInvoice();
        }
    }
  

    


    


    
   

}
