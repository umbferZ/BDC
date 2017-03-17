/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.view
 * Type: JFrameNuovoUtente
 * Last update: 17-mar-2017 7.53.09
 * 
 */

package org.bdc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class JFrameNuovoUtente extends JFrame {

    private JPanel         contentPane;

    private JPasswordField pwdPassword;

    private JPasswordField pwdPassword_2;

    private JTextField     txtUtentecognome;

    private JTextField     txtUtenteemail;

    private JTextField     txtUtenteid;

    private JTextField     txtUtenteNome;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                JFrameNuovoUtente frame = new JFrameNuovoUtente();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public JFrameNuovoUtente() {
        setType(Type.UTILITY);

        setTitle("Nuovo utente");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel formLayout = new JPanel();
        formLayout.setBorder(new TitledBorder(null, "Nuovo Utente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        formLayout.setBounds(20, 0, 407, 263);
        contentPane.add(formLayout);
        formLayout.setLayout(new FormLayout(new ColumnSpec[] {
                FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
        }, new RowSpec[] {
                FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
                FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
        }));

        JLabel lblNome = new JLabel("Nome");
        formLayout.add(lblNome, "2, 2, right, default");

        txtUtenteNome = new JTextField();
        formLayout.add(txtUtenteNome, "4, 2, fill, default");
        txtUtenteNome.setColumns(10);

        JLabel lblCognome = new JLabel("Cognome");
        formLayout.add(lblCognome, "2, 4, right, default");

        txtUtentecognome = new JTextField();
        formLayout.add(txtUtentecognome, "4, 4, fill, default");
        txtUtentecognome.setColumns(10);

        JLabel lblEmail = new JLabel("Email");
        formLayout.add(lblEmail, "2, 6, right, default");

        txtUtenteemail = new JTextField();
        formLayout.add(txtUtenteemail, "4, 6, fill, default");
        txtUtenteemail.setColumns(10);

        JPanel pnlLabel_1 = new JPanel();
        formLayout.add(pnlLabel_1, "2, 8, fill, fill");
        pnlLabel_1.setLayout(new BorderLayout(0, 0));

        JLabel lblUserid = new JLabel("User-Id");
        lblUserid.setHorizontalAlignment(SwingConstants.RIGHT);
        pnlLabel_1.add(lblUserid);

        JLabel lblMinCaratteri = new JLabel("min 6 caratteri");
        lblMinCaratteri.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMinCaratteri.setFont(new Font("Dialog", Font.PLAIN, 10));
        pnlLabel_1.add(lblMinCaratteri, BorderLayout.SOUTH);

        txtUtenteid = new JTextField();
        formLayout.add(txtUtenteid, "4, 8, fill, default");
        txtUtenteid.setColumns(10);

        JPanel pnlLabel_2 = new JPanel();
        formLayout.add(pnlLabel_2, "2, 10, fill, fill");
        pnlLabel_2.setLayout(new BorderLayout(0, 0));

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        pnlLabel_2.add(lblPassword);

        JLabel lblMinCaratteri_1 = new JLabel("min 6 caratteri");
        lblMinCaratteri_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMinCaratteri_1.setFont(new Font("Dialog", Font.PLAIN, 10));
        pnlLabel_2.add(lblMinCaratteri_1, BorderLayout.SOUTH);

        pwdPassword = new JPasswordField();
        formLayout.add(pwdPassword, "4, 10, fill, default");

        JLabel lblPassword_2 = new JLabel("Ripeti Password");
        formLayout.add(lblPassword_2, "2, 12, right, default");

        pwdPassword_2 = new JPasswordField();
        formLayout.add(pwdPassword_2, "4, 12, fill, default");

        JLabel lblAmministratore = new JLabel("Amministratore");
        formLayout.add(lblAmministratore, "2, 14");

        JCheckBox chckbxNewCheckBox = new JCheckBox("");
        formLayout.add(chckbxNewCheckBox, "4, 14");

        JButton btnInserisci = new JButton("Inserisci");
        formLayout.add(btnInserisci, "4, 16");
    }
}
