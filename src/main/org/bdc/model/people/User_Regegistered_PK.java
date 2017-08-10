/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.people
 * Type: User_Regegistered_PK
 * Last update: 12-mar-2017 16.23.01
 * 
 */

package main.org.bdc.model.people;

import java.io.Serializable;

/**
 * The Class User_Regegistered_PK.
 */
public class User_Regegistered_PK implements Serializable {

    private String email;

    private String userId;

    /**
     * Instantiates a new utente PK.
     */
    public User_Regegistered_PK() {
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
     * Gets the userId.
     *
     * @return the userId
     */
    public String getUserId() {
        return userId;
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
