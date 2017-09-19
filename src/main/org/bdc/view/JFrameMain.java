/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view
 * Type: JFrameMain
 * Last update: 15-set-2017 14.32.39
 * 
 */

package main.org.bdc.view;

import main.org.bdc.controls.C_UC_SearchClumpsMass;
import main.org.bdc.model.DaoFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 * The Class JFrameMain.
 */
public class JFrameMain extends JFrame {

    private JPanel    contentPane;

    private JLabel    lbl_welcome;

    private JList     list;

    private JMenu     mn_uploadFiles;

    private JMenu     mn_utente;

    private JMenuItem mntm_glimpse;

    private JMenuItem mntm_higal;

    private JMenuItem mntm_higalAddictional;

    private JMenuItem mntm_mipsGal;

    private JMenuItem mntm_newInstruments;

    private JMenuItem mntm_newSatellite;

    private JMenuItem mntm_newUser;

    private JMenuItem mntm_showAllObject;

    private JMenuItem mntm_showClumpMass;

    private JMenuItem mntm_YoungStars;

    private JMenuItem mntmSearchClump;

    private JMenuItem mntmSearchClumpDensity;

    private JMenuItem mntmSearchClumpMassStats;

    private JMenuItem mntmSearchPosition;

    private JMenuItem mntmSearchSource;

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

        mntmSearchClump = new JMenuItem("Search a clump");
        mnClump.add(mntmSearchClump);

        mntmSearchClumpDensity = new JMenuItem("Show clumps density");
        mnClump.add(mntmSearchClumpDensity);
        mntm_showClumpMass = new JMenuItem("Show clumps mass");
        mnClump.add(mntm_showClumpMass);

        mntmSearchClumpMassStats = new JMenuItem("Show clumps mass statistics");
        mnClump.add(mntmSearchClumpMassStats);
        mntmSearchClumpMassStats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    list.setListData(C_UC_SearchClumpsMass.getInstance().showStats());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        JMenu mnSource = new JMenu("Sources");
        menuBar.add(mnSource);

        mntm_YoungStars = new JMenuItem("Search young stars");
        mnSource.add(mntm_YoungStars);

        mntmSearchSource = new JMenuItem("Search source");
        mnSource.add(mntmSearchSource);

        JMenu mnPosition = new JMenu("Position");
        mnSource.add(mnPosition);

        mntmSearchPosition = new JMenuItem("Search for position");
        mnPosition.add(mntmSearchPosition);

