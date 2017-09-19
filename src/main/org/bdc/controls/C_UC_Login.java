/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls
 * Type: C_UC_Login
 * Last update: 14-set-2017 13.37.12
 * 
 */

package main.org.bdc.controls;

import javax.security.auth.login.LoginException;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.people.UserRegistered;

public class C_UC_Login {

    private static C_UC_Login instance;

    public synchronized static C_UC_Login getInstance() {
        if (instance == null)
            instance = new C_UC_Login();
        return instance;
    }

    private C_UC_Login() {
    }

    /* REQ 01 */
    public UserRegistered login(String user_id, String password) throws LoginException {
        return DaoFactory.getInstance().getUserDao().login(user_id, password);
    }
}
