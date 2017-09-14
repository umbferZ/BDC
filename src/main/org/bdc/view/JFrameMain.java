/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view
 * Type: JFrameMain
 * Last update: 14-set-2017 17.27.46
 * 
 */

package main.org.bdc.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import main.org.bdc.controls.C_UC_SearchObjectsInRegionByPosition;

/**
 * The Class JFrameMain.
 */
public class JFrameMain extends JFrame {

    private JPanel       contentPane;

    private JLabel       lbl_welcome;

    private JMenu        mn_uploadFiles;

    private JMenu        mn_utente;

    private JMenuItem    mntm_glimpse;

    private JMenuItem    mntm_higal;

    private JMenuItem    mntm_higalAddictional;

    private JMenuItem    mntm_mipsGal;

    private JMenuItem    mntm_newInstruments;

    private JMenuItem    mntm_newSatellite;

    private JMenuItem    mntm_newUser;

    private JMenuItem    mntm_showAllObject;

    private JProgressBar progressBar;

    public static void main(String[] args) {

    }

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

        mn_uploadFiles = new JMenu("Upload"); // ho creato questo menu
        mnFile.add(mn_uploadFiles);

        mntm_higal = new JMenuItem("Higal");

        JMenuItem mntmExit = new JMenuItem("Exit");

        mn_uploadFiles.add(mntm_higal); // il nuovo menu lo inserisco i un altro

        mntm_higalAddictional = new JMenuItem("Higal Addictional");

        mn_uploadFiles.add(mntm_higalAddictional);

        mntm_glimpse = new JMenuItem("Glimpse");
        mn_uploadFiles.add(mntm_glimpse);

        mntm_mipsGal = new JMenuItem("MIPSGAL-GAL");
        mn_uploadFiles.add(mntm_mipsGal);
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

        mntm_newUser = new JMenuItem("Insert new user");

        mn_utente.add(mntm_newUser);

        JMenu mnMap = new JMenu("Maps");
        menuBar.add(mnMap);

        mntm_showAllObject = new JMenuItem("Show all object");
        mnMap.add(mntm_showAllObject);

        JMenu mnSatellite = new JMenu("Satellites");
        menuBar.add(mnSatellite);

        mntm_newSatellite = new JMenuItem("Insert new satellite");

        mnSatellite.add(mntm_newSatellite);

        JMenu mnInstruments = new JMenu("Instruments");
        mnSatellite.add(mnInstruments);

        mntm_newInstruments = new JMenuItem("Insert new instrument");
        mnInstruments.add(mntm_newInstruments);

        JMenuItem mntmAddBand = new JMenuItem("Add band");
        mnInstruments.add(mntmAddBand);

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

        JMenu mnSource = new JMenu("Sources");
        mnClump.add(mnSource);

        JMenuItem mntmSourceSearch = new JMenuItem("Search a source");
        mnSource.add(mntmSourceSearch);

        JMenu mnPosition = new JMenu("Position");
        mnSource.add(mnPosition);

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

        JPanel pn_statusBar = new JPanel();
        contentPane.add(pn_statusBar, BorderLayout.SOUTH);

        lbl_welcome = new JLabel("Welcome...");
        lbl_welcome.setFont(new Font("Dialog", Font.PLAIN, 12));

        progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        progressBar.setVisible(false);
        GroupLayout gl_pn_statusBar = new GroupLayout(pn_statusBar);
        gl_pn_statusBar.setHorizontalGroup(gl_pn_statusBar.createParallelGroup(Alignment.LEADING).addGroup(gl_pn_statusBar.createSequentialGroup().addContainerGap()
                .addComponent(lbl_welcome, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE).addGap(172).addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addContainerGap()));
        gl_pn_statusBar.setVerticalGroup(gl_pn_statusBar.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_pn_statusBar.createSequentialGroup().addContainerGap()
                        .addGroup(gl_pn_statusBar.createParallelGroup(Alignment.TRAILING).addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(lbl_welcome))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        pn_statusBar.setLayout(gl_pn_statusBar);
    }

    public void addButtonNewInstrumentAL(ActionListener actionListener) {
        mntm_newInstruments.addActionListener(actionListener);
    }

    public void addButtonNewSatellite(ActionListener actionListener) {
        mntm_newSatellite.addActionListener(actionListener);
    }

    public void addButtonNewUserActionListener(ActionListener actionListener) {
        mntm_newUser.addActionListener(actionListener);
    }

    public void addButtonShowObjectActionListener(ActionListener actionListener) {
        mntm_showAllObject.addActionListener(actionListener);
    }

    public void addImportActionListener(TypeFile typeFile, ActionListener actionListener) {
        switch (typeFile) {
            case Higal:
                mntm_higal.addActionListener(actionListener);
                break;
            case Glimpse:
                mntm_glimpse.addActionListener(actionListener);
                break;
            case HigalAddictional:
                mntm_higalAddictional.addActionListener(actionListener);
                break;
            case MIPSGAL:
                mntm_mipsGal.addActionListener(actionListener);
                break;
        }
    }

    public JMenu getMn_uploadFiles() {
        return mn_uploadFiles;
    }

    public JMenuItem getMntm_newInstruments() {
        return mntm_newInstruments;
    }

    public JMenuItem getMntm_newSatellite() {
        return mntm_newSatellite;
    }

    public JMenuItem getMntm_newUser() {
        return mntm_newUser;
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }

    public void setMn_uploadFiles(JMenu mn_uploadFiles) {
        this.mn_uploadFiles = mn_uploadFiles;
    }

    public void setMntm_newInstruments(JMenuItem mntm_newInstruments) {
        this.mntm_newInstruments = mntm_newInstruments;
    }

    public void setMntm_newSatellite(JMenuItem mntm_newSatellite) {
        this.mntm_newSatellite = mntm_newSatellite;
    }

    public void setMntm_newUser(JMenuItem mntm_newUser) {
        this.mntm_newUser = mntm_newUser;
    }

    public void setProgressBar(JProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    /**
     * Welcome.
     *
     * @param message the name
     */
    public void setStatusBarMessage(String message) {
        lbl_welcome.setText(message);
    }

    public enum TypeFile {
        Glimpse, Higal, HigalAddictional, MIPSGAL;
    }

}
