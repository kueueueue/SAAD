/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cis2103;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author queen
 */
public class Framememe extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Framememe() {
        initComponents();
        ImageIcon icon = (ImageIcon) labelBackground.getIcon();
        Image image = icon.getImage().getScaledInstance(labelBackground.getWidth(), labelBackground.getHeight(), Image.SCALE_SMOOTH);
        labelBackground.setIcon(new ImageIcon(image));
        
        ImageIcon icon1 = (ImageIcon) jLabel1.getIcon();
        Image image1 = icon1.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        jLabel1.setIcon(new ImageIcon(image1));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        inputLoginUP = new javax.swing.JPasswordField();
        inputLoginUN = new java.awt.TextField();
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
        setMaximumSize(new java.awt.Dimension(602, 470));
        setMinimumSize(new java.awt.Dimension(602, 470));
        setPreferredSize(new java.awt.Dimension(602, 470));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cis2103/logo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 10, 334, 240);

        inputLoginUP.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        inputLoginUP.setText("password");
        inputLoginUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputLoginUPActionPerformed(evt);
            }
        });
        getContentPane().add(inputLoginUP);
        inputLoginUP.setBounds(270, 300, 200, 31);

        inputLoginUN.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inputLoginUN.setEditable(false);
        inputLoginUN.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        inputLoginUN.setForeground(java.awt.Color.lightGray);
        inputLoginUN.setText("username");
        getContentPane().add(inputLoginUN);
        inputLoginUN.setBounds(270, 250, 200, 23);

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

        labelUN.setForeground(java.awt.Color.red);
        labelUN.setText("Username is empty!");
        getContentPane().add(labelUN);
        labelUN.setBounds(270, 280, 111, 16);

        labelUP.setForeground(java.awt.Color.red);
        labelUP.setText("Password is empty!");
        getContentPane().add(labelUP);
        labelUP.setBounds(270, 330, 108, 16);

        labelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cis2103/bckg.png"))); // NOI18N
        labelBackground.setToolTipText("");
        labelBackground.setMaximumSize(new java.awt.Dimension(1020, 600));
        labelBackground.setMinimumSize(new java.awt.Dimension(1020, 600));
        labelBackground.setPreferredSize(new java.awt.Dimension(1020, 600));
        getContentPane().add(labelBackground);
        labelBackground.setBounds(0, 0, 610, 440);

        pack();
    }// </editor-fold>                        

    private void inputLoginUPActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

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
            java.util.logging.Logger.getLogger(Framememe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Framememe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Framememe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Framememe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Framememe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton buttonLogin;
    private java.awt.TextField inputLoginUN;
    private javax.swing.JPasswordField inputLoginUP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelBackground;
    private javax.swing.JLabel labelUN;
    private javax.swing.JLabel labelUP;
    // End of variables declaration                   
}
