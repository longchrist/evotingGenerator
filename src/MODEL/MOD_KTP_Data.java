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
public class MOD_KTP_Data {
    private int ktp_id;
    private String ktp_no;
    private int ktp_status;
    private String timestamp;

    /**
     * @return the ktp_id
     */
    public int getKtp_id() {
        return ktp_id;
    }

    /**
     * @param ktp_id the ktp_id to set
     */
    public void setKtp_id(int ktp_id) {
        this.ktp_id = ktp_id;
    }

    /**
     * @return the ktp_no
     */
    public String getKtp_no() {
        return ktp_no;
    }

    /**
     * @param ktp_no the ktp_no to set
     */
    public void setKtp_no(String ktp_no) {
        this.ktp_no = ktp_no;
    }

    /**
     * @return the ktp_status
     */
    public int getKtp_status() {
        return ktp_status;
    }

    /**
     * @param ktp_status the ktp_status to set
     */
    public void setKtp_status(int ktp_status) {
        this.ktp_status = ktp_status;
    }

    /**
     * @return the timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
