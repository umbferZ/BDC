/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view.manager
 * Type: JFramMainManagerView
 * Last update: 20-set-2017 13.23.23
 * 
 */

package main.org.bdc.view.manager;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.filechooser.FileNameExtensionFilter;

import main.org.bdc.controls.C_UC_ImportFile;
import main.org.bdc.controls.C_UC_ClumpsMasses;
import main.org.bdc.model.people.UserRegistered;
import main.org.bdc.model.people.UserType;
import main.org.bdc.service.parser.monitor.producers.IllegalFileException;
import main.org.bdc.view.JFrameMain;
import main.org.bdc.view.JFrameMain.TypeFile;

/**
 * The Class JFramMainManagerView.
 */
public class JFramMainManagerView {

    private JList<String>  list;

    private UserRegistered userRegistered;

    private JFrameMain     view;

    /**
     * Instantiates a new j fram main manager view.
     *
     * @param userRegistered the user registered
     */
    public JFramMainManagerView(UserRegistered userRegistered) {
        this.userRegistered = userRegistered;
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    view = new JFrameMain();
                    view.setVisible(true);

                    list = view.getList();
                    view.addImportActionListener(TypeFile.Higal, new ImportActionListener(TypeFile.Higal));
                    view.addImportActionListener(TypeFile.HigalAddictional, new ImportActionListener(TypeFile.HigalAddictional));
                    view.addImportActionListener(TypeFile.Glimpse, new ImportActionListener(TypeFile.Glimpse));
                    view.addImportActionListener(TypeFile.MIPSGAL, new ImportActionListener(TypeFile.MIPSGAL));
                    view.addMenuInsertUserAL(new MenuInsertUser());
                    view.addMenuNewSatellite(new MenuInsertSatellite());
                    view.addMenuShowAllObjectActionListener(new MenuObjectInMap());
                    view.addMenuInstrumentAL(new MenuInsertStrumento());
                    view.addMenuClumpMassAL(new MenuClumpMass());
                    view.addMenuSearchSourceAL(new MenuShowSources());
                    view.addMenuSearchClumpAL(new MenuSearchClump());
                    view.addMenuPositionAL(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            new CJFrameSearchPosition(view);

                        }
                    });

                    if (userRegistered.getUserType() == UserType.USER_REGISTERED) {
                        view.getMn_uploadFiles().setEnabled(false);
                        view.getMntm_newInstruments().setEnabled(false);
                        view.getMntm_newSatellite().setEnabled(false);
                        view.getMntm_newUser().setEnabled(false);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Gets the list.
     *
     * @return the list
     */
    public JList<String> getList() {
        return list;
    }

    /**
     * Sets the list.
     *
     * @param list the new list
     */
    public void setList(JList<String> list) {
        this.list = list;
    }

    /**
     * The listener interface for receiving importAction events. The class that
     * is interested in processing a importAction event implements this
     * interface, and the object created with that class is registered with a
     * component using the component's <code>addImportActionListener<code>
     * method. When the importAction event occurs, that object's appropriate
     * method is invoked.
     *
     * @see ImportActionEvent
     */
    class ImportActionListener implements ActionListener {

        private TypeFile typeFile;

        /**
         * Instantiates a new import action listener.
         *
         * @param typeFile the type file
         */
        public ImportActionListener(TypeFile typeFile) {
            this.typeFile = typeFile;
        }

        /* (non-Javadoc)
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent ev) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Format", "csv");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(view);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String fileName = chooser.getSelectedFile().getAbsolutePath();
                Thread threadFile = null;
                try {
                    threadFile = C_UC_ImportFile.getInstance().importFile(fileName, typeFile);
                    view.setStatusBarMessage(String.format("Importing %s ...", fileName));
                    threadFile.start();

                    try {
                        threadFile.join();
                        view.setStatusBarMessage(String.format("%s imported successfully ", fileName));
                    } catch (InterruptedException e) {
                        view.setStatusBarMessage(String.format("Error in importing %s...", fileName));
                    }
                    view.setStatusBarMessage(String.format(" "));
                } catch (IllegalFileException e) {
                    view.setStatusBarMessage("Unsupported file");
                }

            } else
                view.setStatusBarMessage("Error");
        }

    }

    /**
     * The Class MenuClumpMass.
     */
    class MenuClumpMass implements ActionListener {

        /* (non-Javadoc)
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                list.setListData(C_UC_ClumpsMasses.getInstance().searchClumpsMass());
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

    }

    /**
     * The Class MenuInsertSatellite.
     */
    class MenuInsertSatellite implements ActionListener {

        /* (non-Javadoc)
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            new CJFramNewSatellite(view);

        }

    }

    /**
     * The Class MenuInsertStrumento.
     */
    class MenuInsertStrumento implements ActionListener {

        /* (non-Javadoc)
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            new CJFrameInsertInstrument();
        }
    }

    /**
     * The Class MenuInsertUser.
     */
    class MenuInsertUser implements ActionListener {

        /* (non-Javadoc)
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            new CJFrameNewUser();

        }
    }

    /**
     * The Class MenuSearchClump.
     */
    class MenuSearchClump implements ActionListener {

        /* (non-Javadoc)
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            new CJFrameClumpSearch(view);

        }

    }

    /**
     * The Class MenuSearchSource.
     */
    class MenuSearchSource implements ActionListener {

        /* (non-Javadoc)
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            new CJFrameSearchSource(view);

        }

    }

    /**
     * The Class MenuShowSources.
     */
    class MenuShowSources implements ActionListener {

        /* (non-Javadoc)
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            new CJFrameSearchSource(view);

        }

    }

    /**
     * The Class MenuObjectInMap.
     */
    class MenuObjectInMap implements ActionListener {

        /* (non-Javadoc)
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            new CJFrameObjectInMap(view);

        }

    }

}