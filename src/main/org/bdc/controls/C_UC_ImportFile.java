package main.org.bdc.controls;

import main.org.bdc.service.parser.CSVFactory;
import main.org.bdc.service.parser.monitor.exceptions.FailedInsertException;
import main.org.bdc.service.parser.monitor.exceptions.FailedReadException;
import main.org.bdc.view.JFrameMain;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sasha on 13/09/17.
 */
public class C_UC_ImportFile extends Component {

    private static C_UC_ImportFile instance = null;

    public synchronized static C_UC_ImportFile getInstance() {
        if (instance == null)
            instance = new C_UC_ImportFile();
        return instance;
    }

    public C_UC_ImportFile() {
    }

    public void importFile(){

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "CSV Format", "csv");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(C_UC_ImportFile.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getName());


            if (chooser.getSelectedFile().getName() == "higal.csv"){
                try {
                    CSVFactory.translateFile1(chooser.getSelectedFile().getAbsolutePath());
                } catch (FailedInsertException e) {
                    e.printStackTrace();
                } catch (FailedReadException e) {
                    e.printStackTrace();
                }
            }
            if (chooser.getSelectedFile().getName() == "higal_additionalinfo.csv"){
                try {
                    CSVFactory.translateFile2(chooser.getSelectedFile().getAbsolutePath());
                } catch (FailedInsertException e) {
                    e.printStackTrace();
                } catch (FailedReadException e) {
                    e.printStackTrace();
                }
            }
            if (chooser.getSelectedFile().getName() == "r08.csv"){
                try {
                    CSVFactory.translateFile3(chooser.getSelectedFile().getAbsolutePath());
                } catch (FailedInsertException e) {
                    e.printStackTrace();
                } catch (FailedReadException e) {
                    e.printStackTrace();
                }
            }
            if (chooser.getSelectedFile().getName() == "mips.csv"){
                try {
                    CSVFactory.translateFile4(chooser.getSelectedFile().getAbsolutePath());
                } catch (FailedInsertException e) {
                    e.printStackTrace();
                } catch (FailedReadException e) {
                    e.printStackTrace();
                }
            }

        }
    }

 /*   private class MntmImportActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "CSV Format", "csv");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(C_UC_ImportFile.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " +
                            chooser.getSelectedFile().getName());
                }
                CSVFactory.translateFile1("/Users/Francesco/Desktop/higal.csv");
            } catch (FailedInsertException e1) {
                e1.printStackTrace();
            } catch (FailedReadException e1) {
                e1.printStackTrace();
            }
        }

    }*/

}
