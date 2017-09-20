/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view.tools
 * Type: CheckerField
 * Last update: 20-set-2017 13.23.23
 * 
 */

package main.org.bdc.view.tools;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * The Class CheckerField.
 */
public class CheckerField {

    /**
     * Check password field.
     *
     * @param jPasswordField the j password field
     * @param leght the leght
     * @return true, if successful
     */
    public static boolean checkPasswordField(JPasswordField jPasswordField, int leght) {
        return true;
    }

    /**
     * Check text field.
     *
     * @param jTextField the j text field
     * @return true, if successful
     */
    public static boolean checkTextField(JTextField jTextField) {
        return checkTextField(jTextField, 0);
    }

    /**
     * Check text field.
     *
     * @param jTextField the j text field
     * @param lenght the lenght
     * @return true, if successful
     */
    public static boolean checkTextField(JTextField jTextField, int lenght) {
        if (jTextField.getText().length() > lenght)
            return true;
        return false;
    }
}
