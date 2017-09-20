/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls
 * Type: Init
 * Last update: 20-set-2017 13.23.24
 * 
 */

package main.org.bdc.controls;

import java.awt.EventQueue;

import main.org.bdc.view.JFrameInit;
import main.org.bdc.view.manager.CJFrameLogin;
import test.Demo;

/**
 * The Class Init.
 */
public class Init {

    private JFrameInit view;

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        new Init().start();
    }

    /**
     * Start.
     */
    public void start() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    view = new JFrameInit();
                    view.setVisible(true);
                    new Demo().start();
                    new CJFrameLogin();
                    view.setVisible(false);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
    }
}
