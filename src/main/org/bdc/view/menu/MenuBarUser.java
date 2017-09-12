/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view.menu
 * Type: MenuBarUser
 * Last update: 13-set-2017 0.30.22
 * 
 */

package main.org.bdc.view.menu;

public class MenuBarUser extends MenuBarAdmin {

    public MenuBarUser() {
        super.getMntm_upload().setEnabled(false);
    }

}
