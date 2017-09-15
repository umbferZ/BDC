/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view.manager
 * Type: CJFrameSearchSource
 * Last update: 15-set-2017 12.37.44
 * 
 */

package main.org.bdc.view.manager;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import main.org.bdc.controls.C_UC_SearchSource;
import main.org.bdc.view.JFrameMain;
import main.org.bdc.view.JFrameSourceSearch;
import main.org.bdc.view.tools.CheckerField;

public class CJFrameSearchSource {

    private double             bandResolution;

    private int                clumpId;

    private JFrameMain         parent;

    private JFrameSourceSearch view;

    public CJFrameSearchSource(JFrameMain parent) {
        this.parent = parent;
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    view = new JFrameSourceSearch();
                    view.setVisible(true);
                    view.addSearchActionListener(new SearchActionListener());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public boolean checkField() {
        clumpId = Integer.parseInt(view.getTxt_clumpId().getText());
        bandResolution = Double.parseDouble(view.getTxt_band().getText());
        return validateClumpId() && validateBand();
    }

    private boolean validateBand() {
        JTextField jTextField = view.getTxt_band();
        if (!CheckerField.checkTextField(jTextField))
            return false;
        try {
            bandResolution = Integer.parseInt(jTextField.getText());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean validateClumpId() {
        JTextField jTextField = view.getTxt_clumpId();
        if (!CheckerField.checkTextField(jTextField))
            return false;
        try {
            clumpId = Integer.parseInt(jTextField.getText());
        } catch (Exception e) {
            return false;
        }
        return true;

    }

    private class SearchActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("qui");
            if (checkField())
                try {
                    parent.getList().setListData(C_UC_SearchSource.getInstance().searchSourceInMipsGal(clumpId, bandResolution));
                    view.setVisible(false);
                } catch (Exception e1) {
                    e1.getMessage();
                }
        }

    }
}
