/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.view
 * Type: JFrameMain
 * Last update: 10-ago-2017 14.45.20
 * 
 */

package main.org.bdc.view;

import java.awt.BorderLayout;
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

    JLabel         lbl_welcome;

    private JPanel contentPane;

    private JMenu  mn_utente;

    // /**
    // * The main method.
    // *
    // * @param args the arguments
    // */
    // public static void main(String[] args) {
    // EventQueue.invokeLater(new Runnable() {
    //
    // @Override
    // public void run() {
    // try {
    // JFrameMain frame = new JFrameMain();
    // frame.setVisible(true);
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }
    // });
    // }

    /**
     * Instantiates a new j frame main.
     */
    public JFrameMain() {
        setTitle("Osservatorio Astronomico Virtuale");
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

        mn_utente = new JMenu("UserRegegistered");
        menuBar.add(mn_utente);

        JMenuItem mntmNuovoUtente = new JMenuItem("Nuovo utente...");
        mntmNuovoUtente.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrameNuovoUtente frameNuovoUtente = new JFrameNuovoUtente();
                frameNuovoUtente.setVisible(true);
            }
        });
        mn_utente.add(mntmNuovoUtente);

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

        lbl_welcome = new JLabel("Welcome...");
        lbl_welcome.setFont(new Font("Dialog", Font.PLAIN, 12));
        contentPane.add(lbl_welcome, BorderLayout.SOUTH);
    }

    /**
     * Welcome.
     *
     * @param name the name
     */
    public void welcome(String name) {
        lbl_welcome.setText("Welcome " + name);
    }
}
