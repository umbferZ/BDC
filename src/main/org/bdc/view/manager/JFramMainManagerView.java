/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view.manager
 * Type: JFramMainManagerView
 * Last update: 14-set-2017 17.31.36
 * 
 */

package main.org.bdc.view.manager;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import main.org.bdc.controls.C_UC_ImportFile;
import main.org.bdc.model.people.UserRegistered;
import main.org.bdc.model.people.UserType;
import main.org.bdc.service.parser.monitor.producers.IllegalFileException;
import main.org.bdc.view.JFrameMain;
import main.org.bdc.view.JFrameMain.TypeFile;

public class JFramMainManagerView {

    private UserRegistered userRegistered;

    private JFrameMain     view;

    public JFramMainManagerView(UserRegistered userRegistered) {
        this.userRegistered = userRegistered;
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    JFramMainManagerView.this.view = new JFrameMain();
                    JFramMainManagerView.this.view.setVisible(true);
                    JFramMainManagerView.this.view.addImportActionListener(TypeFile.Higal, new ImportActionListener(TypeFile.Higal));
                    JFramMainManagerView.this.view.addImportActionListener(TypeFile.HigalAddictional, new ImportActionListener(TypeFile.HigalAddictional));
                    JFramMainManagerView.this.view.addImportActionListener(TypeFile.Glimpse, new ImportActionListener(TypeFile.Glimpse));
                    JFramMainManagerView.this.view.addImportActionListener(TypeFile.MIPSGAL, new ImportActionListener(TypeFile.MIPSGAL));
                    JFramMainManagerView.this.view.addButtonNewUserActionListener(new MenuIsertUser());
                    JFramMainManagerView.this.view.addButtonNewSatellite(new MenuInsertSatellite());
                    JFramMainManagerView.this.view.addButtonShowObjectActionListener(null);
                    JFramMainManagerView.this.view.addButtonNewInstrumentAL(new MenuInsertStrumento());

                    if (userRegistered.getUserType() == UserType.USER_REGISTERED) {
                        JFramMainManagerView.this.view.getMn_uploadFiles().setEnabled(false);
                        JFramMainManagerView.this.view.getMntm_newInstruments().setEnabled(false);
                        JFramMainManagerView.this.view.getMntm_newSatellite().setEnabled(false);
                        JFramMainManagerView.this.view.getMntm_newUser().setEnabled(false);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
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
            int returnVal = chooser.showOpenDialog(JFramMainManagerView.this.view);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String fileName = chooser.getSelectedFile().getAbsolutePath();
                Thread threadFile = null;
                try {
                    threadFile = C_UC_ImportFile.getInstance().importFile(fileName, this.typeFile);
                    JFramMainManagerView.this.view.setStatusBarMessage(String.format("Importing %s ...", fileName));
                    JFramMainManagerView.this.view.getProgressBar().setVisible(true);
                    threadFile.start();

                    try {
                        threadFile.join();
                        JFramMainManagerView.this.view.setStatusBarMessage(String.format("%s imported successfully ", fileName));
                    } catch (InterruptedException e) {
                        JFramMainManagerView.this.view.setStatusBarMessage(String.format("Error in importing %s...", fileName));
                    } finally {
                        JFramMainManagerView.this.view.getProgressBar().setVisible(false);
                    }
                    JFramMainManagerView.this.view.setStatusBarMessage(String.format(" "));
                } catch (IllegalFileException e) {
                    JFramMainManagerView.this.view.setStatusBarMessage("Unsupported file");
                }

            } else
                JFramMainManagerView.this.view.setStatusBarMessage("Error");
        }

    }

    class MenuInsertSatellite implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new CJFramNewSatellite(JFramMainManagerView.this.view);

        }

    }

    class MenuInsertStrumento implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new CJFrameInsertInstrument();
        }
    }

    class MenuIsertUser implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new CJFrameNewUser();

        }

    }
}