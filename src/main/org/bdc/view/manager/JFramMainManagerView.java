/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view.manager
 * Type: JFramMainManagerView
 * Last update: 15-set-2017 14.51.11
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

public class JFramMainManagerView {

    private JList<String>  list;

    private UserRegistered userRegistered;

    private JFrameMain     view;

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
                    view.addMenuShowAllObjectActionListener(null);
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

    public JList<String> getList() {
        return list;
    }

    public void setList(JList<String> list) {
        this.list = list;
    }

    class ImportActionListener implements ActionListener {

        private TypeFile typeFile;

        public ImportActionListener(TypeFile typeFile) {
            this.typeFile = typeFile;
        }

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

    class MenuClumpMass implements ActionListener {

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

    class MenuInsertSatellite implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new CJFramNewSatellite(view);

        }

    }

    class MenuInsertStrumento implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new CJFrameInsertInstrument();
        }
    }

    class MenuInsertUser implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new CJFrameNewUser();

        }
    }

    class MenuSearchClump implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new CJFrameClumpSearch(view);

        }

    }

    class MenuSearchSource implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new CJFrameSearchSource(view);

        }

    }

    class MenuShowSources implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new CJFrameSearchSource(view);

        }

    }

}