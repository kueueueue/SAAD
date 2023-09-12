package cis2103;

import java.awt.Font;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

import model.BillingAddress;
import model.Database;
import model.Invoice;
import model.Item;
import model.Menu;
import model.Order;
import model.UserClass;

public class Billing extends javax.swing.JFrame {

	private static Order order;
	private static JFrame reg;
	private static float amount, tdiscount, tchange;
	private static Invoice i = new Invoice();
	private static BillingAddress bill = new BillingAddress();
    private static final DecimalFormat df = new DecimalFormat("'₱'0.00");
	int vid = 1;
	UserClass user;
	
    public Billing(JFrame regular, UserClass u, Order ord, float amountPaid) {
    	order = ord;
    	reg = regular;
    	amount = amountPaid;
        user = u;
    	initComponents();
        initBilling();
        
        ButtonGroup OMG = new ButtonGroup();
        OMG.add(jRadioButton1);
        OMG.add(jRadioButton2);
        jRadioButton1.setSelected(true);
        ButtonGroup DMG = new ButtonGroup();
        DMG.add(jRadioButton3);
        DMG.add(jRadioButton4);
        jRadioButton3.setSelected(true);
        ButtonGroup PMG = new ButtonGroup();
        PMG.add(radioCash);
        PMG.add(radioWallet);
        radioCash.setSelected(true);
       
    }
    @SuppressWarnings("unchecked")
    
    private void initComponents() {
    	
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        radioCash = new javax.swing.JRadioButton();
        radioWallet = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        receiptArea = new javax.swing.JTextArea();
        buttonBillPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 550));
        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
            	reg.setVisible(true);
            }
        });
        
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(700, 550));
        jPanel1.setMinimumSize(new java.awt.Dimension(700, 550));

        jLabel1.setText("BILLING ID");

        jLabel2.setText("NAME :");

        jLabel3.setText("EMAIL :");

        jLabel4.setText("CONTACT NUMBER :");

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addComponent(jTextField3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jLabel5.setText("PAYMENT METHOD");

        jLabel6.setText("SHIPPING ADDRESS :");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel7.setText("STATUS :");

        radioCash.setText("CASH");

        radioWallet.setText("E-WALLET");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioCash)
                        .addGap(18, 18, 18)
                        .addComponent(radioWallet))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(radioCash)
                    .addComponent(radioWallet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(37, 37, 37))
        );

        jLabel8.setText("");
        jLabel8.setVisible(false);
        jLabel9.setText("");

        jLabel9.setVisible(false);
        jLabel10.setText("");

        jLabel10.setVisible(false);
        jButton2.setText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              //  jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jButton1.setText("GENERATE RECEIPT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setText("AMOUNT: <AMOUNT>");

        jLabel12.setText("TOTAL BILL : <TOTAL BILL>");

        jLabel13.setText("CHANGE : <CHANGE>");

        jLabel14.setText("ORDER METHOD :");

        jLabel15.setText("DELIVERY METHOD :");

        jRadioButton1.setText("PHYSICAL");

        jRadioButton2.setText("ONLINE");

        jRadioButton3.setText("PICKUP");

        jRadioButton4.setText("DELIVERY");

        receiptArea.setColumns(20);
        receiptArea.setRows(5);
        jScrollPane2.setViewportView(receiptArea);

        buttonBillPrint.setText("PRINT");
        buttonBillPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBillPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel14)
                                                .addComponent(jLabel15))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jRadioButton3)
                                                .addComponent(jRadioButton1))))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButton4)
                                        .addComponent(jRadioButton2))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBillPrint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(38, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(jRadioButton3)
                                    .addComponent(jRadioButton4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13))
                            .addComponent(jScrollPane2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonBillPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))))
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

        jPanel4.setVisible(false);
        pack();
    }// </editor-fold>                        
                  
    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {   
        if(!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        } else {
        	String num = ((JTextComponent) evt.getComponent()).getText();
        	if(num.length() >= 11) {
        		evt.consume();
        	}
        }
    } 
    
 
    private void initBilling() {
    	tchange = amount - (order.getTotal() - tdiscount);
        try {
			jLabel1.setText("BILLING ID # " + Database.getLastBillingID());
		
    	jLabel11.setText("AMOUNT PAID: " + String.valueOf(amount));
    	jLabel12.setText("ORDER TOTAL: " + String.valueOf(order.getTotal()));
    	jLabel13.setText("TOTAL CHANGE : " + String.valueOf(tchange)); 
    	receiptArea.setEditable(false);
        } catch (SQLException e) {
 			// TODO Auto-generated catch block
 			JOptionPane.showMessageDialog(this, "Something went wrong. Method initBilling() in Billing class.");
 		}
    }
   
    
    private boolean isBillEmpty() {
    	if(jTextField1.getText().isEmpty()) {
    		return false;
    	}
    	if(jTextField2.getText().isEmpty()) {
    		return false;
    	}
    	if(jTextField3.getText().isEmpty()) {
    		return false;
    	}
    	if(jTextArea1.getText().isEmpty()) {
    		return false;
    	}
    	return true;
    }

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	
    	if(isBillEmpty()) {
            // PAY
        	
        	receipt();	
    	} else {
    		JOptionPane.showMessageDialog(this, "Some inputs are missing.");
    	}
    }



	private void buttonBillPrintActionPerformed(java.awt.event.ActionEvent evt) {
	    try {
	    	receiptArea.print(); 
	    	bill.setName(jTextField1.getText());
        	bill.setEmailAdd(jTextField2.getText());
        	bill.setContactNo(jTextField3.getText());
        	
        	
        	order.setOrderMethod(Order.PHYSICAL);
        	if(jRadioButton2.isSelected()) {
        		order.setOrderMethod(Order.ONLINE);
        	}
        	order.setDeliveryMethod(Order.PICKUP);
        	if(jRadioButton4.isSelected()) {
        		order.setDeliveryMethod(Order.DELIVER);
        	}    	
        	
        	i.setPaymentMethod("CASH");
        	if(radioWallet.isSelected()) {
        		i.setPaymentMethod("EWALLET");
        	}
        	i.setShippingAdd(jTextArea1.getText());
        	i.setBillingID(bill.getId());
        	i.setVoucherID(vid);;
        	i.setOrderID(order.getId());
        	i.setUserID(user.getId());

        	try {
    			Database.addBilling(bill);
    			Database.addOrder(order);
    			
    			Database.addInvoice(i);
    			
    			JOptionPane.showMessageDialog(this, "Payment Complete");
    			
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
        	addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    dispose();
                    reg.dispose();
                }
            });
        	dispose();
        	new RegularClassFrame(user).setVisible(true);
	    } catch (PrinterException ex) {
	        JOptionPane.showMessageDialog(this, "Something went wrong. Button: Print.");
	    }
	  
	}
	
	
