/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view
 * Type: JFrameInserisciSatellite
 * Last update: 14-set-2017 15.14.58
 * 
 */

package main.org.bdc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;

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

import main.org.bdc.model.galaxy.Satellite;

public class JFrameInserisciSatellite extends JFrame {

    private JButton    btn_insert;

    private JPanel     contentPane;

    private JLabel     lbl_error;

    private Satellite  satellite;

    private JTextField txt_endDay;

    private JTextField txt_endMonth;

    private JTextField txt_endYear;

    private JTextField txt_satelliteAgency;

    private JTextField txt_satelliteName;

    private JTextField txt_startDay;

    private JTextField txt_startMonth;

    private JTextField txt_startYear;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    JFrameInserisciSatellite frame = new JFrameInserisciSatellite();
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
    public JFrameInserisciSatellite() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

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

        txt_satelliteName = new JTextField();
        txt_satelliteName.setToolTipText("New satellite name");
        panel.add(txt_satelliteName, "4, 2, fill, default");
        txt_satelliteName.setColumns(10);

        JLabel lblAgenzia = new JLabel("Agency");
        panel.add(lblAgenzia, "2, 4, right, default");

        txt_satelliteAgency = new JTextField();
        txt_satelliteAgency.setToolTipText("Agency");
        panel.add(txt_satelliteAgency, "4, 4, fill, default");
        txt_satelliteAgency.setColumns(10);

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

        txt_startDay = new JTextField();
        pnlForm_startMission.add(txt_startDay, "2, 2, fill, default");
        txt_startDay.setColumns(10);

        JLabel lblMm = new JLabel("/");
        pnlForm_startMission.add(lblMm, "4, 2, right, default");

        txt_startMonth = new JTextField();
        pnlForm_startMission.add(txt_startMonth, "6, 2, fill, default");
        txt_startMonth.setColumns(10);

        JLabel lblYyyy = new JLabel("/");
        pnlForm_startMission.add(lblYyyy, "8, 2, right, default");

        txt_startYear = new JTextField();
        pnlForm_startMission.add(txt_startYear, "10, 2, fill, default");
        txt_startYear.setColumns(10);

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

        txt_endDay = new JTextField();
        pnlForm_endMission.add(txt_endDay, "2, 2, fill, default");
        txt_endDay.setColumns(10);

        JLabel lblMm_1 = new JLabel("/");
        pnlForm_endMission.add(lblMm_1, "4, 2, right, default");

        txt_endMonth = new JTextField();
        pnlForm_endMission.add(txt_endMonth, "6, 2, fill, default");
        txt_endMonth.setColumns(10);

        JLabel lblYyyy_1 = new JLabel("/");
        pnlForm_endMission.add(lblYyyy_1, "8, 2, right, default");

        txt_endYear = new JTextField();
        pnlForm_endMission.add(txt_endYear, "10, 2, fill, default");
        txt_endYear.setColumns(10);

        btn_insert = new JButton("Inserisci");
        panel.add(btn_insert, "4, 10");

        lbl_error = new JLabel("");
        lbl_error.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbl_error.setBounds(12, 253, 422, 15);
        lbl_error.setVisible(false);
        contentPane.add(lbl_error);
        // btn_insert.addActionListener(new ActionListener() {
        //
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // BeanInserisciSatellite beanSatellite = new BeanInserisciSatellite();
        // beanSatellite.setNomeSatellite(txt_satelliteName.getText());
        // beanSatellite.setAgenziaSatellite(txt_satelliteAgency.getText());
        // beanSatellite.setStartDate(Integer.parseInt(txt_startYear.getText()),
        // Integer.parseInt(txt_startMonth.getText()),
        // Integer.parseInt(txt_startDay.getText()));
        // beanSatellite.setEndDate(Integer.parseInt(txt_endYear.getText()),
        // Integer.parseInt(txt_endMonth.getText()),
        // Integer.parseInt(txt_endDay.getText()));
        //
        // C_UC_InsertSatellite c_uc_insertSatellite =
        // C_UC_InsertSatellite.getInstance();
        // c_uc_insertSatellite.inserisciSatellite(beanSatellite);
        // setVisible(false);
        //
        // }
        //
        // });
    }

    public void addButtonInsertActionListener(ActionListener actionListener) {
        btn_insert.addActionListener(actionListener);
    }

    public JButton getBtn_insert() {
        return btn_insert;
    }

    public JTextField getTxt_endDay() {
        return txt_endDay;
    }

    public JTextField getTxt_endMonth() {
        return txt_endMonth;
    }

    public JTextField getTxt_endYear() {
        return txt_endYear;
    }

    public JTextField getTxt_satelliteAgency() {
        return txt_satelliteAgency;
    }

    public JTextField getTxt_satelliteName() {
        return txt_satelliteName;
    }

    public JTextField getTxt_startDay() {
        return txt_startDay;
    }

    public JTextField getTxt_startMonth() {
        return txt_startMonth;
    }

    public JTextField getTxt_startYear() {
        return txt_startYear;
    }

    public void setBtn_insert(JButton btn_insert) {
        this.btn_insert = btn_insert;
    }

    public void setTxt_endDay(JTextField txt_endDay) {
        this.txt_endDay = txt_endDay;
    }

    public void setTxt_endMonth(JTextField txt_endMonth) {
        this.txt_endMonth = txt_endMonth;
    }

    public void setTxt_endYear(JTextField txt_endYear) {
        this.txt_endYear = txt_endYear;
    }

    public void setTxt_satelliteAgency(JTextField txt_satelliteAgency) {
        this.txt_satelliteAgency = txt_satelliteAgency;
    }

    public void setTxt_satelliteName(JTextField txt_satelliteName) {
        this.txt_satelliteName = txt_satelliteName;
    }

    public void setTxt_startDay(JTextField txt_startDay) {
        this.txt_startDay = txt_startDay;
    }

    public void setTxt_startMonth(JTextField txt_startMonth) {
        this.txt_startMonth = txt_startMonth;
    }

    public void setTxt_startYear(JTextField txt_startYear) {
        this.txt_startYear = txt_startYear;
    }

    public void showError(String string) {
        lbl_error.setText(string);
        lbl_error.setVisible(true);
    }
}
