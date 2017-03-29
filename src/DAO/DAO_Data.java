/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Long
 */
public class DAO_Data {
    private Connection conn = null;
    
    public DAO_Data(Connection conn){
        this.conn = conn;
    }
    
    public int SaveQRData(String rawData){
        int qrDataLastID = 0;
        
        String rawQRData = rawData;
        Date dateNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String timestamp = ft.format(dateNow);
      
        try {
            PreparedStatement ps = this.conn.prepareStatement("INSERT tb_raw_data (raw_data_id, raw_data, timestamp) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, null);
            ps.setString(2, rawQRData);
            ps.setString(3, timestamp);
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            
            if (generatedKeys.next()) {
                qrDataLastID = generatedKeys.getInt(1);
            } else {
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return qrDataLastID;
    }
    
}
