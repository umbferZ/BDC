/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.view
 * Type: JFrameLogin
 * Last update: 13-set-2017 0.23.41
 * 
 */

package main.org.bdc.view;

import java.awt.Color;
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
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(this.contentPane);
        this.contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Login System", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(60, 33, 329, 154);
        this.contentPane.add(panel);
        panel.setLayout(new FormLayout(new ColumnSpec[] {
                FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
        }, new RowSpec[] {
                FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
        }));

        JLabel lblUsername = new JLabel("User-Id");
        panel.add(lblUsername, "2, 2, right, default");

        this.txt_user_name = new JTextField();
        panel.add(this.txt_user_name, "4, 2, fill, default");
        this.txt_user_name.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        panel.add(lblPassword, "2, 4, right, default");

        this.pwd_password = new JPasswordField();
        this.pwd_password.setBackground(new Color(255, 255, 255));
        panel.add(this.pwd_password, "4, 4, fill, default");

        this.btn_login = new JButton("Login");
        panel.add(this.btn_login, "4, 6");

        this.lbl_error = new JLabel("lbl_error");
        this.lbl_error.setForeground(Color.RED);
        this.lbl_error.setBounds(12, 253, 422, 15);
        this.lbl_error.setVisible(false);
        this.contentPane.add(this.lbl_error);
    }

    public void addButtonLoginActionListener(ActionListener buttonLoginActionListener) {
        this.btn_login.addActionListener(buttonLoginActionListener);

    }

    public JButton getBtnLogin() {
        return this.btn_login;
    }

    public JPasswordField getPwdPassword() {
        return this.pwd_password;
    }

    public JTextField getTxtUsername() {
        return this.txt_user_name;
    }

    public void setBtnLogin(JButton btnLogin) {
        this.btn_login = btnLogin;
    }

    public void setErrorMessage(String message) {
        this.lbl_error.setText(message);
        this.lbl_error.setVisible(true);
    }

    public void setPwdPassword(JPasswordField pwdPassword) {
        this.pwd_password = pwdPassword;
    }

    public void setTxtUsername(JTextField txtUsername) {
        this.txt_user_name = txtUsername;
    }
}
