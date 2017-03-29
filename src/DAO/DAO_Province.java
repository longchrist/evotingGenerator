/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import MODEL.MOD_Area;
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
public class DAO_Province {
    private Connection conn = null;
    
    public DAO_Province(Connection conn){
        this.conn = conn;
    }
    
    public List<MOD_Province> RetrieveProvinceData(){
        List<MOD_Province> getProvinceData = new ArrayList();
        
        try {
            PreparedStatement ps = this.conn.prepareStatement("SELECT tb_provinsi.provinsi_id, tb_provinsi.provinsi, tb_provinsi.ibukota FROM tb_provinsi");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MOD_Province MP = new MOD_Province();
                MP.setProvince_id(Integer.parseInt(rs.getString(1)));
                MP.setProvince(rs.getString(2));
                MP.setCapital(rs.getString(3));
                getProvinceData.add(MP);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Province.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return getProvinceData;
    }
    
    public List<MOD_Area> RetrieveAreaData(int province_id){
        List<MOD_Area> getAreaData = new ArrayList();
        
        try {
            PreparedStatement ps = this.conn.prepareStatement("SELECT tb_area.area_id, tb_area.province_id, tb_area.area_number, tb_area.area_name FROM tb_area WHERE tb_area.province_id = "+province_id+"");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MOD_Area MA = new MOD_Area();
                MA.setArea_id(rs.getInt(1));
                MA.setProvince_id(rs.getInt(2));
                MA.setArea_number(rs.getInt(3));
                MA.setArea_name(rs.getString(4));
                getAreaData.add(MA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Province.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return getAreaData;
    }
}
