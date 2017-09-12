/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy.pk
 * Type: Position_PK
 * Last update: 13-set-2017 0.27.04
 * 
 */

package main.org.bdc.model.galaxy.pk;

import java.io.Serializable;

/**
 * The Class Position_PK.
 */

public class Position_PK implements Serializable {

    private String source;

    public Position_PK() {}

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}