/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy.pk
 * Type: ClumpDetails_PK
 * Last update: 20-set-2017 13.23.24
 * 
 */

package main.org.bdc.model.galaxy.pk;

import java.io.Serializable;

/**
 * The Class ClumpDetails_PK.
 */
public class ClumpDetails_PK implements Serializable {

    private int clump;

    /**
     * Instantiates a new clump details PK.
     */
    public ClumpDetails_PK() {}

    /**
     * Gets the clump.
     *
     * @return the clump
     */
    public int getClump() {
        return this.clump;
    }

    /**
     * Sets the clump.
     *
     * @param clump the new clump
     */
    public void setClump(int clump) {
        this.clump = clump;
    }

}
