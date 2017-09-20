/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy.pk
 * Type: Position_PK
 * Last update: 20-set-2017 13.23.23
 * 
 */

package main.org.bdc.model.galaxy.pk;

import java.io.Serializable;

/**
 * The Class Position_PK.
 */

public class Position_PK implements Serializable {

    private String source;

    /**
     * Instantiates a new position PK.
     */
    public Position_PK() {}

    /**
     * Gets the source.
     *
     * @return the source
     */
    public String getSource() {
        return this.source;
    }

    /**
     * Sets the source.
     *
     * @param source the new source
     */
    public void setSource(String source) {
        this.source = source;
    }

}