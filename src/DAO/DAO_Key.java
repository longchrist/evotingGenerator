/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import MODEL.MOD_Key;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  THIS SAVED VOTER DATA CANNOT BE DELETED OR EDITED
 *  DATA GENERATED AUTOMATICALLY
 */

public class DAO_Key {
    
    private Connection conn = null;

    public DAO_Key(Connection conn) {
        this.conn = conn;
    }
    
    public int InputTpsKeyValue(String[] keyData, int sumData, int countData){
        String tpsKeyData = "";
        int tpsLastID = 0;
        
        for(int ix = 0; ix < keyData.length; ix++){
            tpsKeyData += keyData[ix]+":";
        }
        tpsKeyData = tpsKeyData.substring(0, tpsKeyData.length()-1);
        
        try {
            PreparedStatement ps = this.conn.prepareStatement("INSERT tb_tps_key (tps_key_id, tps_key, tps_sum_key) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, null);
            ps.setString(2, tpsKeyData);
            ps.setInt(3, sumData);
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            
            if (generatedKeys.next()) {
                tpsLastID = generatedKeys.getInt(1);
            } else {
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tpsLastID;
    }
    
    public int InputPengawasKeyValue(String[] keyData, int sumData, int countData){
        String pengawasKeyData = "";
        int pengawasLastID = 0;
        
        for(int ix = 0; ix < keyData.length; ix++){
            pengawasKeyData += keyData[ix]+":";
        }
        pengawasKeyData = pengawasKeyData.substring(0, pengawasKeyData.length()-1);
        
        try {
            PreparedStatement ps = this.conn.prepareStatement("INSERT tb_pengawas_key (pengawas_key_id, pengawas_key, pengawas_sum_key) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, null);
            ps.setString(2, pengawasKeyData);
            ps.setInt(3, sumData);
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            
            if (generatedKeys.next()) {
                pengawasLastID = generatedKeys.getInt(1);
            } else {
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pengawasLastID;
    }
    
    public int InputKTPKeyValue(String[] keyData, int sumData, int countData){        
        String KTPKeyData = "";
        int ktpLastID = 0;
        
        for(int ix = 0; ix < keyData.length; ix++){
            KTPKeyData += keyData[ix]+":";
        }
        KTPKeyData = KTPKeyData.substring(0, KTPKeyData.length()-1);
        
        try {
            PreparedStatement ps = this.conn.prepareStatement("INSERT tb_ktp_key (ktp_key_id, ktp_key, ktp_sum_key) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, null);
            ps.setString(2, KTPKeyData);
            ps.setInt(3, sumData);
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            
            if (generatedKeys.next()) {
                ktpLastID = generatedKeys.getInt(1);
            } else {
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ktpLastID;
    }
    
    public boolean InputLinkedKeyData(int ktpKeyId, int tpsKeyId, int pengawasKeyId, int rawDataId, String voteLocation){
        boolean result = false;
        
        Date dateNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String timestamp = ft.format(dateNow);
        
        try {
            PreparedStatement ps = this.conn.prepareStatement("INSERT tb_key_data (key_data_id, ktp_key_id, tps_key_id, pengawas_key_id, raw_data_id, timestamp, vote_location) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, null);
            ps.setInt(2, ktpKeyId);
            ps.setInt(3, tpsKeyId);
            ps.setInt(4, pengawasKeyId);
            ps.setInt(5, rawDataId);
            ps.setString(6, timestamp);
            ps.setString(7, voteLocation);
            
            if (ps.executeUpdate() > 0) {
                result = true;
            } else {
                result = false;
            }
        } catch (SQLException ex) {
            
        }
        return result;
    }
    
    public static void main(String[] args) {
        DAO_RandomNumberGenerator DRNG = new DAO_RandomNumberGenerator();
    }
}
