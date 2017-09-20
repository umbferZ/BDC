/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view.manager
 * Type: CJFrameObjectInMap
 * Last update: 20-set-2017 13.23.21
 * 
 */
package main.org.bdc.view.manager;

import main.org.bdc.controls.C_UC_SearchClumps;
import main.org.bdc.controls.C_UC_SearchObjectInMap;
import main.org.bdc.controls.C_UC_SearchYoungStars;
import main.org.bdc.view.JFrameClumpSearch;
import main.org.bdc.view.JFrameMain;
import main.org.bdc.view.JFrameObjectInMap;
import main.org.bdc.view.tools.CheckerField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * The Class CJFrameObjectInMap.
 */
public class CJFrameObjectInMap {

    private String map;

    private JFrameMain parent;

    private JFrameObjectInMap view;

    /**
     * Instantiates a new CJ frame object in map.
     *
     * @param parent the parent
     */
    public CJFrameObjectInMap(JFrameMain parent) {
        this.parent = parent;
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    view = new JFrameObjectInMap();
                    view.setVisible(true);
                    view.addButtonObject(new BtnListener());

                } catch (Exception e) {

                }
            }
        });
    }

    /**
     * Check field.
     *
     * @return true, if successful
     */
    private boolean checkField() {
        JTextField jTextField = view.getMap();
        if (!CheckerField.checkTextField(jTextField)) {
            view.showError("Insert Map!");
            return false;
        }
        map = jTextField.getText();
        return true;

    }

    /**
     * The listener interface for receiving btn events. The class that is
     * interested in processing a btn event implements this interface, and the
     * object created with that class is registered with a component using the
     * component's <code>addBtnListener<code> method. When the btn event occurs,
     * that object's appropriate method is invoked.
     *
     * @see BtnEvent
     */
    private class BtnListener implements ActionListener {

        /* (non-Javadoc)
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (checkField())
                try {
                    parent.getList().setListData(C_UC_SearchObjectInMap.getInstance().searchForAllBands(map, 1));
                } catch (Exception e1) {
                    e1.printStackTrace();
                    parent.getList().setListData(new String[] {
                            "Nessun elemento trovato"
                    });

                }
        }

    }
}
