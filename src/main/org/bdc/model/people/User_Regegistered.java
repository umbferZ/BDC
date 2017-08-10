/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.people
 * Type: User_Regegistered
 * Last update: 10-ago-2017 16.12.15
 * 
 */

package main.org.bdc.model.people;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * The Class User_Regegistered.
 */
@Entity
@IdClass(User_Regegistered_PK.class)
public class User_Regegistered {

    @Id
    private String   email;

    private String   firstName;

    private String   lastName;

    private String   password;

    @Id
    private String   userId;

    @Enumerated(EnumType.ORDINAL)
    private UserType userType;

    /**
     * Instantiates a new utente.
     */
    public User_Regegistered() {
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
     * Gets the firstName.
     *
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the lastName.
     *
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
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
     * Gets the tipo utente.
     *
     * @return the tipo utente
     */
    public UserType getUserType() {
        return userType;
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
     * Sets the firstName.
     *
     * @param firstName the new firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the lastName.
     *
     * @param lastName the new lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the userId.
     *
     * @param userId the new userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Sets the tipo utente.
     *
     * @param userType the new tipo utente
     */
    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
