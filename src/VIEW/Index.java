/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VIEW;

import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Long
 */
public class Index extends javax.swing.JFrame {

    /**
     * Creates new form test
     */
    public Index() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("image/icon.png"));
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        desktops = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemFileExit = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuItemGeneratorKTPQR = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuItemSettingsConfigurations = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuItemHelp = new javax.swing.JMenuItem();
        menuItemAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EVoting System V.1.0.1");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Copyright, 2016 -  Komisi Pemilihan Umum Republik Indonesia. Jakarta.");

        jLabel2.setText(">");

        jLabel3.setText("Connecting to web API...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout desktopsLayout = new javax.swing.GroupLayout(desktops);
        desktops.setLayout(desktopsLayout);
        desktopsLayout.setHorizontalGroup(
            desktopsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        desktopsLayout.setVerticalGroup(
            desktopsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        menuItemFileExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        menuItemFileExit.setText("Exit");
        menuItemFileExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFileExitActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemFileExit);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Generator");

        menuItemGeneratorKTPQR.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        menuItemGeneratorKTPQR.setText("KTP - QR Generator");
        menuItemGeneratorKTPQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGeneratorKTPQRActionPerformed(evt);
            }
        });
        jMenu3.add(menuItemGeneratorKTPQR);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Validator");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Mobile Phone Validator");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Kasus");

        jMenuItem2.setText("Kasus Dilaporkan");
        jMenu6.add(jMenuItem2);

        jMenuItem3.setText("Kasus Diselesaikan");
        jMenu6.add(jMenuItem3);

        jMenuBar1.add(jMenu6);

        jMenu2.setText("Settings");

        menuItemSettingsConfigurations.setText("Configurations");
        menuItemSettingsConfigurations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSettingsConfigurationsActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemSettingsConfigurations);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("About");

        menuItemHelp.setText("Help");
        menuItemHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemHelpActionPerformed(evt);
            }
        });
        jMenu4.add(menuItemHelp);

        menuItemAbout.setText("About");
        menuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAboutActionPerformed(evt);
            }
        });
        jMenu4.add(menuItemAbout);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(desktops)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktops)
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemGeneratorKTPQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGeneratorKTPQRActionPerformed
        // TODO add your handling code here:
        try {
            Generator QRG = new Generator();
            QRG.setVisible(true);
            desktops.add(QRG);
            QRG.setSelected(true);
        } catch (Exception e) {} 
    }//GEN-LAST:event_menuItemGeneratorKTPQRActionPerformed

    private void menuItemFileExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemFileExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menuItemFileExitActionPerformed

    private void menuItemSettingsConfigurationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSettingsConfigurationsActionPerformed
        // TODO add your handling code here:
        try {
            Settings st = new Settings();
            st.setVisible(true);
            desktops.add(st);
            st.setSelected(true);
        } catch (Exception e) {
        
        } 
    }//GEN-LAST:event_menuItemSettingsConfigurationsActionPerformed

    private void menuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAboutActionPerformed
        // TODO add your handling code here:
        try {
            About at = new About();
            at.setVisible(true);
        } catch (Exception e) {
        
        } 
    }//GEN-LAST:event_menuItemAboutActionPerformed

    private void menuItemHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemHelpActionPerformed
        // TODO add your handling code here:
        try {
//            Settings st = new Settings();
//            st.setVisible(true);
//            desktops.add(st);
//            st.setSelected(true);
        } catch (Exception e) {
        
        } 
    }//GEN-LAST:event_menuItemHelpActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        try {
            MobilePhoneValidator MPV = new MobilePhoneValidator();
            MPV.setVisible(true);
            desktops.add(MPV);
            MPV.setSelected(true);
        } catch (Exception e) {
        
        } 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktops;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JMenuItem menuItemAbout;
    private javax.swing.JMenuItem menuItemFileExit;
    private javax.swing.JMenuItem menuItemGeneratorKTPQR;
    private javax.swing.JMenuItem menuItemHelp;
    private javax.swing.JMenuItem menuItemSettingsConfigurations;
    // End of variables declaration//GEN-END:variables
}