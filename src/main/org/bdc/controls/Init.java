/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls
 * Type: Init
 * Last update: 13-set-2017 9.37.53
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
                    new Demo().start(); // todo: remove this line
                    new C_UC_Login();
                    view.setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
