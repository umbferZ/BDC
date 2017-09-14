/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view.manager
 * Type: CJFramNewSatellite
 * Last update: 14-set-2017 15.23.09
 * 
 */

package main.org.bdc.view.manager;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import main.org.bdc.controls.C_UC_InsertSatellite;
import main.org.bdc.controls.gestisciSatellite.BeanInserisciSatellite;
import main.org.bdc.service.dal.exception.SaveOrUpdateDalException;
import main.org.bdc.view.JFrameInserisciSatellite;
import main.org.bdc.view.JFrameMain;
import main.org.bdc.view.tools.CheckerField;

public class CJFramNewSatellite {

    private BeanInserisciSatellite   bean;

    private JFrameMain               parentView;

    private JFrameInserisciSatellite view;

    public static void main(String[] args) {
        new CJFramNewSatellite(null);
    }

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

    private boolean checkFields() {

        return validateName() && validateAgency() && validateStartDate() && validateEndDate();
    }

    private boolean validateAgency() {
        JTextField jText = view.getTxt_satelliteAgency();
        if (!CheckerField.checkTextField(jText)) {
            view.showError("Agency can not be empty");
            return false;
        }
        bean.setAgenziaSatellite(jText.getText());
        return true;

    }

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

    private boolean validateName() {
        JTextField jText = view.getTxt_satelliteName();
        if (!CheckerField.checkTextField(jText)) {
            view.showError("Name can not be empty");
            return false;
        }
        bean.setNomeSatellite(jText.getText());
        return true;
    }

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

    private class ButtonInsertSatelliteAL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (checkFields())
                try {
                    C_UC_InsertSatellite.getInstance().inserisciSatellite(bean);
                    view.setVisible(false);
                    parentView.setStatusBarMessage("New satellite inserted successfully");
                } catch (SaveOrUpdateDalException e1) {
                    view.showError("Impossible to insert a new satellite");
                }

        }

    }
}
