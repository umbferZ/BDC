/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy.pk
 * Type: ClumpDetails_PK
 * Last update: 13-set-2017 0.27.04
 * 
 */

package main.org.bdc.model.galaxy.pk;

import java.io.Serializable;

public class ClumpDetails_PK implements Serializable {

    private int clump;

    public ClumpDetails_PK() {}

    public int getClump() {
        return this.clump;
    }

    public void setClump(int clump) {
        this.clump = clump;
    }

}
