/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity.pk
 * Type: Strumento_PK
 * Last update: 9-mar-2017 15.17.16
 * 
 */
package org.bdc.model.entity.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Strumento_PK implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    protected String nome_strumento;

    protected String satellite_sd;

    public Strumento_PK() {}

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

}
