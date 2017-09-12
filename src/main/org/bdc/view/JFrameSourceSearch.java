package main.org.bdc.view;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by Sasha on 11/09/17.
 */
public class JFrameSourceSearch extends JFrame {

    private JPanel contentPane;

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
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Search source", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(47, 43, 354, 200);
        contentPane.add(panel);
        panel.setLayout(new FormLayout(new ColumnSpec[]{
                FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
        }, new RowSpec[]{
                FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"), FormSpecs.RELATED_GAP_ROWSPEC,
                RowSpec.decode("default:grow"), FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
        }));

        JLabel lblNome = new JLabel("Position");
        panel.add(lblNome, "2, 2, right, default");

        position = new JTextField();
        panel.add(position, "4, 2, fill, default");
        position.setColumns(10);

        /*JLabel lblr = new JLabel("Round");
        panel.add(lblr, "2, 10, right, default");

        JCheckBox round = new JCheckBox("");
        panel.add(round, "4, 10");

        JLabel lblsq = new JLabel("Square");
        panel.add(lblsq, "2, 10, right, default");

        JCheckBox square = new JCheckBox("");
        panel.add(square, "4, 10");*/

        JButton btnInserisci = new JButton("Search");
        panel.add(btnInserisci, "4, 10");
    }

}
