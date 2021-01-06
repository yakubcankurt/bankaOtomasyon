/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author yakub cankurt
 */
public class Yonetici extends Calisan {
    
    public Yonetici(String ad, String soyad, String sifre, String tc, int maas) {
        super(ad, soyad, sifre, tc, maas);
    }
    
    public static  ArrayList<Personel> personelList(){
        ArrayList<Personel> personelListe = new ArrayList<>();
        
                
               String sorgu ="SELECT * FROM YAKUB.PERSONEL";
               

                try {
                   try {
                       Baglanti.baglantiAc();
                   } catch (Exception ex) {
                       JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());
                   }
                   Baglanti.st = Baglanti.conn.createStatement();
                   Baglanti.res = Baglanti.st.executeQuery(sorgu);
                   Personel personel;
                   while(Baglanti.res.next()){
                       personel = new Personel(Baglanti.res.getString("AD"), Baglanti.res.getString("SOYAD"),Baglanti.res.getString("SIFRE"),Baglanti.res.getString("TC"),Baglanti.res.getInt("MAAS"));
                       personelListe.add(personel);
                   }
                   Baglanti.conn.close();
                   
               } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

               }
               return personelListe;
    }
    
    public static void setMaasPersonel(String tc,int maas){
        
        
        String sorgu ="UPDATE PERSONEL SET MAAS = " +  maas  +" WHERE TC = '" + tc + "'";
        
        
               

                try {
                   try {
                       Baglanti.baglantiAc();
                   } catch (Exception ex) {
                       JOptionPane.showMessageDialog(null,"Veritabanı'na Bağlanma Hatası: " + ex.toString());
                   }
                   Baglanti.st = Baglanti.conn.createStatement();
                   Baglanti.st.executeUpdate(sorgu);
                   JOptionPane.showMessageDialog(null,"Maaş güncellendi");
                   Baglanti.conn.close();
                   
               } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

               }
        
    }
    
    public static void newPersonel(Personel personel){
        
        String sorgu = "INSERT INTO PERSONEL (AD, SOYAD, SIFRE, MAAS, TC) VALUES " + 
                "('" + personel.getAd() + "', '" + personel.getSoyad() + " ', '" +  personel.getSifre() + "'," +  personel.getMaas() +  ", '" + personel.getTc() + "' )" ;
        
        
        try {
                   try {
                       Baglanti.baglantiAc();
                   } catch (Exception ex) {
                       JOptionPane.showMessageDialog(null,"Veritabanı'na Bağlanma Hatası: " + ex.toString());
                   }
                   Baglanti.st = Baglanti.conn.createStatement();
                   Baglanti.st.executeUpdate(sorgu);
                   JOptionPane.showMessageDialog(null,"Personel Eklendi");
                   Baglanti.conn.close();
                   
               } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

               }
        
    }
    
    public static void delPersonel(String tc){
        String sorgu ="DELETE FROM PERSONEL WHERE TC = '" + tc + "'";
        
        
               

                try {
                   try {
                       Baglanti.baglantiAc();
                   } catch (Exception ex) {
                       JOptionPane.showMessageDialog(null,"Veritabanı'na Bağlanma Hatası: " + ex.toString());
                   }
                   Baglanti.st = Baglanti.conn.createStatement();
                   Baglanti.st.executeUpdate(sorgu);
                   JOptionPane.showMessageDialog(null,"Personel Silindi (kovuldu)");
                   Baglanti.conn.close();
                   
               } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

               }
    }
    
}
