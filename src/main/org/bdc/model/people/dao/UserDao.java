/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.people.dao
 * Type: UserDao
 * Last update: 12-set-2017 23.07.11
 * 
 */

package main.org.bdc.model.people.dao;

import java.util.List;

import javax.persistence.Query;
import javax.security.auth.login.LoginException;

import main.org.bdc.model.people.UserRegistered;
import main.org.bdc.service.dal.EntityDaoHibernate;

/**
 * The Class UserDao.
 */
public class UserDao extends EntityDaoHibernate<UserRegistered, Integer> {

    /**
     * Login.
     *
     * @param userId the username
     * @param password the password
     * @return the utente
     * @throws LoginException the login exception
     */
    @SuppressWarnings("unchecked")
    public UserRegistered login(String userId, String password) throws LoginException {
        String sql = "FROM UserRegistered WHERE userId= :userId AND password= :password";
        Query query = getSession().createQuery(sql);
        query.setParameter("userId", userId);
        query.setParameter("password", password);
        List<UserRegistered> utenti = query.getResultList();
        closeSession();
        if (utenti.size() == 1)
            return utenti.get(0);
        throw new LoginException("Impossibile effettuare il login.userId o password errati");
    }
}
