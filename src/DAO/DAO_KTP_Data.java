/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import MODEL.MOD_KTP_Data;
import MODEL.MOD_Province;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Long
 */
public class DAO_KTP_Data {
    private Connection conn = null;
    
    public DAO_KTP_Data(Connection conn){
        this.conn = conn;
    }
    
    public boolean SaveKTPData(String ktpData){
        boolean result = false;
        
        Date dateNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String timestamp = ft.format(dateNow);
      
        try {
            PreparedStatement ps = this.conn.prepareStatement("INSERT tb_ktp (ktp_id, ktp_no, ktp_status, timestamp) VALUES (?,?,?,?)");
            ps.setString(1, null);
            ps.setString(2, ktpData);
            ps.setInt(3, 1);
            ps.setString(4, timestamp);
            
            if (ps.executeUpdate() > 0) {
                result = true;
            } else {
                result = false;
            }
        } catch (SQLException ex) {
            
        }
        
        return result;
    }
    
    public List<MOD_KTP_Data> RetrieveKTPData(){
        List<MOD_KTP_Data> getKTPData = new ArrayList();
        
        try {
            PreparedStatement ps = this.conn.prepareStatement("SELECT tb_ktp.ktp_id, tb_ktp.ktp_no, tb_ktp.ktp_status, tb_ktp.timestamp FROM tb_ktp");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MOD_KTP_Data MKD = new MOD_KTP_Data();
                MKD.setKtp_id(Integer.parseInt(rs.getString(1)));
                MKD.setKtp_no(rs.getString(2));
                MKD.setKtp_status(rs.getInt(3));
                MKD.setTimestamp(rs.getString(4));
                getKTPData.add(MKD);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_KTP_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return getKTPData;
    }
}
