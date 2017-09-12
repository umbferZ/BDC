
/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy
 * Type: Agency
 * Last update: 13-set-2017 0.26.51
 * 
 */

package main.org.bdc.model.galaxy;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Class Agency.
 */
@Entity
public class Agency implements Serializable {

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
