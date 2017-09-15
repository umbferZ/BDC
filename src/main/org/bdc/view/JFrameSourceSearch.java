/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view
 * Type: JFrameSourceSearch
 * Last update: 15-set-2017 9.59.15
 * 
 */

package main.org.bdc.view;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

/**
 * Created by Sasha on 11/09/17.
 */
public class JFrameSourceSearch extends JFrame {

    private JButton    btnInserisci;

    private JPanel     contentPane;

    private JTextField txt_band;

    private JTextField txt_clumpId;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    JFrameSourceSearch frame = new JFrameSourceSearch();
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
    public JFrameSourceSearch() {
        setTitle("Search source");
        setType(Type.UTILITY);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Search source", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(47, 43, 356, 142);
        contentPane.add(panel);
        panel.setLayout(new FormLayout(new ColumnSpec[] {
                FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
        }, new RowSpec[] {
                FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"), FormSpecs.RELATED_GAP_ROWSPEC,
                RowSpec.decode("default:grow"), FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
        }));

        JLabel lblNome = new JLabel("ID-CLUMP");
        panel.add(lblNome, "2, 2, right, default");

        txt_clumpId = new JTextField();
        panel.add(txt_clumpId, "4, 2, fill, default");
        txt_clumpId.setColumns(10);

        /*
         * JLabel lblr = new JLabel("Round"); panel.add(lblr,
         * "2, 10, right, default"); JCheckBox round = new JCheckBox("");
         * panel.add(round, "4, 10"); JLabel lblsq = new JLabel("Square");
         * panel.add(lblsq, "2, 10, right, default"); JCheckBox square = new
         * JCheckBox(""); panel.add(square, "4, 10");
         */

        JLabel lblResolutionBand = new JLabel("Resolution band");
        panel.add(lblResolutionBand, "2, 4, right, default");

        txt_band = new JTextField();
        panel.add(txt_band, "4, 4, fill, default");
        txt_band.setColumns(10);

        btnInserisci = new JButton("Search");
        panel.add(btnInserisci, "4, 10");

    }

    public void addSearchActionListener(ActionListener actionListener) {
        btnInserisci.addActionListener(actionListener);
    }

    public JTextField getTxt_band() {
        return txt_band;
    }

    public JTextField getTxt_clumpId() {
        return txt_clumpId;
    }

    public void setTxt_band(JTextField txt_band) {
        this.txt_band = txt_band;
    }

    public void setTxt_clumpId(JTextField txt_clumpId) {
        this.txt_clumpId = txt_clumpId;
    }
}
