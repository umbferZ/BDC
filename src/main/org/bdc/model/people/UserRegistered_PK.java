/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.people
 * Type: UserRegistered_PK
 * Last update: 20-set-2017 13.23.24
 * 
 */

package main.org.bdc.model.people;

import java.io.Serializable;

/**
 * The Class UserRegistered_PK.
 */
public class UserRegistered_PK implements Serializable {

    private String email;

    private String userId;

    /**
     * Instantiates a new user registered PK.
     */
    public UserRegistered_PK() {
        super();
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    public String getUserId() {
        return this.userId;
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
     * Sets the user id.
     *
     * @param userId the new user id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
