
package cis2103;

import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import exceptions.UserNotFoundException;
import model.Database;
import model.UserClass;

public class Login extends javax.swing.JFrame {

public Login() {
		boolean connected = false;
		while (!connected) {
	        try {
	            Database.loadUsersFromDatabase();
	            Database.loadItemsFromDatabase();
	            Database.loadPackageFromDatabase();
	            Database.loadMenuFromDatabase();
	            Database.loadFeedbackFromDatabase();
	            connected = true;
	        } catch (SQLException e) {
	            String[] options = {"Try Again", "Exit"};
	            int choice = javax.swing.JOptionPane.showOptionDialog(null, "Database Error. Try again once connected.", "Database Error", javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	            System.out.println(e.getMessage());
	            if (choice == 1) {
	                System.exit(1);
	            }
	        }
	    }
		
        initComponents();
        
        labelUN.setVisible(false);
        labelUP.setVisible(false);

    }


    private void initComponents() {

    	jLabel1 = new javax.swing.JLabel();
        inputLoginUP = new javax.swing.JPasswordField();
        inputLoginUN = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buttonLogin = new javax.swing.JButton();
        labelUN = new javax.swing.JLabel();
        labelUP = new javax.swing.JLabel();
        labelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(15, 4, 76));
        setFocusTraversalPolicyProvider(true);
        setMaximumSize(new java.awt.Dimension(602, 480));
        setMinimumSize(new java.awt.Dimension(602, 480));
        setPreferredSize(new java.awt.Dimension(602, 480));
        setResizable(false);
        getContentPane().setLayout(null);
        
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cis2103/logo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 10, 334, 240);
        
        inputLoginUP.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        inputLoginUP.setText("password");
        inputLoginUP.setForeground(java.awt.Color.lightGray);
        inputLoginUP.addFocusListener(new java.awt.event.FocusAdapter() {
          public void focusGained(java.awt.event.FocusEvent evt) {
          	inputLoginUPFocusGained(evt);
          }
          public void focusLost(java.awt.event.FocusEvent evt) {
          	inputLoginUPFocusLost(evt);
          }
        });
        
        getContentPane().add(inputLoginUP);
        inputLoginUP.setBounds(270, 300, 200, 31);

        inputLoginUN.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inputLoginUN.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        inputLoginUN.setForeground(java.awt.Color.lightGray);
        inputLoginUN.setText("username");
        getContentPane().add(inputLoginUN);
        inputLoginUN.setBounds(270, 250, 200, 30);
        inputLoginUN.addFocusListener(new java.awt.event.FocusAdapter() {
          public void focusGained(java.awt.event.FocusEvent evt) {
          	inputLoginUNFocusGained(evt);
          }
          public void focusLost(java.awt.event.FocusEvent evt) {
          	inputLoginUNFocusLost(evt);
          }
        });

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setText("Username:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 250, 97, 24);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setText("Password:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(150, 300, 93, 24);

        buttonLogin.setBackground(new java.awt.Color(240, 240, 192));
        buttonLogin.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        buttonLogin.setForeground(new java.awt.Color(51, 0, 51));
        buttonLogin.setText("LOGIN");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(buttonLogin);
        buttonLogin.setBounds(230, 370, 100, 50);

        labelUN.setForeground(new Color(255, 255, 0));
        labelUN.setFont(new java.awt.Font("sansserif", 1, 11)); // NOI18N
        labelUN.setText("Username is empty!");
        getContentPane().add(labelUN);
        labelUN.setBounds(270, 275, 200, 16);


        labelUP.setForeground(new Color(255, 255, 0));
        labelUP.setFont(new java.awt.Font("sansserif", 1, 11)); // NOI18N
        labelUP.setText("Password is empty!");
        getContentPane().add(labelUP);
        labelUP.setBounds(270, 330, 200, 16);

        labelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cis2103/bckg.jpg"))); // NOI18N
        labelBackground.setToolTipText("");
        labelBackground.setMaximumSize(new java.awt.Dimension(1020, 600));
        labelBackground.setMinimumSize(new java.awt.Dimension(1020, 600));
        labelBackground.setPreferredSize(new java.awt.Dimension(1020, 600));
        getContentPane().add(labelBackground);
        labelBackground.setBounds(0, 0, 610, 450);
        
//        
//
//        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cis2103/logo.png"))); // NOI18N
//        jLabel1.setText("jLabel1");
//        
//        
//        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
//        jLabel2.setText("Username:");
//
//        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
//        jLabel3.setText("Password:");
//        
//        buttonLogin.setText("LOGIN");
//        buttonLogin.setBackground(new java.awt.Color(240, 240, 192));
//        buttonLogin.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
//        buttonLogin.setForeground(Color.WHITE);
//        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                buttonLoginActionPerformed(evt);
//            }
//        });
//
//        labelUN.setForeground(java.awt.Color.red);
//        labelUN.setText("Username is empty!");
//
//        labelUP.setForeground(java.awt.Color.red);
//        labelUP.setText("Password is empty!");
//
//        inputLoginUN.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
//        inputLoginUN.setForeground(Color.LIGHT_GRAY);
//        inputLoginUN.setFont(new java.awt.Font("Dialog", 0, 14));
//        inputLoginUN.setText("username");
//        inputLoginUN.setBorder(javax.swing.BorderFactory.createEtchedBorder());
//        inputLoginUN.addFocusListener(new java.awt.event.FocusAdapter() {
//            public void focusGained(java.awt.event.FocusEvent evt) {
//            	inputLoginUNFocusGained(evt);
//            }
//            public void focusLost(java.awt.event.FocusEvent evt) {
//            	inputLoginUNFocusLost(evt);
//            }
//        });
//
//        inputLoginUP.setForeground(Color.LIGHT_GRAY);
//        inputLoginUP.setFont(new java.awt.Font("sansserif", 0, 14));
//        inputLoginUP.setText("password");
//        inputLoginUP.setBorder(javax.swing.BorderFactory.createEtchedBorder());
//        inputLoginUP.addFocusListener(new java.awt.event.FocusAdapter() {
//            public void focusGained(java.awt.event.FocusEvent evt) {
//            	inputLoginUPFocusGained(evt);
//            }
//            public void focusLost(java.awt.event.FocusEvent evt) {
//            	inputLoginUPFocusLost(evt);
//            }
//        });
//        
//        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
//        jPanel1.setLayout(jPanel1Layout);
//        jPanel1Layout.setHorizontalGroup(
//            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel1Layout.createSequentialGroup()
//                .addContainerGap(121, Short.MAX_VALUE)
//                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
//                    .addGroup(jPanel1Layout.createSequentialGroup()
//                        .addComponent(jLabel2)
//                        .addGap(22, 22, 22)
//                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addComponent(labelUN)
//                            .addComponent(inputLoginUN, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                    .addGroup(jPanel1Layout.createSequentialGroup()
//                        .addComponent(jLabel3)
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addComponent(labelUP)
//                            .addComponent(inputLoginUP, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))))
//                .addGap(134, 134, 134))
//            .addGroup(jPanel1Layout.createSequentialGroup()
//                .addGap(230, 230, 230)
//                .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGap(0, 0, Short.MAX_VALUE))
//            .addGroup(jPanel1Layout.createSequentialGroup()
//                .addGap(151, 151, 151)
//                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//        jPanel1Layout.setVerticalGroup(
//            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel1Layout.createSequentialGroup()
//                .addGap(44, 44, 44)
//                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGap(18, 18, 18)
//                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                    .addComponent(inputLoginUN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jLabel2))
//                .addGap(3, 3, 3)
//                .addComponent(labelUN)
//                .addGap(18, 18, 18)
//                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(inputLoginUP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jLabel3))
//                .addGap(2, 2, 2)
//                .addComponent(labelUP)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addContainerGap(130, Short.MAX_VALUE))
//        );
//
//        getContentPane().add(jPanel1);
//        jPanel1.setBounds(0, 0, 610, 550);
//
//        labelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cis2103/bckg2.jpg"))); // NOI18N
//        labelBackground.setToolTipText("");
//        labelBackground.setMaximumSize(new java.awt.Dimension(1020, 600));
//        labelBackground.setMinimumSize(new java.awt.Dimension(1020, 600));
//        labelBackground.setPreferredSize(new java.awt.Dimension(1020, 600));
//        getContentPane().add(labelBackground);
//        labelBackground.setBounds(0, 0, 610, 550);
        pack();
    }
    

