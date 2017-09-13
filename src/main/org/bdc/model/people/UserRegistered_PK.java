/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.people
 * Type: UserRegegistered_PK
 * Last update: 13-set-2017 0.25.20
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
     * Instantiates a new utente PK.
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
     * Gets the userId.
     *
     * @return the userId
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
     * Sets the userId.
     *
     * @param userId the new userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
