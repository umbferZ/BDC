/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view
 * Type: JFrameInsertInstrument
 * Last update: 20-set-2017 13.23.22
 * 
 */
package main.org.bdc.view;

import javax.swing.*;
import java.awt.*;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

        import javax.swing.JFrame;
        import javax.swing.JPanel;
        import javax.swing.border.EmptyBorder;
        import javax.swing.border.TitledBorder;
        import com.jgoodies.forms.layout.FormLayout;
        import com.jgoodies.forms.layout.ColumnSpec;
        import com.jgoodies.forms.layout.RowSpec;
        import com.jgoodies.forms.layout.FormSpecs;
        import javax.swing.JLabel;
        import javax.swing.JTextField;
        import javax.swing.WindowConstants;
        import javax.swing.JComboBox;
        import javax.swing.JButton;

/**
 * The Class JFrameInsertInstrument.
 */
public class JFrameInsertInstrument extends JFrame {

    private JPanel contentPane;
    private JTextField txt_instrumentName;
    private JPanel panel;
    private JLabel lbl_name;
    private JLabel lbl_satellite;
    private JTextField txt_satName;
    private JLabel lbl_map;
    private JTextField txt_mapName;
    private JButton btn_insert;

    /**
     * Sets the txt instrument name.
     *
     * @param txt_instrumentName the new txt instrument name
     */
    public void setTxt_instrumentName(JTextField txt_instrumentName) {
        this.txt_instrumentName = txt_instrumentName;
    }

    /**
     * Gets the txt sat name.
     *
     * @return the txt sat name
     */
    public JTextField getTxt_satName() {
        return txt_satName;
    }

    /**
     * Sets the txt sat name.
     *
     * @param txt_satName the new txt sat name
     */
    public void setTxt_satName(JTextField txt_satName) {
        this.txt_satName = txt_satName;
    }

    /**
     * Gets the txt map name.
     *
     * @return the txt map name
     */
    public JTextField getTxt_mapName() {
        return txt_mapName;
    }

    /**
     * Sets the txt map name.
     *
     * @param txt_mapName the new txt map name
     */
    public void setTxt_mapName(JTextField txt_mapName) {
        this.txt_mapName = txt_mapName;
    }

    private JLabel lbl_error;

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrameInsertInstrument frame = new JFrameInsertInstrument();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Instantiates a new j frame insert instrument.
     */
    public JFrameInsertInstrument() {
        setTitle("New instrument");
        setType(Type.UTILITY);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "New Instrument", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(52, 37, 332, 200);
        contentPane.add(panel);
        panel.setLayout(new FormLayout(
                new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
                        FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), },
                new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
                        FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
                        FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
                        FormSpecs.DEFAULT_ROWSPEC, }));

        lbl_name = new JLabel("Name");
        panel.add(lbl_name, "2, 2, right, default");

        txt_instrumentName = new JTextField();
        panel.add(txt_instrumentName, "4, 2, fill, default");
        txt_instrumentName.setColumns(10);

        lbl_map = new JLabel("Map");
        panel.add(lbl_map, "2, 4, right, default");

        txt_mapName = new JTextField();
        panel.add(txt_mapName, "4, 4, fill, default");
        txt_mapName.setColumns(10);

        lbl_satellite = new JLabel("Satellite");
        panel.add(lbl_satellite, "2, 6, right, default");

        txt_satName = new JTextField();
        panel.add(txt_satName, "4, 8, fill, default");
        txt_satName.setColumns(10);

        btn_insert = new JButton("Insert");
        panel.add(btn_insert, "4, 10, default, top");

        lbl_error = new JLabel("");
        lbl_error.setBounds(12, 253, 422, 15);
        contentPane.add(lbl_error);
    }

    /**
     * Gets the txt instrument name.
     *
     * @return the txt instrument name
     */
    public JTextField getTxt_instrumentName() {
        return txt_instrumentName;
    }

    /**
     * Sets the txt name.
     *
     * @param txt_name the new txt name
     */
    public void setTxt_name(JTextField txt_name) {
        this.txt_instrumentName = txt_name;
    }

    /**
     * Gets the panel.
     *
     * @return the panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * Sets the panel.
     *
     * @param panel the new panel
     */
    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    /**
     * Gets the lbl name.
     *
     * @return the lbl name
     */
    public JLabel getLbl_name() {
        return lbl_name;
    }

    /**
     * Sets the lbl name.
     *
     * @param lbl_name the new lbl name
     */
    public void setLbl_name(JLabel lbl_name) {
        this.lbl_name = lbl_name;
    }

    /**
     * Gets the lbl satellite.
     *
     * @return the lbl satellite
     */
    public JLabel

    getLbl_satellite() {
        return lbl_satellite;
    }

    /**
     * Sets the lbl satellite.
     *
     * @param lbl_satellite the new lbl satellite
     */
    public void setLbl_satellite(JLabel lbl_satellite) {
        this.lbl_satellite = lbl_satellite;
    }



    /**
     * Gets the lbl map.
     *
     * @return the lbl map
     */
    public JLabel getLbl_map() {
        return lbl_map;
    }

    /**
     * Sets the lbl map.
     *
     * @param lbl_map the new lbl map
     */
    public void setLbl_map(JLabel lbl_map) {
        this.lbl_map = lbl_map;
    }



    /**
     * Gets the btn insert.
     *
     * @return the btn insert
     */
    public JButton getBtn_insert() {
        return btn_insert;
    }

    /**
     * Sets the btn insert.
     *
     * @param btn_insert the new btn insert
     */
    public void setBtn_insert(JButton btn_insert) {
        this.btn_insert = btn_insert;
    }

    /**
     * Gets the lbl error.
     *
     * @return the lbl error
     */
    public JLabel getLbl_error() {
        return lbl_error;
    }

    /**
     * Sets the lbl error.
     *
     * @param lbl_error the new lbl error
     */
    public void setLbl_error(JLabel lbl_error) {
        this.lbl_error = lbl_error;
    }

    /**
     * Adds the button insert AL.
     *
     * @param actionListener the action listener
     */
    public void addButtonInsertAL(ActionListener actionListener) {
        btn_insert.addActionListener(actionListener);
    }

}