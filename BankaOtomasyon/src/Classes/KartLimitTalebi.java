/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Banka_Otomasyon.Giris;

/**
 *
 * @author yakub cankurt
 */
public class KartLimitTalebi extends Talep{
    private double eskiLimit,talepLimit;
    private int id,maas,raporNo;
        private String tc;
    public KartLimitTalebi( int id, String tc,String durum,double eskiLimit,double talepLimit,int maas,int raporNo) {
        super( durum);
        this.eskiLimit = eskiLimit;
        this.talepLimit = talepLimit;
        this.id = id;
        this.maas = maas;
        this.tc = tc;
        this.raporNo = raporNo;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    public int getRaporNo() {
        return raporNo;
    }

    public void setRaporNo(int raporNo) {
        this.raporNo = raporNo;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    

    public double getEskiLimit() {
        return eskiLimit;
    }

    public void setEskiLimit(double eskiLimit) {
        this.eskiLimit = eskiLimit;
    }

    public double getTalepLimit() {
        return talepLimit;
    }

    public void setTalepLimit(double talepLimit) {
        this.talepLimit = talepLimit;
    }
    
    
    public static String getMevcutLimit(){
        String feedback = null;
        try {
            try {
                Baglanti.baglantiAc();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());
            }
            
            Baglanti.st = Baglanti.conn.createStatement();
            Baglanti.res = Baglanti.st.executeQuery("SELECT * FROM HESAPLAR WHERE HESAP_ID =" + Giris.idMusteri);
            
            if(Baglanti.res.next()){
                feedback = String.valueOf(Baglanti.res.getDouble("KART_LIMIT"));
                
            }
          
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Mevcut limit bilginize erişilirken hata oluştu: " + ex.toString());
            
        }
        return feedback;
    }
    
    
    
    
    
    public static void TalepEt(double talepLimit){
        
        try {
            try {
                Baglanti.baglantiAc();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());
            }
            
            Baglanti.st = Baglanti.conn.createStatement();
            Baglanti.res = Baglanti.st.executeQuery("SELECT * FROM MUSTERI WHERE ID =" + Giris.idMusteri);
            String sorgu = null;
            
            if(Baglanti.res.next()){
                sorgu = "INSERT INTO KART_LIMIT_TALEPLERI (BASVURAN_ID, BASVURAN_TC, BASVURANIN_MAASI,TALEP_LIMIT,ESKI_LIMIT) \n" +
            "VALUES (" + Giris.idMusteri + ",'" + Baglanti.res.getString("TC") + "'," +  Baglanti.res.getInt("MAAS") + "," + talepLimit +  "," + Double.parseDouble(getMevcutLimit()) + ")";
                
            }
          
            Baglanti.st.executeUpdate(sorgu);
            Baglanti.conn.close();
            JOptionPane.showMessageDialog(null,"Limit Değiştirme Başvurusu oluşturuldu.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Başvururken hata oluştu: " + ex.toString());
            
        }
        
    }
    
    
    
    public static void Onay(int rapor_no,int id,double limit){
        try {
            try {
                Baglanti.baglantiAc();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Bağlantı Hatası: " + ex.toString());
            }
                    
                String sorgu = "UPDATE KART_LIMIT_TALEPLERI SET DURUM = 'ONAYLANDI' WHERE RAPOR_NO =" + rapor_no  ;
                
                Baglanti.st = Baglanti.conn.createStatement();
                Baglanti.st.executeUpdate(sorgu);
                
                String sorgu1 = "UPDATE HESAPLAR SET KART_LIMIT = " + limit  + " WHERE HESAP_ID =" + id ;
                
                Baglanti.st.executeUpdate(sorgu1);
                     
                
          
                JOptionPane.showMessageDialog(null,"Onaylandı ve kart limiti değiştirildi");
                Baglanti.conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Onaylanırken hata oluştu: " + ex.toString());
            
        }
    }
    
    
    public static void Ret(int rapor_no,int id){
        
        try {
            try {
                Baglanti.baglantiAc();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Bağlantı Hatası: " + ex.toString());
            }
                    
                String sorgu = "UPDATE KART_LIMIT_TALEPLERI SET DURUM = 'RET' WHERE RAPOR_NO =" + rapor_no  ;
                
                Baglanti.st = Baglanti.conn.createStatement();
                Baglanti.st.executeUpdate(sorgu);
                
                
          
                JOptionPane.showMessageDialog(null,"Reddedildi");
                Baglanti.conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Reddedilirken hata oluştu: " + ex.toString());
            
        }
        
        
    }
    
    
    public static  ArrayList<KartLimitTalebi> limitList(){
        ArrayList<KartLimitTalebi> limitListe = new ArrayList<>();
        
                
               String sorgu ="SELECT * FROM YAKUB.KART_LIMIT_TALEPLERI";
               

                try {
                   try {
                       Baglanti.baglantiAc();
                   } catch (Exception ex) {
                       JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());
                   }
                   Baglanti.st = Baglanti.conn.createStatement();
                   Baglanti.res = Baglanti.st.executeQuery(sorgu);
                   
                   // polymorphism
                   Talep klt1;
                   
                   while(Baglanti.res.next()){
                       
                        klt1 = new KartLimitTalebi(Baglanti.res.getInt("BASVURAN_ID"), Baglanti.res.getString("BASVURAN_TC"),Baglanti.res.getString("DURUM"), Baglanti.res.getDouble("ESKI_LIMIT"),Baglanti.res.getDouble("TALEP_LIMIT"),Baglanti.res.getInt("BASVURANIN_MAASI"),Baglanti.res.getInt("RAPOR_NO"));
                        //Downcasting
                        limitListe.add((KartLimitTalebi) klt1);
                   }
                   Baglanti.conn.close();
                   
               } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

               }
               return limitListe;
    }
    
}
