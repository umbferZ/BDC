/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view
 * Type: InserisciSatellite
 * Last update: 13-set-2017 0.23.41
 * 
 */

package main.org.bdc.view;

import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@Deprecated
public class InserisciSatellite extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JTextField        txt_agenzia;

    private JTextField        txt_name;

    private JTextField        txt_start_day;

    private JTextField        txt_start_month;

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

        JLabel lblNewLabel = new JLabel("Agency:");
        add(lblNewLabel);

        JLabel lblInizioMissione = new JLabel("Inizio Missione:");
        add(lblInizioMissione);

        JLabel lblFineMissione = new JLabel("Fine Missione:");
        add(lblFineMissione);

        this.txt_name = new JTextField();
        add(this.txt_name);
        this.txt_name.setColumns(15);

        this.txt_agenzia = new JTextField();
        add(this.txt_agenzia);
        this.txt_agenzia.setColumns(15);

        // UtilDateModel model = new UtilDateModel();
        // JDatePanelImpl datePanet = new JDatePanelImpl(model, null);
        // JDatePickerImpl datePicker = new JDatePickerImpl(datePanet, null);
        // add(datePicker);

        JButton btnInserisci = new JButton("Inserisci");
        add(btnInserisci);

        this.txt_start_day = new JTextField();
        add(this.txt_start_day);
        this.txt_start_day.setColumns(10);

        this.txt_start_month = new JTextField();
        add(this.txt_start_month);
        this.txt_start_month.setColumns(10);

        this.txt_start_year = new JTextField();
        add(this.txt_start_year);
        this.txt_start_year.setColumns(10);

        Panel panel = new Panel();
        add(panel);

    }
}
