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

public class JFrameInsertInstrument extends JFrame {

    private JPanel contentPane;
    private JTextField txt_instrumentName;
    private JPanel panel;
    private JLabel lbl_name;
    private JLabel lbl_satellite;
    private JComboBox cb_satellite;
    private JLabel lbl_map;
    private JComboBox cb_map;
    private JButton btn_insert;
    private JLabel lbl_error;

    /**
     * Launch the application.
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
     * Create the frame.
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
        panel.setBounds(52, 37, 332, 177);
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

        lbl_satellite = new JLabel("Satellite");
        panel.add(lbl_satellite, "2, 4, right, default");


        String[] combolistSatellite = new String[]{"auu","ausi","asodiuasoidu","!asioduoas","!kasd"};
        cb_satellite = new JComboBox(combolistSatellite);



//  // riempi(combolist);
//  for (int i = 1; i < 10; i++)
//   combolistSatellite[i] = "yugg" + i;
//  JComboBox cb_satellite = new JComboBox(combolistSatellite);

        cb_satellite.setSelectedItem(null);
        panel.add(cb_satellite, "4, 4, fill, default");

        lbl_map = new JLabel("Map");
        panel.add(lbl_map, "2, 6, right, default");

        String[] combolistMap = new String[]{"12","12387","ahsiuwo"};
        cb_map = new JComboBox(combolistMap);

//  for (int i = 1; i < 10; i++)
//   combolistSatellite[i] = "yugg" + i;
//  JComboBox cb_map = new JComboBox(combolistSatellite);
        cb_map.setSelectedItem(null);

        panel.add(cb_map, "4, 6, fill, default");

        btn_insert = new JButton("Insert");
        panel.add(btn_insert, "4, 10, default, top");

        lbl_error = new JLabel("");
        lbl_error.setBounds(12, 253, 422, 15);
        contentPane.add(lbl_error);
    }

    public JTextField getTxt_instrumentName() {
        return txt_instrumentName;
    }

    public void setTxt_name(JTextField txt_name) {
        this.txt_instrumentName = txt_name;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JLabel getLbl_name() {
        return lbl_name;
    }

    public void setLbl_name(JLabel lbl_name) {
        this.lbl_name = lbl_name;
    }

    public JLabel

    getLbl_satellite() {
        return lbl_satellite;
    }

    public void setLbl_satellite(JLabel lbl_satellite) {
        this.lbl_satellite = lbl_satellite;
    }

    public JComboBox getCb_satellite() {
        return cb_satellite;
    }

    public void setCb_satellite(JComboBox cb_satellite) {
        this.cb_satellite = cb_satellite;
    }

    public JLabel getLbl_map() {
        return lbl_map;
    }

    public void setLbl_map(JLabel lbl_map) {
        this.lbl_map = lbl_map;
    }

    public JComboBox getCb_map() {
        return cb_map;
    }

    public void setCb_map(JComboBox cb_map) {
        this.cb_map = cb_map;
    }

    public JButton getBtn_insert() {
        return btn_insert;
    }

    public void setBtn_insert(JButton btn_insert) {
        this.btn_insert = btn_insert;
    }

    public JLabel getLbl_error() {
        return lbl_error;
    }

    public void setLbl_error(JLabel lbl_error) {
        this.lbl_error = lbl_error;
    }

    public void addButtonInsertAL(ActionListener actionListener) {
        btn_insert.addActionListener(actionListener);
    }

}