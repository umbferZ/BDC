/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.parser.monitor.beans
 * Type: Bean_File4
 * Last update: 11-set-2017 15.46.01
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

    private String sourceId_GLIMPSE;

    private String sourceId_MIPSGAL;

    /**
     * Instantiates a new bean file 4.
     *
     * @param sourceId_MIPSGAL the sorgent id MIPSGAL
     * @param longitude the longitude
     * @param latitude the latitude
     * @param flow_24d0 the flow 24 d 0
     * @param error_24d0 the error 24 d 0
     * @param sourceId_GLIMPSE the sorgent id GLIMPSE
     */
    public Bean_File4(String sourceId_MIPSGAL, double longitude, double latitude, double flow_24d0, double error_24d0, String sourcetId_GLIMPSE) {
        super();
        this.sourceId_MIPSGAL = sourceId_MIPSGAL;
        this.longitude = longitude;
        this.latitude = latitude;
        this.flow_24d0 = flow_24d0;
        this.error_24d0 = error_24d0;
        sourceId_GLIMPSE = sourcetId_GLIMPSE;
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
    public String getSourceId_GLIMPSE() {
        return sourceId_GLIMPSE;
    }

    /**
     * Gets the sorgent id MIPSGAL.
     *
     * @return the sorgent id MIPSGAL
     */
    public String getSourceId_MIPSGAL() {
        return sourceId_MIPSGAL;
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
     * Sets the source id MIPSGAL.
     *
     * @param sourceId_MIPSGAL the new source id MIPSGAL
     */
    public void setSourceId_MIPSGAL(String sourceId_MIPSGAL) {
        this.sourceId_MIPSGAL = sourceId_MIPSGAL;
    }

    /**
     * Sets the sorgent id GLIMPSE.
     *
     * @param sourceId_GLIMPSE the new sorgent id GLIMPSE
     */
    public void setSourcetId_GLIMPSE(String sourceId_GLIMPSE) {
        this.sourceId_GLIMPSE = sourceId_GLIMPSE;
    }
}