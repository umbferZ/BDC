/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor.beans
 * Type: Bean_File3
 * Last update: 11-mar-2017 19.20.51
 * 
 */

package org.bdc.service.parser.monitor.beans;

public class Bean_File3 extends SimpleBean {

    private double flow_3d6;

    private double flow_4d5;

    private double flow_5d8;

    private double flow_8d0;

    private double latitude;

    private double longitude;

    private String sotgentId;

    public Bean_File3(String sotgentId, double longitude, double latitude, double flow_3d6, double flow_4d5, double flow_5d8, double flow_8d0) {
        super();
        this.sotgentId = sotgentId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.flow_3d6 = flow_3d6;
        this.flow_4d5 = flow_4d5;
        this.flow_5d8 = flow_5d8;
        this.flow_8d0 = flow_8d0;
    }

    public double getFlow_3d6() {
        return flow_3d6;
    }

    public double getFlow_4d5() {
        return flow_4d5;
    }

    public double getFlow_5d8() {
        return flow_5d8;
    }

    public double getFlow_8d0() {
        return flow_8d0;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getSotgentId() {
        return sotgentId;
    }

    public void setFlow_3d6(double flow_3d6) {
        this.flow_3d6 = flow_3d6;
    }

    public void setFlow_4d5(double flow_4d5) {
        this.flow_4d5 = flow_4d5;
    }

    public void setFlow_5d8(double flow_5d8) {
        this.flow_5d8 = flow_5d8;
    }

    public void setFlow_8d0(double flow_8d0) {
        this.flow_8d0 = flow_8d0;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setSotgentId(String sotgentId) {
        this.sotgentId = sotgentId;
    }
}