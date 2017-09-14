/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view.tools
 * Type: CheckerField
 * Last update: 14-set-2017 14.45.39
 * 
 */

package main.org.bdc.view.tools;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CheckerField {

    public static boolean checkPasswordField(JPasswordField jPasswordField, int leght) {
        return true;
    }

    public static boolean checkTextField(JTextField jTextField) {
        return checkTextField(jTextField, 0);
    }

    public static boolean checkTextField(JTextField jTextField, int lenght) {
        if (jTextField.getText().length() > lenght)
            return true;
        return false;
    }
}
