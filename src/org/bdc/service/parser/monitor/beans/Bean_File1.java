/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor.beans
 * Type: Bean_File1
 * Last update: 11-mar-2017 19.20.51
 * 
 */

package org.bdc.service.parser.monitor.beans;

public class Bean_File1 extends SimpleBean {

    private int clumpId;

    private String clumpType;

    private double density;

    private double latitude;

    private double longitude;

    private double ratioTempMass;

    private double temp;

    public Bean_File1(int clumpId, double longitude, double latitude, double temp, double ratioTempMass, double density, String clumpType) {
        super();
        this.clumpId = clumpId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.temp = temp;
        this.ratioTempMass = ratioTempMass;
        this.density = density;
        this.clumpType = clumpType;
    }

    public int getClumpId() {
        return clumpId;
    }

    public String getClumpType() {
        return clumpType;
    }

    public double getDensity() {
        return density;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getRatioTempMass() {
        return ratioTempMass;
    }

    public double getTemp() {
        return temp;
    }

    public void setClumpId(int clumpId) {
        this.clumpId = clumpId;
    }

    public void setClumpType(String clumpType) {
        this.clumpType = clumpType;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setRatioTempMass(double ratioTempMass) {
        this.ratioTempMass = ratioTempMass;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
}