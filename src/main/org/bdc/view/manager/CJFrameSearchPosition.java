/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view.manager
 * Type: CJFrameSearchPosition
 * Last update: 15-set-2017 13.33.49
 * 
 */

package main.org.bdc.view.manager;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;

import main.org.bdc.controls.C_UC_SearchSource;
import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.model.galaxy.Source;
import main.org.bdc.view.JFrameMain;
import main.org.bdc.view.JFrameSearchPosition;
import main.org.bdc.view.tools.CheckerField;

public class CJFrameSearchPosition {

    public double                distance;

    public double                latitude;

    public int                   limit;

    public double                longitude;

    private List<Clump>          clumps;

    private DaoFactory           dao;

    private String               error;

    private boolean              isClump, isSquare;

    private JFrameMain           mainView;

    private List<Source>         sources;

    private JFrameSearchPosition view;

    public CJFrameSearchPosition(JFrameMain mainView) {
        this.mainView = mainView;
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    view = new JFrameSearchPosition();
                    view.setVisible(true);
                    view.addInserisciSearchListener(new InsertSearchActionListener());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public boolean checkField() {
        isClump = view.getRdbtnTypeClump().isSelected();
        isSquare = view.getRdbtnGeometrySquare().isSelected();
        return checklat() && checkLon() && checkDist() && checkLimit();
    }

    private boolean checkDist() {
        JTextField jTextField = view.getFld_dist();
        if (!CheckerField.checkTextField(jTextField)) {
            view.showError("scrivi la distanza");
            return false;
        }
        try {
            distance = Double.parseDouble(jTextField.getText().trim());
        } catch (Exception e) {
            view.showError("distance non valido");
            return false;
        }
        return true;
    }

    private boolean checklat() {
        JTextField jTextField = view.getFld_lat();
        if (!CheckerField.checkTextField(jTextField)) {
            view.showError("scrivi la latitude");
            return false;
        }
        try {
            latitude = Double.parseDouble(jTextField.getText().trim());
        } catch (Exception e) {
            view.showError("Latitude non valido");
            return false;
        }
        return true;
    }

    private boolean checkLimit() {
        JTextField jTextField = view.getFld_limit();
        if (!CheckerField.checkTextField(jTextField)) {
            view.showError("scrivi il limite");
            return false;
        }
        try {
            limit = Integer.parseInt(jTextField.getText().trim());
        } catch (Exception e) {
            view.showError("limit non valido");
            return false;
        }
        return true;
    }

    private boolean checkLon() {
        try {
            longitude = Double.parseDouble(view.getFld_long().getText().trim());
        } catch (Exception e) {
            error = e.getMessage();
            return false;
        }
        return true;
    }

    private class InsertSearchActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (checkField())
                try {
                    mainView.getList().setListData(C_UC_SearchSource.getInstance().searchSourceInRegion(isClump, isSquare, latitude, longitude, distance, limit));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    mainView.getList().setListData(new String[] {
                            "Nessun elemento trovato"
                    });
                    view.showError("Nessun elemento trovato");
                }

        }

    }

}
