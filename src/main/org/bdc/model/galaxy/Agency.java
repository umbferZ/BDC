
/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy
 * Type: Agency
 * Last update: 10-set-2017 17.30.46
 * 
 */

package main.org.bdc.model.galaxy;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Class Agency.
 */
@Entity
public class Agency {

    @Id
    private String name;

    /**
     * Instantiates a new agency.
     */
    public Agency() {
        super();
    }

    /**
     * Instantiates a new agency.
     *
     * @param name the name
     */
    public Agency(String name) {
        super();
        this.name = name;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

}
