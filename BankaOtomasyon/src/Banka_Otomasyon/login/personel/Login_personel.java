/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banka_Otomasyon.login.personel;

import Classes.KartLimitTalebi;
import Classes.krediTalebi;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yakub cankurt
 */
public class Login_personel extends javax.swing.JFrame {
    int id_kredi;
    int tutar_kredi;
    String durum_kredi;
    int id_limit;
    double talep_limit;
    String durum_limit;
    
    public Login_personel() {
        initComponents();
        show_kredi();
        show_limit();
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
        jButton_MusteriKayit = new javax.swing.JButton();
        jButton_KREDI_RET = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_KREDI = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_LIMIT = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_RAPOR_NO_KREDI = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton_KREDI_ONAY = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField_RAPOR_NO_LIMIT = new javax.swing.JTextField();
        jButton_LIMIT_RET = new javax.swing.JButton();
        jButton_LIMIT_ONAY = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jButton_MusteriKayit.setText("Müşteri Kayıt");
        jButton_MusteriKayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MusteriKayitActionPerformed(evt);
            }
        });

        jButton_KREDI_RET.setBackground(new java.awt.Color(255, 102, 102));
        jButton_KREDI_RET.setText("RET");
        jButton_KREDI_RET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_KREDI_RETActionPerformed(evt);
            }
        });

        jTable_KREDI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rapor No", "Başvuran ID", "Kredi Tutarı", "Maaş", "Durum"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_KREDI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_KREDIMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_KREDI);

        jTable_LIMIT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rapor No", "Başvuran ID", "Mevcut Limit", "Talep Limit", "Maaş", "Durum"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_LIMIT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_LIMITMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_LIMIT);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Kredi Başvuruları");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Kart Limit Arttırma Başvuruları");

        jLabel4.setText("İşlem yapılacak Rapor No:");

        jButton_KREDI_ONAY.setBackground(new java.awt.Color(102, 255, 102));
        jButton_KREDI_ONAY.setText("ONAY");
        jButton_KREDI_ONAY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_KREDI_ONAYActionPerformed(evt);
            }
        });

        jLabel5.setText("İşlem yapılacak Rapor No:");

        jButton_LIMIT_RET.setBackground(new java.awt.Color(255, 102, 102));
        jButton_LIMIT_RET.setText("RET");
        jButton_LIMIT_RET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LIMIT_RETActionPerformed(evt);
            }
        });

        jButton_LIMIT_ONAY.setBackground(new java.awt.Color(102, 255, 102));
        jButton_LIMIT_ONAY.setText("ONAY");
        jButton_LIMIT_ONAY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LIMIT_ONAYActionPerformed(evt);
            }
        });

        jLabel7.setText("Başvuruyu soldaki tablodan tıklayarak seçin");

        jLabel8.setText("Başvuruyu soldaki tablodan tıklayarak seçin");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addComponent(jButton_KREDI_RET, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField_RAPOR_NO_KREDI, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_KREDI_ONAY, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(39, 39, 39)
                                        .addComponent(jTextField_RAPOR_NO_LIMIT, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(65, 65, 65)
                                        .addComponent(jButton_LIMIT_RET, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(76, 76, 76)
                                        .addComponent(jButton_LIMIT_ONAY, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(71, 71, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_MusteriKayit, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_RAPOR_NO_KREDI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_KREDI_RET)
                            .addComponent(jButton_KREDI_ONAY))
                        .addGap(104, 104, 104)
                        .addComponent(jButton_MusteriKayit, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(48, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField_RAPOR_NO_LIMIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_LIMIT_ONAY)
                            .addComponent(jButton_LIMIT_RET))
                        .addGap(149, 149, 149))))
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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_MusteriKayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MusteriKayitActionPerformed
         Kayit_musteri x = new Kayit_musteri();
        setVisible(false);
        x.setVisible(true);
    }//GEN-LAST:event_jButton_MusteriKayitActionPerformed

    private void jButton_KREDI_ONAYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_KREDI_ONAYActionPerformed
        if(durum_kredi.equals("BEKLİYOR")){
            krediTalebi.Onay(Integer.parseInt(jTextField_RAPOR_NO_KREDI.getText()),id_kredi,tutar_kredi);
            clear_kredi();
            show_kredi();
        }else if(durum_kredi.equals("ONAYLANDI")){
            JOptionPane.showMessageDialog(null,"Başvuru zaten onaylandı");
        } else{
            JOptionPane.showMessageDialog(null,"Onaylama başarısız");
        }
        
    }//GEN-LAST:event_jButton_KREDI_ONAYActionPerformed

    private void jTable_KREDIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_KREDIMouseClicked
       DefaultTableModel model = (DefaultTableModel)jTable_KREDI.getModel();
       int selectedIndex = jTable_KREDI.getSelectedRow();
       jTextField_RAPOR_NO_KREDI.setText(model.getValueAt(selectedIndex, 0).toString());
       id_kredi = Integer.parseInt(model.getValueAt(selectedIndex, 1).toString());
       tutar_kredi = Integer.parseInt(model.getValueAt(selectedIndex, 2).toString());
       durum_kredi = model.getValueAt(selectedIndex, 4).toString();
    }//GEN-LAST:event_jTable_KREDIMouseClicked

    private void jTable_LIMITMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_LIMITMouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable_LIMIT.getModel();
       int selectedIndex = jTable_LIMIT.getSelectedRow();
       jTextField_RAPOR_NO_LIMIT.setText(model.getValueAt(selectedIndex, 0).toString());
       id_limit = (int) model.getValueAt(selectedIndex, 1);
       talep_limit =  (double) model.getValueAt(selectedIndex, 3);
       durum_limit = model.getValueAt(selectedIndex, 5).toString();
       System.out.println(durum_limit + " " + talep_limit + " " + id_limit);
    }//GEN-LAST:event_jTable_LIMITMouseClicked

    private void jButton_LIMIT_ONAYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LIMIT_ONAYActionPerformed
       
       if(durum_limit.equals("BEKLİYOR")){
           KartLimitTalebi.Onay(Integer.parseInt(jTextField_RAPOR_NO_LIMIT.getText()), id_limit, talep_limit);
           clear_limit();
           show_limit();
       }else if(durum_limit.equals("ONAYLANDI")){
            JOptionPane.showMessageDialog(null,"Başvuru zaten onaylandı");
        } else{
            JOptionPane.showMessageDialog(null,"Onaylama başarısız");
        }
    }//GEN-LAST:event_jButton_LIMIT_ONAYActionPerformed

    private void jButton_KREDI_RETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_KREDI_RETActionPerformed
        if(durum_kredi.equals("BEKLİYOR")){
            krediTalebi.Ret(Integer.parseInt(jTextField_RAPOR_NO_KREDI.getText()),id_kredi);
            clear_kredi();
            show_kredi();
        }else if(durum_kredi.equals("RET")){
            JOptionPane.showMessageDialog(null,"Başvuru zaten reddedildi");
        } else{
            JOptionPane.showMessageDialog(null,"Reddetme başarısız");
        }
    }//GEN-LAST:event_jButton_KREDI_RETActionPerformed

    private void jButton_LIMIT_RETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LIMIT_RETActionPerformed
        if(durum_limit.equals("BEKLİYOR")){
           KartLimitTalebi.Ret(Integer.parseInt(jTextField_RAPOR_NO_LIMIT.getText()), id_limit);
           clear_limit();
           show_limit();
       }else if(durum_limit.equals("RET")){
            JOptionPane.showMessageDialog(null,"Başvuru zaten reddedildi");
        } else{
            JOptionPane.showMessageDialog(null,"Reddetme başarısız");
        }
    }//GEN-LAST:event_jButton_LIMIT_RETActionPerformed

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
            java.util.logging.Logger.getLogger(Login_personel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_personel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_personel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_personel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_personel().setVisible(true);
            }
        });
    }
    
    public void show_kredi(){
        ArrayList<krediTalebi> list = krediTalebi.krediList();
        DefaultTableModel model = (DefaultTableModel)jTable_KREDI.getModel();
        Object[] row = new Object[5];
        for(int i =0;i<list.size();i++){
            row[0] = list.get(i).getRaporNo();
            row[1] = list.get(i).getId();
            row[2] = list.get(i).getTalepTutar();
            row[3] = list.get(i).getMaas();
            row[4] = list.get(i).getDurum();
            model.addRow(row);
        }
    }
    public void show_limit(){
        ArrayList<KartLimitTalebi> list = KartLimitTalebi.limitList();
        DefaultTableModel model = (DefaultTableModel)jTable_LIMIT.getModel();
        Object[] row = new Object[6];
        for(int i =0;i<list.size();i++){
            row[0] = list.get(i).getRaporNo();
            row[1] = list.get(i).getId();
            row[2] = list.get(i).getEskiLimit();
            row[3] = list.get(i).getTalepLimit();
            row[4] = list.get(i).getMaas();
            row[5] = list.get(i).getDurum();
            model.addRow(row);
        }
    }
    public void clear_kredi(){
        DefaultTableModel model = (DefaultTableModel)jTable_KREDI.getModel();
        model.setRowCount(0);
    }
    public void clear_limit(){
        DefaultTableModel model = (DefaultTableModel)jTable_LIMIT.getModel();
        model.setRowCount(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_KREDI_ONAY;
    private javax.swing.JButton jButton_KREDI_RET;
    private javax.swing.JButton jButton_LIMIT_ONAY;
    private javax.swing.JButton jButton_LIMIT_RET;
    private javax.swing.JButton jButton_MusteriKayit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_KREDI;
    private javax.swing.JTable jTable_LIMIT;
    private javax.swing.JTextField jTextField_RAPOR_NO_KREDI;
    private javax.swing.JTextField jTextField_RAPOR_NO_LIMIT;
    // End of variables declaration//GEN-END:variables
}