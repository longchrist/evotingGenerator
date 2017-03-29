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
public class MOD_Validator {
    private int validatorId;
    private String provinceName;
    private String areaName;
    private String voteLocation;
    private int numberTPS;
    private int numberPengawas;
    private String imeiPanitiaTPS;
    private String imeiPengawasTPS;
    private String deviceMACAddress;

    /**
     * @return the provinceName
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * @param provinceName the provinceName to set
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     * @return the areaName
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * @param areaName the areaName to set
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * @return the numberTPS
     */
    public int getNumberTPS() {
        return numberTPS;
    }

    /**
     * @param numberTPS the numberTPS to set
     */
    public void setNumberTPS(int numberTPS) {
        this.numberTPS = numberTPS;
    }

    /**
     * @return the numberPengawas
     */
    public int getNumberPengawas() {
        return numberPengawas;
    }

    /**
     * @param numberPengawas the numberPengawas to set
     */
    public void setNumberPengawas(int numberPengawas) {
        this.numberPengawas = numberPengawas;
    }

    /**
     * @return the imeiPanitiaTPS
     */
    public String getImeiPanitiaTPS() {
        return imeiPanitiaTPS;
    }

    /**
     * @param imeiPanitiaTPS the imeiPanitiaTPS to set
     */
    public void setImeiPanitiaTPS(String imeiPanitiaTPS) {
        this.imeiPanitiaTPS = imeiPanitiaTPS;
    }

    /**
     * @return the imeiPengawasTPS
     */
    public String getImeiPengawasTPS() {
        return imeiPengawasTPS;
    }

    /**
     * @param imeiPengawasTPS the imeiPengawasTPS to set
     */
    public void setImeiPengawasTPS(String imeiPengawasTPS) {
        this.imeiPengawasTPS = imeiPengawasTPS;
    }

    /**
     * @return the deviceMACAddress
     */
    public String getDeviceMACAddress() {
        return deviceMACAddress;
    }

    /**
     * @param deviceMACAddress the deviceMACAddress to set
     */
    public void setDeviceMACAddress(String deviceMACAddress) {
        this.deviceMACAddress = deviceMACAddress;
    }

    /**
     * @return the voteLocation
     */
    public String getVoteLocation() {
        return voteLocation;
    }

    /**
     * @param voteLocation the voteLocation to set
     */
    public void setVoteLocation(String voteLocation) {
        this.voteLocation = voteLocation;
    }

    /**
     * @return the validatorId
     */
    public int getValidatorId() {
        return validatorId;
    }

    /**
     * @param validatorId the validatorId to set
     */
    public void setValidatorId(int validatorId) {
        this.validatorId = validatorId;
    }
}
