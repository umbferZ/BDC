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


public class JFrameObjectInMap extends JFrame {

    private JButton btn_search;

    public JTextField getMap() {
        return map;
    }

    public void setMap(JTextField map) {
        this.map = map;
    }

    public JTextField getBand() {
        return band;
    }

    public void setBand(JTextField band) {
        this.band = band;
    }

    private JTextField map;

    private JTextField band;

    private JPanel     contentPane;

    private JLabel     lblNewLabel;

    /**
     * Create the frame.
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

    public void addButtonObject(ActionListener actionListener) {
        btn_search.addActionListener(actionListener);
    }

    public JButton getBtn_search() {
        return btn_search;
    }


    public void setBtn_search(JButton btn_search) {
        this.btn_search = btn_search;
    }


    public void showError(String string) {
        lblNewLabel.setText(string);
        lblNewLabel.setVisible(true);

    }


}
