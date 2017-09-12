/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy.pk
 * Type: Ellipse_PK
 * Last update: 12-set-2017 13.00.28
 * 
 */

package main.org.bdc.model.galaxy.pk;

import java.io.Serializable;

public class Ellipse_PK implements Serializable {

    protected int band;

    protected int clump;

    public Ellipse_PK() {
        super();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    public int getBand() {
        return band;
    }

    public int getClump() {
        return clump;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    public void setBand(int band) {
        this.band = band;
    }

    public void setClump(int clump) {
        this.clump = clump;
    }

}
