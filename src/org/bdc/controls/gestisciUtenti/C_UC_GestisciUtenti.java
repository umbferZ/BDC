
package org.bdc.controls.gestisciUtenti;

import javax.security.auth.login.LoginException;

import org.bdc.model.DaoFactory;
import org.bdc.model.people.Utente;

public class C_UC_GestisciUtenti {

    public Utente login(String username, String password) throws LoginException {
        return DaoFactory.getInstance().getUtenteDao().login(username, password);
    }
}
