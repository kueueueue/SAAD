
package cis2103;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import exceptions.MenuNotFoundException;
import model.Database;
import model.Feedbacks;
import model.Item;
import model.Menu;
import model.Order;
import model.Package;
import model.RegularClass;
import model.UserClass;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class RegularClassFrame extends javax.swing.JFrame {

    Order order;
    private DefaultTableModel model;
    int rowIndex1, rowIndex2, rowIndex3;
    private static RegularClass temp;

    private static final DecimalFormat df = new DecimalFormat("'₱'0.00");
    
    public RegularClassFrame(UserClass user) {
        initComponents();
        try {
			order = new Order();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(this, "Something went wrong in the database. Please contact developers.");
		}
        tableViewRegOne();
        tableViewRegTwo();
        tableViewRegItem();
        tableViewFeedbacks();
//        
//        ButtonGroup custOrderBG = new ButtonGroup();
//        custOrderBG.add(radioRegDigital);
//        custOrderBG.add(radioRegPhysical);
//        ButtonGroup custModeBG = new ButtonGroup();
//        custModeBG.add(radioRegPickup);
//        custModeBG.add(radioRegDeliver);
        
        try {
			inputRegTrans.setText(String.valueOf(Database.getLastOrderID()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
        inputRegTrans.setEditable(false);
        inputRegTotal.setEditable(false);
        inputRegChange.setEditable(false); 
        
        temp = (RegularClass) user;
        initWelcome();
    }


    private void initComponents() {
    	
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        welcomeName = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        welcomeItem = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        welcomePack = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        welcomeUser = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        welcomeMess = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        welcomeOrder = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        inputRegTrans = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableRegOne = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableRegTwo = new javax.swing.JTable();
        buttonRegAddOne = new javax.swing.JButton();
        spinnerOne = new javax.swing.JSpinner();
        inputRegOne = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRegItems = new javax.swing.JTable();
        inputRegTemp = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        buttonRegRemove = new javax.swing.JButton();
        buttonRegUpdate = new javax.swing.JButton();
        buttonRegProceed = new javax.swing.JButton();
        buttonRegCal = new javax.swing.JButton();
        inputRegChange = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputRegTotal = new javax.swing.JTextField();
        inputRegAmount = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        textFeedArea = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableFeedbacks = new javax.swing.JTable();
        buttonFeedSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1720, 880));
        setMinimumSize(new java.awt.Dimension(1720, 880));
        setPreferredSize(new java.awt.Dimension(1720, 880));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1720, 880));
        jPanel1.setMinimumSize(new java.awt.Dimension(1720, 880));
        jPanel1.setPreferredSize(new java.awt.Dimension(1720, 880));

        jPanel2.setBackground(new java.awt.Color(1, 18, 68));
        jPanel2.setMaximumSize(new java.awt.Dimension(1720, 100));
        jPanel2.setMinimumSize(new java.awt.Dimension(1720, 100));
        jPanel2.setPreferredSize(new java.awt.Dimension(1720, 100));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SYSTEM | REGULAR");

        jButton1.setText("LOG OUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTabbedPane1.setMaximumSize(new java.awt.Dimension(1720, 779));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(1720, 779));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1720, 779));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        welcomeName.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        welcomeName.setText("Welcome , ADMIN <admin>");

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("ITEMS"));

        welcomeItem.setText("jLabel26");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(welcomeItem, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeItem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("PACKAGES"));

        welcomePack.setText("jLabel26");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(welcomePack, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomePack, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("USERS"));

        welcomeUser.setText("jLabel26");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(welcomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("FEEDBACKS"));

        welcomeMess.setText("jLabel26");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(welcomeMess, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeMess, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("ORDERS"));

        welcomeOrder.setText("jLabel26");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(welcomeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(welcomeName)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(welcomeName)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(453, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("WELCOME", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("ORDER #");

        jPanel6.setBackground(new java.awt.Color(1, 18, 68));

        tableRegOne.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "PRICE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRegOne.setRowHeight(40);
        tableRegOne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRegOneMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableRegOne);

        tableRegTwo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "PRICE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRegTwo.setRowHeight(40);
        tableRegTwo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRegTwoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableRegTwo);

        buttonRegAddOne.setText("ADD");
        buttonRegAddOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegAddOneActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PACKAGES");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("SINGLE ITEMS");

        jLabel10.setText("jLabel10");
        jLabel10.setVisible(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(239, 239, 239)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(inputRegOne, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spinnerOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonRegAddOne, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(379, 379, 379))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGap(37, 37, 37)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerOne, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputRegOne, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(buttonRegAddOne, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        jPanel7.setBackground(new java.awt.Color(1, 18, 68));

        tableRegItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "QUANTITY", "PRICE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRegItems.setRowHeight(40);
        tableRegItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRegItemsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableRegItems);

        buttonRegRemove.setText("REMOVE");
        buttonRegRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegRemoveActionPerformed(evt);
            }
        });

        buttonRegUpdate.setText("UPDATE");
        buttonRegUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(inputRegTemp)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonRegUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonRegRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputRegTemp)
                    .addComponent(buttonRegRemove, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jSpinner1)
                    .addComponent(buttonRegUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        buttonRegProceed.setText("PROCEED");
        buttonRegProceed.setBackground(new Color(15, 4, 76));
        buttonRegProceed.setForeground(Color.WHITE);

        buttonRegProceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegProceedActionPerformed(evt);
            }
        });

        buttonRegCal.setText("CALCULATE");
        buttonRegCal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegCalActionPerformed(evt);
            }
        });

        inputRegChange.setText("0.00");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("CHANGE ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("TOTAL");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("AMOUNT");

        inputRegTotal.setText("0.00");

        inputRegAmount.setText("0.00");

        inputRegAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputRegAmountKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(inputRegTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(inputRegAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonRegCal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(inputRegChange)
                                .addGap(18, 18, 18)
                                .addComponent(buttonRegProceed, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inputRegTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(inputRegTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(inputRegChange, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(inputRegTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(buttonRegCal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputRegAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonRegProceed, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("SYSTEM", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("SEND A FEEDBACK");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Enter your message below :");

        textFeedArea.setColumns(20);
        textFeedArea.setRows(5);
        jScrollPane4.setViewportView(textFeedArea);

        jPanel8.setBackground(new java.awt.Color(1, 18, 68));

        tableFeedbacks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MESSAGE", "DATE"
            }
        ));
        tableFeedbacks.setRowHeight(40);
        jScrollPane5.setViewportView(tableFeedbacks);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonFeedSend.setText("SEND");
        buttonFeedSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFeedSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonFeedSend, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(368, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonFeedSend, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(139, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("SEND FEEDBACK", jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }                        


    //```buttons ---- LOG OUT//
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	int out = JOptionPane.showConfirmDialog(this, "Do you want to log out?", "SELECT", JOptionPane.YES_NO_OPTION);
        if(out == 0) {
            Login log = new Login();
        	log.setVisible(true);
        	log.setLocationRelativeTo(null);
        	this.dispose();
        }
    }
    
    private void tableViewRegOne() {
    	model = (DefaultTableModel) tableRegOne.getModel();
    	Object[] row = new Object[3];
    	    	
    	for(Item i : Database.getItems()) {
    		row[0] = i.getId();
			row[1] = i.getName();
			row[2] = df.format(i.getPrice());
			model.addRow(row);
		}
    }
    
    private void tableViewRegTwo() {
    	
        model = (DefaultTableModel) tableRegTwo.getModel(); 
        model.setRowCount(0);
    	Object[] row = new Object[3];
    	
    	for(Package p : Database.getPack()) {
    		row[0] = p.getId();
    		row[1] = p.getName();
    		row[2] = df.format(p.getPrice());
    		model.addRow(row);
    	}
    }
    
    private void tableViewRegItem() {
        
        model = (DefaultTableModel) tableRegItems.getModel();
        model.setRowCount(0);
        Object[] row = new Object[3];

        for(Menu m : order.getMenuOrders()) {
        	row[0] = m.getName();
        	row[1] = m.getQuantity();
        	row[2] = df.format(m.getPrice() * m.getQuantity());
        	model.addRow(row);
        }
    }
    
    private void tableRegOneMouseClicked(java.awt.event.MouseEvent evt) {                                            
        model = (DefaultTableModel) tableRegOne.getModel();
        rowIndex1 = tableRegOne.getSelectedRow();


        
        jLabel10.setText(model.getValueAt(rowIndex1, 0).toString());

        inputRegOne.setText(model.getValueAt(rowIndex1, 1).toString());
        spinnerOne.setValue(1);        
        tableRegTwo.clearSelection();
    }                                           

    private void tableRegTwoMouseClicked(java.awt.event.MouseEvent evt) {                                             
        model = (DefaultTableModel) tableRegTwo.getModel();
        rowIndex2 = tableRegTwo.getSelectedRow();
        
        jLabel10.setText(model.getValueAt(rowIndex2, 0).toString());
        
        inputRegOne.setText(model.getValueAt(rowIndex2, 1).toString());
        spinnerOne.setValue(1);          
        tableRegOne.clearSelection();
        tableRegItems.clearSelection();
        
        
        displayPack(jLabel10.getText(), inputRegOne.getText(), Float.parseFloat(model.getValueAt(rowIndex2, 2).toString().substring(1)));
    }        
    
 // display item list of a package
    private void displayPack(String id, String packName, float price) {
        JFrame newFrame = new JFrame("Items inside " + packName);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setSize(600, 400);
        newFrame.setLayout(new BorderLayout());
        newFrame.setFocusable(true);
        newFrame.addFocusListener(new FocusListener() {
        	public void focusLost(FocusEvent e) {
        		newFrame.toFront();
                newFrame.dispose();
            }

			public void focusGained(FocusEvent e) {
				
			}
        });
        JLabel lblTitle = new JLabel("Package " + packName);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        newFrame.add(lblTitle, BorderLayout.NORTH);
        
        String[] columnNames = {"Name", "Quantity", "Price"};

		ArrayList<Item> mi = Database.loadPackageItemFromDatabase(id);
		Object[][] rowData = new Object[mi.size()][3];
		int i = 0;
		for(Item it : mi) {
			rowData[i][0] = it.getName();
			rowData[i][1] = it.getQuantity();
			rowData[i][2] = df.format(it.getPrice());
			i++;
		}
		JTable table = new JTable(rowData, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500, 200));
		table.setRowHeight(40);
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		newFrame.add(scrollPane, BorderLayout.CENTER);
		
		newFrame.pack();
		newFrame.setVisible(true);
		newFrame.setLocationRelativeTo(null);
    }

    private void tableRegItemsMouseClicked(java.awt.event.MouseEvent evt) {                                           
        
        model = (DefaultTableModel) tableRegItems.getModel();
        rowIndex3 = tableRegItems.getSelectedRow();
        
        
        jSpinner1.setValue(model.getValueAt(rowIndex3, 1));
        inputRegTemp.setText(model.getValueAt(rowIndex3, 0).toString());   
        inputRegOne.setText("");
        spinnerOne.setValue(0);
        tableRegOne.clearSelection();
        tableRegTwo.clearSelection();
    }      
    
    private boolean menuExistInOrder(String name) {
    	for(Menu m: order.getMenuOrders()) {
    		if(m.getName().equals(name)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    private void clearReg() {
    	
        inputRegOne.setText("");
        spinnerOne.setValue(0);
        inputRegTemp.setText("");
        jSpinner1.setValue(0);
        tableRegOne.clearSelection();
        tableRegTwo.clearSelection();
	    tableRegItems.clearSelection();
    }

    private void buttonRegAddOneActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	int tempQty = Integer.parseInt(spinnerOne.getValue().toString());
    	try {
    		
    		Menu temp = Database.getMenuByID(jLabel10.getText());
            if(menuExistInOrder(model.getValueAt(rowIndex1, 1).toString())) {
            	JOptionPane.showMessageDialog(this, "This item already exists.");
            	return;
            }
            
    		temp.setQuantity(tempQty);
    		order.getMenuOrders().add(temp);
    	
    		
           
		} catch (NumberFormatException | MenuNotFoundException e) {
			e.printStackTrace();
		}

    	tableViewRegItem();
	    inputRegTotal.setText(Float.toString(currentTotal()));
	    clearReg();
    }                                                                                   

    private void buttonRegUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                                
        if(inputRegTemp.getText().isEmpty()) {
        	JOptionPane.showMessageDialog(this, "Please select an item to update");
        }
    	int choice = JOptionPane.showConfirmDialog(null, "Update Order Item?", "Update Confirmation", JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.NO_OPTION) {
			return;
		} 
        String tempName = model.getValueAt(rowIndex3, 0).toString();
        int tempQty = Integer.parseInt(jSpinner1.getValue().toString());

        for(Menu m : order.getMenuOrders()) {
        	if(m.getName().equals(tempName)) {
        		m.setQuantity(tempQty);        	
        		break;
        	}
        } 
        
        tableViewRegItem();
        inputRegTotal.setText(Float.toString(currentTotal()));
        clearReg();
        
    }                                               

    private void buttonRegRemoveActionPerformed(java.awt.event.ActionEvent evt) {                                                
    	int choice = JOptionPane.showOptionDialog(null, "Remove Order Item?", "Remove Confirmation", JOptionPane.YES_NO_OPTION,
    		    JOptionPane.WARNING_MESSAGE,
    		    null,
    		    null,
    		    null);
		if(choice != JOptionPane.YES_OPTION) {
			return;
		} 
		
        model = (DefaultTableModel) tableRegItems.getModel();
        String tempName = model.getValueAt(rowIndex3, 0).toString();
        for(Menu m : order.getMenuOrders()) {
        	if(m.getName().equals(tempName)) {
        		order.getMenuOrders().remove(m);
        		break;
        	}
        } 
        
        tableViewRegItem();
        clearReg();
        inputRegTotal.setText(df.format(currentTotal()));
    
    }                                                                                          
                                
    private void inputRegAmountKeyTyped(java.awt.event.KeyEvent evt) {
        if(!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }
    
    private void buttonRegCalActionPerformed(java.awt.event.ActionEvent evt) {
    	if(inputRegAmount.getText().isEmpty()) {
    		inputRegAmount.setText("0");
    	}
    	float change = Float.parseFloat(inputRegAmount.getText()) - Float.parseFloat(inputRegTotal.getText());
    	inputRegChange.setText(String.valueOf(change)); 	
    }
    
    private void buttonRegProceedActionPerformed(java.awt.event.ActionEvent evt) {
    	order.setTotal(Float.parseFloat(inputRegTotal.getText()));
    	setVisible(false);
    	new Billing(this, temp, order, Float.parseFloat(inputRegAmount.getText())).setVisible(true);
    }
    
    public float currentTotal() {
        float total = 0;
        
        for(Menu m: order.getMenuOrders()) {
        	total += (m.getQuantity() * m.getPrice());
        }
        
        return total;
    } 
    
	////////////SEND A FEEDBACK////////////////////
    
    private void tableViewFeedbacks() {
    	model = (DefaultTableModel) tableFeedbacks.getModel();
    	model.setRowCount(0);
    	Object[] row = new Object[3];
    	for(Feedbacks f : Database.getFeedback()) {     	
    		row[0] = f.getId();
    		row[1] = f.getMessage();
    		row[2] = f.getDateAdded();
    		model.addRow(row);
    	}
    	
    }
    
    private void buttonFeedSendActionPerformed(java.awt.event.ActionEvent evt) {  
    	Feedbacks feed;
		try {
	    	int choice = JOptionPane.showConfirmDialog(null, "Send Message?", "Add Confirmation", JOptionPane.YES_NO_OPTION);
			if(choice != JOptionPane.YES_OPTION) {
				return;
			} 
			feed = new Feedbacks(Database.getLastFeedbackID(), temp.getId(), textFeedArea.getText(), LocalDateTime.now());
	    	Database.addFeedback(feed);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tableViewFeedbacks();
    } 
    
    
	////////////WELCOME PAGE////////////////////
    private void initWelcome() {
    	welcomeName.setText("Welcome, " + temp.getUserName() + "!");
    	welcomeItem.setText(String.valueOf(Database.getItems().size()));
    	welcomePack.setText(String.valueOf(Database.getPack().size()));
    	welcomeUser.setText(String.valueOf(Database.getUsers().size()));
    	welcomeMess.setText(String.valueOf(Database.getFeedback().size()));    	
    }
    
                   
    private javax.swing.JButton buttonFeedSend;
    private javax.swing.JButton buttonRegAddOne;
    private javax.swing.JButton buttonRegCal;
    private javax.swing.JButton buttonRegProceed;
    private javax.swing.JButton buttonRegRemove;
    private javax.swing.JButton buttonRegUpdate;
    private javax.swing.JTextField inputRegAmount;
    private javax.swing.JTextField inputRegChange;
    private javax.swing.JTextField inputRegOne;
    private javax.swing.JTextField inputRegTemp;
    private javax.swing.JTextField inputRegTotal;
    private javax.swing.JTextField inputRegTrans;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JSpinner spinnerOne;
    private javax.swing.JTable tableFeedbacks;
    private javax.swing.JTable tableRegItems;
    private javax.swing.JTable tableRegOne;
    private javax.swing.JTable tableRegTwo;
    private javax.swing.JTextArea textFeedArea;
    private javax.swing.JLabel welcomeItem;
    private javax.swing.JLabel welcomeMess;
    private javax.swing.JLabel welcomeName;
    private javax.swing.JLabel welcomeOrder;
    private javax.swing.JLabel welcomePack;
    private javax.swing.JLabel welcomeUser;           
}
