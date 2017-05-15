/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Katarzyna
 */
public class DataBase {
    
            static String url = "jdbc:sqlite:Planzajec.db";
            Connection conn = null;
            ResultSet rs = null;
            PreparedStatement pst = null;
      
     public static Connection Connection()
     {
                try
                {
                  Class.forName("org.sqlite.JDBC");
                  Connection conn=DriverManager.getConnection(url);
                  return conn;
                }
                  catch (ClassNotFoundException | SQLException e)
                {
                   JOptionPane.showMessageDialog(null,e.getMessage());
                    return null;
                }
     }
    
     public static void CreateTableProgram_Lojalnosciowy()
     {
         String sql = "CREATE TABLE IF NOT EXISTS Program_Lojal (\n"
                + "	Pro_Id integer PRIMARY KEY,\n"
                + "	Pro_Pkt_Paliwo integer,\n"
                + "	Pro_Pkt_Gaz integer,\n"
                + "	Pro_Pkt_Myjnia integer,\n"
                + "	Pro_Pkt_Wosk integer\n"
                + ");";
      
          try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement())
           {
            
            stmt.execute(sql);
            // stmt.close();
           }
           catch (SQLException e) 
           {
            System.out.println(e.getMessage());
           }
    }
     
     public static void CreateTableUsluga()
     {
         String sql = "CREATE TABLE IF NOT EXISTS Usluga (\n"
                + "	Usl_Id integer PRIMARY KEY,\n"
                + "	Usl_Data integer,\n"
                + "	Usl_Faktura_Id integer,\n"
                + "	Usl_Cena_Paliwa integer,\n"
                + "	Usl_Cena_Myjni integer\n"
                + ");";
      
          try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement())
           {
            
            stmt.execute(sql);
            // stmt.close();
           }
           catch (SQLException e) 
           {
            System.out.println(e.getMessage());
           }
    }
     
     public static void CreateTableRezerwacja()
     {
         String sql = "CREATE TABLE IF NOT EXISTS Rezerwacja (\n"
                + "	Rez_Id integer PRIMARY KEY,\n"
                + "	Rez_Klient_Id integer,\n"
                + "	Rez_Data integer\n"
                + ");";
      
          try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement())
           {
            
            stmt.execute(sql);
            // stmt.close();
           }
           catch (SQLException e) 
           {
            System.out.println(e.getMessage());
           }
    } 
     
     public static void CreateTableParametry()
     {
         String sql = "CREATE TABLE IF NOT EXISTS Parametry (\n"
                + "	Par_Id integer PRIMARY KEY,\n"
                + "	Par_Nazwa text,\n"
                + "	Par_Stan text,\n"
                + "	Par_Punkt_Alarmowy text\n"
                + ");";
      
          try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement())
           {
            
            stmt.execute(sql);
            // stmt.close();
           }
           catch (SQLException e) 
           {
            System.out.println(e.getMessage());
           }
    }
     
    public static void CreateTableKlient()
     {
         String sql = "CREATE TABLE IF NOT EXISTS Klient (\n"
                + "	Kli_Id integer PRIMARY KEY,\n"
                + "	Kli_Imie text,\n"
                + "	Kli_Nazwisko text,\n"
                + "	Kli_Adres_Id integer,\n"
                + "	Kli_Haslo text,\n"
                + "	Kli_Rezerwacja_Id integer,\n"
                + "	Kli_Punkty integer,\n" 
                + "	Par_Faktura_Id integer\n"
                + ");";
      
          try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement())
           {
            
            stmt.execute(sql);
            // stmt.close();
           }
           catch (SQLException e) 
           {
            System.out.println(e.getMessage());
           }
    }
    
    public static void CreateTableFirma()
     {
         String sql = "CREATE TABLE IF NOT EXISTS Firma (\n"
                + "	Fir_Id integer PRIMARY KEY,\n"
                + "	Fir_Nip text,\n"
                + "	Fir_Regon text,\n"
                + "	Fir_Nazwa text,\n"
                + "	Fir_Klient_Id integer\n"
                + ");";
      
          try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement())
           {
            
            stmt.execute(sql);
            // stmt.close();
           }
           catch (SQLException e) 
           {
            System.out.println(e.getMessage());
           }
    }
    
    public static void CreateTableFaktura()
     {
         String sql = "CREATE TABLE IF NOT EXISTS Faktura (\n"
                + "	Fak_Id integer PRIMARY KEY,\n"
                 + "	Fak_Klient_Id integer,\n"
                + "	Fir_Usluga_Id integer\n"
                + ");";
      
          try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement())
           {
            
            stmt.execute(sql);
            // stmt.close();
           }
           catch (SQLException e) 
           {
            System.out.println(e.getMessage());
           }
    }
    
    public static void CreateTableAdres()
     {
         String sql = "CREATE TABLE IF NOT EXISTS Adres (\n"
                + "	Adr_Id integer PRIMARY KEY,\n"
                + "	Adr_Ulica text,\n"
                + "	Adr_Kod text,\n"
                + "	Adr_Miasto text,\n"
                + "	Adr_Klient_Id integer\n"
                + ");";
      
          try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement())
           {
            
            stmt.execute(sql);
            // stmt.close();
           }
           catch (SQLException e) 
           {
            System.out.println(e.getMessage());
           }
    }
     
}
