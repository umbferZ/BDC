/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.view
 * Type: InserisciSatellite
 * Last update: 11-mar-2017 19.20.51
 * 
 */

package org.bdc.view;

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

    private JTextField textStartMonth;

    private JTextField txtAgenzia;

    private JTextField txtNome;

    private JTextField txtStartDay;

    private JTextField txtStartYear;

    /**
     * Create the panel.
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

        txtNome = new JTextField();
        add(txtNome);
        txtNome.setColumns(15);

        txtAgenzia = new JTextField();
        add(txtAgenzia);
        txtAgenzia.setColumns(15);

        // UtilDateModel model = new UtilDateModel();
        // JDatePanelImpl datePanet = new JDatePanelImpl(model, null);
        // JDatePickerImpl datePicker = new JDatePickerImpl(datePanet, null);
        // add(datePicker);

        JButton btnInserisci = new JButton("Inserisci");
        add(btnInserisci);

        txtStartDay = new JTextField();
        add(txtStartDay);
        txtStartDay.setColumns(10);

        textStartMonth = new JTextField();
        add(textStartMonth);
        textStartMonth.setColumns(10);

        txtStartYear = new JTextField();
        add(txtStartYear);
        txtStartYear.setColumns(10);

        Panel panel = new Panel();
        add(panel);

    }
}
