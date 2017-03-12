/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.people
 * Type: Utente_PK
 * Last update: 12-mar-2017 16.23.01
 * 
 */

package org.bdc.model.people;

import java.io.Serializable;

/**
 * The Class Utente_PK.
 */
public class Utente_PK implements Serializable {

    private String email;

    private String username;

    /**
     * Instantiates a new utente PK.
     */
    public Utente_PK() {
        super();
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the username.
     *
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