private void receipt() {
	
		
    	
    	Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy");
        String formattedDate = dateFormat.format(currentDate);

        
    	receiptArea.setFont(new Font("Courier New", Font.BOLD, 14));
    	receiptArea.setText(receiptArea.getText() + "================================================\r\n"
    			+ "                 J&J PARTY FOOD\r\n"
    			+ "              PAJO, LAPU-LAPU CITY\r\n"
    			+ "               DATE : " + formattedDate + "\r\n"
    			+ "================================================\r\n"
    			+ "\r\n"
    			+ "ORDER # : \r\n"
    			+ "NAME                 QTY              PRICE\n");
    	for(Menu m : order.getMenuOrders()) {
			String str = String.format("%-22s", m.getName());
    		String str2 = String.format("%-17s", m.getQuantity());
    		String str3 = String.format("%s", df.format(m.getPrice()*m.getQuantity()));
    		receiptArea.setText(receiptArea.getText() + str + str2 + str3 + "\n");
    		if(m.getType().equals(Menu.PACKAGE_TYPE)) {
    			String pi = "";
    			for(Item i: Database.loadPackageItemFromDatabase(m.getId())) {
    				String name = i.getId()+ " " + i.getName();
    				if(name.length()>15) {
    					name = name.substring(0, 15);
    				}
    				pi += " ``" + name + "\n";
    			}

        		receiptArea.setText(receiptArea.getText() + pi + "\n");
    		}
    	}
    	receiptArea.setText(receiptArea.getText() + "================================================\r\n"
    			+ "                   Order Total   : " + df.format(order.getTotal()) + "\r\n"
    			+ "                   Discount      : " + df.format(tdiscount) + "\r\n"
    			+ "                   Amount Paid   : " + order.getTotal() + "\r\n"
    			+ "                   Change        : " + df.format(tchange) + "\r\n"
    			+ "\r\n"
    			+ "CUSTOMER DETAILS:\n");
    	
    	receiptArea.setText(receiptArea.getText()  + jTextField1.getText() + "\n");
    	receiptArea.setText(receiptArea.getText()  + jTextArea1.getText()  + "\n");
    	receiptArea.setText(receiptArea.getText()  + jTextField2.getText() + "\n");
    	receiptArea.setText(receiptArea.getText()  + jTextField3.getText() +"\n\n\n");
    	receiptArea.setText(receiptArea.getText() + "===============================================\r\n");
    	receiptArea.setText(receiptArea.getText() + "             THANK YOU FOR ORDERING!");

    }
                
    private javax.swing.JButton buttonBillPrint;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JRadioButton radioCash;
    private javax.swing.JRadioButton radioWallet;
    private javax.swing.JTextArea receiptArea;            
}
