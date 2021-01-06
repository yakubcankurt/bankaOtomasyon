package Classes;

import java.sql.SQLException;
import javax.swing.JOptionPane;



 

 public class Musteri implements Display,Para_CekYatir,Borc_Ode{
    private String ad,soyad,sifre,tc;
    private int maas;

    public Musteri(String ad, String soyad, String sifre, String tc, int maas) {
        this.ad = ad;
        this.soyad = soyad;
        this.sifre = sifre;
        this.tc = tc;
        this.maas = maas;
    }

    public Musteri() {
        
    }

    

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    @Override
    public void displayBorc(int id) {
        try {
            try {
                Baglanti.baglantiAc();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());
            }
            
            Baglanti.st = Baglanti.conn.createStatement();
            Baglanti.res = Baglanti.st.executeQuery("SELECT * FROM HESAPLAR WHERE HESAP_ID =" + id);
            String feedBack = null;
            
            if(Baglanti.res.next()){
                feedBack = String.valueOf(Baglanti.res.getDouble("BORC"));
                
            }
          
            
            Baglanti.conn.close();
            JOptionPane.showMessageDialog(null,feedBack);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Borç bilginize erişilemedi " + ex.toString());
            
        }
    }

    @Override
    public void displayBakiye(int id) {
        try {
            try {
                Baglanti.baglantiAc();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());
            }
            
            Baglanti.st = Baglanti.conn.createStatement();
            Baglanti.res = Baglanti.st.executeQuery("SELECT * FROM HESAPLAR WHERE HESAP_ID =" + id);
            String feedBack = null;
            
            if(Baglanti.res.next()){
                feedBack = String.valueOf(Baglanti.res.getDouble("BAKİYE"));
                
            }
          
            
            Baglanti.conn.close();
            JOptionPane.showMessageDialog(null,feedBack);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Borç bilginize erişilemedi " + ex.toString());
            
        }
    }

    @Override
    public void paraYatir(int id, double tutar) {
        try {
            try {
                Baglanti.baglantiAc();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Bağlantı Hatası: " + ex.toString());
            }
                    double bakiye1;
                    double bakiye2 =0;
                    
                Baglanti.st = Baglanti.conn.createStatement();
                
                Baglanti.res =Baglanti.st.executeQuery("SELECT * FROM HESAPLAR WHERE HESAP_ID =" + id);
                    while(Baglanti.res.next()){
                        bakiye1 =Baglanti.res.getDouble("BAKIYE");
                        bakiye2 = bakiye1 + tutar;
                        
                    }
                    
                String sorgu1 = "UPDATE HESAPLAR SET BAKIYE = "+ bakiye2  + " WHERE HESAP_ID =" + id ;
                Baglanti.st.executeUpdate(sorgu1);
                
                JOptionPane.showMessageDialog(null,"Hesaba para yatırıldı");
                Baglanti.conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Para yatırırken hata oluştu: " + ex.toString());
            
        }
    }
    
    
    @Override
    public void paraCek(int id, double tutar) {
        try {
            try {
                Baglanti.baglantiAc();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Bağlantı Hatası: " + ex.toString());
            }
                    double bakiye1;
                    double bakiye2 =0;
                    
                Baglanti.st = Baglanti.conn.createStatement();
                
                Baglanti.res =Baglanti.st.executeQuery("SELECT * FROM HESAPLAR WHERE HESAP_ID =" + id);
                    while(Baglanti.res.next()){
                        bakiye1 =Baglanti.res.getDouble("BAKIYE");
                        bakiye2 = bakiye1 - tutar;
                        
                    }
                if(bakiye2 >= 0){
                    String sorgu1 = "UPDATE HESAPLAR SET BAKIYE = "+ bakiye2  + " WHERE HESAP_ID =" + id ;
                    Baglanti.st.executeUpdate(sorgu1);
                    JOptionPane.showMessageDialog(null,"Para cektiniz");
                }  else if(bakiye2 < 0){
                    
                    JOptionPane.showMessageDialog(null,"Bakiye yetersiz");
                }  
                
                Baglanti.conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Para cekilirken hata oluştu: " + ex.toString());
            
        }
    }
    

    @Override
    public void borcOde(int id, double tutar) {
        
        
        try {
            try {
                Baglanti.baglantiAc();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Bağlantı Hatası: " + ex.toString());
            }
                    double borc1;
                    double borc2 =0;
                    
                Baglanti.st = Baglanti.conn.createStatement();
                
                Baglanti.res =Baglanti.st.executeQuery("SELECT * FROM HESAPLAR WHERE HESAP_ID =" + id);
                    while(Baglanti.res.next()){
                        borc1 =Baglanti.res.getDouble("BORC");
                        borc2 = borc1 - tutar;
                        
                    }
                    
                String sorgu1 = "UPDATE HESAPLAR SET BORC = "+ borc2  + " WHERE HESAP_ID =" + id ;
                Baglanti.st.executeUpdate(sorgu1);
                Baglanti.conn.close();
                JOptionPane.showMessageDialog(null,"Borc'a para yatırıldı");
                Baglanti.conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Borç ödenirken hata oluştu: " + ex.toString());
            
        }
        
        
        
    }

    

    
    
    
}
