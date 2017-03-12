/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity.pk
 * Type: Posizione_PK
 * Last update: 12-mar-2017 15.56.02
 * 
 */

package org.bdc.model.entity.pk;

import java.io.Serializable;

public class Posizione_PK implements Serializable {

    protected double lat;

    protected double lon;

    public Posizione_PK() {}

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}