/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view
 * Type: JFrameLogin
 * Last update: 14-set-2017 12.23.14
 * 
 */

package main.org.bdc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

/**
 * The Class JFrameLogin.
 */
public class JFrameLogin extends JFrame {

    private JButton        btn_login;

    private JPanel         contentPane;

    private JLabel         lbl_error;

    private JPasswordField pwd_password;

    private JTextField     txt_user_name;

    // /**
    // * The main method.
    // *
    // * @param args the arguments
    // */
    // public static void main(String[] args) {
    // EventQueue.invokeLater(new Runnable() {
    //
    // @Override
    // public void run() {
    // try {
    // JFrameLogin frame = new JFrameLogin();
    // frame.setVisible(true);
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }
    // });
    // }

    /**
     * Instantiates a new j frame login.
     */
    public JFrameLogin() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Login System", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(66, 42, 320, 120);
        contentPane.add(panel);
        panel.setLayout(new FormLayout(new ColumnSpec[] {
                FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
        }, new RowSpec[] {
                FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
        }));

        JLabel lblUsername = new JLabel("User-Id");
        panel.add(lblUsername, "2, 2, right, default");

        txt_user_name = new JTextField();
        panel.add(txt_user_name, "4, 2, fill, default");
        txt_user_name.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        panel.add(lblPassword, "2, 4, right, default");

        pwd_password = new JPasswordField();
        pwd_password.setBackground(new Color(255, 255, 255));
        panel.add(pwd_password, "4, 4, fill, default");

        btn_login = new JButton("Login");
        panel.add(btn_login, "4, 6");

        lbl_error = new JLabel("");
        lbl_error.setBounds(12, 201, 422, 17);
        lbl_error.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbl_error.setVisible(false);

        contentPane.add(lbl_error);

        JLabel lblAdministratorUsera = new JLabel("Administrator: user_a, user_a");
        lblAdministratorUsera.setFont(new Font("Dialog", Font.PLAIN, 11));
        lblAdministratorUsera.setBounds(12, 163, 422, 15);
        contentPane.add(lblAdministratorUsera);

        JLabel lblUserRegistered = new JLabel("User registered: user_r, user_r");
        lblUserRegistered.setFont(new Font("Dialog", Font.PLAIN, 11));
        lblUserRegistered.setBounds(12, 174, 422, 15);
        contentPane.add(lblUserRegistered);
    }

    public void addButtonLoginActionListener(ActionListener buttonLoginActionListener) {
        btn_login.addActionListener(buttonLoginActionListener);

    }

    public JButton getBtnLogin() {
        return btn_login;
    }

    public JPasswordField getPwdPassword() {
        return pwd_password;
    }

    public JTextField getTxtUsername() {
        return txt_user_name;
    }

    public void setBtnLogin(JButton btnLogin) {
        btn_login = btnLogin;
    }

    public void setErrorMessage(String message) {
        lbl_error.setText(message);
        lbl_error.setVisible(true);
    }

    public void setPwdPassword(JPasswordField pwdPassword) {
        pwd_password = pwdPassword;
    }

    public void setTxtUsername(JTextField txtUsername) {
        txt_user_name = txtUsername;
    }
}
