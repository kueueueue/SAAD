
package cis2103;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.time.LocalDateTime;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import exceptions.MenuNotFoundException;
import exceptions.NameExistsInArrayException;
import exceptions.UserNotFoundException;
import model.AdminClass;
import model.RegularClass;
import model.Database;
import model.Feedbacks;
import model.Item;
import model.Package;
import model.UserClass;


import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;


public class AdminClassFrame extends javax.swing.JFrame {
    

    private DefaultTableModel model;


    private int rowIndex;
    private static AdminClass temp;
    private static final DecimalFormat df = new DecimalFormat("'₱'0.00");
    
    public AdminClassFrame(UserClass user) {
    	
        temp = (AdminClass) user;
        
        initComponents();

		inputItemID.setText(Database.getLastItemID() + "");
		inputNewPackage.setText("" + Database.getLastPackageID());
        inputUserID.setText(String.valueOf("" + Database.getLastUserID()));
          
        inputItemID.setEditable(false);
        inputPackageID.setEditable(false);
        inputUserID.setEditable(false);
        inputNewPackage.setEditable(false);
        inputPackageSingleID.setEditable(false);
        
        tableViewUsers("");
        tableViewItems("");
        tableViewPackages();
        tableViewPackageSingle();
        tableViewFeedbacks();
        
        ButtonGroup userRoles = new ButtonGroup();
        userRoles.add(radioUserAdmin);
        userRoles.add(radioUserRegular);
        radioUserRegular.setSelected(true);
        jSpinner1.setValue(1);
        
        initWelcome();
        
    }

