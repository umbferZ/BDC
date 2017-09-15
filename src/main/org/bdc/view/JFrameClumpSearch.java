/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view
 * Type: JFrameClumpSearch
 * Last update: 15-set-2017 13.53.04
 * 
 */

package main.org.bdc.view;

import java.awt.Font;
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

public class JFrameClumpSearch extends JFrame {

    private JButton    btn_search;

    private JTextField clump_id;

    private JPanel     contentPane;

    private JLabel     lblNewLabel;

    /**
     * Create the frame.
     */
    public JFrameClumpSearch() {

        setTitle("Search Clump");
        setType(Type.UTILITY);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Search Clump from ID", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(47, 22, 354, 100);
        contentPane.add(panel);
        panel.setLayout(new FormLayout(new ColumnSpec[] {
                FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
        }, new RowSpec[] {
                FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"), FormSpecs.RELATED_GAP_ROWSPEC,
                RowSpec.decode("default:grow"), FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
        }));

        JLabel lblNome = new JLabel("Clump ID");
        panel.add(lblNome, "2, 2, right, default");

        clump_id = new JTextField();
        panel.add(clump_id, "4, 2, fill, default");
        clump_id.setColumns(10);

        btn_search = new JButton("Search");
        panel.add(btn_search, "4, 4");

        lblNewLabel = new JLabel("");
        lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 11));
        lblNewLabel.setBounds(12, 153, 422, 15);
        contentPane.add(lblNewLabel);
    }

    public void addButtonSearchAL(ActionListener actionListener) {
        btn_search.addActionListener(actionListener);
    }

    public JButton getBtn_search() {
        return btn_search;
    }

    public JTextField getClump_id() {
        return clump_id;
    }

    public void setBtn_search(JButton btn_search) {
        this.btn_search = btn_search;
    }

    public void setClump_id(JTextField clump_id) {
        this.clump_id = clump_id;
    }

    public void showError(String string) {
        lblNewLabel.setText(string);
        lblNewLabel.setVisible(true);

    }

}
