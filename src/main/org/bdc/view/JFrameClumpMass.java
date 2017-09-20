/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view
 * Type: JFrameClumpMass
 * Last update: 20-set-2017 13.23.24
 * 
 */

package main.org.bdc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 * The Class JFrameClumpMass.
 */
public class JFrameClumpMass extends JFrame {

    private JPanel contentPane;

    private JTable table;

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
                    JFrameClumpMass frame = new JFrameClumpMass();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Instantiates a new j frame clump mass.
     */
    public JFrameClumpMass() {
        setTitle("Clumps Mass");
        setType(Type.UTILITY);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(this.contentPane);
        this.contentPane.setLayout(null);

        Object data[][] = {
                {
                        "id", "m"
                }
        };
        Object colN[] = {
                "clump-id", "mass"
        };

        this.table = new JTable(data, colN);
        this.table.setBounds(0, 0, 450, 300);
        this.add(new JScrollPane(this.table));

        /*
         * JPanel panel = new JPanel(); panel.setBorder(new TitledBorder(null,
         * "Clumps Mass", TitledBorder.LEADING, TitledBorder.TOP, null, null));
         * panel.setBounds(47, 43, 354, 200); contentPane.add(panel);
         * panel.setLayout(new FormLayout(new ColumnSpec[]{
         * FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
         * FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), },
         * new RowSpec[]{ FormSpecs.RELATED_GAP_ROWSPEC,
         * FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
         * FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
         * RowSpec.decode("default:grow"), FormSpecs.RELATED_GAP_ROWSPEC,
         * RowSpec.decode("default:grow"), FormSpecs.RELATED_GAP_ROWSPEC,
         * FormSpecs.DEFAULT_ROWSPEC, }));
         */

    }

}
