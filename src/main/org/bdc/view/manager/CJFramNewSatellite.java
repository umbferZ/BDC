/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view.manager
 * Type: CJFramNewSatellite
 * Last update: 20-set-2017 13.23.25
 * 
 */

package main.org.bdc.view.manager;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import main.org.bdc.controls.C_UC_InsertSatellite;
import main.org.bdc.controls.gestisciSatellite.BeanInserisciSatellite;
import main.org.bdc.service.dal.exception.SaveDalException;
import main.org.bdc.view.JFrameInserisciSatellite;
import main.org.bdc.view.JFrameMain;
import main.org.bdc.view.tools.CheckerField;

/**
 * The Class CJFramNewSatellite.
 */
public class CJFramNewSatellite {

    private BeanInserisciSatellite   bean;

    private JFrameMain               parentView;

    private JFrameInserisciSatellite view;

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        new CJFramNewSatellite(null);
    }

    /**
     * Instantiates a new CJ fram new satellite.
     *
     * @param parenteView the parente view
     */
    public CJFramNewSatellite(JFrameMain parenteView) {
        parentView = parenteView;
        bean = new BeanInserisciSatellite();
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    view = new JFrameInserisciSatellite();
                    view.setVisible(true);
                    view.addButtonInsertActionListener(new ButtonInsertSatelliteAL());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Check fields.
     *
     * @return true, if successful
     */
    private boolean checkFields() {

        return validateName() && validateAgency() && validateStartDate() && validateEndDate();
    }

    /**
     * Validate agency.
     *
     * @return true, if successful
     */
    private boolean validateAgency() {
        JTextField jText = view.getTxt_satelliteAgency();
        if (!CheckerField.checkTextField(jText)) {
            view.showError("Agency can not be empty");
            return false;
        }
        bean.setAgenziaSatellite(jText.getText());
        return true;

    }

    /**
     * Validate end date.
     *
     * @return true, if successful
     */
    private boolean validateEndDate() {
        JTextField txt_day = view.getTxt_endDay();
        JTextField txt_month = view.getTxt_endMonth();
        JTextField txt_year = view.getTxt_endYear();
        if (CheckerField.checkTextField(txt_day) && CheckerField.checkTextField(txt_month) && CheckerField.checkTextField(txt_year)) {
            int year, month, day;
            try {
                day = Integer.parseInt(txt_day.getText());
                year = Integer.parseInt(txt_year.getText());
                month = Integer.parseInt(txt_month.getText());
                bean.setEndDate(year, month, day);
                return true;
            } catch (Exception e) {
                view.showError("Error in end date");
                return false;
            }
        }
        view.showError("End date can not be empty");
        return false;

    }

    /**
     * Validate name.
     *
     * @return true, if successful
     */
    private boolean validateName() {
        JTextField jText = view.getTxt_satelliteName();
        if (!CheckerField.checkTextField(jText)) {
            view.showError("Name can not be empty");
            return false;
        }
        bean.setNomeSatellite(jText.getText());
        return true;
    }

    /**
     * Validate start date.
     *
     * @return true, if successful
     */
    private boolean validateStartDate() {
        JTextField txt_day = view.getTxt_startDay();
        JTextField txt_month = view.getTxt_startMonth();
        JTextField txt_year = view.getTxt_startYear();
        if (CheckerField.checkTextField(txt_day) && CheckerField.checkTextField(txt_month) && CheckerField.checkTextField(txt_year)) {
            int year, month, day;
            try {
                day = Integer.parseInt(txt_day.getText());
                year = Integer.parseInt(txt_year.getText());
                month = Integer.parseInt(txt_month.getText());
                bean.setStartDate(year, month, day);
                return true;
            } catch (Exception e) {
                view.showError("Error in start date");
                return false;
            }
        }
        view.showError("Start date can not be empty");
        return false;
    }

    /**
     * The Class ButtonInsertSatelliteAL.
     */
    private class ButtonInsertSatelliteAL implements ActionListener {

        /* (non-Javadoc)
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (checkFields())
                try {
                    C_UC_InsertSatellite.getInstance().inserisciSatellite(bean);
                    view.setVisible(false);
                    parentView.setStatusBarMessage("New satellite inserted successfully");
                } catch (SaveDalException e1) {
                    view.showError("Impossible to insert a new satellite");
                }

        }

    }
}
