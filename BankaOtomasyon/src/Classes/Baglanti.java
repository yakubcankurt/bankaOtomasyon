/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author yakub cankurt
 */
public class Baglanti {
     static Connection conn = null; // bağlantı nesnesi
     static  String url = "jdbc:derby://localhost:1527/"; //veritabanı adresi ve portu
     static  String dbName = "BANKA"; //veritabanı ismi
     static  String userName = "yakub",password = "123";
     static  String driver = "org.apache.derby.jdbc.ClientDriver";
     static  Statement st;
     static ResultSet res;

    
    
    static public Statement baglantiAc() throws Exception{
        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url+dbName, userName, password);
        return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    }
    
   

    public static String getUrl() {
        return url;
    }

    public static String getDbName() {
        return dbName;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getPassword() {
        return password;
    }

    public static String getDriver() {
        return driver;
    }

    public static Statement getSt() {
        return st;
    }

    public static ResultSet getRes() {
        return res;
    }
    
}
