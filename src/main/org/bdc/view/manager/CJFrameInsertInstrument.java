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

import main.org.bdc.controls.C_UC_InsertNewInstrument;
import main.org.bdc.model.galaxy.Map;
import main.org.bdc.model.galaxy.Satellite;
import main.org.bdc.model.instruments.Instrument;
import main.org.bdc.service.dal.exception.SaveDalException;
import main.org.bdc.view.JFrameInsertInstrument;
import main.org.bdc.view.tools.CheckerField;

public class CJFrameInsertInstrument {

    private JFrameInsertInstrument view;
    private String name;
    private String satName;
    private String mapName;
    private Instrument instrument = new Instrument();

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
            //TODO: show error
            return false;
        }
        name = jTextField.getText();
        instrument.setName(name);
        return true;
    }

    private boolean validateMap() {
        JTextField jTextField = view.getTxt_mapName();
        if (!CheckerField.checkTextField(jTextField)) {
            //TODO: show error
            return false;
        }
        mapName = jTextField.getText();
        instrument.setMap(new Map(mapName));
        return true;
    }

    private boolean validateSatellite() {
        JTextField jTextField = view.getTxt_satName();
        if (!CheckerField.checkTextField(jTextField)) {
            //TODO: show error
            return false;
        }
        satName = jTextField.getText();
        instrument.setSatellite(new Satellite(satName));
        return true;
    }

    private class ButtonInsertAL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (checkFiels()) {
                try {
                    C_UC_InsertNewInstrument.getInstance().inserisciStrumento(instrument);
                } catch (SaveDalException e1) {
                    e1.printStackTrace();
                }
            }
        }

    }
}