    private void inputLoginUNFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userNameFieldFocusGained
        // TODO add your handling code here:
        if (inputLoginUN.getText().equals("username")) {
        	inputLoginUN.setText("");
        	inputLoginUN.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_userNameFieldFocusGained

    private void inputLoginUNFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userNameFieldFocusLost
        // TODO add your handling code here:
        if (inputLoginUN.getText().isEmpty()) {
        	inputLoginUN.setText("username");
        	inputLoginUN.setForeground(Color.GRAY);
        }   
    }//GEN-LAST:event_userNameFieldFocusLost

    private void inputLoginUPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passWordFieldFocusGained
        // TODO add your handling code here:
        String pass = new String(inputLoginUP.getPassword());
        if (pass.equals("password")) {
        	inputLoginUP.setText("");
        	inputLoginUP.setForeground(Color.BLACK);
            
        }
    }//GEN-LAST:event_passWordFieldFocusGained

    private void inputLoginUPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passWordFieldFocusLost
        // TODO add your handling code here:
        String pass = new String(inputLoginUP.getPassword());
        if (pass.isEmpty()) {
        	inputLoginUP.setText("password");
        	inputLoginUP.setForeground(Color.GRAY);
        }   
    }//GEN-LAST:event_passWordFieldFocusLost

    
    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        
        labelUN.setVisible(false);
        labelUP.setVisible(false);
        
        String username = inputLoginUN.getText();
        String password = String.valueOf(inputLoginUP.getPassword());
        
        if(username.equals("") || username.equals("username")) {
            labelUN.setVisible(true);
            return;
            
        }

        if(password.equals("") || password.equals("password")) {
            labelUP.setVisible(true);
            return;
        }

        else {
        	try {
				UserClass temp = loginUser(username, password);

				if(temp.getRole().equals(UserClass.ADMIN_USER)) {
					AdminClassFrame a = new AdminClassFrame(temp);
					a.setVisible(true);
					a.setLocationRelativeTo(null);
					this.dispose();
				}else {
					RegularClassFrame r = new RegularClassFrame(temp);
					r.setVisible(true);
					r.setLocationRelativeTo(null);
					this.dispose();
				}
			} catch (UserNotFoundException e) {	
				JOptionPane.showMessageDialog(this, "Credentials incorrect. Please contact administrator.");
				
			}
        }
    }
    
    public UserClass loginUser(String username, String password) throws UserNotFoundException {
        for (UserClass user : Database.getUsers()) {
        	if(user.getUserName().equals(username) && user.getPassword().equals(password)) {
        		return user;
        	}
        }
        throw new UserNotFoundException("User not found.");
    }
    
    
    public static void main(String[] args) {
		
    	try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    	
    	Login log = new Login();
    	log.setVisible(true);
    	log.setLocationRelativeTo(null);
	}


    private javax.swing.JTextField inputLoginUN;
    private javax.swing.JPasswordField inputLoginUP;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelBackground;
    private javax.swing.JLabel labelUN;
    private javax.swing.JLabel labelUP;
}
