/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls
 * Type: C_UC_Login
 * Last update: 20-set-2017 13.23.23
 * 
 */

package main.org.bdc.controls;

import javax.security.auth.login.LoginException;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.people.UserRegistered;

/**
 * The Class C_UC_Login.
 */
public class C_UC_Login {

    private static C_UC_Login instance;

    /**
     * Gets the single instance of C_UC_Login.
     *
     * @return single instance of C_UC_Login
     */
    public synchronized static C_UC_Login getInstance() {
        if (instance == null)
            instance = new C_UC_Login();
        return instance;
    }

    /**
     * Instantiates a new c U C login.
     */
    private C_UC_Login() {
    }

    /**
     * Login.
     *
     * @param user_id the user id
     * @param password the password
     * @return the user registered
     * @throws LoginException the login exception
     */
    /* REQ 01 */
    public UserRegistered login(String user_id, String password) throws LoginException {
        return DaoFactory.getInstance().getUserDao().login(user_id, password);
    }
}
