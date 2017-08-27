/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacja;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Katarzyna
 */
public class FillTable {
        public void FillClients(JTable tabela, ResultSet rs)throws SQLException{

        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        String idKli, imieKli, nazwKli, mailKli, telKli, ulKli, kodKli, miasKli;
        int i=8;
                    
        Object[] row = new Object[i];

        while(rs.next()){
            
            idKli = rs.getString("kli_id");
            imieKli = rs.getString("kli_imie");
            nazwKli = rs.getString("kli_nazwisko");
            mailKli = rs.getString("kli_mail");
            telKli = rs.getString("kli_telefon");
            ulKli = rs.getString("adr_ulica");
            kodKli = rs.getString("adr_kod");
            miasKli = rs.getString("adr_miasto");

            row[0] = idKli;
            row[1] = imieKli;
            row[2] = nazwKli;
            row[3] = mailKli;
            row[4] = telKli;
            row[5] = ulKli;
            row[6] = kodKli;
            row[7] = miasKli;
            
            model.addRow(row); //dodajemy rząd do tabeli
            tabela.setModel(model); //ustawiamy nowy model tabeli
            model.fireTableDataChanged();
            
        }
        rs.close();
    }
        
    public void FillCompany(JTable tabela, ResultSet rs)throws SQLException{
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        String idComp, nipComp, regComp, nazwComp, wlaComp, imieComp, nazwiskoComp, idwlaComp;
        int i=6;
                    
        Object[] row = new Object[i];

        while(rs.next()){
            
            idComp = rs.getString("fir_id");
            nipComp = rs.getString("fir_nip");
            regComp = rs.getString("fir_regon");
            nazwComp = rs.getString("fir_nazwa");
            imieComp = rs.getString("kli_imie");
            nazwiskoComp = rs.getString("kli_nazwisko");
            wlaComp = imieComp + " " + nazwiskoComp;
            idwlaComp = rs.getString("fir_klient_id");

            row[0] = idComp;
            row[1] = nazwComp;
            row[2] = nipComp;
            row[3] = regComp;
            row[4] = wlaComp;
            row[5] = idwlaComp;
            
            model.addRow(row);
            tabela.setModel(model);
            model.fireTableDataChanged();
            
        }
        rs.close();
    }
    
    public void FilltableReserve(JTable tabela, ResultSet rs)throws SQLException
    {
        DefaultTableModel model = (DefaultTableModel)tabela.getModel();
        String data, godz, rodzaj;
        int i = 3;
        Object row[] = new Object[i];
        
        while(rs.next())
        {
            data = rs.getString("Rez_data");
            godz = rs.getString("Rez_godz");
            rodzaj = rs.getString("Rez_Myj_rodzaj");
            model.addRow(row);
            tabela.setModel(model);
            model.fireTableDataChanged();
        }
        rs.close();
    }
    
        
    public void ClearTable(JTable tabela) {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        
        int row = model.getRowCount();
        for(int i = row-1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
}
