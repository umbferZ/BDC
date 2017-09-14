/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view.manager
 * Type: CJFrameLogin
 * Last update: 14-set-2017 13.36.45
 * 
 */

package main.org.bdc.view.manager;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.security.auth.login.LoginException;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.org.bdc.controls.C_UC_Login;
import main.org.bdc.view.JFrameLogin;

public class CJFrameLogin {

    private String      password;

    private String      user_id;

    private JFrameLogin view;

    public CJFrameLogin() {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    view = new JFrameLogin();
                    view.setVisible(true);
                    view.addButtonLoginActionListener(new ButtonLoginActionListener());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private boolean checkFields() {
        return validateUserId() && validatePassword();
    }

    private boolean validatePassword() {
        JPasswordField fld_pwd = view.getPwdPassword();
        if ((password = new String(fld_pwd.getPassword())).length() < 5) {
            view.setErrorMessage("La password deve contenere almeno 5 caratteri");
            return false;
        }
        return true;
    }

    private boolean validateUserId() {
        JTextField fld_user_id = view.getTxtUsername();
        if ((user_id = fld_user_id.getText()).length() < 5) {
            view.setErrorMessage("Lo user-id deve contenere almeno 5 caratteri");
            return false;
        }
        return true;

    }

    private class ButtonLoginActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (checkFields())
                try {
                    new JFramMainManagerView(C_UC_Login.getInstance().login(user_id, password));
                    view.setVisible(false);
                } catch (LoginException e1) {
                    view.setErrorMessage("Unable to login, wrong user-id or password");
                }

        }

    }
}
