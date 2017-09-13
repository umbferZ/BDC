/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view
 * Type: JFrameMain
 * Last update: 13-set-2017 23.54.33
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

import main.org.bdc.controls.C_UC_ImportFile;
import main.org.bdc.controls.C_UC_InsertNewUser;
import main.org.bdc.controls.C_UC_SearchObjectsInRegionByPosition;

/**
 * The Class JFrameMain.
 */
public class JFrameMain extends JFrame {

    private JPanel contentPane;

    private JLabel lbl_welcome;

    private JMenu  mn_utente;

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

        JMenu mnUploadFiles = new JMenu("Upload"); // ho creato questo menu
        mnFile.add(mnUploadFiles);

        JMenuItem mntmUpload = new JMenuItem("Higal");

        mntmUpload.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ev) {
                C_UC_ImportFile c_uc_importFile = C_UC_ImportFile.getInstance();
                c_uc_importFile.importFile();
            }
        });
        // admin
        JMenuItem mntmExit = new JMenuItem("Exit");

        mnUploadFiles.add(mntmUpload); // il nuovo menu lo inserisco i un altro

        JMenuItem mntmHigalAddictional = new JMenuItem("Higal Addictional");
        mnUploadFiles.add(mntmHigalAddictional);

        JMenuItem mntmMips = new JMenuItem("Glimpse");
        mnUploadFiles.add(mntmMips);

        JMenuItem mntmMipsgal = new JMenuItem("MIPS-GAL");
        mnUploadFiles.add(mntmMipsgal);
        // menu
        mnFile.add(mntmExit);

        mntmExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int exit = JOptionPane.showConfirmDialog(null, "Are you sure?");
                if (exit == JOptionPane.OK_OPTION)
                    System.exit(0);
            }
        });

        mn_utente = new JMenu("Users");
        menuBar.add(mn_utente);

        JMenuItem mntmNuovoUtente = new JMenuItem("Insert new user");
        mntmNuovoUtente.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new C_UC_InsertNewUser();
            }
        });
        // TODO: Dialog User registered!
        mn_utente.add(mntmNuovoUtente);

        JMenu mnSatellite = new JMenu("Satellites");
        menuBar.add(mnSatellite);

        JMenuItem mntmNuvoSatellite = new JMenuItem("Insert new satellite");
        mntmNuvoSatellite.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrameInserisciSatellite frameInserisciSattellite = new JFrameInserisciSatellite();
                frameInserisciSattellite.setVisible(true);
            }
        });
        // TODO: Dialog Satellite inserted!
        mnSatellite.add(mntmNuvoSatellite);

        JMenu mnClump = new JMenu("Clumps");
        menuBar.add(mnClump);

        JMenuItem mntmSearchClump = new JMenuItem("Search a clump");
        mnClump.add(mntmSearchClump);
        mntmSearchClump.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrameClumpSearch jFrameClumpSearch = new JFrameClumpSearch();
                jFrameClumpSearch.setVisible(true);
            }
        });
        JMenuItem mntmSearchClumpDensity = new JMenuItem("Show clumps density");
        mnClump.add(mntmSearchClumpDensity);
        JMenuItem mntmSearchClumpMass = new JMenuItem("Show clumps mass");
        mnClump.add(mntmSearchClumpMass);
        mntmSearchClumpMass.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrameClumpMass jFrameClumpMass = new JFrameClumpMass();
                jFrameClumpMass.setVisible(true);
            }
        });
        JMenuItem mntmSearchClumpMassStats = new JMenuItem("Show clumps mass statistics");
        mnClump.add(mntmSearchClumpMassStats);

        JMenu mnPosition = new JMenu("Position");
        menuBar.add(mnPosition);

        JMenuItem mntmSearchPosition = new JMenuItem("Search for position");
        mnPosition.add(mntmSearchPosition);

        mntmSearchPosition.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // JFrameSearchPosition jFrameSearchPosition = new
                // JFrameSearchPosition();
                // jFrameSearchPosition.setVisible(true);
                new C_UC_SearchObjectsInRegionByPosition();
            }
        });

        JMenu mnSource = new JMenu("Sources");
        menuBar.add(mnSource);

        JMenuItem mntmSourceSearch = new JMenuItem("Search a source");
        mnSource.add(mntmSourceSearch);

        JMenu mnMap = new JMenu("Maps");
        menuBar.add(mnMap);

        JMenuItem mntmShowAllObject = new JMenuItem("Show all object");
        mnMap.add(mntmShowAllObject);

        JMenu mnInstruments = new JMenu("Instruments");
        menuBar.add(mnInstruments);

        JMenuItem mntmNewInstruments = new JMenuItem("New instrument");
        mnInstruments.add(mntmNewInstruments);

        JMenuItem mntmAddBand = new JMenuItem("Add band");
        mnInstruments.add(mntmAddBand);

        mntmSourceSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrameSourceSearch jFrameSourceSearch = new JFrameSourceSearch();
                jFrameSourceSearch.setVisible(true);
            }
        });

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
