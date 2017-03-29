/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MODEL;

/**
 *
 * @author Long
 */
public class MOD_Area {
    private int area_id;
    private int province_id;
    private int area_number;
    private String area_name;

    /**
     * @return the area_id
     */
    public int getArea_id() {
        return area_id;
    }

    /**
     * @param area_id the area_id to set
     */
    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    /**
     * @return the province_id
     */
    public int getProvince_id() {
        return province_id;
    }

    /**
     * @param province_id the province_id to set
     */
    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }

    /**
     * @return the area_number
     */
    public int getArea_number() {
        return area_number;
    }

    /**
     * @param area_number the area_number to set
     */
    public void setArea_number(int area_number) {
        this.area_number = area_number;
    }

    /**
     * @return the area_name
     */
    public String getArea_name() {
        return area_name;
    }

    /**
     * @param area_name the area_name to set
     */
    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }
}
