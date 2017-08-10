/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.people.dao
 * Type: UserDao
 * Last update: 10-ago-2017 15.46.43
 * 
 */

package main.org.bdc.model.people.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.security.auth.login.LoginException;

import main.org.bdc.model.people.User_Regegistered;
import main.org.bdc.service.dal.EntityDaoHibernate;

/**
 * The Class UserDao.
 */
public class UserDao extends EntityDaoHibernate<User_Regegistered, Integer> {

    /**
     * Login.
     *
     * @param userId the username
     * @param password the password
     * @return the utente
     * @throws LoginException the login exception
     */
    @SuppressWarnings("unchecked")
    public User_Regegistered login(String userId, String password) throws LoginException {
        String sql = "FROM User_Regegistered WHERE userId=:userId AND password=:password";
        TypedQuery<User_Regegistered> query = getSession().createQuery(sql);
        query.setParameter("userId", userId);
        query.setParameter("password", password);
        List<User_Regegistered> utenti = query.getResultList();
        closeSession();
        if (utenti.size() == 1)
            return utenti.get(0);
        throw new LoginException("Impossibile effettuare il login.userId o password errati");
    }
}
