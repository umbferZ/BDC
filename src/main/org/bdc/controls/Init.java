/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls
 * Type: Init
 * Last update: 14-set-2017 3.36.29
 * 
 */

package main.org.bdc.controls;

import java.awt.EventQueue;

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
                    System.out.println(e.getMessage());
                }
            }
        });
    }
}
