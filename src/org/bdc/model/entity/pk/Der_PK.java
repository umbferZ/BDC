/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.entity.pk
 * Type: Der_PK
 * Last update: 8-mar-2017 14.11.14
 * 
 */
package org.bdc.model.entity.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class Der_PK implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    protected String satellite_nome;

    public Der_PK() {
        super();
    }

}
