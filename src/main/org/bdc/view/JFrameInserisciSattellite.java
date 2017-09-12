/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view
 * Type: JFrameInserisciSattellite
 * Last update: 13-set-2017 0.23.41
 * 
 */

package main.org.bdc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class JFrameInserisciSattellite extends JFrame {

    private JPanel     contentPane;

    private JTextField txt_end_d;

    private JTextField txt_end_m;

    private JTextField txt_end_y;

    private JTextField txt_satellite_agenzia;

    private JTextField txt_satellite_agenzia_2;

    private JTextField txt_start_d;

    private JTextField txt_start_m;

    private JTextField txt_start_y;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    JFrameInserisciSattellite frame = new JFrameInserisciSattellite();
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
    public JFrameInserisciSattellite() {
        setTitle("New Satellite");
        setType(Type.UTILITY);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(this.contentPane);
        this.contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "New satellite", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(47, 43, 354, 189);
        this.contentPane.add(panel);
        panel.setLayout(new FormLayout(new ColumnSpec[] {
                FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
        }, new RowSpec[] {
                FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"), FormSpecs.RELATED_GAP_ROWSPEC,
                RowSpec.decode("default:grow"), FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
        }));

        JLabel lblNome = new JLabel("Name");
        panel.add(lblNome, "2, 2, right, default");

        this.txt_satellite_agenzia_2 = new JTextField();
        this.txt_satellite_agenzia_2.setToolTipText("New satellite name");
        panel.add(this.txt_satellite_agenzia_2, "4, 2, fill, default");
        this.txt_satellite_agenzia_2.setColumns(10);

        JLabel lblAgenzia = new JLabel("Agency");
        panel.add(lblAgenzia, "2, 4, right, default");

        this.txt_satellite_agenzia = new JTextField();
        this.txt_satellite_agenzia.setToolTipText("Agency");
        panel.add(this.txt_satellite_agenzia, "4, 4, fill, default");
        this.txt_satellite_agenzia.setColumns(10);

        JPanel pnlLabel_startMission = new JPanel();
        panel.add(pnlLabel_startMission, "2, 6, right, center");
        pnlLabel_startMission.setLayout(new BorderLayout(0, 0));

        JLabel lblInizioMissione = new JLabel("Mission start");
        lblInizioMissione.setHorizontalAlignment(SwingConstants.RIGHT);
        pnlLabel_startMission.add(lblInizioMissione, BorderLayout.CENTER);

        JLabel lblGgmmyyyy = new JLabel("gg/mm/yyyy");
        lblGgmmyyyy.setHorizontalAlignment(SwingConstants.RIGHT);
        pnlLabel_startMission.add(lblGgmmyyyy, BorderLayout.SOUTH);
        lblGgmmyyyy.setFont(new Font("Dialog", Font.PLAIN, 10));

        JPanel pnlForm_startMission = new JPanel();
        panel.add(pnlForm_startMission, "4, 6, fill, center");
        pnlForm_startMission.setLayout(new FormLayout(new ColumnSpec[] {
                FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
                ColumnSpec.decode("default:grow"), FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
        }, new RowSpec[] {
                FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
        }));

        this.txt_start_d = new JTextField();
        pnlForm_startMission.add(this.txt_start_d, "2, 2, fill, default");
        this.txt_start_d.setColumns(10);

        JLabel lblMm = new JLabel("/");
        pnlForm_startMission.add(lblMm, "4, 2, right, default");

        this.txt_start_m = new JTextField();
        pnlForm_startMission.add(this.txt_start_m, "6, 2, fill, default");
        this.txt_start_m.setColumns(10);

        JLabel lblYyyy = new JLabel("/");
        pnlForm_startMission.add(lblYyyy, "8, 2, right, default");

        this.txt_start_y = new JTextField();
        pnlForm_startMission.add(this.txt_start_y, "10, 2, fill, default");
        this.txt_start_y.setColumns(10);

        JPanel pnlLabel_endMission = new JPanel();
        panel.add(pnlLabel_endMission, "2, 8, fill, center");
        pnlLabel_endMission.setLayout(new BorderLayout(0, 0));

        JLabel lblFineMissione = new JLabel("Mission end *");
        lblFineMissione.setHorizontalAlignment(SwingConstants.RIGHT);
        pnlLabel_endMission.add(lblFineMissione, BorderLayout.NORTH);

        JLabel lblGgmmyyyy_1 = new JLabel("gg/mm/yyyy");
        lblGgmmyyyy_1.setHorizontalAlignment(SwingConstants.RIGHT);
        pnlLabel_endMission.add(lblGgmmyyyy_1, BorderLayout.SOUTH);
        lblGgmmyyyy_1.setFont(new Font("Dialog", Font.PLAIN, 10));

        JPanel pnlForm_endMission = new JPanel();
        panel.add(pnlForm_endMission, "4, 8, fill, center");
        pnlForm_endMission.setLayout(new FormLayout(new ColumnSpec[] {
                FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
                ColumnSpec.decode("default:grow"), FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
        }, new RowSpec[] {
                FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
        }));

        this.txt_end_d = new JTextField();
        pnlForm_endMission.add(this.txt_end_d, "2, 2, fill, default");
        this.txt_end_d.setColumns(10);

        JLabel lblMm_1 = new JLabel("/");
        pnlForm_endMission.add(lblMm_1, "4, 2, right, default");

        this.txt_end_m = new JTextField();
        pnlForm_endMission.add(this.txt_end_m, "6, 2, fill, default");
        this.txt_end_m.setColumns(10);

        JLabel lblYyyy_1 = new JLabel("/");
        pnlForm_endMission.add(lblYyyy_1, "8, 2, right, default");

        this.txt_end_y = new JTextField();
        pnlForm_endMission.add(this.txt_end_y, "10, 2, fill, default");
        this.txt_end_y.setColumns(10);

        JButton btnInserisci = new JButton("Inserisci");
        panel.add(btnInserisci, "4, 10");
    }
}
