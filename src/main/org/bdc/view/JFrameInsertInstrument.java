/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view
 * Type: JFrameInsertInstrument
 * Last update: 14-set-2017 17.00.48
 * 
 */

package main.org.bdc.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class JFrameInsertInstrument extends JFrame {

    private JButton    btn_insert;

    private JComboBox  cb_map;

    private JComboBox  cb_satellite;

    private JLabel     lbl_error;

    private JTextField txt_instrumentName;
    private JLabel lblName;

    public JFrameInsertInstrument() {
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "New instrument", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(42, 49, 376, 167);
        getContentPane().add(panel);
        panel.setLayout(new FormLayout(new ColumnSpec[] {
                FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
        }, new RowSpec[] {
                FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
        }));

        lblName = new JLabel("Name");
        panel.add(lblName, "2, 2, right, default");

        txt_instrumentName = new JTextField();
        panel.add(txt_instrumentName, "4, 2, fill, default");
        txt_instrumentName.setColumns(10);

        JLabel lblSatellite = new JLabel("Satellite");
        panel.add(lblSatellite, "2, 4, right, default");

        cb_satellite = new JComboBox();
        panel.add(cb_satellite, "4, 4, fill, default");

        JLabel lblMap = new JLabel("Map");
        panel.add(lblMap, "2, 6, right, default");

        cb_map = new JComboBox();
        panel.add(cb_map, "4, 6, fill, default");

        btn_insert = new JButton("Insert");
        panel.add(btn_insert, "4, 8");

        lbl_error = new JLabel("");
        lbl_error.setBounds(12, 253, 422, 15);
        getContentPane().add(lbl_error);
    }

    public void addButtonInsertAL(ActionListener actionListener) {
        btn_insert.addActionListener(actionListener);
    }

    public JButton getBtn_insert() {
        return btn_insert;
    }

    public JComboBox getCb_map() {
        return cb_map;
    }

    public JComboBox getCb_satellite() {
        return cb_satellite;
    }

    public JTextField getTxt_instrumentName() {
        return txt_instrumentName;
    }

    public void setBtn_insert(JButton btn_insert) {
        this.btn_insert = btn_insert;
    }

    public void setCb_map(JComboBox cb_map) {
        this.cb_map = cb_map;
    }

    public void setCb_satellite(JComboBox cb_satellite) {
        this.cb_satellite = cb_satellite;
    }

    public void setTxt_instrumentName(JTextField txt_instrumentName) {
        this.txt_instrumentName = txt_instrumentName;
    }

    public void showError(String string) {
        lbl_error.setText(string);
        lbl_error.setVisible(true);
    }
}
