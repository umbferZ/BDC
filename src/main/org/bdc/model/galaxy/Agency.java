
/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy
 * Type: Agency
 * Last update: 8-set-2017 15.55.28
 * 
 */

package main.org.bdc.model.galaxy;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Enum Agency.
 */
@Entity
public class Agency {

    @Id
    private String name;

    public Agency() {
        super();
    }

    public Agency(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
