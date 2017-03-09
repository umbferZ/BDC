
/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity
 * Type: Agenzia
 * Last update: 9-mar-2017 15.17.16
 * 
 */
package org.bdc.model.entity;

/**
 * The Enum Agenzia.
 */
public enum Agenzia {
    ESA("ESA"), NASA("NASA");

    private String agenzia;

    Agenzia(String agenzia) {
        this.agenzia = agenzia;
    };

    @Override
    public String toString() {
        return agenzia;
    }
}