/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy.pk
 * Type: Position_PK
 * Last update: 11-set-2017 12.36.45
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
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}