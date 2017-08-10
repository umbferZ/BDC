/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.view
 * Type: InserisciSatellite
 * Last update: 17-mar-2017 7.53.09
 * 
 */

package main.org.bdc.view;

import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InserisciSatellite extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JTextField        txt_start_month;

    private JTextField        txt_agenzia;

    private JTextField        txt_name;

    private JTextField        txt_start_day;

    private JTextField        txt_start_year;

    /**
     * Instantiates a new inserisci satellite.
     */
    public InserisciSatellite() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblInserisciSatellite = new JLabel("Inserisci Satellite");
        add(lblInserisciSatellite);

        JLabel lblNome = new JLabel("Nome:");
        add(lblNome);

        JLabel lblNewLabel = new JLabel("Agenzia:");
        add(lblNewLabel);

        JLabel lblInizioMissione = new JLabel("Inizio Missione:");
        add(lblInizioMissione);

        JLabel lblFineMissione = new JLabel("Fine Missione:");
        add(lblFineMissione);

        txt_name = new JTextField();
        add(txt_name);
        txt_name.setColumns(15);

        txt_agenzia = new JTextField();
        add(txt_agenzia);
        txt_agenzia.setColumns(15);

        // UtilDateModel model = new UtilDateModel();
        // JDatePanelImpl datePanet = new JDatePanelImpl(model, null);
        // JDatePickerImpl datePicker = new JDatePickerImpl(datePanet, null);
        // add(datePicker);

        JButton btnInserisci = new JButton("Inserisci");
        add(btnInserisci);

        txt_start_day = new JTextField();
        add(txt_start_day);
        txt_start_day.setColumns(10);

        txt_start_month = new JTextField();
        add(txt_start_month);
        txt_start_month.setColumns(10);

        txt_start_year = new JTextField();
        add(txt_start_year);
        txt_start_year.setColumns(10);

        Panel panel = new Panel();
        add(panel);

    }
}
