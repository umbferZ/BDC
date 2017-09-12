/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.controls
 * Type: C_UC_SearchPosition
 * Last update: 12-set-2017 18.48.03
 * 
 */

package main.org.bdc.controls;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.model.galaxy.Source;
import main.org.bdc.view.JFrameMain;
import main.org.bdc.view.JFrameSearchPosition;

public class C_UC_SearchPosition {

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

    public C_UC_SearchPosition() {
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
        isClump = view.getRdbtnTypeClump().isEnabled();
        isSquare = view.getRdbtnGeometrySquare().isEnabled();
        return checklat() && checkLon() && checkDist() && checkLimit();
    }

    private boolean checkDist() {
        try {
            distance = Double.parseDouble(view.getFld_dist().getText().trim());
        } catch (Exception e) {
            error = e.getMessage();
            return false;
        }
        return true;
    }

    private boolean checklat() {
        try {
            latitude = Double.parseDouble(view.getFld_lat().getText().trim());
        } catch (Exception e) {
            error = e.getMessage();
            return false;
        }
        return true;
    }

    private boolean checkLimit() {
        try {
            limit = Integer.parseInt(view.getFld_limit().getText().trim());
        } catch (Exception e) {
            error = e.getMessage();
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
                if (isClump)
                    clumps = dao.getClumpDao().getByPositionIntoSquare(latitude, longitude, distance, limit);
                else
                    sources = dao.getSourceDao().getByPositionIntoSqure(latitude, longitude, distance, limit);
            else
                view.showError(error);

        }

    }

}
