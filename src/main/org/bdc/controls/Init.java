/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.controls
 * Type: Init
 * Last update: 10-ago-2017 17.19.22
 * 
 */

package main.org.bdc.controls;

import java.awt.EventQueue;

import main.org.bdc.controls.gestisciUtenti.C_UC_Login;
import main.org.bdc.view.JFrameInit;
import test.Demo;

public class Init {

    private JFrameInit view;

    public static void main(String[] args) {
        new Init().start();
    }

    public void start() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    view = new JFrameInit();
                    view.setVisible(true);
                    new Demo().start();
                    new C_UC_Login();
                    view.setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
