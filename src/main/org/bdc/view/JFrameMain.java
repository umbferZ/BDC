/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view
 * Type: JFrameMain
 * Last update: 20-set-2017 13.23.21
 * 
 */

package main.org.bdc.view;

import main.org.bdc.controls.C_UC_ClumpsMasses;
import main.org.bdc.controls.C_UC_SearchYoungStars;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

    /* CONSTRUCTOR */

    /**
     * Instantiates a new j frame main.
     */
    public JFrameMain() {
        setTitle("Osservatorio Astronomico Virtuale");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 500);

        /* MENU */

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

        mn_uploadFiles = new JMenu("Upload");
        mnFile.add(mn_uploadFiles);

        mntm_higal = new JMenuItem("Higal");
        mn_uploadFiles.add(mntm_higal);
        mntm_higalAddictional = new JMenuItem("Higal Addictional");
        mn_uploadFiles.add(mntm_higalAddictional);
        mntm_glimpse = new JMenuItem("Glimpse");
        mn_uploadFiles.add(mntm_glimpse);
        mntm_mipsGal = new JMenuItem("MIPSGAL-GAL");
        mn_uploadFiles.add(mntm_mipsGal);

        JMenuItem mntmExit = new JMenuItem("Exit");
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
        mntmSearchClumpDensity = new JMenuItem("Show clumps for density");
        mnClump.add(mntmSearchClumpDensity);
        mntmSearchClumpDensity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    list.setListData(C_UC_ClumpsMasses.getInstance().searchClumpsDensities());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        mntm_showClumpMass = new JMenuItem("Show clumps mass");
        mnClump.add(mntm_showClumpMass);
        mntmSearchClumpMassStats = new JMenuItem("Show clumps mass statistics");
        mnClump.add(mntmSearchClumpMassStats);
        mntmSearchClumpMassStats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    list.setListData(C_UC_ClumpsMasses.getInstance().showStats());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        JMenu mnSource = new JMenu("Sources");
        menuBar.add(mnSource);

        mntm_YoungStars = new JMenuItem("Search young stars");
        mnSource.add(mntm_YoungStars);
        mntm_YoungStars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    list.setListData(C_UC_SearchYoungStars.getInstance().showClumps());
                    list.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            try {
                                list.setListData(C_UC_SearchYoungStars.getInstance().youngStars(Integer.parseInt(list.getSelectedValue().toString())));
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }
                    });
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        mntmSearchSource = new JMenuItem("Search source");
        mnSource.add(mntmSearchSource);

        JMenu mnPosition = new JMenu("Position");
        mnSource.add(mnPosition);

        mntmSearchPosition = new JMenuItem("Search for position");
        mnPosition.add(mntmSearchPosition);

        /* END OF MENU */

        /* GENERIC COMPONENTS */

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

        /* END OF GENERIC COMPONENTS */
    }

    /* END OF CONSTRUCTOR */



    /**
     * Adds the button search clump.
     *
     * @param actionListener the action listener
     */
    public void addButtonSearchClump(ActionListener actionListener) {
        mntmSearchClump.addActionListener(actionListener);

    }

    /**
     * Adds the import action listener.
     *
     * @param typeFile the type file
     * @param actionListener the action listener
     */
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

    /**
     * Adds the menu clump mass AL.
     *
     * @param actionListener the action listener
     */
    public void addMenuClumpMassAL(ActionListener actionListener) {
        mntm_showClumpMass.addActionListener(actionListener);
    }

    /**
     * Adds the menu insert user AL.
     *
     * @param actionListener the action listener
     */
    public void addMenuInsertUserAL(ActionListener actionListener) {
        mntm_newUser.addActionListener(actionListener);
    }

    /**
     * Adds the menu instrument AL.
     *
     * @param actionListener the action listener
     */
    public void addMenuInstrumentAL(ActionListener actionListener) {
        mntm_newInstruments.addActionListener(actionListener);
    }

    /**
     * Adds the menu new satellite.
     *
     * @param actionListener the action listener
     */
    public void addMenuNewSatellite(ActionListener actionListener) {
        mntm_newSatellite.addActionListener(actionListener);
    }

    /**
     * Adds the menu position AL.
     *
     * @param actionListener the action listener
     */
    public void addMenuPositionAL(ActionListener actionListener) {
        mntmSearchPosition.addActionListener(actionListener);
    }

    /**
     * Adds the menu search clump AL.
     *
     * @param actionListener the action listener
     */
    public void addMenuSearchClumpAL(ActionListener actionListener) {
        mntmSearchClump.addActionListener(actionListener);
    }

    /**
     * Adds the menu search source AL.
     *
     * @param actionListener the action listener
     */
    public void addMenuSearchSourceAL(ActionListener actionListener) {
        mntmSearchSource.addActionListener(actionListener);
    }

    /**
     * Adds the menu show all object action listener.
     *
     * @param actionListener the action listener
     */
    public void addMenuShowAllObjectActionListener(ActionListener actionListener) {
        mntm_showAllObject.addActionListener(actionListener);
    }

    /**
     * Gets the lbl welcome.
     *
     * @return the lbl welcome
     */
    public JLabel getLbl_welcome() {
        return lbl_welcome;
    }

    /**
     * Gets the list.
     *
     * @return the list
     */
    public JList getList() {
        return list;
    }

    /**
     * Gets the mn upload files.
     *
     * @return the mn upload files
     */
    public JMenu getMn_uploadFiles() {
        return mn_uploadFiles;
    }

    /**
     * Gets the mn utente.
     *
     * @return the mn utente
     */
    public JMenu getMn_utente() {
        return mn_utente;
    }

    /**
     * Gets the mntm glimpse.
     *
     * @return the mntm glimpse
     */
    public JMenuItem getMntm_glimpse() {
        return mntm_glimpse;
    }

    /**
     * Gets the mntm higal.
     *
     * @return the mntm higal
     */
    public JMenuItem getMntm_higal() {
        return mntm_higal;
    }

    /**
     * Gets the mntm higal addictional.
     *
     * @return the mntm higal addictional
     */
    public JMenuItem getMntm_higalAddictional() {
        return mntm_higalAddictional;
    }

    /**
     * Gets the mntm mips gal.
     *
     * @return the mntm mips gal
     */
    public JMenuItem getMntm_mipsGal() {
        return mntm_mipsGal;
    }

    /**
     * Gets the mntm new instruments.
     *
     * @return the mntm new instruments
     */
    public JMenuItem getMntm_newInstruments() {
        return mntm_newInstruments;
    }

    /**
     * Gets the mntm new satellite.
     *
     * @return the mntm new satellite
     */
    public JMenuItem getMntm_newSatellite() {
        return mntm_newSatellite;
    }

    /**
     * Gets the mntm new user.
     *
     * @return the mntm new user
     */
    public JMenuItem getMntm_newUser() {
        return mntm_newUser;
    }

    /**
     * Gets the mntm show all object.
     *
     * @return the mntm show all object
     */
    public JMenuItem getMntm_showAllObject() {
        return mntm_showAllObject;
    }

    /**
     * Gets the mntm show clump mass.
     *
     * @return the mntm show clump mass
     */
    public JMenuItem getMntm_showClumpMass() {
        return mntm_showClumpMass;
    }

    /**
     * Gets the mntm young stars.
     *
     * @return the mntm young stars
     */
    public JMenuItem getMntm_YoungStars() {
        return mntm_YoungStars;
    }

    /**
     * Gets the mntm search clump.
     *
     * @return the mntm search clump
     */
    public JMenuItem getMntmSearchClump() {
        return mntmSearchClump;
    }

    /**
     * Gets the mntm search clump density.
     *
     * @return the mntm search clump density
     */
    public JMenuItem getMntmSearchClumpDensity() {
        return mntmSearchClumpDensity;
    }

    /**
     * Gets the mntm search clump mass stats.
     *
     * @return the mntm search clump mass stats
     */
    public JMenuItem getMntmSearchClumpMassStats() {
        return mntmSearchClumpMassStats;
    }

    /**
     * Gets the mntm search position.
     *
     * @return the mntm search position
     */
    public JMenuItem getMntmSearchPosition() {
        return mntmSearchPosition;
    }

    /**
     * Gets the mntm search source.
     *
     * @return the mntm search source
     */
    public JMenuItem getMntmSearchSource() {
        return mntmSearchSource;
    }

    /**
     * Sets the lbl welcome.
     *
     * @param lbl_welcome the new lbl welcome
     */
    public void setLbl_welcome(JLabel lbl_welcome) {
        this.lbl_welcome = lbl_welcome;
    }

    /**
     * Sets the list.
     *
     * @param list the new list
     */
    public void setList(JList list) {
        this.list = list;
    }

    /**
     * Sets the mn upload files.
     *
     * @param mn_uploadFiles the new mn upload files
     */
    public void setMn_uploadFiles(JMenu mn_uploadFiles) {
        this.mn_uploadFiles = mn_uploadFiles;
    }

    /**
     * Sets the mn utente.
     *
     * @param mn_utente the new mn utente
     */
    public void setMn_utente(JMenu mn_utente) {
        this.mn_utente = mn_utente;
    }

    /**
     * Sets the mntm glimpse.
     *
     * @param mntm_glimpse the new mntm glimpse
     */
    public void setMntm_glimpse(JMenuItem mntm_glimpse) {
        this.mntm_glimpse = mntm_glimpse;
    }

    /**
     * Sets the mntm higal.
     *
     * @param mntm_higal the new mntm higal
     */
    public void setMntm_higal(JMenuItem mntm_higal) {
        this.mntm_higal = mntm_higal;
    }

    /**
     * Sets the mntm higal addictional.
     *
     * @param mntm_higalAddictional the new mntm higal addictional
     */
    public void setMntm_higalAddictional(JMenuItem mntm_higalAddictional) {
        this.mntm_higalAddictional = mntm_higalAddictional;
    }

    /**
     * Sets the mntm mips gal.
     *
     * @param mntm_mipsGal the new mntm mips gal
     */
    public void setMntm_mipsGal(JMenuItem mntm_mipsGal) {
        this.mntm_mipsGal = mntm_mipsGal;
    }

    /**
     * Sets the mntm new instruments.
     *
     * @param mntm_newInstruments the new mntm new instruments
     */
    public void setMntm_newInstruments(JMenuItem mntm_newInstruments) {
        this.mntm_newInstruments = mntm_newInstruments;
    }

    /**
     * Sets the mntm new satellite.
     *
     * @param mntm_newSatellite the new mntm new satellite
     */
    public void setMntm_newSatellite(JMenuItem mntm_newSatellite) {
        this.mntm_newSatellite = mntm_newSatellite;
    }

    /**
     * Sets the mntm new user.
     *
     * @param mntm_newUser the new mntm new user
     */
    public void setMntm_newUser(JMenuItem mntm_newUser) {
        this.mntm_newUser = mntm_newUser;
    }

    /**
     * Sets the mntm show all object.
     *
     * @param mntm_showAllObject the new mntm show all object
     */
    public void setMntm_showAllObject(JMenuItem mntm_showAllObject) {
        this.mntm_showAllObject = mntm_showAllObject;
    }

    /**
     * Sets the mntm show clump mass.
     *
     * @param mntm_showClumpMass the new mntm show clump mass
     */
    public void setMntm_showClumpMass(JMenuItem mntm_showClumpMass) {
        this.mntm_showClumpMass = mntm_showClumpMass;
    }

    /**
     * Sets the mntm young stars.
     *
     * @param mntm_YoungStars the new mntm young stars
     */
    public void setMntm_YoungStars(JMenuItem mntm_YoungStars) {
        this.mntm_YoungStars = mntm_YoungStars;
    }

    /**
     * Sets the mntm search clump.
     *
     * @param mntmSearchClump the new mntm search clump
     */
    public void setMntmSearchClump(JMenuItem mntmSearchClump) {
        this.mntmSearchClump = mntmSearchClump;
    }

    /**
     * Sets the mntm search clump density.
     *
     * @param mntmSearchClumpDensity the new mntm search clump density
     */
    public void setMntmSearchClumpDensity(JMenuItem mntmSearchClumpDensity) {
        this.mntmSearchClumpDensity = mntmSearchClumpDensity;
    }

    /**
     * Sets the mntm search clump mass stats.
     *
     * @param mntmSearchClumpMassStats the new mntm search clump mass stats
     */
    public void setMntmSearchClumpMassStats(JMenuItem mntmSearchClumpMassStats) {
        this.mntmSearchClumpMassStats = mntmSearchClumpMassStats;
    }

    /**
     * Sets the mntm search position.
     *
     * @param mntmSearchPosition the new mntm search position
     */
    public void setMntmSearchPosition(JMenuItem mntmSearchPosition) {
        this.mntmSearchPosition = mntmSearchPosition;
    }

    /**
     * Sets the mntm search source.
     *
     * @param mntmSearchSource the new mntm search source
     */
    public void setMntmSearchSource(JMenuItem mntmSearchSource) {
        this.mntmSearchSource = mntmSearchSource;
    }

    /**
     * Sets the status bar message.
     *
     * @param message the new status bar message
     */
    public void setStatusBarMessage(String message) {
        lbl_welcome.setText(message);
    }

    /**
     * The Enum TypeFile.
     */
    public enum TypeFile {
        Glimpse("Glimpse"), Higal("Higal"), HigalAddictional("Higal"), MIPSGAL("MIPSGAL-GAL");

        private String name;

        /**
         * Instantiates a new type file.
         *
         * @param name the name
         */
        private TypeFile(String name) {
            this.name = name;
        }

        /**
         * Gets the name.
         *
         * @return the name
         */
        public Object getName() {
            return name();
        }
    }

}
