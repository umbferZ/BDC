/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.view
 * Type: JFrameInserisciSattellite
 * Last update: 17-mar-2017 7.53.09
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
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "New satellite", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(47, 43, 354, 189);
        contentPane.add(panel);
        panel.setLayout(new FormLayout(new ColumnSpec[] {
                FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
        }, new RowSpec[] {
                FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"), FormSpecs.RELATED_GAP_ROWSPEC,
                RowSpec.decode("default:grow"), FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
        }));

        JLabel lblNome = new JLabel("Name");
        panel.add(lblNome, "2, 2, right, default");

        txt_satellite_agenzia_2 = new JTextField();
        txt_satellite_agenzia_2.setToolTipText("New satellite name");
        panel.add(txt_satellite_agenzia_2, "4, 2, fill, default");
        txt_satellite_agenzia_2.setColumns(10);

        JLabel lblAgenzia = new JLabel("Agency");
        panel.add(lblAgenzia, "2, 4, right, default");

        txt_satellite_agenzia = new JTextField();
        txt_satellite_agenzia.setToolTipText("Agency");
        panel.add(txt_satellite_agenzia, "4, 4, fill, default");
        txt_satellite_agenzia.setColumns(10);

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

        txt_start_d = new JTextField();
        pnlForm_startMission.add(txt_start_d, "2, 2, fill, default");
        txt_start_d.setColumns(10);

        JLabel lblMm = new JLabel("/");
        pnlForm_startMission.add(lblMm, "4, 2, right, default");

        txt_start_m = new JTextField();
        pnlForm_startMission.add(txt_start_m, "6, 2, fill, default");
        txt_start_m.setColumns(10);

        JLabel lblYyyy = new JLabel("/");
        pnlForm_startMission.add(lblYyyy, "8, 2, right, default");

        txt_start_y = new JTextField();
        pnlForm_startMission.add(txt_start_y, "10, 2, fill, default");
        txt_start_y.setColumns(10);

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

        txt_end_d = new JTextField();
        pnlForm_endMission.add(txt_end_d, "2, 2, fill, default");
        txt_end_d.setColumns(10);

        JLabel lblMm_1 = new JLabel("/");
        pnlForm_endMission.add(lblMm_1, "4, 2, right, default");

        txt_end_m = new JTextField();
        pnlForm_endMission.add(txt_end_m, "6, 2, fill, default");
        txt_end_m.setColumns(10);

        JLabel lblYyyy_1 = new JLabel("/");
        pnlForm_endMission.add(lblYyyy_1, "8, 2, right, default");

        txt_end_y = new JTextField();
        pnlForm_endMission.add(txt_end_y, "10, 2, fill, default");
        txt_end_y.setColumns(10);

        JButton btnInserisci = new JButton("Inserisci");
        panel.add(btnInserisci, "4, 10");
    }
}
