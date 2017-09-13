/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls.gestisciUtenti
 * Type: C_UC_InsertNewUser
 * Last update: 13-set-2017 0.28.46
 * 
 */

package main.org.bdc.controls;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.people.UserRegistered;
import main.org.bdc.model.people.UserType;
import main.org.bdc.service.dal.exception.SaveOrUpdateDalException;
import main.org.bdc.view.JFrameNuovoUtente;

public class C_UC_InsertNewUser {

    private String            firstName, lastName, email, password, userId, password_reply;

    private boolean           isAdmin;

    private UserRegistered userReg;

    private JFrameNuovoUtente view;

    public C_UC_InsertNewUser() {
        this.userReg = new UserRegistered();
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    C_UC_InsertNewUser.this.view = new JFrameNuovoUtente();
                    C_UC_InsertNewUser.this.view.setVisible(true);
                    C_UC_InsertNewUser.this.view.addButtonInsertActionListener(new ButtonInsertActionListener());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private boolean checkFields() {
        this.isAdmin = this.view.getChckbx_admin().isSelected();
        return validateFirstName() && validateLastName() && validateEmail() && validatePassword() && validateUserId();
    }

    private boolean validateEmail() {
        if ((this.email = this.view.getTxt_user_email().getText()).length() < 1) {
            this.view.setErrorMessage("L'email non può essere vuota");
            return false;
        }
        if (!this.email.contains("@") && !this.email.contains(".")) {
            this.view.setErrorMessage("Formato email non valido");
            return false;
        }
        return true;
    }

    private boolean validateFirstName() {
        JTextField txt_user_first_name = this.view.getTxt_user_first_name();
        if ((this.firstName = txt_user_first_name.getText()).length() < 1) {
            this.view.setErrorMessage("Check first name");
            return false;
        }
        return true;
    }

    private boolean validateLastName() {
        if ((this.lastName = this.view.getTxt_user_last_name().getText()).length() < 1) {
            this.view.setErrorMessage("Check last name");
            return false;
        }
        return true;
    }

    private boolean validatePassword() {
        JPasswordField fld_pwd = this.view.getPwd_password();
        JPasswordField fld_pwd_repeat = this.view.getPwd_password_reply();
        this.password_reply = new String(fld_pwd_repeat.getPassword());
        this.password = new String(fld_pwd.getPassword());
        if (this.password.length() < 5) {
            this.view.setErrorMessage("La password deve contenere almeno 5 caratteri");
            return false;
        }
        if (!this.password.equals(this.password_reply)) {
            this.view.setErrorMessage("Le passwords non coincidono");
            return false;
        }
        return true;
    }

    private boolean validateUserId() {
        JTextField fld_user_id = this.view.getTxt_user_id();
        if ((this.userId = fld_user_id.getText()).length() < 5) {
            this.view.setErrorMessage("Lo user-id deve contenere almeno 5 caratteri");
            return false;
        }
        return true;

    }

    private class ButtonInsertActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (checkFields()) {
                C_UC_InsertNewUser.this.userReg.setEmail(C_UC_InsertNewUser.this.email);
                C_UC_InsertNewUser.this.userReg.setFirstName(C_UC_InsertNewUser.this.firstName);
                C_UC_InsertNewUser.this.userReg.setPassword(C_UC_InsertNewUser.this.password);
                C_UC_InsertNewUser.this.userReg.setLastName(C_UC_InsertNewUser.this.lastName);
                C_UC_InsertNewUser.this.userReg.setUserType(C_UC_InsertNewUser.this.isAdmin ? UserType.ADMIN : UserType.USER_REGISTERED);
                C_UC_InsertNewUser.this.userReg.setUserId(C_UC_InsertNewUser.this.userId);
                try {
                    DaoFactory.getInstance().getUserDao().saveOrUpdate(C_UC_InsertNewUser.this.userReg);
                    C_UC_InsertNewUser.this.view.setVisible(false);

                } catch (SaveOrUpdateDalException e1) {
                    C_UC_InsertNewUser.this.view.setErrorMessage(e1.getMessage());
                }
            }
        }

    }

}
