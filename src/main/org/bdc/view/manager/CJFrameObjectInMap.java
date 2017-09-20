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


public class CJFrameObjectInMap {

    private String map;

    private JFrameMain parent;

    private JFrameObjectInMap view;

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

    private boolean checkField() {
        JTextField jTextField = view.getMap();
        if (!CheckerField.checkTextField(jTextField)) {
            view.showError("Insert Map!");
            return false;
        }
        map = jTextField.getText();
        return true;

    }

    private class BtnListener implements ActionListener {

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
