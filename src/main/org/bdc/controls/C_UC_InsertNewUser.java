/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls
 * Type: C_UC_InsertNewUser
 * Last update: 20-set-2017 13.23.21
 * 
 */

package main.org.bdc.controls;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.people.UserRegistered;
import main.org.bdc.service.dal.exception.SaveDalException;

/**
 * The Class C_UC_InsertNewUser.
 */
public class C_UC_InsertNewUser {

    private static C_UC_InsertNewUser instance;

    /**
     * Gets the single instance of C_UC_InsertNewUser.
     *
     * @return single instance of C_UC_InsertNewUser
     */
    public static C_UC_InsertNewUser getInstance() {
        if (instance == null)
            instance = new C_UC_InsertNewUser();
        return instance;
    }

    /**
     * Sets the instance.
     *
     * @param instance the new instance
     */
    public static void setInstance(C_UC_InsertNewUser instance) {
        C_UC_InsertNewUser.instance = instance;
    }

    /**
     * Instantiates a new c U C insert new user.
     */
    private C_UC_InsertNewUser() {}

    /**
     * Insert user.
     *
     * @param userRegistered the user registered
     * @return the user registered
     * @throws SaveDalException the save dal exception
     */
    /* REQ 03.2 */
    public UserRegistered insertUser(UserRegistered userRegistered) throws SaveDalException {
        return DaoFactory.getInstance().getUserDao().save(userRegistered);
    }

}
