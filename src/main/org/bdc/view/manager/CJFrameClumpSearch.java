/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view.manager
 * Type: CJFrameClumpSearch
 * Last update: 20-set-2017 13.23.24
 * 
 */

package main.org.bdc.view.manager;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.JTextField;

import main.org.bdc.controls.C_UC_SearchClumps;
import main.org.bdc.model.galaxy.Clump;
import main.org.bdc.view.JFrameClumpSearch;
import main.org.bdc.view.JFrameMain;
import main.org.bdc.view.tools.CheckerField;

/**
 * The Class CJFrameClumpSearch.
 */
public class CJFrameClumpSearch {

    private int               clumpId;

    private JFrameMain        parent;

    private JFrameClumpSearch view;


    /**
     * Instantiates a new CJ frame clump search.
     *
     * @param parent the parent
     */
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

    /**
     * Check field.
     *
     * @return true, if successful
     */
    private boolean checkField() {
        JTextField jTextField = view.getClump_id();
        if (!CheckerField.checkTextField(jTextField)) {
            view.showError("Scrivi l'id clump");
            return false;
        }
        clumpId = Integer.parseInt(jTextField.getText());
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
