/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view
 * Type: JFrameSourceSearch
 * Last update: 13-set-2017 0.23.41
 * 
 */

package main.org.bdc.view;

import java.awt.EventQueue;

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

    private JPanel     contentPane;

    private JTextField position;

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
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(this.contentPane);
        this.contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Search source", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(47, 43, 354, 200);
        this.contentPane.add(panel);
        panel.setLayout(new FormLayout(new ColumnSpec[] {
                FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
        }, new RowSpec[] {
                FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"), FormSpecs.RELATED_GAP_ROWSPEC,
                RowSpec.decode("default:grow"), FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
        }));

        JLabel lblNome = new JLabel("Position");
        panel.add(lblNome, "2, 2, right, default");

        this.position = new JTextField();
        panel.add(this.position, "4, 2, fill, default");
        this.position.setColumns(10);

        /*
         * JLabel lblr = new JLabel("Round"); panel.add(lblr,
         * "2, 10, right, default"); JCheckBox round = new JCheckBox("");
         * panel.add(round, "4, 10"); JLabel lblsq = new JLabel("Square");
         * panel.add(lblsq, "2, 10, right, default"); JCheckBox square = new
         * JCheckBox(""); panel.add(square, "4, 10");
         */

        JButton btnInserisci = new JButton("Search");
        panel.add(btnInserisci, "4, 10");
    }

}
