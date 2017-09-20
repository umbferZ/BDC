/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.service.parser.monitor.beans
 * Type: Bean_File1
 * Last update: 20-set-2017 13.23.22
 * 
 */

package main.org.bdc.service.parser.monitor.beans;

/**
 * The Class Bean_File1.
 */
public class Bean_File1 extends SimpleBean {

    private int    clumpId;

    private int    clumpType;

    private double density;

    private double latitude;

    private double longitude;

    private double ratioTempMass;

    private double temp;

    /**
     * Instantiates a new bean file 1.
     *
     * @param clumpId the clump id
     * @param longitude the longitude
     * @param latitude the latitude
     * @param temp the temp
     * @param ratioTempMass the ratio temp mass
     * @param density the density
     * @param clumpType the clump type
     */
    public Bean_File1(int clumpId, double longitude, double latitude, double temp, double ratioTempMass, double density, int clumpType) {
        super();
        this.clumpId = clumpId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.temp = temp;
        this.ratioTempMass = ratioTempMass;
        this.density = density;
        this.clumpType = clumpType;
    }

    /**
     * Gets the clump id.
     *
     * @return the clump id
     */
    public int getClumpId() {
        return this.clumpId;
    }

    /**
     * Gets the clump type.
     *
     * @return the clump type
     */
    public int getClumpType() {
        return this.clumpType;
    }

    /**
     * Gets the density.
     *
     * @return the density
     */
    public double getDensity() {
        return this.density;
    }

    /**
     * Gets the latitude.
     *
     * @return the latitude
     */
    public double getLatitude() {
        return this.latitude;
    }

    /**
     * Gets the longitude.
     *
     * @return the longitude
     */
    public double getLongitude() {
        return this.longitude;
    }

    /**
     * Gets the ratio temp mass.
     *
     * @return the ratio temp mass
     */
    public double getRatioTempMass() {
        return this.ratioTempMass;
    }

    /**
     * Gets the temp.
     *
     * @return the temp
     */
    public double getTemp() {
        return this.temp;
    }

    /**
     * Sets the clump id.
     *
     * @param clumpId the new clump id
     */
    public void setClumpId(int clumpId) {
        this.clumpId = clumpId;
    }

    /**
     * Sets the clump type.
     *
     * @param clumpType the new clump type
     */
    public void setClumpType(int clumpType) {
        this.clumpType = clumpType;
    }

    /**
     * Sets the density.
     *
     * @param density the new density
     */
    public void setDensity(double density) {
        this.density = density;
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
     * Sets the ratio temp mass.
     *
     * @param ratioTempMass the new ratio temp mass
     */
    public void setRatioTempMass(double ratioTempMass) {
        this.ratioTempMass = ratioTempMass;
    }

    /**
     * Sets the temp.
     *
     * @param temp the new temp
     */
    public void setTemp(double temp) {
        this.temp = temp;
    }
}