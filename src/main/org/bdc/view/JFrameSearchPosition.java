/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view
 * Type: JFrameSearchPosition
 * Last update: 20-set-2017 13.23.24
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

/**
 * The Class JFrameSearchPosition.
 */
public class JFrameSearchPosition extends JFrame {

    private JButton      btnInserisci;

    private JPanel       contentPane;

    private JLabel       error;

    private JTextField   fld_dist;

    private JTextField   fld_lat;

    private JTextField   fld_limit;

    private JTextField   fld_long;

    private JLabel       lblGeometry;

    private JLabel       lblType;

    private ButtonGroup  radioGroupGeometry;

    private ButtonGroup  radioGroupType;

    private JRadioButton rdbtnGeometryRound;

    private JRadioButton rdbtnGeometrySquare;

    private JRadioButton rdbtnTypeClump;

    private JRadioButton rdbtnTypeSource;

    /**
     * The main method.
     *
     * @param args the arguments
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
     * Instantiates a new j frame search position.
     */
    public JFrameSearchPosition() {
        setTitle("Search From Position");
        setType(Type.UTILITY);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(this.contentPane);
        this.contentPane.setLayout(null);

        this.radioGroupGeometry = new ButtonGroup();

        this.radioGroupType = new ButtonGroup();

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Search from position", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(12, 45, 422, 173);
        this.contentPane.add(panel);
        panel.setLayout(new FormLayout(new ColumnSpec[] {
                FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
                ColumnSpec.decode("default:grow"),
        }, new RowSpec[] {
                FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
                FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
        }));

        JLabel lblNome = new JLabel("Latitude");
        panel.add(lblNome, "2, 2, right, default");

        this.fld_lat = new JTextField();
        panel.add(this.fld_lat, "4, 2, fill, default");
        this.fld_lat.setColumns(10);

        JLabel lblLongitude = new JLabel("Longitude");
        panel.add(lblLongitude, "6, 2, right, default");

        this.fld_long = new JTextField();
        panel.add(this.fld_long, "8, 2, fill, default");
        this.fld_long.setColumns(10);

        JLabel lblDistance = new JLabel("Distance");
        panel.add(lblDistance, "2, 4, right, default");

        this.fld_dist = new JTextField();
        panel.add(this.fld_dist, "4, 4, fill, default");
        this.fld_dist.setColumns(10);

        JLabel lblNewLabel = new JLabel("Limit");
        panel.add(lblNewLabel, "6, 4, right, default");

        this.fld_limit = new JTextField();
        panel.add(this.fld_limit, "8, 4, fill, default");
        this.fld_limit.setColumns(10);

        this.lblType = new JLabel("Type");
        panel.add(this.lblType, "2, 6");

        this.rdbtnTypeSource = new JRadioButton("Source");
        panel.add(this.rdbtnTypeSource, "4, 6");
        this.radioGroupType.add(this.rdbtnTypeSource);

        this.rdbtnTypeClump = new JRadioButton("Clump");
        this.rdbtnTypeClump.setSelected(true);
        panel.add(this.rdbtnTypeClump, "6, 6");
        this.radioGroupType.add(this.rdbtnTypeClump);

        this.lblGeometry = new JLabel("Geometry");
        panel.add(this.lblGeometry, "2, 8");

        this.rdbtnGeometrySquare = new JRadioButton("Square");
        panel.add(this.rdbtnGeometrySquare, "4, 8");
        this.radioGroupGeometry.add(this.rdbtnGeometrySquare);

        this.rdbtnGeometryRound = new JRadioButton("Round");
        this.rdbtnGeometryRound.setSelected(true);
        panel.add(this.rdbtnGeometryRound, "6, 8");
        this.radioGroupGeometry.add(this.rdbtnGeometryRound);

        this.btnInserisci = new JButton("Search");

        panel.add(this.btnInserisci, "8, 10, center, center");

        this.error = new JLabel("");
        this.error.setBounds(12, 253, 422, 15);
        this.contentPane.add(this.error);
    }

    /**
     * Adds the inserisci search listener.
     *
     * @param listener the listener
     */
    public void addInserisciSearchListener(ActionListener listener) {
        this.btnInserisci.addActionListener(listener);
    }

