/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls
 * Type: C_UC_Main
 * Last update: 14-set-2017 0.58.39
 * 
 */

package main.org.bdc.controls;

import java.awt.EventQueue;

import main.org.bdc.model.people.UserRegistered;
import main.org.bdc.view.JFrameMain;

@Deprecated
public class C_UC_Main {

    private UserRegistered user;

    private JFrameMain     view;

    public C_UC_Main(UserRegistered user) {
        this.user = user;
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    view = new JFrameMain();
                    /*
                     * if (user.getUserType() == UserType.ADMIN)
                     * view.setJMenuBar(new MenuBarAdmin()); else
                     * view.setJMenuBar(new MenuBarUser());
                     */
                    view.setVisible(true);
                    view.setStatusBarMessage(String.format("%s", user.getUserId()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
