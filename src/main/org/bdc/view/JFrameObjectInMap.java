/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view
 * Type: JFrameObjectInMap
 * Last update: 20-set-2017 13.23.22
 * 
 */
package main.org.bdc.view;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 * The Class JFrameObjectInMap.
 */
public class JFrameObjectInMap extends JFrame {

    private JButton btn_search;

    /**
     * Gets the map.
     *
     * @return the map
     */
    public JTextField getMap() {
        return map;
    }

    /**
     * Sets the map.
     *
     * @param map the new map
     */
    public void setMap(JTextField map) {
        this.map = map;
    }

    /**
     * Gets the band.
     *
     * @return the band
     */
    public JTextField getBand() {
        return band;
    }

    /**
     * Sets the band.
     *
     * @param band the new band
     */
    public void setBand(JTextField band) {
        this.band = band;
    }

    private JTextField map;

    private JTextField band;

    private JPanel     contentPane;

    private JLabel     lblNewLabel;

    /**
     * Instantiates a new j frame object in map.
     */
    public JFrameObjectInMap() {

        setTitle("Search Object in Map");
        setType(Window.Type.UTILITY);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Search Object in Map", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(47, 22, 354, 100);
        contentPane.add(panel);
        panel.setLayout(new FormLayout(new ColumnSpec[] {
                FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
        }, new RowSpec[] {
                FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"), FormSpecs.RELATED_GAP_ROWSPEC,
                RowSpec.decode("default:grow"), FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
        }));

        JLabel lblNome = new JLabel("Map Name");
        panel.add(lblNome, "2, 2, right, default");

        map = new JTextField();
        panel.add(map, "4, 2, fill, default");
        map.setColumns(10);

        /*
        band = new JTextField();
        panel.add(band, "4, 2, fill, default");
        band.setColumns(10);
        */

        btn_search = new JButton("Search");
        panel.add(btn_search, "4, 4");

        lblNewLabel = new JLabel("");
        lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 11));
        lblNewLabel.setBounds(12, 153, 422, 15);
        contentPane.add(lblNewLabel);
    }

    /**
     * Adds the button object.
     *
     * @param actionListener the action listener
     */
    public void addButtonObject(ActionListener actionListener) {
        btn_search.addActionListener(actionListener);
    }

    /**
     * Gets the btn search.
     *
     * @return the btn search
     */
    public JButton getBtn_search() {
        return btn_search;
    }


    /**
     * Sets the btn search.
     *
     * @param btn_search the new btn search
     */
    public void setBtn_search(JButton btn_search) {
        this.btn_search = btn_search;
    }


    /**
     * Show error.
     *
     * @param string the string
     */
    public void showError(String string) {
        lblNewLabel.setText(string);
        lblNewLabel.setVisible(true);

    }


}
