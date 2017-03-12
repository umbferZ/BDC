/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.people.dao
 * Type: UtenteDao
 * Last update: 12-mar-2017 16.23.00
 * 
 */

package org.bdc.model.people.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.security.auth.login.LoginException;

import org.bdc.model.people.Utente;
import org.bdc.service.dal.EntityDaoHibernate;

/**
 * The Class UtenteDao.
 */
public class UtenteDao extends EntityDaoHibernate<Utente, Integer> {

    /**
     * Login.
     *
     * @param username the username
     * @param password the password
     * @return the utente
     * @throws LoginException the login exception
     */
    @SuppressWarnings("unchecked")
    public Utente login(String username, String password) throws LoginException {
        String sql = "FROM Utente WHERE username=:username AND password=:password";
        TypedQuery<Utente> query = getSession().createQuery(sql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        List<Utente> utenti = query.getResultList();
        closeSession();
        if (utenti.size() == 1)
            return utenti.get(0);
        throw new LoginException("username o password errati");
    }
}
