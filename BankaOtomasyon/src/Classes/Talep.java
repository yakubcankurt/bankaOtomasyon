/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author yakub cankurt
 */

 public abstract class Talep{
    private String durum;

    public Talep( String durum) {
        
        this.durum = durum;
    }
    
    

    


    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    
    
}
