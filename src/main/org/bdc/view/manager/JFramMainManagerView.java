/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view.manager
 * Type: JFramMainManagerView
 * Last update: 14-set-2017 1.59.32
 * 
 */

package main.org.bdc.view.manager;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import main.org.bdc.model.people.UserRegistered;
import main.org.bdc.service.parser.CSVFactory;
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
                    view = new JFrameMain();
                    view.setVisible(true);
                    view.addImportActionListener(TypeFile.Higal, new ImportActionListener(TypeFile.Higal));
                    view.addImportActionListener(TypeFile.HigalAddictional, new ImportActionListener(TypeFile.HigalAddictional));
                    view.addImportActionListener(TypeFile.Glimpse, new ImportActionListener(TypeFile.Glimpse));
                    view.addImportActionListener(TypeFile.MIPSGAL, new ImportActionListener(TypeFile.MIPSGAL));
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
            int returnVal = chooser.showOpenDialog(view);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String fileName = chooser.getSelectedFile().getAbsolutePath();
                Thread threadFile = null;

                switch (typeFile) {
                    case Higal:
                        threadFile = CSVFactory.translateFile1(fileName);
                        break;
                    case HigalAddictional:
                        threadFile = CSVFactory.translateFile2(fileName);
                        break;
                    case Glimpse:
                        threadFile = CSVFactory.translateFile3(fileName);
                        break;
                    case MIPSGAL:
                        threadFile = CSVFactory.translateFile4(fileName);
                        break;
                }
                view.setStatusBarMessage(String.format("Importing %s ...", fileName));
                view.getProgressBar().setVisible(true);
                threadFile.start();

                try {
                    threadFile.join();
                    view.setStatusBarMessage(String.format("%s imported successfully ", fileName));
                } catch (InterruptedException e) {
                    view.setStatusBarMessage(String.format("Error in importing %s...", fileName));
                } finally {
                    view.getProgressBar().setVisible(false);
                }
                view.setStatusBarMessage(String.format(" "));

            } else
                view.setStatusBarMessage("Error");
        }

    }
}