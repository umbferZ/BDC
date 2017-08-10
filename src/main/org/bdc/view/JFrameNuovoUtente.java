/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.view
 * Type: JFrameNuovoUtente
 * Last update: 7-ago-2017 12.44.54
 * 
 */

package main.org.bdc.view;

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

    private JPasswordField pwd_password;

    private JPasswordField pwd_password_reply;

    private JTextField     txt_user_email;

    private JTextField     txt_user_id;

    private JTextField     txt_user_last_name;

    private JTextField     txt_user_first_name;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    JFrameNuovoUtente frame = new JFrameNuovoUtente();
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
        formLayout.setBorder(new TitledBorder(null, "Nuovo User_Regegistered", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        formLayout.setBounds(20, 0, 407, 263);
        contentPane.add(formLayout);
        formLayout.setLayout(new FormLayout(new ColumnSpec[] {
                FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
        }, new RowSpec[] {
                FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
                FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
        }));

        JLabel lbl_name = new JLabel("Nome");
        formLayout.add(lbl_name, "2, 2, right, default");

        txt_user_first_name = new JTextField();
        formLayout.add(txt_user_first_name, "4, 2, fill, default");
        txt_user_first_name.setColumns(10);

        JLabel lbl_last_name = new JLabel("Cognome");
        formLayout.add(lbl_last_name, "2, 4, right, default");

        txt_user_last_name = new JTextField();
        formLayout.add(txt_user_last_name, "4, 4, fill, default");
        txt_user_last_name.setColumns(10);

        JLabel lblEmail = new JLabel("Email");
        formLayout.add(lblEmail, "2, 6, right, default");

        txt_user_email = new JTextField();
        formLayout.add(txt_user_email, "4, 6, fill, default");
        txt_user_email.setColumns(10);

        JPanel pnlLabel_1 = new JPanel();
        formLayout.add(pnlLabel_1, "2, 8, fill, fill");
        pnlLabel_1.setLayout(new BorderLayout(0, 0));

        JLabel lbl_user_id = new JLabel("User_Regegistered-Id");
        lbl_user_id.setHorizontalAlignment(SwingConstants.RIGHT);
        pnlLabel_1.add(lbl_user_id);

        JLabel lbl_min_chars_id = new JLabel("min 6 caratteri");
        lbl_min_chars_id.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl_min_chars_id.setFont(new Font("Dialog", Font.PLAIN, 10));
        pnlLabel_1.add(lbl_min_chars_id, BorderLayout.SOUTH);

        txt_user_id = new JTextField();
        formLayout.add(txt_user_id, "4, 8, fill, default");
        txt_user_id.setColumns(10);

        JPanel pnlLabel_2 = new JPanel();
        formLayout.add(pnlLabel_2, "2, 10, fill, fill");
        pnlLabel_2.setLayout(new BorderLayout(0, 0));

        JLabel lbl_password = new JLabel("Password");
        lbl_password.setHorizontalAlignment(SwingConstants.RIGHT);
        pnlLabel_2.add(lbl_password);

        JLabel lbl_min_chars_pwd = new JLabel("min 6 caratteri");
        lbl_min_chars_pwd.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl_min_chars_pwd.setFont(new Font("Dialog", Font.PLAIN, 10));
        pnlLabel_2.add(lbl_min_chars_pwd, BorderLayout.SOUTH);

        pwd_password = new JPasswordField();
        formLayout.add(pwd_password, "4, 10, fill, default");

        JLabel lbl_password_reply = new JLabel("Ripeti Password");
        formLayout.add(lbl_password_reply, "2, 12, right, default");

        pwd_password_reply = new JPasswordField();
        formLayout.add(pwd_password_reply, "4, 12, fill, default");

        JLabel lbl_amministratore = new JLabel("Amministratore");
        formLayout.add(lbl_amministratore, "2, 14");

        JCheckBox chckbx_admin = new JCheckBox("");
        formLayout.add(chckbx_admin, "4, 14");

        JButton btn_insert = new JButton("Inserisci");
        formLayout.add(btn_insert, "4, 16");
    }
}
