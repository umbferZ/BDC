/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view
 * Type: MainActivity_old
 * Last update: 13-set-2017 0.23.41
 * 
 */

package main.org.bdc.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@Deprecated
public class MainActivity_old {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                try {
                    MainActivity_old window = new MainActivity_old();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MainActivity_old() {
        initialize();
    }

    /**
     * Initialize.
     */
    private void initialize() {

        this.frame = new JFrame();
        this.frame.setBounds(100, 100, 450, 300);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        this.frame.setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("New menu");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
        mntmNewMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
        mnNewMenu.add(mntmNewMenuItem_2);
        this.frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        this.frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new CardLayout(0, 0));

        InserisciSatellite inserisciSatellitePanel = new InserisciSatellite();
        panel.add(inserisciSatellitePanel, "InserisciSatellite");

        JPanel panel_1 = new JPanel();
        this.frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
    }

}
