/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.SQLException;
import javax.swing.JOptionPane;



/**
 *
 * @author yakub cankurt
 */
public class Personel extends Calisan {
    
    
    public Personel(String ad, String soyad, String sifre, String tc, int maas) {
        super(ad, soyad, sifre, tc, maas);
    }
    
    public static void setLimit(double limit){
        String sorgu2 = "INSERT INTO HESAPLAR (KART_LIMIT) VALUES(" + limit + ")" ;
            
    }
    
    
   public static void musteriKayit(Musteri musteri){

       double limit = musteri.getMaas()/2;
        String sorgu = "INSERT INTO YAKUB.MUSTERI (AD,SOYAD,SIFRE,MAAS,TC) " 
                + "VALUES('" + musteri.getAd() + "','" + musteri.getSoyad() + "','" + musteri.getSifre() + "'," + musteri.getMaas() + ",'" + musteri.getTc() + "')";
        
        
         String sorgu1 = "INSERT INTO HESAPLAR (HESAP_ID,HESAP_SAHIBI)\n" +
            "SELECT ID,AD || ' ' || SOYAD \n" +
            "FROM MUSTERI WHERE ID NOT IN(SELECT HESAP_ID FROM HESAPLAR)";
         
         
         
         try {
            try {
                Baglanti.baglantiAc();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());
            }
            Baglanti.st = Baglanti.conn.createStatement();
            Baglanti.st.executeUpdate(sorgu);
            Baglanti.st.executeUpdate(sorgu1);
            System.out.println(GetMusteriID("44788547859") + "  " + limit);
                Baglanti.st.executeUpdate("UPDATE YAKUB.HESAPLAR SET  KART_LIMIT = " + limit +" WHERE HESAP_ID = " + GetMusteriID(musteri.getTc()));
            
            JOptionPane.showMessageDialog(null,"kayıt başarılı");
            Baglanti.conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());
            
        }
        
    }
   public static int GetMusteriID(String tc){
       int id =0;
       try {
            try {
                Baglanti.baglantiAc();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Bağlantı Hatası: " + ex.toString());
            }
                    
                String sorgu = "SELECT * FROM MUSTERI WHERE TC ='" + tc + "'";
                Baglanti.st = Baglanti.conn.createStatement();
                Baglanti.res =Baglanti.st.executeQuery(sorgu);
                while(Baglanti.res.next()){
                        id =Baglanti.res.getInt("ID");
                        System.out.println(id);
                   }
                     
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Id iletilemedi: " + ex.toString());
            
        }
       return id;
   }
    
}
