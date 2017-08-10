/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.parser.monitor.beans
 * Type: Bean_File4
 * Last update: 12-mar-2017 16.25.12
 * 
 */

package main.org.bdc.service.parser.monitor.beans;

/**
 * The Class Bean_File4.
 */
public class Bean_File4 extends SimpleBean {

    private double error_24d0;

    private double flow_24d0;

    private double latitude;

    private double longitude;

    private String sorgentId_GLIMPSE;

    private String sorgentId_MIPSGAL;

    /**
     * Instantiates a new bean file 4.
     *
     * @param sorgentId_MIPSGAL the sorgent id MIPSGAL
     * @param longitude the longitude
     * @param latitude the latitude
     * @param flow_24d0 the flow 24 d 0
     * @param error_24d0 the error 24 d 0
     * @param sorgentId_GLIMPSE the sorgent id GLIMPSE
     */
    public Bean_File4(String sorgentId_MIPSGAL, double longitude, double latitude, double flow_24d0, double error_24d0, String sorgentId_GLIMPSE) {
        super();
        this.sorgentId_MIPSGAL = sorgentId_MIPSGAL;
        this.longitude = longitude;
        this.latitude = latitude;
        this.flow_24d0 = flow_24d0;
        this.error_24d0 = error_24d0;
        this.sorgentId_GLIMPSE = sorgentId_GLIMPSE;
    }

    /**
     * Gets the error 24 d 0.
     *
     * @return the error 24 d 0
     */
    public double getError_24d0() {
        return error_24d0;
    }

    /**
     * Gets the flow 24 d 0.
     *
     * @return the flow 24 d 0
     */
    public double getFlow_24d0() {
        return flow_24d0;
    }

    /**
     * Gets the latitude.
     *
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Gets the longitude.
     *
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Gets the sorgent id GLIMPSE.
     *
     * @return the sorgent id GLIMPSE
     */
    public String getSorgentId_GLIMPSE() {
        return sorgentId_GLIMPSE;
    }

    /**
     * Gets the sorgent id MIPSGAL.
     *
     * @return the sorgent id MIPSGAL
     */
    public String getSorgentId_MIPSGAL() {
        return sorgentId_MIPSGAL;
    }

    /**
     * Sets the error 24 d 0.
     *
     * @param error_24d0 the new error 24 d 0
     */
    public void setError_24d0(double error_24d0) {
        this.error_24d0 = error_24d0;
    }

    /**
     * Sets the flow 24 d 0.
     *
     * @param flow_24d0 the new flow 24 d 0
     */
    public void setFlow_24d0(double flow_24d0) {
        this.flow_24d0 = flow_24d0;
    }

    /**
     * Sets the latitude.
     *
     * @param latitude the new latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Sets the longitude.
     *
     * @param longitude the new longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Sets the sorgent id GLIMPSE.
     *
     * @param sorgentId_GLIMPSE the new sorgent id GLIMPSE
     */
    public void setSorgentId_GLIMPSE(String sorgentId_GLIMPSE) {
        this.sorgentId_GLIMPSE = sorgentId_GLIMPSE;
    }

    /**
     * Sets the sorgent id MIPSGAL.
     *
     * @param sorgentId_MIPSGAL the new sorgent id MIPSGAL
     */
    public void setSorgentId_MIPSGAL(String sorgentId_MIPSGAL) {
        this.sorgentId_MIPSGAL = sorgentId_MIPSGAL;
    }
}