/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls.gestisciUtenti
 * Type: C_UC_Login
 * Last update: 13-set-2017 0.28.46
 * 
 */

package main.org.bdc.controls.gestisciUtenti;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.security.auth.login.LoginException;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.org.bdc.controls.C_UC_Main;
import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.people.UserRegistered;
import main.org.bdc.view.JFrameLogin;

public class C_UC_Login {

    private String      password;

    private String      user_id;

    private JFrameLogin view;

    public C_UC_Login() {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    C_UC_Login.this.view = new JFrameLogin();
                    C_UC_Login.this.view.setVisible(true);
                    C_UC_Login.this.view.addButtonLoginActionListener(new ButtonLoginActionListener());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private boolean checkFields() {
        return validateUserId() && validatePassword();
    }

    private UserRegistered login(String user_id, String password) throws LoginException {
        return DaoFactory.getInstance().getUserDao().login(user_id, password);
    }

    private boolean validatePassword() {
        JPasswordField fld_pwd = this.view.getPwdPassword();
        if ((this.password = new String(fld_pwd.getPassword())).length() < 5) {
            this.view.setErrorMessage("La password deve contenere almeno 5 caratteri");
            return false;
        }
        return true;
    }

    private boolean validateUserId() {
        JTextField fld_user_id = this.view.getTxtUsername();
        if ((this.user_id = fld_user_id.getText()).length() < 5) {
            this.view.setErrorMessage("Lo user-id deve contenere almeno 5 caratteri");
            return false;
        }
        return true;

    }

    private class ButtonLoginActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (checkFields())
                try {
                    new C_UC_Main(login(C_UC_Login.this.user_id, C_UC_Login.this.password));
                    C_UC_Login.this.view.setVisible(false);
                } catch (LoginException e1) {
                    C_UC_Login.this.view.setErrorMessage(e1.getMessage());
                }

        }

    }
}
