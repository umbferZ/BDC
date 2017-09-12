/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.view
 * Type: JFrameSearchPosition
 * Last update: 12-set-2017 19.15.25
 * 
 */

package main.org.bdc.view;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class JFrameSearchPosition extends JFrame {

    private JButton      btnInserisci;

    private JPanel       contentPane;

    private JLabel       error;

    private JTextField   fld_dist;

    private JTextField   fld_lat;

    private JTextField   fld_limit;

    private JTextField   fld_long;

    private ButtonGroup  radioGroupGeometry;

    private ButtonGroup  radioGroupType;

    private JRadioButton rdbtnGeometryRound;

    private JRadioButton rdbtnGeometrySquare;

    private JRadioButton rdbtnTypeClump;

    private JRadioButton rdbtnTypeSource;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    JFrameSearchPosition frame = new JFrameSearchPosition();
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
    public JFrameSearchPosition() {
        setTitle("Search From Position");
        setType(Type.UTILITY);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        radioGroupGeometry = new ButtonGroup();

        radioGroupType = new ButtonGroup();

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Search from position", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(12, 12, 422, 229);
        contentPane.add(panel);
        panel.setLayout(new FormLayout(new ColumnSpec[] {
                FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
                ColumnSpec.decode("default:grow"),
        }, new RowSpec[] {
                FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
                FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"), FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"), FormSpecs.RELATED_GAP_ROWSPEC,
                FormSpecs.DEFAULT_ROWSPEC,
        }));

        JLabel lblNome = new JLabel("Latitude");
        panel.add(lblNome, "2, 2, right, default");

        fld_lat = new JTextField();
        panel.add(fld_lat, "4, 2, fill, default");
        fld_lat.setColumns(10);

        JLabel lblLongitude = new JLabel("Longitude");
        panel.add(lblLongitude, "6, 2, right, default");

        fld_long = new JTextField();
        panel.add(fld_long, "8, 2, fill, default");
        fld_long.setColumns(10);

        JLabel lblDistance = new JLabel("Distance");
        panel.add(lblDistance, "2, 4, right, default");

        fld_dist = new JTextField();
        panel.add(fld_dist, "4, 4, fill, default");
        fld_dist.setColumns(10);

        JLabel lblNewLabel = new JLabel("Limit");
        panel.add(lblNewLabel, "6, 4, right, default");

        fld_limit = new JTextField();
        panel.add(fld_limit, "8, 4, fill, default");
        fld_limit.setColumns(10);

        rdbtnTypeSource = new JRadioButton("Source");
        panel.add(rdbtnTypeSource, "4, 6");
        radioGroupType.add(rdbtnTypeSource);

        rdbtnTypeClump = new JRadioButton("Clump");
        rdbtnTypeClump.setSelected(true);
        panel.add(rdbtnTypeClump, "8, 6");
        radioGroupType.add(rdbtnTypeClump);

        rdbtnGeometrySquare = new JRadioButton("Square");
        panel.add(rdbtnGeometrySquare, "4, 8");
        radioGroupGeometry.add(rdbtnGeometrySquare);

        rdbtnGeometryRound = new JRadioButton("Round");
        rdbtnGeometryRound.setSelected(true);
        panel.add(rdbtnGeometryRound, "8, 8");
        radioGroupGeometry.add(rdbtnGeometryRound);

        btnInserisci = new JButton("Search");

        panel.add(btnInserisci, "8, 12, center, center");

        error = new JLabel("");
        error.setBounds(12, 253, 422, 15);
        contentPane.add(error);
    }

    public void addInserisciSearchListener(ActionListener listener) {
        btnInserisci.addActionListener(listener);
    }

    public JButton getBtnInserisci() {
        return btnInserisci;
    }

    public JLabel getError() {
        return error;
    }

    public JTextField getFld_dist() {
        return fld_dist;
    }

    public JTextField getFld_lat() {
        return fld_lat;
    }

    public JTextField getFld_limit() {
        return fld_limit;
    }

    public JTextField getFld_long() {
        return fld_long;
    }

    public JRadioButton getRdbtnGeometryRound() {
        return rdbtnGeometryRound;
    }

    public JRadioButton getRdbtnGeometrySquare() {
        return rdbtnGeometrySquare;
    }

    public JRadioButton getRdbtnTypeClump() {
        return rdbtnTypeClump;
    }

    public JRadioButton getRdbtnTypeSource() {
        return rdbtnTypeSource;
    }

    public void setBtnInserisci(JButton btnInserisci) {
        this.btnInserisci = btnInserisci;
    }

    public void setError(JLabel error) {
        this.error = error;
    }

    public void setFld_dist(JTextField fld_dist) {
        this.fld_dist = fld_dist;
    }

    public void setFld_lat(JTextField fld_lat) {
        this.fld_lat = fld_lat;
    }

    public void setFld_limit(JTextField fld_limit) {
        this.fld_limit = fld_limit;
    }

    public void setFld_long(JTextField fld_long) {
        this.fld_long = fld_long;
    }

    public void setRdbtnGeometryRound(JRadioButton rdbtnGeometryRound) {
        this.rdbtnGeometryRound = rdbtnGeometryRound;
    }

    public void setRdbtnGeometrySquare(JRadioButton rdbtnGeometrySquare) {
        this.rdbtnGeometrySquare = rdbtnGeometrySquare;
    }

    public void setRdbtnTypeClump(JRadioButton rdbtnTypeClump) {
        this.rdbtnTypeClump = rdbtnTypeClump;
    }

    public void setRdbtnTypeSource(JRadioButton rdbtnTypeSource) {
        this.rdbtnTypeSource = rdbtnTypeSource;
    }

    public void showError(String error) {
        this.error.setText(error);
        this.error.setVisible(true);
    }
}