    private void initComponents() {
    	

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonLogOut = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        welcomeName = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        welcomeItem = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        welcomePack = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        welcomeUser = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        welcomeMess = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        welcomeOrder = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        welcomeTable = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        inputSingleSearch = new javax.swing.JTextField();
        buttonItemSearch = new javax.swing.JButton();
        buttonItemTableRefresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableItems = new javax.swing.JTable();
        inputItemID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputSingleName = new javax.swing.JTextField();
        inputSinglePrice = new javax.swing.JTextField();
        buttonAddNewItem = new javax.swing.JButton();
        buttonItemUpdate = new javax.swing.JButton();
        buttonItemRemove = new javax.swing.JButton();
        buttonClearInputItem = new javax.swing.JButton();
        buttonItemPrint = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePackageSingle = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablePackageItem = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        inputPackageSingleID = new javax.swing.JTextField();
        buttonPackageItemAdd = new javax.swing.JButton();
        buttonPackageItemRemove = new javax.swing.JButton();
        inputPackageSingleID2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        inputNewPackage = new javax.swing.JTextField();
        inputNewPackageName = new javax.swing.JTextField();
        buttonPackageAdd = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablePackages = new javax.swing.JTable();
        buttonPackageUpdate = new javax.swing.JButton();
        buttonPackageRemove = new javax.swing.JButton();
        inputPackageName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        inputPackageID = new javax.swing.JTextField();
        inputPackagePrice = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        inputUserSearch = new javax.swing.JTextField();
        buttonUserSearch = new javax.swing.JButton();
        buttonUserRefresh = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableUsers = new javax.swing.JTable();
        buttonUserPrint = new javax.swing.JButton();
        buttonUserRemove = new javax.swing.JButton();
        buttonUserUpdate = new javax.swing.JButton();
        buttonUserAdd = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        inputUserID = new javax.swing.JTextField();
        inputUserName = new javax.swing.JTextField();
        inputUserPass = new javax.swing.JTextField();
        inputUserContact = new javax.swing.JTextField();
        radioUserAdmin = new javax.swing.JRadioButton();
        radioUserRegular = new javax.swing.JRadioButton();
        buttonUserClear = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        labelFeedID = new javax.swing.JLabel();
        labelFeedSender = new javax.swing.JLabel();
        labelFeedDate = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        textFeedArea = new javax.swing.JTextArea();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableFeedback = new javax.swing.JTable();

        radioUserAdmin.setOpaque(false);
        radioUserRegular.setOpaque(false);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1720, 880));
        setMinimumSize(new java.awt.Dimension(1720, 880));
        setPreferredSize(new java.awt.Dimension(1720, 880));
        setResizable(false);

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
        jLabel1.setText("SYSTEM | ADMIN");

        
        
        buttonLogOut.setText("LOG OUT");
        buttonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogOutActionPerformed(evt);
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
                .addComponent(buttonLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTabbedPane2.setMaximumSize(new java.awt.Dimension(1720, 788));
        jTabbedPane2.setMinimumSize(new java.awt.Dimension(1720, 788));
        jTabbedPane2.setPreferredSize(new java.awt.Dimension(1720, 788));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setMaximumSize(new java.awt.Dimension(1720, 754));
        jPanel8.setMinimumSize(new java.awt.Dimension(1720, 754));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        welcomeName.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        welcomeName.setText("Welcome , ADMIN <admin>");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("ITEMS"));

        welcomeItem.setText("jLabel26");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(welcomeItem, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeItem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("PACKAGES"));

        welcomePack.setText("jLabel26");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(welcomePack, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomePack, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("USERS"));

        welcomeUser.setText("jLabel26");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(welcomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("FEEDBACKS"));

        welcomeMess.setText("jLabel26");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(welcomeMess, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeMess, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("ORDERS"));

        welcomeOrder.setText("jLabel26");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(welcomeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(welcomeName)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(welcomeName)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        welcomeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        welcomeTable.setRowHeight(40);
        welcomeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                welcomeTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(welcomeTable);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("WELCOME", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(1, 18, 68));
        jPanel14.setMaximumSize(new java.awt.Dimension(1100, 754));
        jPanel14.setMinimumSize(new java.awt.Dimension(1100, 754));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setMaximumSize(new java.awt.Dimension(1100, 80));
        jPanel15.setMinimumSize(new java.awt.Dimension(1100, 80));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Search for an Item : ");

        buttonItemSearch.setText("SEARCH");
        buttonItemSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonItemSearchActionPerformed(evt);
            }
        });

        buttonItemTableRefresh.setText("REFRESH");
        buttonItemTableRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonItemTableRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(inputSingleSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonItemSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonItemTableRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonItemTableRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                        .addComponent(inputSingleSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonItemSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );

        tableItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM ID", "NAME", "PRICE", "DATE ADDED", "DATE UPDATED"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tableItems.setRowHeight(40);
        tableItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableItemsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableItems);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Item ID :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Item Name :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Item Price :");

        inputSinglePrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputSinglePriceKeyTyped(evt);
            }
        });

        buttonAddNewItem.setText("ADD NEW");
        buttonAddNewItem.setBackground(new Color(91, 140, 90));
        buttonAddNewItem.setForeground(Color.white);
        buttonAddNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddNewItemActionPerformed(evt);
            }
        });
        
        
        buttonItemUpdate.setText("UPDATE");
        buttonItemUpdate.setBackground(new Color(233, 235, 135));
        buttonItemUpdate.setForeground(Color.black);
        buttonItemUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					buttonItemUpdateActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        buttonItemRemove.setText("REMOVE");
        buttonItemRemove.setBackground(new Color(123, 8, 40));
        buttonItemRemove.setForeground(Color.white);
        buttonItemRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonItemRemoveActionPerformed(evt);
            }
        });

        buttonClearInputItem.setText("CLEAR");
        buttonClearInputItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearInputItemActionPerformed(evt);
            }
        });

        buttonItemPrint.setText("PRINT");
        buttonItemPrint.setBackground(new Color(47, 88, 112));
        buttonItemPrint.setForeground(Color.white);
        buttonItemPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonItemPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5))
                    .addComponent(buttonAddNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(inputItemID)
                        .addComponent(inputSingleName)
                        .addComponent(inputSinglePrice, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonClearInputItem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonItemUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonItemRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonItemPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)))
                .addGap(92, 92, 92)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inputSingleName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(inputSinglePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(121, 121, 121)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAddNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonItemUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonItemRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonClearInputItem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonItemPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("ITEMS", jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jPanel16.setBackground(new java.awt.Color(1, 18, 68));
        
        javax.swing.SpinnerModel model = new SpinnerNumberModel(1, 1, 1000, 1);
        jSpinner1 = new javax.swing.JSpinner(model);
        
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent e) {
            	addChangeListenerActionPerformed(e);
            }
        });
        
        tablePackageSingle.setModel(new javax.swing.table.DefaultTableModel(
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
                return canEdit[columnIndex];
            }
        });
        tablePackageSingle.setRowHeight(40);
        tablePackageSingle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePackageSingleMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablePackageSingle);

        tablePackageItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "ID", "NAME", "QUANTITY", "PRICE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tablePackageItem.setRowHeight(40);
        tablePackageItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePackageItemMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablePackageItem);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ITEM ID :");

        buttonPackageItemAdd.setText("ADD TO PACKAGE");
        buttonPackageItemAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPackageItemAddActionPerformed(evt);
            }
        });

        buttonPackageItemRemove.setText("REMOVE FROM PACKAGE");
        buttonPackageItemRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPackageItemRemoveActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ITEM ID :");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("ITEM LIST");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("ITEMS IN SELECTED PACKAGE");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(inputPackageSingleID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonPackageItemAdd)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel15)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(inputPackageSingleID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonPackageItemRemove)))
                .addGap(27, 27, 27))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonPackageItemAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputPackageSingleID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(inputPackageSingleID2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonPackageItemRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("CREATE NEW PACKAGE WITH ID :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("ENTER PACKAGE NAME :");

        buttonPackageAdd.setText("CREATE");
        buttonPackageAdd.setBackground(new Color(91, 140, 90));
        buttonPackageAdd.setForeground(Color.white);
        buttonPackageAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	buttonPackageAddActionPerformed(evt);
            }
        });

        tablePackages.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "PRICE", "# OF ITEMS", "DATE CREATED"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tablePackages.setRowHeight(40);
        tablePackages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePackagesMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tablePackages);

        buttonPackageUpdate.setText("UPDATE");
        buttonPackageUpdate.setBackground(new Color(233, 235, 135));
        buttonPackageUpdate.setForeground(Color.black);
        buttonPackageUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPackageUpdateActionPerformed(evt);
            }
        });

        buttonPackageRemove.setText("REMOVE");
        buttonPackageRemove.setBackground(new Color(123, 8, 40));
        buttonPackageRemove.setForeground(Color.white);
        buttonPackageRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPackageRemoveActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Package Price :");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Package ID :");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Package Name :");

        inputPackagePrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputPackagePriceKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(buttonPackageRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonPackageUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(62, 62, 62))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputNewPackage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(inputNewPackageName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(buttonPackageAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(inputPackagePrice, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel12))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(inputPackageName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                            .addComponent(inputPackageID))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)))
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(inputNewPackage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(inputNewPackageName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPackageAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(inputPackageID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPackageName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(buttonPackageUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPackagePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(buttonPackageRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("PACKAGES", jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jPanel17.setBackground(new java.awt.Color(1, 18, 68));
        jPanel17.setMaximumSize(new java.awt.Dimension(1100, 748));
        jPanel17.setMinimumSize(new java.awt.Dimension(1100, 748));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setMaximumSize(new java.awt.Dimension(1100, 80));
        jPanel18.setMinimumSize(new java.awt.Dimension(1100, 80));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Search for a User :");

        buttonUserSearch.setText("SEARCH");
        buttonUserSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserSearchActionPerformed(evt);
            }
        });

        buttonUserRefresh.setText("REFRESH");
        buttonUserRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(inputUserSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonUserSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonUserRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputUserSearch)
                    .addComponent(buttonUserSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(buttonUserRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "USERNAME", "CONTACT #", "ROLE", "DATE CREATED", "DATE UPDATED", "UPDATE BY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tableUsers.setRowHeight(40);
        tableUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUsersMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tableUsers);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1055, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        buttonUserPrint.setText("PRINT");        
        buttonUserPrint.setBackground(new Color(47, 88, 112));
        buttonUserPrint.setForeground(Color.white);
        buttonUserPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserPrintActionPerformed(evt);
            }
        });

        buttonUserRemove.setText("REMOVE");
        buttonUserRemove.setBackground(new Color(123, 8, 40));
        buttonUserRemove.setForeground(Color.white);
        buttonUserRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserRemoveActionPerformed(evt);
            }
        });

        buttonUserUpdate.setText("UPDATE");
        buttonUserUpdate.setBackground(new Color(233, 235, 135));
        buttonUserUpdate.setForeground(Color.black);
        buttonUserUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserUpdateActionPerformed(evt);
            }
        });

        buttonUserAdd.setText("ADD NEW");
        buttonUserAdd.setBackground(new Color(91, 140, 90));
        buttonUserAdd.setForeground(Color.white);
        buttonUserAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserAddActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("User ID :");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("Username :");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setText("Password :");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setText("Contact # :");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setText("User Role :");
        inputUserContact.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField textField = (JTextField) input;
                String text = textField.getText();

                if (!text.matches("[0-9]+")) {
                	if(text.equals("")) {
                		return true;
                	}
                    JOptionPane.showMessageDialog(textField, "Invalid input!");
                    return false;
                }

                return true;
            }
        });
        inputUserContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputUserContactKeyTyped(evt);
            }
        });

        radioUserAdmin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        radioUserAdmin.setText("ADMIN");

        radioUserRegular.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        radioUserRegular.setText("REGULAR");

        buttonUserClear.setText("CLEAR");
        buttonUserClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20)))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))
                                .addGap(1, 1, 1)))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(radioUserAdmin)
                                .addGap(18, 18, 18)
                                .addComponent(radioUserRegular))
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(inputUserID)
                                .addComponent(inputUserName)
                                .addComponent(inputUserPass)
                                .addComponent(inputUserContact, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(buttonUserAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(buttonUserClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonUserPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(buttonUserUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonUserRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(92, 92, 92)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(inputUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(inputUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(inputUserPass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(inputUserContact, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(radioUserAdmin)
                    .addComponent(radioUserRegular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonUserRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonUserUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonUserAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonUserPrint, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(buttonUserClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(219, 219, 219))
        );

        jTabbedPane2.addTab("USERS", jPanel11);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        labelFeedID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelFeedID.setText("Feedback ID :");

        labelFeedSender.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelFeedSender.setText("Sender :");

        labelFeedDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelFeedDate.setText("Date :");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setText("Message :");

        textFeedArea.setColumns(20);
        textFeedArea.setRows(5);
        jScrollPane7.setViewportView(textFeedArea);

        jPanel19.setBackground(new java.awt.Color(1, 18, 68));

        tableFeedback.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null}
            },
            new String [] {
                "ID", "MESSAGE", "DATE", "SENT BY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tableFeedback.setRowHeight(40);
        tableFeedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableFeedbackMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tableFeedback);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFeedDate)
                    .addComponent(labelFeedID)
                    .addComponent(labelFeedSender))
                .addGap(60, 60, 60)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(421, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(labelFeedID)
                        .addGap(18, 18, 18)
                        .addComponent(labelFeedSender)
                        .addGap(18, 18, 18)
                        .addComponent(labelFeedDate)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(222, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("SEE FEEDBACKS", jPanel12);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    

    protected void addChangeListenerActionPerformed(ChangeEvent e) {
		// TODO Auto-generated method stub
    	
		
		try {
			Package p = Database.getPackageByID(inputPackageID.getText());
			Item i = Database.getItemByID(inputPackageSingleID.getText());
			inputPackagePrice.setText("" + df.format(p.getPrice() + i.getPrice()*(int)jSpinner1.getValue()));
		} catch (MenuNotFoundException e1) {
		}
	}

	// LOG OUT //AnotherClass //AnotherClass
    private void buttonLogOutActionPerformed(java.awt.event.ActionEvent evt) {
        
        int out = JOptionPane.showConfirmDialog(this, "Do you want to log out?", "SELECT", JOptionPane.YES_NO_OPTION);
        if(out == 0) {
            this.dispose();
            Login log = new Login();
        	log.setVisible(true);
        	log.setLocationRelativeTo(null);
        }
    } 
    
    ////////////MANAGE SINGLE ITEMS////////////////////
    
    //```buttons ---- ADD NEW// //AnotherClass
    private void buttonAddNewItemActionPerformed(java.awt.event.ActionEvent evt) {
        if(isEmptyItems()) {
        	try {
				@SuppressWarnings("unused")
				Item item = Database.getItemByID(inputSingleName.getText());
				JOptionPane.showMessageDialog(this, "Item already exists","Warning", JOptionPane.WARNING_MESSAGE);
			} catch (MenuNotFoundException e) {
				try {
					int choice = JOptionPane.showConfirmDialog(null, "Add item?", "Add Confirmation", JOptionPane.YES_NO_OPTION);
			        
			        if(choice != JOptionPane.YES_OPTION) {
			        	return;
			        }
			        String price = inputSinglePrice.getText();
		        	System.out.println('P');
			        if(price.contains("₱")) {
			        	price = price.substring(1);
			        }
					Database.addItem(new Item("I" + inputItemID.getText(), inputSingleName.getText(), Float.parseFloat(price)));
				} catch (NumberFormatException | SQLException | NameExistsInArrayException e1) {
					JOptionPane.showMessageDialog(this, e1.getMessage());
				}
			}finally {
				clearSingle();
				tableViewItems("");
		        tableViewPackageSingle();
			}
        }
    }
    
    //```buttons ---- UPDATE ITEM// //AnotherClass
    private void buttonItemUpdateActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
    	if(inputSinglePrice.getText().isEmpty() || inputSingleName.getText().isEmpty()) {
    		JOptionPane.showMessageDialog(
    			    this,
    			    "Required fields are missing",
    			    "Warning",
    			    JOptionPane.WARNING_MESSAGE
    			);

    		return;
    	}
  
    	
		try {

        	int choice = JOptionPane.showConfirmDialog(null, "Update item?", "Update Confirmation", JOptionPane.YES_NO_OPTION);
	        if(choice == JOptionPane.NO_OPTION) {
	        	return;
	        }
	        String price = inputSinglePrice.getText();
        	System.out.println('P');
	        if(price.contains("₱")) {
	        	price = price.substring(1);
	        }
			Database.updateItem(inputItemID.getText(), inputSingleName.getText(), Float.parseFloat(price));
	        
		} catch (Exception e) {
			JOptionPane.showInputDialog(this, e.getMessage());
		} finally {
			clearSingle();
			tableViewItems("");
	        tableViewPackageSingle();
		}
    }
    
    //```buttons ---- REMOVE ITEM// //AnotherClass
    private void buttonItemRemoveActionPerformed(java.awt.event.ActionEvent evt) {
        try {
        	int choice = JOptionPane.showOptionDialog(
        		    null,
        		    "Remove item?",
        		    "Remove Confirmation",
        		    JOptionPane.YES_NO_OPTION,
        		    JOptionPane.WARNING_MESSAGE,
        		    null,
        		    null,
        		    null
        		);
	        if(choice != JOptionPane.YES_OPTION) {
	        	return;
	        }
        	Item item = Database.getItemByID(inputItemID.getText());
			Database.removeMenu(item);
			tableViewItems("");
		} catch (SQLException | MenuNotFoundException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}finally {
			clearSingle();
			tableViewItems("");
	        tableViewPackageSingle();
		}
    }
    
    //```buttons ---- PRINT ITEM// //AnotherClass
    private void buttonItemPrintActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            MessageFormat header = new MessageFormat("ALL ITEMS");
            MessageFormat footer = new MessageFormat("Page {0, number, integer}");
            tableItems.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(AdminClassFrame.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
        	tableViewItems("");
        }
    }

    //```buttons ---- SEARCH ITEM// //AnotherClass
    private void buttonItemSearchActionPerformed(java.awt.event.ActionEvent evt) {   
        if(inputSingleSearch.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Input is empty");
        } else {
            tableItems.setModel(new DefaultTableModel(null, new Object[] {
            "ID", "NAME", "PRICE", "DATE ADDED", "LAST UPDATED ON"
        }));
        tableViewItems(inputSingleSearch.getText());
        }
    }

    //```buttons ---- CLEAR//     //AnotherClass
    private void buttonClearInputItemActionPerformed(java.awt.event.ActionEvent evt) {   
        tableItems.clearSelection();
    	clearSingle();
    }

    //```buttons ---- REFRESH ITEM// //AnotherClass
    private void buttonItemTableRefreshActionPerformed(java.awt.event.ActionEvent evt) {
    	clearSingle();
		tableViewItems("");
    }
    
    // clear input boxes //AnotherClass
    private void clearSingle() {
		inputItemID.setText("" + Database.getLastItemID());
	    inputSingleName.setText(null);
	    inputSinglePrice.setText(null);
		buttonAddNewItem.setEnabled(true);
    }

    // display data of clicked row in MANAGE SINGLE ITEMS //AnotherClass
    private void tableItemsMouseClicked(java.awt.event.MouseEvent evt) {      
        model = (DefaultTableModel) tableItems.getModel();
        rowIndex = tableItems.getSelectedRow();  
        String id = model.getValueAt(rowIndex, 0).toString();
        try {
			Item item = Database.getItemByID(model.getValueAt(rowIndex, 0).toString());
			inputItemID.setText(item.getId());
	        inputSingleName.setText(item.getName());
	        inputSinglePrice.setText(df.format(item.getPrice()));
	        buttonAddNewItem.setEnabled(false);
		} catch (MenuNotFoundException e) {
			e.printStackTrace();
		}
        
    }
    
    // put data of items in a table //AnotherClass
    private void tableViewItems(String searchVal) {
    	DefaultTableModel model = (DefaultTableModel) tableItems.getModel();
    	model.setRowCount(0);
    	Object[] row;
    	for(Item i: Database.getItems()) {
    		if(i.concatDets().toLowerCase().contains(searchVal.toLowerCase())) {
                row = new Object[5];
                row[0] = i.getId();
                row[1] = i.getName();
                row[2] = df.format(i.getPrice());
                row[3] = i.getDateAdded();
                row[4] = i.getDateUpdated();
                model.addRow(row);
    		}
    	}
		buttonAddNewItem.setEnabled(true);
    }
    

    //Check if all fields are filled //AnotherClass
    public boolean isEmptyItems() {
        
        if(inputItemID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Item ID is missing");
            return false;
        }   
        if(inputSingleName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Item Name is missing");
            return false;
        }
        if(inputSinglePrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Item Price is missing");
            return false;
        }
        return true;
    }

    
    // Only numeric inputs for price
    private void inputSinglePriceKeyTyped(java.awt.event.KeyEvent evt) {
        if(!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }

    
	////////////MANAGE PACKAGES////////////////////
    
    // -- CRUD -- //
    
    // display data to table //AnotherClass
	private void tableViewPackages() {
		model = (DefaultTableModel) tablePackages.getModel();
    	model.setRowCount(0);
    	Object[] row;
    	for(Package pack: Database.getPack()) {
    		row = new Object[5];
    		row[0] = pack.getId();
            row[1] = pack.getName();
            row[2] = df.format(pack.getPrice());
            row[3] = pack.getNumberOfItems();
            row[4] = pack.getDateAdded();
            model.addRow(row);
  		}
    }
  
	
	// display data to table //AnotherClass
    private void tableViewPackageSingle() {
    	DefaultTableModel model = (DefaultTableModel) tablePackageSingle.getModel();
    	model.setRowCount(0);
    	Object[] row;
    	for(Item i: Database.getItems()) {
               row = new Object[3];
               row[0] = i.getId();
               row[1] = i.getName();
               row[2] = df.format(i.getPrice());
               model.addRow(row);
    	}
    }
    
    // display data to table //AnotherClass
    private void tableViewPackageItem(String id) {
    	DefaultTableModel model = (DefaultTableModel) tablePackageItem.getModel();
    	model.setRowCount(0);
    	Object[] row;
		try {
	    	Package temp = Database.getPackageByID(id);
			Database.loadPackageItemFromDatabase(id);
	    	for(Item i : temp.getPackageitems()) {
	    		row = new Object[4];
	    		row[0] = i.getId();
	    		row[1] = i.getName();
	    		row[2] = i.getQuantity();
	    		row[3] = row[2] + " * " + df.format(i.getPrice());
	    		System.out.println(i.getPrice());
	    		model.addRow(row);
	    	}
		} catch (MenuNotFoundException e) {
			JOptionPane.showMessageDialog(this, "Package not found");
		}
    }
    
    
    // Fetch data of selected package //AnotherClass
    private void tablePackagesMouseClicked(java.awt.event.MouseEvent evt) {
        model = (DefaultTableModel) tablePackages.getModel();
        rowIndex = tablePackages.getSelectedRow();

        try {
			Package pack = Database.getPackageByID(model.getValueAt(rowIndex, 0).toString());
			inputPackageID.setText(pack.getId());
	        inputPackagePrice.setText(df.format(pack.getPrice()));
	        
	        tablePackageItem.setModel(new DefaultTableModel(null, new Object[] {
	        		"ID", "NAME", "QUANTITY", "PRICE"
	        }));
	        
	    	inputPackageName.setText(pack.getName());
	    	inputPackagePrice.setText(df.format(pack.getPrice()));
	    	tableViewPackageItem(inputPackageID.getText());
        
        } catch (MenuNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        

    }
    

    
    //```buttons ---- ADD PACKAGE// //AnotherClass
    private void buttonPackageAddActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	String id = "P" + inputNewPackage.getText();
    	 if(inputNewPackageName.getText().isEmpty()) {
             JOptionPane.showMessageDialog(this, "Package Name is missing");
             return;
         }
    	 
    	try{
    		Package pack = Database.getPackageByID(id);
			JOptionPane.showMessageDialog(this, "Package already exists");
    	} catch (MenuNotFoundException e) {
    		int choice = JOptionPane.showConfirmDialog(null, "Add package?", "Add Confirmation", JOptionPane.YES_NO_OPTION);
	        
	        if(choice != JOptionPane.YES_OPTION) {
	        	return;
	        }
	        try {
				Database.addPackage(new Package(id, inputNewPackageName.getText(), 0));
	        } catch (SQLException | NameExistsInArrayException e1) {
	        	JOptionPane.showMessageDialog(this, "Package already exists");
	        }
    	} finally {
        	clearPackages();
			tableViewPackages();
    	}
    }

	

    //```buttons ---- UPDATE PACKAGE// //AnotherClass
    private void buttonPackageUpdateActionPerformed(java.awt.event.ActionEvent evt) {

	   	 
	   	 if(isEmptyPackage()) {
        	int choice = JOptionPane.showConfirmDialog(null, "Update Package?", "Update Confirmation", JOptionPane.YES_NO_OPTION);
    		if(choice != JOptionPane.YES_OPTION) {
    			return;
    		}
    		updatePackage();
    	} 

    }
    //AnotherClass
    private void updatePackage() {
    	try {
			Package temp = Database.getPackageByID(inputPackageID.getText());
			Database.updatePackage(inputPackageID.getText(), inputPackageName.getText(), Float.parseFloat(inputPackagePrice.getText().substring(1)), tablePackageItem.getRowCount());
		} catch (NumberFormatException | SQLException | MenuNotFoundException | NameExistsInArrayException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
    	tableViewPackages();
    }
    
    //```buttons ---- REMOVE PACKAGE// //AnotherClass
    private void buttonPackageRemoveActionPerformed(java.awt.event.ActionEvent evt) {
    	int choice = JOptionPane.showOptionDialog(
    		    null,
    		    "Remove Package?",
    		    "Remove Confirmation",
    		    JOptionPane.YES_NO_OPTION,
    		    JOptionPane.WARNING_MESSAGE,
    		    null,
    		    null,
    		    null
    		);
    	
		if(choice != JOptionPane.YES_OPTION) {
			return;
		}
		try {
        	Package pack = Database.getPackageByID(inputPackageID.getText());
			Database.removeMenu(pack);
			inputNewPackage.setText("" + Database.getLastPackageID());
		} catch (SQLException | MenuNotFoundException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}finally {
			clearPackages();
			tableViewPackages();
		}
    }

    
    // check if package input boxes are empty //AnotherClass
    public boolean isEmptyPackage() {
        if(inputPackageName.getText().isEmpty() || inputPackagePrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Required fields are missing");
            return false;
        }   
        return true;
    } 
    
    // Fetch data of selected item //AnotherClass
    private void tablePackageSingleMouseClicked(java.awt.event.MouseEvent evt) {
        model = (DefaultTableModel) tablePackageSingle.getModel();
        rowIndex = tablePackageSingle.getSelectedRow();
        
        String itemID = model.getValueAt(rowIndex, 0).toString();
        inputPackageSingleID.setText(itemID);
        Item i;
        
        if(inputPackageID.getText().isEmpty()) {
        	JOptionPane.showMessageDialog(this, "Please choose a package.");
        	return;
        }
		try {
	        Package p = Database.getPackageByID(inputPackageID.getText());
			i = Database.getItemByID(inputPackageSingleID.getText());
			inputPackagePrice.setText("" + df.format((p.getPrice() + i.getPrice()*(int)jSpinner1.getValue())));
		} catch (MenuNotFoundException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
        
    }
    

    //```buttons ---- ADD ITEM TO PACKAGE// //AnotherClass
    private void buttonPackageItemAddActionPerformed(java.awt.event.ActionEvent evt) {

		int choice = JOptionPane.showConfirmDialog(null, "Add item to package?", "Add Confirmation", JOptionPane.YES_NO_OPTION);
        if(choice != JOptionPane.YES_OPTION) {
        	return;
        }

    	try {
    		Package p = Database.getPackageByID(inputPackageID.getText());
    		String itemID = inputPackageSingleID.getText();
    		double oldPrice = p.getPrice();
//			for(Item ip: p.getPackageitems()) {
//				if(ip.getId().equals(itemID)) {
//					SpinnerNumberModel sModel = new SpinnerNumberModel(ip.getQuantity(), 1, 200, 1);
//					JSpinner updateQty = new JSpinner(sModel);
//					javax.swing.JPanel existingQty = new javax.swing.JPanel();
//					existingQty.setLayout(new javax.swing.BoxLayout(existingQty, javax.swing.BoxLayout.Y_AXIS));
//					existingQty.add(new javax.swing.JLabel("Item already exists in the package."));
//					existingQty.add(new javax.swing.JLabel("Enter new quantity: "));
//					existingQty.add(updateQty);
//					int confirm = JOptionPane.showConfirmDialog(null, existingQty, "Existing package item", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//					double priceDifference = (ip.getPrice()*ip.getQuantity()) - ((int)updateQty.getValue()*ip.getPrice());
//					inputPackagePrice.setText("" + (oldPrice - priceDifference));
//					if(confirm != JOptionPane.OK_OPTION) {
//						return;
//					}
//					Database.updatePackageItem(p.getId(), itemID, (int)updateQty.getValue());
//					updatePackage();
//					return;
//				}
//			}
    		
//			
//			if((int)jSpinner1.getValue() == 0) {
//				JOptionPane.showMessageDialog(this, "Please specify a quantity.");
//				return;
//			}
    		
    		for(Item ip: p.getPackageitems()) {
    			if(ip.getId().equals(itemID)) {
    				JOptionPane.showMessageDialog(this, "This item already exists in the package.");
    				return;
    			}
    		}
    		
			updatePackage();
			Database.addPackageItem(p, Database.getItemByID(itemID), (int)jSpinner1.getValue());
			
		} catch (MenuNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			tableViewPackageItem(inputPackageID.getText());
			tableViewPackages();
		}

    }
   
    // Fetch data of item inside package //AnotherClass
    private void tablePackageItemMouseClicked(java.awt.event.MouseEvent evt) {
        model = (DefaultTableModel) tablePackageItem.getModel();
        rowIndex = tablePackageItem.getSelectedRow();
        inputPackageSingleID2.setText(model.getValueAt(rowIndex, 0).toString());
    }

    //```buttons ---- REMOVE ITEM FROM PACKAGE// //AnotherClass
    private void buttonPackageItemRemoveActionPerformed(java.awt.event.ActionEvent evt) {
    	int choice = JOptionPane.showOptionDialog(
    		    null,
    		    "Remove item from pacakage?",
    		    "Remove Confirmation",
    		    JOptionPane.YES_NO_OPTION,
    		    JOptionPane.WARNING_MESSAGE,
    		    null,
    		    null,
    		    null
    		);


		if(choice != JOptionPane.YES_OPTION) {
			return;
		}
		
		
    	try {
    		Package p = Database.getPackageByID(inputPackageID.getText());
    		String itemID = inputPackageSingleID2.getText();
    		double oldPrice = p.getPrice();
//    		if(choice == JOptionPane.NO_OPTION) {    			
//        		for(Item ip: p.getPackageitems()) {
//    				if(ip.getId().equals(itemID)) {
//    					SpinnerNumberModel sModel = new SpinnerNumberModel(ip.getQuantity(), 1, ip.getQuantity(), 1);
//    					JSpinner updateQty = new JSpinner(sModel);
//    					javax.swing.JPanel existingQty = new javax.swing.JPanel();
//    					existingQty.setLayout(new javax.swing.BoxLayout(existingQty, javax.swing.BoxLayout.Y_AXIS));
//    					existingQty.add(new javax.swing.JLabel("Removing items"));
//    					existingQty.add(new javax.swing.JLabel("Enter new quantity: "));
//    					existingQty.add(updateQty);
//    					int confirm = JOptionPane.showConfirmDialog(null, existingQty, "Existing package item", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//    					
//    					if(confirm != JOptionPane.OK_OPTION) {
//    						return;
//    					}
//    					
//    					double priceDifference = (ip.getQuantity() - (int)updateQty.getValue())*ip.getPrice();
//    					inputPackagePrice.setText("" + (oldPrice - priceDifference));
//    					
//    					Database.updatePackageItem(p.getId(), itemID, (int)updateQty.getValue());
//
//    					tableViewPackageItem(p.getId());
//    					updatePackage();
//    					
//    					return;
//    				}
//    			}
//    		}
			
    		
			Item i = Database.getItemByID(itemID);
		
				inputPackagePrice.setText("" + df.format(p.getPrice() - i.getPrice()));
				if(inputPackagePrice.getText().substring(0, 1).equals("-")) {
					inputPackagePrice.setText("0");
				}
				Database.removePackageItem(p, i);
				tableViewPackageItem(inputPackageID.getText());
				updatePackage();
			
		} catch (MenuNotFoundException | SQLException e ) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
    	
    	
    	
    	tableViewPackageItem(inputPackageID.getText());
    	tableViewPackages();
    }


    // PACKAGE OTHER FUNCTIONS //
        
    // clear input boxes and table selections  //AnotherClass
    private void clearPackages() {
    	inputNewPackage.setText("" + Database.getLastPackageID());
    	inputNewPackageName.setText("");
    	inputPackageID.setText("");
    	inputPackageName.setText("");
    	inputPackagePrice.setText("");
    	inputPackageSingleID.setText("");
    	inputPackageSingleID2.setText("");
    	tablePackages.clearSelection();
    	tablePackageSingle.clearSelection();
    	tablePackageItem.clearSelection();
    	model = (DefaultTableModel) tablePackageItem.getModel();
    	model.setRowCount(0);
    }
    
    // clearing input boxes
    // for Manage Single Items

    
    
	////////////MANAGE USERS////////////////////
    
    // clear input boxes and table selections //AnotherClass
    private void clearUser() {
        inputUserID.setText("" + Database.getLastUserID());
        inputUserName.setText(null);
        inputUserPass.setText(null);
        inputUserContact.setText(null);
        radioUserRegular.setSelected(true); 
        tableUsers.getSelectionModel().clearSelection();
        buttonUserAdd.setEnabled(true);
    }
    
    
    
    // Only numeric inputs for package price
    private void inputPackagePriceKeyTyped(java.awt.event.KeyEvent evt) {

        if(!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }
    

	////////////MANAGE USERS////////////////////
    // -- CRUD -- //
        
    // display data to table //AnotherClass
    private void tableViewUsers(String searchVal) {
        model = (DefaultTableModel) tableUsers.getModel();
        model.setRowCount(0);
        Object[] row = new Object[8];
        for(UserClass u : Database.getUsers()) {
        	if(u.concatDets().toLowerCase().contains(searchVal.toLowerCase())) {
        		row[0] = u.getId();
            	row[1] = u.getUserName();
            	row[2] = u.getContact();
            	row[3] = u.getRole();
            	row[4] = u.getUserCreated();
            	row[5] = u.getUserUpdated();
            	row[6] = u.getEditedByID();
            	model.addRow(row);
        	}
        }
        buttonAddNewItem.setEnabled(true);
    }
    
    // fetch data of selected table row //AnotherClass
    private void tableUsersMouseClicked(java.awt.event.MouseEvent evt) {
        model = (DefaultTableModel) tableUsers.getModel();
        rowIndex = tableUsers.getSelectedRow();
        try {
			UserClass user = Database.getUserByID(model.getValueAt(rowIndex, 0).toString());
			inputUserID.setText(user.getId());
	        inputUserName.setText(user.getUserName());
	        inputUserPass.setText(user.getPassword());
	        inputUserContact.setText(user.getContact());
	        if(user.getRole().equals("ADMIN")) {
	            radioUserAdmin.setSelected(true);
	            radioUserRegular.setSelected(false);
	        } else {
	            radioUserAdmin.setSelected(false);
	            radioUserRegular.setSelected(true);
	        }
	        buttonUserAdd.setEnabled(false);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

    //```buttons ---- ADD USER// //AnotherClass
    private void buttonUserAddActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	if(isEmptyUser()) {
    		try {
    			@SuppressWarnings("unused")
				UserClass u = Database.getUserByID(inputUserName.getText());
				JOptionPane.showMessageDialog(this, "Username already exists");
			} catch (UserNotFoundException e) {
				try {
					int choice = JOptionPane.showConfirmDialog(null, "Add User?", "Add Confirmation", JOptionPane.YES_NO_OPTION);
					if(choice != JOptionPane.YES_OPTION) {
						return;
					}
					if(inputUserName.getText().equals("username") || inputUserPass.getText().equals("password")) {
						JOptionPane.showMessageDialog(this, "Illegal username and password.");
					}
					
					if(radioUserRegular.isSelected()) {
						Database.addUser(new RegularClass("R" + inputUserID.getText(), inputUserName.getText(), inputUserPass.getText(), inputUserContact.getText(), RegularClass.REGULAR_USER, LocalDateTime.now(), LocalDateTime.now(), temp.getId()));
					} else if(radioUserAdmin.isSelected()) {
						Database.addUser(new AdminClass("A" + inputUserID.getText(), inputUserName.getText(), inputUserPass.getText(), inputUserContact.getText(), AdminClass.ADMIN_USER, LocalDateTime.now(), LocalDateTime.now(), temp.getId()));
					}
				} catch (NumberFormatException | SQLException | NameExistsInArrayException ex) {
					JOptionPane.showMessageDialog(this, ex.getMessage());
					System.out.println(ex.getMessage() + " " + ex.getClass());
				}
			} finally {
				clearUser();
		    	tableViewUsers("");
			}
    	}
    }

    //```buttons ---- UPDATE USER// //AnotherClass
    private void buttonUserUpdateActionPerformed(java.awt.event.ActionEvent evt) {
    	
        if(isEmptyUser()) {
        	if(noDupe() != 0) {
            	JOptionPane.showMessageDialog(this, "Username exists");
        		return;
        	} 
        	int choice = JOptionPane.showConfirmDialog(null, "Update User?", "Update Confirmation", JOptionPane.YES_NO_OPTION);
    		if(choice != JOptionPane.YES_OPTION) {
    			return;
    		} 
        	try {
        		if(radioUserAdmin.isSelected()) {
        			Database.updateUser(inputUserID.getText(), inputUserName.getText(), inputUserPass.getText(), inputUserContact.getText(), AdminClass.ADMIN_USER, temp.getId());
        		} else {
        			Database.updateUser(inputUserID.getText(), inputUserName.getText(), inputUserPass.getText(), inputUserContact.getText(), RegularClass.REGULAR_USER, temp.getId());
        		}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
        }
        clearUser();
        tableViewUsers("");
        
    }

    //```buttons ---- REMOVE USER// //AnotherClass
    private void buttonUserRemoveActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	int choice = JOptionPane.showOptionDialog(
    		    null,
    		    "Remove User?",
    		    "Remove Confirmation",
    		    JOptionPane.YES_NO_OPTION,
    		    JOptionPane.WARNING_MESSAGE,
    		    null,
    		    null,
    		    null
    		);

    	
		if(choice != JOptionPane.YES_OPTION) {

			return;
		} 
		try {
			UserClass u = Database.getUserByID(inputUserID.getText());
			Database.removeUser(u);
		} catch (UserNotFoundException | SQLException e) {
			System.out.println(e.getMessage() + " " + e.getClass());
		} finally {
			clearUser();			
			tableViewUsers("");
		}
    }
    
    //```buttons ---- CLEAR USER// //AnotherClass
    private void buttonUserClearActionPerformed(java.awt.event.ActionEvent evt) {
    	clearUser();
    }

    //```buttons ---- PRINT USER// //AnotherClass
    private void buttonUserPrintActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            MessageFormat header = new MessageFormat("ALL USERS");
            MessageFormat footer = new MessageFormat("Page {0, number, integer}");
            tableUsers.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(AdminClassFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //```buttons ---- SEARCH USER// //AnotherClass
    private void buttonUserSearchActionPerformed(java.awt.event.ActionEvent evt) {
    	    	
        if(inputUserSearch.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Input is empty");
        } else {
            tableViewUsers(inputUserSearch.getText());
        }
        clearUser();
    }

    //```buttons ---- REFRESH USER// //AnotherClass
    private void buttonUserRefreshActionPerformed(java.awt.event.ActionEvent evt) {
        tableViewUsers("");
        inputUserSearch.setText(null);
        clearUser();
    }
    
    
    // USER OTHER FUNCTIONS //
    // check if input boxes are empty //AnotherClass
    public boolean isEmptyUser() {
        if(inputUserName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Required fields are missing");
            return false;
        }
        if(inputUserPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "User Password is missing");
            return false;
        }      
        if(inputUserContact.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "User Contact Number is missing");
            return false;
        }    
        return true;
    } 
    
    // Only numeric inputs for contact //AnotherClass
    private void inputUserContactKeyTyped(java.awt.event.KeyEvent evt) {
        if(!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }
    
    // check it exists //AnotherClass
    private int noDupe() { 	
        String id = null;
        
        for (UserClass user : Database.getUsers()) {
            if (inputUserName.getText().equals(user.getUserName())) {
                id = user.getId();
                break;
            }
        }    
        return (id != null && !id.equals(inputUserID.getText())) ? 1 : 0;
    }
    
    
    
	////////////MANAGE FEEDBACK////////////////////
    //AnotherClass
    private void tableViewFeedbacks() {
    	model = (DefaultTableModel) tableFeedback.getModel();
    	model.setRowCount(0);
    	Object[] row = new Object[4];
    	for(Feedbacks f : Database.getFeedback()) {     	
    		row[0] = f.getId();
    		row[1] = f.getMessage();
    		row[2] = f.getDateAdded();
    		row[3] = f.getUserID();
    		model.addRow(row);
    	}
    }
    
    //AnotherClass
    private void tableFeedbackMouseClicked(java.awt.event.MouseEvent evt) {
    	model = (DefaultTableModel) tableFeedback.getModel();
    	rowIndex = tableFeedback.getSelectedRow();
    	UserClass u;
		try {
			u = Database.getUserByID(model.getValueAt(rowIndex, 3).toString());
	    	
	    	labelFeedID.setText("FEEDBACK ID :              " + model.getValueAt(rowIndex, 0));
	    	labelFeedSender.setText("FEEDBACK SENDER :   " + model.getValueAt(rowIndex, 3).toString() + " | " + u.getUserName());
	    	labelFeedDate.setText("SENT ON :                   " + model.getValueAt(rowIndex, 2));
	    	textFeedArea.setText(model.getValueAt(rowIndex, 1).toString());
	    	
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    
	////////////WELCOME PAGE////////////////////
    //AnotherClass
    private void initWelcome() {
    	welcomeName.setText("Welcome, " + temp.getUserName() + "!");
    	welcomeItem.setText(String.valueOf(Database.getItems().size()));
    	welcomePack.setText(String.valueOf(Database.getPack().size()));
    	welcomeUser.setText(String.valueOf(Database.getUsers().size()));
    	welcomeMess.setText(String.valueOf(Database.getFeedback().size()));    	
    }
    
    private void welcomeTableMouseClicked(java.awt.event.MouseEvent evt) {
    	
    }
//    
//    private String currencyFormatter(float ) {
//    	
//    }
    
    private javax.swing.JButton buttonAddNewItem;
    private javax.swing.JButton buttonClearInputItem;
    private javax.swing.JButton buttonItemPrint;
    private javax.swing.JButton buttonItemRemove;
    private javax.swing.JButton buttonItemSearch;
    private javax.swing.JButton buttonItemTableRefresh;
    private javax.swing.JButton buttonItemUpdate;
    private javax.swing.JButton buttonLogOut;
    private javax.swing.JButton buttonPackageItemAdd;
    private javax.swing.JButton buttonPackageItemRemove;
    private javax.swing.JButton buttonPackageRemove;
    private javax.swing.JButton buttonPackageUpdate;
    private javax.swing.JButton buttonUserAdd;
    private javax.swing.JButton buttonUserClear;
    private javax.swing.JButton buttonUserPrint;
    private javax.swing.JButton buttonUserRefresh;
    private javax.swing.JButton buttonUserRemove;
    private javax.swing.JButton buttonUserSearch;
    private javax.swing.JButton buttonUserUpdate;
    private javax.swing.JTextField inputItemID;
    private javax.swing.JTextField inputNewPackage;
    private javax.swing.JTextField inputNewPackageName;
    private javax.swing.JTextField inputPackageID;
    private javax.swing.JTextField inputPackageName;
    private javax.swing.JTextField inputPackagePrice;
    private javax.swing.JTextField inputPackageSingleID;
    private javax.swing.JTextField inputPackageSingleID2;
    private javax.swing.JTextField inputSingleName;
    private javax.swing.JTextField inputSinglePrice;
    private javax.swing.JTextField inputSingleSearch;
    private javax.swing.JTextField inputUserContact;
    private javax.swing.JTextField inputUserID;
    private javax.swing.JTextField inputUserName;
    private javax.swing.JTextField inputUserPass;
    private javax.swing.JTextField inputUserSearch;
    private javax.swing.JButton buttonPackageAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
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
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
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
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel labelFeedDate;
    private javax.swing.JLabel labelFeedID;
    private javax.swing.JLabel labelFeedSender;
    private javax.swing.JRadioButton radioUserAdmin;
    private javax.swing.JRadioButton radioUserRegular;
    private javax.swing.JTable tableFeedback;
    private javax.swing.JTable tableItems;
    private javax.swing.JTable tablePackageItem;
    private javax.swing.JTable tablePackageSingle;
    private javax.swing.JTable tablePackages;
    private javax.swing.JTable tableUsers;
    private javax.swing.JTextArea textFeedArea;
    private javax.swing.JLabel welcomeItem;
    private javax.swing.JLabel welcomeMess;
    private javax.swing.JLabel welcomeName;
    private javax.swing.JLabel welcomeOrder;
    private javax.swing.JLabel welcomePack;
    private javax.swing.JTable welcomeTable;
    private javax.swing.JLabel welcomeUser;
}
