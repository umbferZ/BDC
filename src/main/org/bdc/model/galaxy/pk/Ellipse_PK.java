/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy.pk
 * Type: Ellipse_PK
 * Last update: 13-set-2017 17.50.39
 * 
 */

package main.org.bdc.model.galaxy.pk;

import java.io.Serializable;

public class Ellipse_PK implements Serializable {

    protected int band;

    protected int clump;

    public Ellipse_PK() {}

    public int getBand() {
        return band;
    }

    public int getClump() {
        return clump;
    }

    public void setBand(int band) {
        this.band = band;
    }

    public void setClump(int clump) {
        this.clump = clump;
    }

}
