/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view.menu
 * Type: MenuBarAdmin
 * Last update: 20-set-2017 13.23.24
 * 
 */

package main.org.bdc.view.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * The Class MenuBarAdmin.
 */
public class MenuBarAdmin extends JMenuBar {

    private JMenu     mn_file, mn_users, mn_satellite, mn_clumps, mn_position, mn_sources;

    private JMenuItem mntm_upload, mntm_exit, tm_newUser, tm_newSatellite, tm_searchClump, tm_showClumpDensity, tm_showClumMass, tm_showClumpStatistics;

    /**
     * Instantiates a new menu bar admin.
     */
    public MenuBarAdmin() {
        this.mn_file = new JMenu("File");
        this.mntm_exit = new JMenuItem("Exit...");
        this.mntm_upload = new JMenuItem("Upload a file...");
        this.mn_file.add(this.mntm_upload);
        this.mn_file.add(this.mntm_exit);

        this.mn_users = new JMenu("Users");
        this.mn_satellite = new JMenu("Satellites");
        this.mn_clumps = new JMenu("Clumps");
        this.mn_position = new JMenu("Position");
        this.mn_sources = new JMenu("Sources");

        add(this.mn_file);
        add(this.mn_users);
        add(this.mn_satellite);
        add(this.mn_clumps);
        add(this.mn_position);
        add(this.mn_sources);
    }

    /**
     * Gets the mntm upload.
     *
     * @return the mntm upload
     */
    public JMenuItem getMntm_upload() {
        return this.mntm_upload;
    }

    /**
     * Sets the mntm upload.
     *
     * @param mntm_upload the new mntm upload
     */
    public void setMntm_upload(JMenuItem mntm_upload) {
        this.mntm_upload = mntm_upload;
    }
}
