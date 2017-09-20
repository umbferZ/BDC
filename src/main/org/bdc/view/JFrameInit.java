/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view
 * Type: JFrameInit
 * Last update: 20-set-2017 13.23.22
 * 
 */

package main.org.bdc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * The Class JFrameInit.
 */
public class JFrameInit extends JFrame {

    private JPanel contentPane;

    private JLabel lblStatus;

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
                    JFrameInit frame = new JFrameInit();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Instantiates a new j frame init.
     */
    public JFrameInit() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(this.contentPane);

        JPanel panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel.setBorder(new TitledBorder(null, "Ossertaorio Astronomico Virtuale", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        this.contentPane.add(panel, BorderLayout.CENTER);

        this.lblStatus = new JLabel("Inizializzazione");

        panel.add(this.lblStatus);
    }

    /**
     * Sets the status.
     *
     * @param message the new status
     */
    public void setStatus(String message) {
        this.lblStatus.setText(message);
        this.lblStatus.setVisible(true);
    }

}
