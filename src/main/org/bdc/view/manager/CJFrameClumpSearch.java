/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view.manager
 * Type: CJFrameClumpSearch
 * Last update: 15-set-2017 15.15.13
 * 
 */

package main.org.bdc.view.manager;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import main.org.bdc.controls.C_UC_SearchClumps;
import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.view.JFrameClumpSearch;
import main.org.bdc.view.JFrameMain;
import main.org.bdc.view.tools.CheckerField;

public class CJFrameClumpSearch {

    private int               clumpId;

    private JFrameMain        parent;

    private JFrameClumpSearch view;

    public CJFrameClumpSearch(JFrameMain parent) {
        this.parent = parent;
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    view = new JFrameClumpSearch();
                    view.setVisible(true);
                    view.addButtonSearchAL(new BtnListener());

                } catch (Exception e) {

                }
            }
        });
    }

    private boolean checkField() {
        JTextField jTextField = view.getClump_id();
        if (!CheckerField.checkTextField(jTextField)) {
            view.showError("Scrivi l'id clump");
            return false;
        }
        try {
            clumpId = Integer.parseInt(jTextField.getText().trim());
        } catch (Exception e) {
            view.showError("distance non valido");
            return false;
        }
        return true;

    }

    private class BtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (checkField())
                try {
                    parent.getList().setListData(C_UC_SearchClumps.getInstance().searchClumps(clumpId));
                } catch (Exception e1) {
                    e1.printStackTrace();
                    parent.getList().setListData(new String[] {
                            "Nessun elemento trovato"
                    });

                }
        }

    }
}
