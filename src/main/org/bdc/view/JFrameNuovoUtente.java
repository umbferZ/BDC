/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view
 * Type: JFrameNuovoUtente
 * Last update: 20-set-2017 13.23.23
 * 
 */

package main.org.bdc.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

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

/**
 * The Class JFrameNuovoUtente.
 */
public class JFrameNuovoUtente extends JFrame {

    private JButton        btn_insert;

    private JCheckBox      chckbx_admin;

    private JPanel         contentPane;

    private JLabel         lbl_error;

    private JPasswordField pwd_password;

    private JPasswordField pwd_password_reply;

    private JTextField     txt_user_email;

    private JTextField     txt_user_first_name;

    private JTextField     txt_user_id;

    private JTextField     txt_user_last_name;

    /**
     * Instantiates a new j frame nuovo utente.
     */
    public JFrameNuovoUtente() {
        setType(Type.UTILITY);

        setTitle("New User");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 370);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(this.contentPane);
        this.contentPane.setLayout(null);

        JPanel formLayout = new JPanel();
        formLayout.setBorder(new TitledBorder(null, "Register new user", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        formLayout.setBounds(20, 26, 414, 263);
        this.contentPane.add(formLayout);
        formLayout.setLayout(new FormLayout(new ColumnSpec[] {
                FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
        }, new RowSpec[] {
                FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
                FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
        }));

        JLabel lbl_name = new JLabel("Name");
        formLayout.add(lbl_name, "2, 2, right, default");

        this.txt_user_first_name = new JTextField();
        formLayout.add(this.txt_user_first_name, "4, 2, fill, default");
        this.txt_user_first_name.setColumns(10);

        JLabel lbl_last_name = new JLabel("Surname");
        formLayout.add(lbl_last_name, "2, 4, right, default");

        this.txt_user_last_name = new JTextField();
        formLayout.add(this.txt_user_last_name, "4, 4, fill, default");
        this.txt_user_last_name.setColumns(10);

        JLabel lblEmail = new JLabel("Email");
        formLayout.add(lblEmail, "2, 6, right, default");

        this.txt_user_email = new JTextField();
        formLayout.add(this.txt_user_email, "4, 6, fill, default");
        this.txt_user_email.setColumns(10);

        JPanel pnlLabel_1 = new JPanel();
        formLayout.add(pnlLabel_1, "2, 8, fill, fill");
        pnlLabel_1.setLayout(new BorderLayout(0, 0));

        JLabel lbl_user_id = new JLabel("User-id");
        lbl_user_id.setHorizontalAlignment(SwingConstants.RIGHT);
        pnlLabel_1.add(lbl_user_id);

        JLabel lbl_min_chars_id = new JLabel("min 6");
        lbl_min_chars_id.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl_min_chars_id.setFont(new Font("Dialog", Font.PLAIN, 10));
        pnlLabel_1.add(lbl_min_chars_id, BorderLayout.SOUTH);

        this.txt_user_id = new JTextField();
        formLayout.add(this.txt_user_id, "4, 8, fill, default");
        this.txt_user_id.setColumns(10);

        JPanel pnlLabel_2 = new JPanel();
        formLayout.add(pnlLabel_2, "2, 10, fill, fill");
        pnlLabel_2.setLayout(new BorderLayout(0, 0));

        JLabel lbl_password = new JLabel("Password");
        lbl_password.setHorizontalAlignment(SwingConstants.RIGHT);
        pnlLabel_2.add(lbl_password);

        JLabel lbl_min_chars_pwd = new JLabel("min 6");
        lbl_min_chars_pwd.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl_min_chars_pwd.setFont(new Font("Dialog", Font.PLAIN, 10));
        pnlLabel_2.add(lbl_min_chars_pwd, BorderLayout.SOUTH);

        this.pwd_password = new JPasswordField();
        formLayout.add(this.pwd_password, "4, 10, fill, default");

        JLabel lbl_password_reply = new JLabel("Repeat Password");
        formLayout.add(lbl_password_reply, "2, 12, right, default");

        this.pwd_password_reply = new JPasswordField();
        formLayout.add(this.pwd_password_reply, "4, 12, fill, default");

        JLabel lbl_amministratore = new JLabel("Admin");
        formLayout.add(lbl_amministratore, "2, 14");

        this.chckbx_admin = new JCheckBox("");
        formLayout.add(this.chckbx_admin, "4, 14");

        this.btn_insert = new JButton("Insert");
        formLayout.add(this.btn_insert, "4, 16");

        this.lbl_error = new JLabel("");
        this.lbl_error.setFont(new Font("Dialog", Font.PLAIN, 12));
        this.lbl_error.setBounds(20, 323, 422, 15);
        this.contentPane.add(this.lbl_error);
    }

    /**
     * Adds the button insert action listener.
     *
     * @param actionListener the action listener
     */
    public void addButtonInsertActionListener(ActionListener actionListener) {
        this.btn_insert.addActionListener(actionListener);
    }

    /**
     * Gets the btn insert.
     *
     * @return the btn insert
     */
    public JButton getBtn_insert() {
        return this.btn_insert;
    }

    /**
     * Gets the chckbx admin.
     *
     * @return the chckbx admin
     */
    public JCheckBox getChckbx_admin() {
        return this.chckbx_admin;
    }

    /**
     * Gets the pwd password.
     *
     * @return the pwd password
     */
    public JPasswordField getPwd_password() {
        return this.pwd_password;
    }

    /**
     * Gets the pwd password reply.
     *
     * @return the pwd password reply
     */
    public JPasswordField getPwd_password_reply() {
        return this.pwd_password_reply;
    }

    /**
     * Gets the txt user email.
     *
     * @return the txt user email
     */
    public JTextField getTxt_user_email() {
        return this.txt_user_email;
    }

    /**
     * Gets the txt user first name.
     *
     * @return the txt user first name
     */
    public JTextField getTxt_user_first_name() {
        return this.txt_user_first_name;
    }

    /**
     * Gets the txt user id.
     *
     * @return the txt user id
     */
    public JTextField getTxt_user_id() {
        return this.txt_user_id;
    }

    /**
     * Gets the txt user last name.
     *
     * @return the txt user last name
     */
    public JTextField getTxt_user_last_name() {
        return this.txt_user_last_name;
    }

    /**
     * Sets the btn insert.
     *
     * @param btn_insert the new btn insert
     */
    public void setBtn_insert(JButton btn_insert) {
        this.btn_insert = btn_insert;
    }

    /**
     * Sets the chckbx admin.
     *
     * @param chckbx_admin the new chckbx admin
     */
    public void setChckbx_admin(JCheckBox chckbx_admin) {
        this.chckbx_admin = chckbx_admin;
    }

    /**
     * Sets the error message.
     *
     * @param errorMessage the new error message
     */
    public void setErrorMessage(String errorMessage) {
        this.lbl_error.setText(errorMessage);
        this.lbl_error.setVisible(true);

    }

    /**
     * Sets the pwd password.
     *
     * @param pwd_password the new pwd password
     */
    public void setPwd_password(JPasswordField pwd_password) {
        this.pwd_password = pwd_password;
    }

    /**
     * Sets the pwd password reply.
     *
     * @param pwd_password_reply the new pwd password reply
     */
    public void setPwd_password_reply(JPasswordField pwd_password_reply) {
        this.pwd_password_reply = pwd_password_reply;
    }

    /**
     * Sets the txt user email.
     *
     * @param txt_user_email the new txt user email
     */
    public void setTxt_user_email(JTextField txt_user_email) {
        this.txt_user_email = txt_user_email;
    }

    /**
     * Sets the txt user first name.
     *
     * @param txt_user_first_name the new txt user first name
     */
    public void setTxt_user_first_name(JTextField txt_user_first_name) {
        this.txt_user_first_name = txt_user_first_name;
    }

    /**
     * Sets the txt user id.
     *
     * @param txt_user_id the new txt user id
     */
    public void setTxt_user_id(JTextField txt_user_id) {
        this.txt_user_id = txt_user_id;
    }

    /**
     * Sets the txt user last name.
     *
     * @param txt_user_last_name the new txt user last name
     */
    public void setTxt_user_last_name(JTextField txt_user_last_name) {
        this.txt_user_last_name = txt_user_last_name;
    }
}
