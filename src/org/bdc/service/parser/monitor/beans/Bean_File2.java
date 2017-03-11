/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor.beans
 * Type: Bean_File2
 * Last update: 11-mar-2017 19.20.50
 * 
 */

package org.bdc.service.parser.monitor.beans;

public class Bean_File2 extends SimpleBean {

    private double alpha_160;

    private double alpha_250;

    private double alpha_350;

    private double alpha_500;

    private double alpha_70;

    private int clumpId;

    private double flow_160;

    private double flow_250;

    private double flow_350;

    private double flow_500;

    private double flow_70;

    private double hMaxAx_160;

    private double hMaxAx_250;

    private double hMaxAx_350;

    private double hMaxAx_500;

    private double hMaxAx_70;

    private double hMinAx_160;

    private double hMinAx_250;

    private double hMinAx_350;

    private double hMinAx_500;

    private double hMinAx_70;

    public Bean_File2(int clumpId, double flow_70, double flow_160, double flow_250, double flow_350, double flow_500, double hMaxAx_70, double hMinAx_70, double hMaxAx_160, double hMinAx_160, double hMaxAx_250, double hMinAx_250, double hMaxAx_350,
            double hMinAx_350, double hMaxAx_500, double hMinAx_500, double alpha_70, double alpha_160, double alpha_250, double alpha_350, double alpha_500) {
        super();
        this.clumpId = clumpId;
        this.flow_70 = flow_70;
        this.flow_160 = flow_160;
        this.flow_250 = flow_250;
        this.flow_350 = flow_350;
        this.flow_500 = flow_500;
        this.hMaxAx_70 = hMaxAx_70;
        this.hMinAx_70 = hMinAx_70;
        this.hMaxAx_160 = hMaxAx_160;
        this.hMinAx_160 = hMinAx_160;
        this.hMaxAx_250 = hMaxAx_250;
        this.hMinAx_250 = hMinAx_250;
        this.hMaxAx_350 = hMaxAx_350;
        this.hMinAx_350 = hMinAx_350;
        this.hMaxAx_500 = hMaxAx_500;
        this.hMinAx_500 = hMinAx_500;
        this.alpha_70 = alpha_70;
        this.alpha_160 = alpha_160;
        this.alpha_250 = alpha_250;
        this.alpha_350 = alpha_350;
        this.alpha_500 = alpha_500;
    }

    public double getAlpha_160() {
        return alpha_160;
    }

    public double getAlpha_250() {
        return alpha_250;
    }

    public double getAlpha_350() {
        return alpha_350;
    }

    public double getAlpha_500() {
        return alpha_500;
    }

    public double getAlpha_70() {
        return alpha_70;
    }

    public int getClumpId() {
        return clumpId;
    }

    public double getFlow_160() {
        return flow_160;
    }

    public double getFlow_250() {
        return flow_250;
    }

    public double getFlow_350() {
        return flow_350;
    }

    public double getFlow_500() {
        return flow_500;
    }

    public double getFlow_70() {
        return flow_70;
    }

    public double gethMaxAx_160() {
        return hMaxAx_160;
    }

    public double gethMaxAx_250() {
        return hMaxAx_250;
    }

    public double gethMaxAx_350() {
        return hMaxAx_350;
    }

    public double gethMaxAx_500() {
        return hMaxAx_500;
    }

    public double gethMaxAx_70() {
        return hMaxAx_70;
    }

    public double gethMinAx_160() {
        return hMinAx_160;
    }

    public double gethMinAx_250() {
        return hMinAx_250;
    }

    public double gethMinAx_350() {
        return hMinAx_350;
    }

    public double gethMinAx_500() {
        return hMinAx_500;
    }

    public double gethMinAx_70() {
        return hMinAx_70;
    }

    public void setAlpha_160(double alpha_160) {
        this.alpha_160 = alpha_160;
    }

    public void setAlpha_250(double alpha_250) {
        this.alpha_250 = alpha_250;
    }

    public void setAlpha_350(double alpha_350) {
        this.alpha_350 = alpha_350;
    }

    public void setAlpha_500(double alpha_500) {
        this.alpha_500 = alpha_500;
    }

    public void setAlpha_70(double alpha_70) {
        this.alpha_70 = alpha_70;
    }

    public void setClumpId(int clumpId) {
        this.clumpId = clumpId;
    }

    public void setFlow_160(double flow_160) {
        this.flow_160 = flow_160;
    }

    public void setFlow_250(double flow_250) {
        this.flow_250 = flow_250;
    }

    public void setFlow_350(double flow_350) {
        this.flow_350 = flow_350;
    }

    public void setFlow_500(double flow_500) {
        this.flow_500 = flow_500;
    }

    public void setFlow_70(double flow_70) {
        this.flow_70 = flow_70;
    }

    public void sethMaxAx_160(double hMaxAx_160) {
        this.hMaxAx_160 = hMaxAx_160;
    }

    public void sethMaxAx_250(double hMaxAx_250) {
        this.hMaxAx_250 = hMaxAx_250;
    }

    public void sethMaxAx_350(double hMaxAx_350) {
        this.hMaxAx_350 = hMaxAx_350;
    }

    public void sethMaxAx_500(double hMaxAx_500) {
        this.hMaxAx_500 = hMaxAx_500;
    }

    public void sethMaxAx_70(double hMaxAx_70) {
        this.hMaxAx_70 = hMaxAx_70;
    }

    public void sethMinAx_160(double hMinAx_160) {
        this.hMinAx_160 = hMinAx_160;
    }

    public void sethMinAx_250(double hMinAx_250) {
        this.hMinAx_250 = hMinAx_250;
    }

    public void sethMinAx_350(double hMinAx_350) {
        this.hMinAx_350 = hMinAx_350;
    }

    public void sethMinAx_500(double hMinAx_500) {
        this.hMinAx_500 = hMinAx_500;
    }

    public void sethMinAx_70(double hMinAx_70) {
        this.hMinAx_70 = hMinAx_70;
    }
}