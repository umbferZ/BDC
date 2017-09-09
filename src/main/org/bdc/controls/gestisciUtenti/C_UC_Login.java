/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.controls.gestisciUtenti
 * Type: C_UC_Login
 * Last update: 9-set-2017 15.37.25
 * 
 */

package main.org.bdc.controls.gestisciUtenti;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.security.auth.login.LoginException;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.org.bdc.controls.gestisciSatellite.C_UC_Main;
import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.people.User_Regegistered;
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

    private User_Regegistered login(String user_id, String password) throws LoginException {
        return DaoFactory.getInstance().getUserDao().login(user_id, password);
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
                    new C_UC_Main(login(user_id, password));
                    view.setVisible(false);
                } catch (LoginException e1) {
                    view.setErrorMessage(e1.getMessage());
                }

        }

    }
}
