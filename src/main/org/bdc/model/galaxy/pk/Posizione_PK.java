/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy.pk
 * Type: Posizione_PK
 * Last update: 9-set-2017 13.41.03
 * 
 */

package main.org.bdc.model.galaxy.pk;

import java.io.Serializable;

/**
 * The Class Posizione_PK.
 */
@Deprecated
public class Posizione_PK implements Serializable {

    protected double lat;

    protected double lon;

    /**
     * Instantiates a new posizione PK.
     */
    public Posizione_PK() {}

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}