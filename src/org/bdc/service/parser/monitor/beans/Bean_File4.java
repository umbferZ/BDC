/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor.beans
 * Type: Bean_File4
 * Last update: 11-mar-2017 19.20.50
 * 
 */

package org.bdc.service.parser.monitor.beans;

public class Bean_File4 extends SimpleBean {

    private double error_24d0;

    private double flow_24d0;

    private double latitude;

    private double longitude;

    private String sorgentId_GLIMPSE;

    private String sorgentId_MIPSGAL;

    public Bean_File4(String sorgentId_MIPSGAL, double longitude, double latitude, double flow_24d0, double error_24d0, String sorgentId_GLIMPSE) {
        super();
        this.sorgentId_MIPSGAL = sorgentId_MIPSGAL;
        this.longitude = longitude;
        this.latitude = latitude;
        this.flow_24d0 = flow_24d0;
        this.error_24d0 = error_24d0;
        this.sorgentId_GLIMPSE = sorgentId_GLIMPSE;
    }

    public double getError_24d0() {
        return error_24d0;
    }

    public double getFlow_24d0() {
        return flow_24d0;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getSorgentId_GLIMPSE() {
        return sorgentId_GLIMPSE;
    }

    public String getSorgentId_MIPSGAL() {
        return sorgentId_MIPSGAL;
    }

    public void setError_24d0(double error_24d0) {
        this.error_24d0 = error_24d0;
    }

    public void setFlow_24d0(double flow_24d0) {
        this.flow_24d0 = flow_24d0;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setSorgentId_GLIMPSE(String sorgentId_GLIMPSE) {
        this.sorgentId_GLIMPSE = sorgentId_GLIMPSE;
    }

    public void setSorgentId_MIPSGAL(String sorgentId_MIPSGAL) {
        this.sorgentId_MIPSGAL = sorgentId_MIPSGAL;
    }
}