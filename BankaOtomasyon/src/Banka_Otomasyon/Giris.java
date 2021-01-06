/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banka_Otomasyon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Banka_Otomasyon.login.personel.Login_personel;
import Banka_Otomasyon.login.yonetici.Login_yonetici;
import Banka_Otomasyon.login.musteri.Login_musteri;
/**
 *
 * @author yakub cankurt
 */
public class Giris extends javax.swing.JFrame {
    private  Connection conn = null; // bağlantı nesnesi
    private   String url = "jdbc:derby://localhost:1527/"; //veritabanı adresi ve portu
    private   String dbName = "BANKA"; //veritabanı ismi
    private   String userName = "yakub",password = "123";
    private   String driver = "org.apache.derby.jdbc.ClientDriver";
    private   Statement st;
    private ResultSet res;
    public static int idMusteri;
    
    
    
   
    public Giris() {
        initComponents();
    }

     public Statement baglantiAc() throws Exception{
        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url+dbName, userName, password);
        return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel_ID = new javax.swing.JLabel();
        jLabel_SIFRE = new javax.swing.JLabel();
        jTextField_ID = new javax.swing.JTextField();
        jButton_GIRIS = new javax.swing.JButton();
        jComboBox_TUR = new javax.swing.JComboBox<>();
        jPasswordField_SIFRE = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel_ID.setText("ID:");

        jLabel_SIFRE.setText("Sifre:");

        jTextField_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_IDActionPerformed(evt);
            }
        });

        jButton_GIRIS.setText("GİRİŞ");
        jButton_GIRIS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GIRISActionPerformed(evt);
            }
        });

        jComboBox_TUR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Müşteri", "Yönetici", "Personel", " " }));
        jComboBox_TUR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_TURActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_ID)
                    .addComponent(jLabel_SIFRE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_ID, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(jPasswordField_SIFRE))
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jComboBox_TUR, javax.swing.GroupLayout.Alignment.LEADING, 0, 78, Short.MAX_VALUE)
                    .addComponent(jButton_GIRIS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ID)
                    .addComponent(jTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_SIFRE)
                    .addComponent(jPasswordField_SIFRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jComboBox_TUR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_GIRIS)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_IDActionPerformed

    private void jComboBox_TURActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_TURActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_TURActionPerformed

    private void jButton_GIRISActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GIRISActionPerformed
        if(jComboBox_TUR.getSelectedItem().toString() == "Müşteri"){
            try {
                
                idMusteri = Integer.parseInt(jTextField_ID.getText());
                
                st = baglantiAc();
                res =st.executeQuery("SELECT * FROM MUSTERI WHERE ID =" + Integer.parseInt(jTextField_ID.getText()));
                res.first();
                
                if(res.getString("SIFRE").equals(jPasswordField_SIFRE.getText())){
                    
                    Login_musteri x = new Login_musteri();
                    setVisible(false);
                    x.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Hatalı Şifre");
                }
                
                
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Hata : " + ex.toString());
            }
            
      }
      if(jComboBox_TUR.getSelectedItem().toString() == "Yönetici"){
          try {
                
                
                st = baglantiAc();
                res =st.executeQuery("SELECT * FROM YONETICI WHERE ID =" + Integer.parseInt(jTextField_ID.getText()));
                res.first();
                
                if(res.getString("SIFRE").equals(jPasswordField_SIFRE.getText())){
                    
                    Login_yonetici x = new Login_yonetici();
                    setVisible(false);
                    x.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Hatalı Şifre");
                }
                
                
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Hata : " + ex.toString());
            }
      }
      if(jComboBox_TUR.getSelectedItem().toString() == "Personel"){
          try {
                
                
                st = baglantiAc();
                res =st.executeQuery("SELECT * FROM PERSONEL WHERE ID =" + Integer.parseInt(jTextField_ID.getText()));
                res.first();
                
                if(res.getString("SIFRE").equals(jPasswordField_SIFRE.getText())){
                    
                    Login_personel x = new Login_personel();
                    setVisible(false);
                    x.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Hatalı Şifre");
                }
                
                
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Hata : " + ex.toString());
            }
          
   
      }
    }//GEN-LAST:event_jButton_GIRISActionPerformed

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
            java.util.logging.Logger.getLogger(Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Giris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_GIRIS;
    private javax.swing.JComboBox<String> jComboBox_TUR;
    private javax.swing.JLabel jLabel_ID;
    private javax.swing.JLabel jLabel_SIFRE;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField_SIFRE;
    private javax.swing.JTextField jTextField_ID;
    // End of variables declaration//GEN-END:variables
}
