/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.view
 * Type: JFrameMain
 * Last update: 17-mar-2017 7.53.09
 * 
 */

package org.bdc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    JFrameMain frame = new JFrameMain();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Instantiates a new j frame main.
     */
    public JFrameMain() {
        setTitle("Welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 500);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

        JMenuItem mntmExit = new JMenuItem("Exit");
        mntmExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int exit = JOptionPane.showConfirmDialog(null, "Sicuro di voler uscire");
                if (exit == JOptionPane.OK_OPTION)
                    System.exit(0);

            }
        });
        mnFile.add(mntmExit);

        mnUtente = new JMenu("Utente");
        menuBar.add(mnUtente);

        JMenuItem mntmNuovoUtente = new JMenuItem("Nuovo utente...");
        mntmNuovoUtente.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrameNuovoUtente frameNuovoUtente = new JFrameNuovoUtente();
                frameNuovoUtente.setVisible(true);
            }
        });
        mnUtente.add(mntmNuovoUtente);

        JMenu mnSatellite = new JMenu("Satellite");
        menuBar.add(mnSatellite);

        JMenuItem mntmNuvoSatellite = new JMenuItem("Nuvo satellite...");
        mntmNuvoSatellite.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrameInserisciSattellite frameInserisciSattellite = new JFrameInserisciSattellite();
                frameInserisciSattellite.setVisible(true);
            }
        });
        mnSatellite.add(mntmNuvoSatellite);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        lblWelcome = new JLabel("Welcome...");
        lblWelcome.setFont(new Font("Dialog", Font.PLAIN, 12));
        contentPane.add(lblWelcome, BorderLayout.SOUTH);
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
