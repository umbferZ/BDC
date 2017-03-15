/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.view
 * Type: JFrameMain
 * Last update: 15-mar-2017 13.46.23
 * 
 */

package org.bdc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * The Class JFrameMain.
 */
public class JFrameMain extends JFrame {

    JLabel         lblWelcome;

    private JPanel contentPane;

    private JMenu  mnUtente;

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                JFrameMain frame = new JFrameMain();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Instantiates a new j frame main.
     */
    public JFrameMain() {
        setTitle("Welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        // setBounds(300, 100, 700, 500);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

        JMenuItem mntmExit = new JMenuItem("Exit");
        mntmExit.addActionListener(e -> {
            int exit = JOptionPane.showConfirmDialog(null, "Sicuro di voler uscire");
            if (exit == JOptionPane.OK_OPTION)
                dispose();

        });
        mnFile.add(mntmExit);

        mnUtente = new JMenu("Utente");
        menuBar.add(mnUtente);

        JMenuItem mntmNuovoUtente = new JMenuItem("Nuovo utente...");
        mntmNuovoUtente.addActionListener(e -> {
            JFrameNuovoUtente frameNuovoUtente = new JFrameNuovoUtente();
            frameNuovoUtente.setVisible(true);
        });
        mnUtente.add(mntmNuovoUtente);

        JMenu mnSatellite = new JMenu("Satellite");
        menuBar.add(mnSatellite);

        JMenuItem mntmNuvoSatellite = new JMenuItem("Nuvo satellite...");
        mntmNuvoSatellite.addActionListener(e -> {
            JFrameInserisciSattellite frameInserisciSattellite = new JFrameInserisciSattellite();
            frameInserisciSattellite.setVisible(true);

        });
        mnSatellite.add(mntmNuvoSatellite);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblWelcome = new JLabel("Welcome...");
        lblWelcome.setBounds(139, 130, 170, 15);
        contentPane.add(lblWelcome);
    }

    /**
     * Welcome.
     *
     * @param name the name
     */
    public void welcome(String name) {
        lblWelcome.setText("Welcome " + name);
    }
}
