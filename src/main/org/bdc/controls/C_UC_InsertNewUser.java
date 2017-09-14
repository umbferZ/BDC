/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls
 * Type: C_UC_InsertNewUser
 * Last update: 14-set-2017 13.44.09
 * 
 */

package main.org.bdc.controls;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.people.UserRegistered;
import main.org.bdc.service.dal.exception.SaveDalException;

public class C_UC_InsertNewUser {

    private static C_UC_InsertNewUser instance;

    public static C_UC_InsertNewUser getInstance() {
        if (instance == null)
            instance = new C_UC_InsertNewUser();
        return instance;
    }

    public static void setInstance(C_UC_InsertNewUser instance) {
        C_UC_InsertNewUser.instance = instance;
    }

    private C_UC_InsertNewUser() {}

    public UserRegistered insertUser(UserRegistered userRegistered) throws SaveDalException {
        return DaoFactory.getInstance().getUserDao().save(userRegistered);
    }

}
