/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.controls.gestisciSatellite
 * Type: C_UC_Main
 * Last update: 7-ago-2017 22.36.16
 * 
 */

package main.org.bdc.controls.gestisciSatellite;

import java.awt.EventQueue;

import main.org.bdc.model.people.User_Regegistered;
import main.org.bdc.view.JFrameMain;

public class C_UC_Main {

    private User_Regegistered     user;

    private JFrameMain view;

    public C_UC_Main(User_Regegistered user) {
        this.user = user;
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    view = new JFrameMain();
                    view.setVisible(true);
                    view.welcome(String.format("%s", user.getUserId()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
