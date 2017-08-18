/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Katarzyna
 */
public class NewID {
    int number1 = 0;
    int number2;
    
    public int UstawNumer(String nazwa_id, String tabela){

        Connection conn = DataBase.Connection();
        PreparedStatement pst;
        ResultSet rs;
        
        String wyszukaj = "select max(" + nazwa_id + ") from " + tabela;

        try{
            pst = conn.prepareStatement(wyszukaj);
            rs = pst.executeQuery();

            if(rs.next()) {
                number1 = rs.getInt(1);
            }
            number2 = number1 + 1;
            pst.close();
            rs.close();
            conn.close();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        } 
        
        return number2;
    }
}
