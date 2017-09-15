/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view.manager
 * Type: CJFrameInsertInstrument
 * Last update: 15-set-2017 13.36.18
 * 
 */

package main.org.bdc.view.manager;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import main.org.bdc.view.JFrameInsertInstrument;
import main.org.bdc.view.tools.CheckerField;

public class CJFrameInsertInstrument {

    private JFrameInsertInstrument view;

    public CJFrameInsertInstrument() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    view = new JFrameInsertInstrument();
                    view.setVisible(true);
                    view.addButtonInsertAL(new ButtonInsertAL());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private boolean checkFiels() {

        return valdateName() && validateSatellite() && validateMap();
    }

    private boolean valdateName() {
        JTextField jTextField = view.getTxt_instrumentName();
        if (!CheckerField.checkTextField(jTextField)) {
            view.showError("Name can't be empty");
            return false;
        }
        return true;
    }

    private boolean validateMap() {
        // TODO Auto-generated method stub
        return false;
    }

    private boolean validateSatellite() {
        // TODO Auto-generated method stub
        return false;
    }

    private class ButtonInsertAL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // if (checkFiels())
            // C_UC_InsertNewInstrument.getInstance().inserisciStrumento(null,
            // null);

        }

    }
}