    /**
     * Gets the btn inserisci.
     *
     * @return the btn inserisci
     */
    public JButton getBtnInserisci() {
        return this.btnInserisci;
    }

    /**
     * Gets the error.
     *
     * @return the error
     */
    public JLabel getError() {
        return this.error;
    }

    /**
     * Gets the fld dist.
     *
     * @return the fld dist
     */
    public JTextField getFld_dist() {
        return this.fld_dist;
    }

    /**
     * Gets the fld lat.
     *
     * @return the fld lat
     */
    public JTextField getFld_lat() {
        return this.fld_lat;
    }

    /**
     * Gets the fld limit.
     *
     * @return the fld limit
     */
    public JTextField getFld_limit() {
        return this.fld_limit;
    }

    /**
     * Gets the fld long.
     *
     * @return the fld long
     */
    public JTextField getFld_long() {
        return this.fld_long;
    }

    /**
     * Gets the rdbtn geometry round.
     *
     * @return the rdbtn geometry round
     */
    public JRadioButton getRdbtnGeometryRound() {
        return this.rdbtnGeometryRound;
    }

    /**
     * Gets the rdbtn geometry square.
     *
     * @return the rdbtn geometry square
     */
    public JRadioButton getRdbtnGeometrySquare() {
        return this.rdbtnGeometrySquare;
    }

    /**
     * Gets the rdbtn type clump.
     *
     * @return the rdbtn type clump
     */
    public JRadioButton getRdbtnTypeClump() {
        return this.rdbtnTypeClump;
    }

    /**
     * Gets the rdbtn type source.
     *
     * @return the rdbtn type source
     */
    public JRadioButton getRdbtnTypeSource() {
        return this.rdbtnTypeSource;
    }

    /**
     * Sets the btn inserisci.
     *
     * @param btnInserisci the new btn inserisci
     */
    public void setBtnInserisci(JButton btnInserisci) {
        this.btnInserisci = btnInserisci;
    }

    /**
     * Sets the error.
     *
     * @param error the new error
     */
    public void setError(JLabel error) {
        this.error = error;
    }

    /**
     * Sets the fld dist.
     *
     * @param fld_dist the new fld dist
     */
    public void setFld_dist(JTextField fld_dist) {
        this.fld_dist = fld_dist;
    }

    /**
     * Sets the fld lat.
     *
     * @param fld_lat the new fld lat
     */
    public void setFld_lat(JTextField fld_lat) {
        this.fld_lat = fld_lat;
    }

    /**
     * Sets the fld limit.
     *
     * @param fld_limit the new fld limit
     */
    public void setFld_limit(JTextField fld_limit) {
        this.fld_limit = fld_limit;
    }

    /**
     * Sets the fld long.
     *
     * @param fld_long the new fld long
     */
    public void setFld_long(JTextField fld_long) {
        this.fld_long = fld_long;
    }

    /**
     * Sets the rdbtn geometry round.
     *
     * @param rdbtnGeometryRound the new rdbtn geometry round
     */
    public void setRdbtnGeometryRound(JRadioButton rdbtnGeometryRound) {
        this.rdbtnGeometryRound = rdbtnGeometryRound;
    }

    /**
     * Sets the rdbtn geometry square.
     *
     * @param rdbtnGeometrySquare the new rdbtn geometry square
     */
    public void setRdbtnGeometrySquare(JRadioButton rdbtnGeometrySquare) {
        this.rdbtnGeometrySquare = rdbtnGeometrySquare;
    }

    /**
     * Sets the rdbtn type clump.
     *
     * @param rdbtnTypeClump the new rdbtn type clump
     */
    public void setRdbtnTypeClump(JRadioButton rdbtnTypeClump) {
        this.rdbtnTypeClump = rdbtnTypeClump;
    }

    /**
     * Sets the rdbtn type source.
     *
     * @param rdbtnTypeSource the new rdbtn type source
     */
    public void setRdbtnTypeSource(JRadioButton rdbtnTypeSource) {
        this.rdbtnTypeSource = rdbtnTypeSource;
    }

    /**
     * Show error.
     *
     * @param error the error
     */
    public void showError(String error) {
        this.error.setText(error);
        this.error.setVisible(true);
    }
}
