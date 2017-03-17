/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.view
 * Type: JFrameLogin
 * Last update: 17-mar-2017 7.53.09
 * 
 */

package org.bdc.view;

import java.awt.EventQueue;

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

    private JButton        btnLogin;

    private JPanel         contentPane;

    private JPasswordField pwdPassword;

    private JTextField     txtUsername;

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
                    JFrameLogin frame = new JFrameLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Instantiates a new j frame login.
     */
    public JFrameLogin() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Login System", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(74, 84, 299, 106);
        contentPane.add(panel);
        panel.setLayout(new FormLayout(new ColumnSpec[] {
                FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
        }, new RowSpec[] {
                FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
        }));

        JLabel lblUsername = new JLabel("User-Id");
        panel.add(lblUsername, "2, 2, right, default");

        txtUsername = new JTextField();
        panel.add(txtUsername, "4, 2, fill, default");
        txtUsername.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        panel.add(lblPassword, "2, 4, right, default");

        pwdPassword = new JPasswordField();
        panel.add(pwdPassword, "4, 4, fill, default");

        btnLogin = new JButton("Login");
        panel.add(btnLogin, "4, 6");
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JPasswordField getPwdPassword() {
        return pwdPassword;
    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public void setBtnLogin(JButton btnLogin) {
        this.btnLogin = btnLogin;
    }

    public void setPwdPassword(JPasswordField pwdPassword) {
        this.pwdPassword = pwdPassword;
    }

    public void setTxtUsername(JTextField txtUsername) {
        this.txtUsername = txtUsername;
    }
}
