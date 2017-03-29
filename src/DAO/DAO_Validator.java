/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import MODEL.MOD_Validator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Long
 */
public class DAO_Validator {
    private Connection conn = null;
    
    public DAO_Validator(Connection conn){
        this.conn = conn;
    }
    
    public int SaveInitialData(String voteLocation, int tps_sum_key, int pengawas_sum_key){
        int qrDataLastID = 0;
      
        try {
            PreparedStatement ps = this.conn.prepareStatement("INSERT tb_validate_device (validate_device_id, vote_location, tps_imei, pengawas_imei, device_mac_address, is_validate_tps, validate_tps_ts, is_validate_pengawas, validate_pengawas_ts, is_validate_device, validate_device_ts, tps_number, pengawas_number) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, null);
            ps.setString(2, voteLocation);
            ps.setString(3, "0");
            ps.setString(4, "0");
            ps.setString(5, "0");
            ps.setBoolean(6, false);
            ps.setString(7, "0000-00-00 00:00:00");
            ps.setBoolean(8, false);
            ps.setString(9, "0000-00-00 00:00:00");
            ps.setBoolean(10, false);
            ps.setString(11, "0000-00-00 00:00:00");
            ps.setInt(12, tps_sum_key);
            ps.setInt(13, pengawas_sum_key);
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
    
    public boolean updateImeiInformation(int validateDeviceID, String panitiaTPSImei, String pengawasImei, String deviceMacAddress){
        boolean result = false;
      
        try {
            PreparedStatement ps = this.conn.prepareStatement("UPDATE tb_validate_device SET tps_imei = '"+panitiaTPSImei+"', pengawas_imei = '"+pengawasImei+"', device_mac_address = '"+deviceMacAddress+"' WHERE validate_device_id = '"+validateDeviceID+"';");
            if(ps.executeUpdate() > 0){
                result = true;
            } else {
                result = false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
    
    public List<MOD_Validator> getAllValidator(String voteLocation){
        List<MOD_Validator> getData = new ArrayList();
        String provinceId = voteLocation.substring(0, 2);
        String areaId = voteLocation.substring(2, 4);
        try {
            PreparedStatement ps = this.conn.prepareStatement("SELECT tb_validate_device.validate_device_id, (SELECT tb_provinsi.provinsi FROM tb_provinsi WHERE tb_provinsi.provinsi_id = '"+provinceId+"') AS Provinsi, (SELECT tb_area.area_name FROM tb_area WHERE tb_area.province_id = '"+provinceId+"' AND tb_area.area_number = '"+areaId+"') AS Area, tb_validate_device.tps_imei, tb_validate_device.pengawas_imei, tb_validate_device.device_mac_address, tb_key_data.vote_location, tb_tps_key.tps_sum_key, tb_pengawas_key.pengawas_sum_key\n" +
                                                                "FROM tb_validate_device LEFT JOIN tb_key_data ON tb_validate_device.vote_location = tb_key_data.vote_location\n" +
                                                                "LEFT JOIN tb_tps_key ON tb_key_data.tps_key_id = tb_tps_key.tps_key_id\n" +
                                                                "LEFT JOIN tb_pengawas_key ON tb_key_data.pengawas_key_id = tb_pengawas_key.pengawas_key_id\n" +
                                                                "WHERE tb_key_data.vote_location LIKE '"+voteLocation+"%' GROUP BY tb_validate_device.validate_device_id;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MOD_Validator MV = new MOD_Validator();
                MV.setValidatorId(Integer.parseInt(rs.getString(1)));
                MV.setProvinceName(rs.getString(2));
                MV.setAreaName(rs.getString(3));
                MV.setImeiPanitiaTPS(rs.getString(4));
                MV.setImeiPengawasTPS(rs.getString(5));
                MV.setDeviceMACAddress(rs.getString(6));
                MV.setVoteLocation(rs.getString(7));
                MV.setNumberTPS(Integer.parseInt(rs.getString(8)));
                MV.setNumberPengawas(Integer.parseInt(rs.getString(9)));
                getData.add(MV);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Validator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DAO_Validator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getData;
    }
    
    public boolean FindExistingVoteLocation(String voteLocation6Digit, int sum_tps_key, int sum_pengawas_key){
        boolean result = false;
        String provinceId = voteLocation6Digit.substring(0, 2);
        String areaId = voteLocation6Digit.substring(2, 4);
        String specificAreaId = voteLocation6Digit.substring(4,6);
        try {
            PreparedStatement ps = this.conn.prepareStatement("SELECT tb_validate_device.vote_location FROM tb_validate_device WHERE tb_validate_device.vote_location = '"+voteLocation6Digit+"' AND tb_validate_device.tps_number = '"+sum_tps_key+"' AND tb_validate_device.pengawas_number = '"+sum_pengawas_key+"'");
            ResultSet rs = ps.executeQuery();
            int count = 0;
            if(!rs.next()){
                result = true;
            } else {
                result = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Validator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DAO_Validator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
