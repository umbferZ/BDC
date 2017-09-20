/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view.manager
 * Type: CJFrameSearchPosition
 * Last update: 20-set-2017 13.23.25
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

/**
 * The Class CJFrameSearchPosition.
 */
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

    /**
     * Instantiates a new CJ frame search position.
     *
     * @param mainView the main view
     */
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

    /**
     * Check field.
     *
     * @return true, if successful
     */
    public boolean checkField() {
        isClump = view.getRdbtnTypeClump().isSelected();
        isSquare = view.getRdbtnGeometrySquare().isSelected();
        return checklat() && checkLon() && checkDist() && checkLimit();
    }

    /**
     * Check dist.
     *
     * @return true, if successful
     */
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

    /**
     * Checklat.
     *
     * @return true, if successful
     */
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

    /**
     * Check limit.
     *
     * @return true, if successful
     */
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

    /**
     * Check lon.
     *
     * @return true, if successful
     */
    private boolean checkLon() {
        try {
            longitude = Double.parseDouble(view.getFld_long().getText().trim());
        } catch (Exception e) {
            error = e.getMessage();
            return false;
        }
        return true;
    }

    /**
     * The listener interface for receiving insertSearchAction events. The class
     * that is interested in processing a insertSearchAction event implements
     * this interface, and the object created with that class is registered with
     * a component using the component's
     * <code>addInsertSearchActionListener<code> method. When the
     * insertSearchAction event occurs, that object's appropriate method is
     * invoked.
     *
     * @see InsertSearchActionEvent
     */
    private class InsertSearchActionListener implements ActionListener {

        /* (non-Javadoc)
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
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