        mntm_YoungStars.addActionListener(new ActionListener() {

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
        GroupLayout gl_pn_statusBar = new GroupLayout(pn_statusBar);
        gl_pn_statusBar.setHorizontalGroup(
                gl_pn_statusBar.createParallelGroup(Alignment.LEADING).addGroup(gl_pn_statusBar.createSequentialGroup().addContainerGap().addComponent(lbl_welcome, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE).addGap(332)));
        gl_pn_statusBar.setVerticalGroup(gl_pn_statusBar.createParallelGroup(Alignment.LEADING).addGroup(gl_pn_statusBar.createSequentialGroup().addContainerGap().addComponent(lbl_welcome).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        pn_statusBar.setLayout(gl_pn_statusBar);

        JPanel listClump = new JPanel();
        contentPane.add(listClump, BorderLayout.CENTER);
        listClump.setLayout(new CardLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        listClump.add(scrollPane, "name_12425516435364");

        list = new JList();
        scrollPane.setViewportView(list);
    }

    public void addButtonSearchClump(ActionListener actionListener) {
        mntmSearchClump.addActionListener(actionListener);

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

    public void addMenuClumpMassAL(ActionListener actionListener) {
        mntm_showClumpMass.addActionListener(actionListener);
    }

    public void addMenuInsertUserAL(ActionListener actionListener) {
        mntm_newUser.addActionListener(actionListener);
    }

    public void addMenuInstrumentAL(ActionListener actionListener) {
        mntm_newInstruments.addActionListener(actionListener);
    }

    public void addMenuNewSatellite(ActionListener actionListener) {
        mntm_newSatellite.addActionListener(actionListener);
    }

    public void addMenuPositionAL(ActionListener actionListener) {
        mntmSearchPosition.addActionListener(actionListener);
    }

    public void addMenuSearchClumpAL(ActionListener actionListener) {
        mntmSearchClump.addActionListener(actionListener);
    }

    public void addMenuSearchSourceAL(ActionListener actionListener) {
        mntmSearchSource.addActionListener(actionListener);
    }

    public void addMenuShowAllObjectActionListener(ActionListener actionListener) {
        mntm_showAllObject.addActionListener(actionListener);
    }

    public JLabel getLbl_welcome() {
        return lbl_welcome;
    }

    public JList getList() {
        return list;
    }

    public JMenu getMn_uploadFiles() {
        return mn_uploadFiles;
    }

    public JMenu getMn_utente() {
        return mn_utente;
    }

    public JMenuItem getMntm_glimpse() {
        return mntm_glimpse;
    }

    public JMenuItem getMntm_higal() {
        return mntm_higal;
    }

    public JMenuItem getMntm_higalAddictional() {
        return mntm_higalAddictional;
    }

    public JMenuItem getMntm_mipsGal() {
        return mntm_mipsGal;
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

    public JMenuItem getMntm_showAllObject() {
        return mntm_showAllObject;
    }

    public JMenuItem getMntm_showClumpMass() {
        return mntm_showClumpMass;
    }

    public JMenuItem getMntm_YoungStars() {
        return mntm_YoungStars;
    }

    public JMenuItem getMntmSearchClump() {
        return mntmSearchClump;
    }

    public JMenuItem getMntmSearchClumpDensity() {
        return mntmSearchClumpDensity;
    }

    public JMenuItem getMntmSearchClumpMassStats() {
        return mntmSearchClumpMassStats;
    }

    public JMenuItem getMntmSearchPosition() {
        return mntmSearchPosition;
    }

    public JMenuItem getMntmSearchSource() {
        return mntmSearchSource;
    }

    public void setLbl_welcome(JLabel lbl_welcome) {
        this.lbl_welcome = lbl_welcome;
    }

    public void setList(JList list) {
        this.list = list;
    }

    public void setMn_uploadFiles(JMenu mn_uploadFiles) {
        this.mn_uploadFiles = mn_uploadFiles;
    }

    public void setMn_utente(JMenu mn_utente) {
        this.mn_utente = mn_utente;
    }

    public void setMntm_glimpse(JMenuItem mntm_glimpse) {
        this.mntm_glimpse = mntm_glimpse;
    }

    public void setMntm_higal(JMenuItem mntm_higal) {
        this.mntm_higal = mntm_higal;
    }

    public void setMntm_higalAddictional(JMenuItem mntm_higalAddictional) {
        this.mntm_higalAddictional = mntm_higalAddictional;
    }

    public void setMntm_mipsGal(JMenuItem mntm_mipsGal) {
        this.mntm_mipsGal = mntm_mipsGal;
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

    public void setMntm_showAllObject(JMenuItem mntm_showAllObject) {
        this.mntm_showAllObject = mntm_showAllObject;
    }

    public void setMntm_showClumpMass(JMenuItem mntm_showClumpMass) {
        this.mntm_showClumpMass = mntm_showClumpMass;
    }

    public void setMntm_YoungStars(JMenuItem mntm_YoungStars) {
        this.mntm_YoungStars = mntm_YoungStars;
    }

    public void setMntmSearchClump(JMenuItem mntmSearchClump) {
        this.mntmSearchClump = mntmSearchClump;
    }

    public void setMntmSearchClumpDensity(JMenuItem mntmSearchClumpDensity) {
        this.mntmSearchClumpDensity = mntmSearchClumpDensity;
    }

    public void setMntmSearchClumpMassStats(JMenuItem mntmSearchClumpMassStats) {
        this.mntmSearchClumpMassStats = mntmSearchClumpMassStats;
    }

    public void setMntmSearchPosition(JMenuItem mntmSearchPosition) {
        this.mntmSearchPosition = mntmSearchPosition;
    }

    public void setMntmSearchSource(JMenuItem mntmSearchSource) {
        this.mntmSearchSource = mntmSearchSource;
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
        Glimpse("Glimpse"), Higal("Higal"), HigalAddictional("Higal"), MIPSGAL("MIPSGAL-GAL");

        private String name;

        private TypeFile(String name) {
            this.name = name;
        }

        public Object getName() {
            return name();
        }
    }

}
