/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view.menu
 * Type: MenuBarUser
 * Last update: 20-set-2017 13.23.25
 * 
 */

package main.org.bdc.view.menu;

/**
 * The Class MenuBarUser.
 */
public class MenuBarUser extends MenuBarAdmin {

    /**
     * Instantiates a new menu bar user.
     */
    public MenuBarUser() {
        super.getMntm_upload().setEnabled(false);
    }

}
