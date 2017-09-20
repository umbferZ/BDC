/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view.manager
 * Type: CJFrameNewUser
 * Last update: 20-set-2017 13.23.22
 * 
 */

package main.org.bdc.view.manager;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.org.bdc.controls.C_UC_InsertNewUser;
import main.org.bdc.model.people.UserRegistered;
import main.org.bdc.model.people.UserType;
import main.org.bdc.service.dal.exception.SaveDalException;
import main.org.bdc.view.JFrameNuovoUtente;

/**
 * The Class CJFrameNewUser.
 */
public class CJFrameNewUser {

    private String            firstName, lastName, email, password, userId, password_reply;

    private boolean           isAdmin;

    private UserRegistered    userReg;

    private JFrameNuovoUtente view;

    /**
     * Instantiates a new CJ frame new user.
     */
    public CJFrameNewUser() {
        userReg = new UserRegistered();
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    view = new JFrameNuovoUtente();
                    view.setVisible(true);
                    view.addButtonInsertActionListener(new ButtonInsertActionListener());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Check fields.
     *
     * @return true, if successful
     */
    private boolean checkFields() {
        isAdmin = view.getChckbx_admin().isSelected();
        return validateFirstName() && validateLastName() && validateEmail() && validatePassword() && validateUserId();
    }

    /**
     * Validate email.
     *
     * @return true, if successful
     */
    private boolean validateEmail() {
        if ((email = view.getTxt_user_email().getText()).length() < 1) {
            view.setErrorMessage("L'email non può essere vuota");
            return false;
        }
        if (!email.contains("@") && !email.contains(".")) {
            view.setErrorMessage("Formato email non valido");
            return false;
        }
        return true;
    }

    /**
     * Validate first name.
     *
     * @return true, if successful
     */
    private boolean validateFirstName() {
        JTextField txt_user_first_name = view.getTxt_user_first_name();
        if ((firstName = txt_user_first_name.getText()).length() < 1) {
            view.setErrorMessage("Check first name");
            return false;
        }
        return true;
    }

    /**
     * Validate last name.
     *
     * @return true, if successful
     */
    private boolean validateLastName() {
        if ((lastName = view.getTxt_user_last_name().getText()).length() < 1) {
            view.setErrorMessage("Check last name");
            return false;
        }
        return true;
    }

    /**
     * Validate password.
     *
     * @return true, if successful
     */
    private boolean validatePassword() {
        JPasswordField fld_pwd = view.getPwd_password();
        JPasswordField fld_pwd_repeat = view.getPwd_password_reply();
        password_reply = new String(fld_pwd_repeat.getPassword());
        password = new String(fld_pwd.getPassword());
        if (password.length() < 5) {
            view.setErrorMessage("La password deve contenere almeno 6 caratteri");
            return false;
        }
        if (!password.equals(password_reply)) {
            view.setErrorMessage("Le passwords non coincidono");
            return false;
        }
        return true;
    }

    /**
     * Validate user id.
     *
     * @return true, if successful
     */
    private boolean validateUserId() {
        JTextField fld_user_id = view.getTxt_user_id();
        if ((userId = fld_user_id.getText()).length() < 5) {
            view.setErrorMessage("Lo user-id deve contenere almeno 6 caratteri");
            return false;
        }
        return true;

    }

    /**
     * The listener interface for receiving buttonInsertAction events. The class
     * that is interested in processing a buttonInsertAction event implements
     * this interface, and the object created with that class is registered with
     * a component using the component's
     * <code>addButtonInsertActionListener<code> method. When the
     * buttonInsertAction event occurs, that object's appropriate method is
     * invoked.
     *
     * @see ButtonInsertActionEvent
     */
    private class ButtonInsertActionListener implements ActionListener {

        /* (non-Javadoc)
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (checkFields()) {
                userReg.setEmail(email);
                userReg.setFirstName(firstName);
                userReg.setPassword(password);
                userReg.setLastName(lastName);
                userReg.setUserType(isAdmin ? UserType.ADMIN : UserType.USER_REGISTERED);
                userReg.setUserId(userId);
                try {
                    C_UC_InsertNewUser.getInstance().insertUser(userReg);
                    view.setVisible(false);
                } catch (SaveDalException e1) {
                    view.setErrorMessage("Already registered");
                }
            }
        }

    }
}
