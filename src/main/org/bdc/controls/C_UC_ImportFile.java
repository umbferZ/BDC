package main.org.bdc.controls;

import main.org.bdc.controls.gestisciUtenti.C_UC_Login;
import main.org.bdc.service.parser.CSVFactory;
import main.org.bdc.service.parser.monitor.exceptions.FailedInsertException;
import main.org.bdc.service.parser.monitor.exceptions.FailedReadException;
import main.org.bdc.view.JFrameLogin;
import main.org.bdc.view.JFrameMain;

import javax.security.auth.login.LoginException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sasha on 13/09/17.
 */
public class C_UC_ImportFile extends Component {

    JFrameMain view;

    public C_UC_ImportFile() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private class MntmImportActionListener implements ActionListener {

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
                /*CSVFactory.translateFile1("/Users/Francesco/Desktop/higal.csv");
            } catch (FailedInsertException e1) {
                e1.printStackTrace();
            } catch (FailedReadException e1) {
                e1.printStackTrace();
            }*/
        }

    }

}
