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


 public class krediTalebi extends Talep {
        private int talepTutar,id,maas,raporNo;
        private String tc;

    public krediTalebi( int id, String tc,int talepTutar, int maas, String durum,int raporNo) {
        super(durum);
        this.talepTutar = talepTutar;
        this.id = id;
        this.maas = maas;
        this.tc = tc;
        this.raporNo = raporNo;
        
    }

    public int getId() {
        return id;
    }

    public void setRaporNo(int raporNo) {
        this.raporNo = raporNo;
    }

    public int getRaporNo() {
        return raporNo;
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

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }
        
        
    

    public int getTalepTutar() {
        return talepTutar;
    }

    public void setTalepTutar(int talepTutar) {
        this.talepTutar = talepTutar;
    }
    
    
    public static void TalepEt(int tutar){
        
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
                sorgu = "INSERT INTO YAKUB.KREDI_TALEPLERI (BASVURAN_ID, BASVURAN_TC, BASVURANIN_MAASI, KREDI_TUTAR) \n" +
            "VALUES (" + Giris.idMusteri + ",'" + Baglanti.res.getString("TC") + "'," + Baglanti.res.getInt("MAAS")  + "," +tutar + ")";
                
            }
          
            Baglanti.st.executeUpdate(sorgu);
            Baglanti.conn.close();
            JOptionPane.showMessageDialog(null,"Kredi başvuru başarılı");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Başvururken hata oluştu: " + ex.toString());
            
        }
        
    }
    
    
    public static void Onay(int rapor_no,int id,int tutar){
        
        try {
            try {
                Baglanti.baglantiAc();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Bağlantı Hatası: " + ex.toString());
            }
                    double bakiye1;
                    double bakiye2 =0;
                    double borc1,borc2 =0;
                String sorgu = "UPDATE KREDI_TALEPLERI SET DURUM = 'ONAYLANDI' WHERE RAPOR_NO =" + rapor_no  ;
                
                Baglanti.st = Baglanti.conn.createStatement();
                Baglanti.st.executeUpdate(sorgu);
                
                Baglanti.res =Baglanti.st.executeQuery("SELECT * FROM HESAPLAR WHERE HESAP_ID =" + id);
                    while(Baglanti.res.next()){
                        bakiye1 =Baglanti.res.getDouble("BAKIYE");
                        bakiye2 = bakiye1 + tutar;
                        borc1 = Baglanti.res.getDouble("BORC");
                        borc2 = tutar + borc1;
                    }
                     
                    
                String sorgu1 = "UPDATE HESAPLAR SET BAKIYE = "+ bakiye2  + " WHERE HESAP_ID =" + id ;
                String sorgu2 = "UPDATE HESAPLAR SET BORC = "+ borc2  + " WHERE HESAP_ID =" + id;
                Baglanti.st.executeUpdate(sorgu1);
                Baglanti.st.executeUpdate(sorgu2);
                
          
                JOptionPane.showMessageDialog(null,"Onaylandı ve hesaba para yatırıldı");
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
                    
                String sorgu = "UPDATE KREDI_TALEPLERI SET DURUM = 'RET' WHERE RAPOR_NO =" + rapor_no  ;
                
                Baglanti.st = Baglanti.conn.createStatement();
                Baglanti.st.executeUpdate(sorgu);
                
                
          
                JOptionPane.showMessageDialog(null,"Reddedildi");
                Baglanti.conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Reddedilirken hata oluştu: " + ex.toString());
            
        }
        
        
    }
    
    
    
    
    
    public static  ArrayList<krediTalebi> krediList(){
        ArrayList<krediTalebi> krediListe = new ArrayList<>();
        
                
               String sorgu ="SELECT * FROM YAKUB.KREDI_TALEPLERI";
               

                try {
                   try {
                       Baglanti.baglantiAc();
                   } catch (Exception ex) {
                       JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());
                   }
                   Baglanti.st = Baglanti.conn.createStatement();
                   Baglanti.res = Baglanti.st.executeQuery(sorgu);
                   //POLYMORPHISM
                   Talep t1;
                   
                   while(Baglanti.res.next()){
                       
                       t1 = new krediTalebi(Baglanti.res.getInt("BASVURAN_ID"), Baglanti.res.getString("BASVURAN_TC"), Baglanti.res.getInt("KREDI_TUTAR"),Baglanti.res.getInt("BASVURANIN_MAASI"),Baglanti.res.getString("DURUM"),Baglanti.res.getInt("RAPOR_NO"));
                       //Downcasting
                       krediListe.add((krediTalebi) t1);
                   }
                   Baglanti.conn.close();
                   
               } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

               }
               return krediListe;
    }
    
    
}

