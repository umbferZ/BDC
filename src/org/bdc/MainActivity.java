/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc
 * Type: MainActivity
 * Last update: 17-mar-2017 7.55.16
 * 
 */

package org.bdc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.security.auth.login.LoginException;
import javax.swing.JOptionPane;

import org.bdc.controls.gestisciUtenti.C_UC_GestisciUtenti;
import org.bdc.model.people.Utente;
import org.bdc.service.activities.Activity;
import org.bdc.view.JFrameLogin;
import org.bdc.view.JFrameMain;

public class MainActivity extends Activity<JFrameLogin> {

    private JFrameLogin contentView;

    @Override
    protected void onClose() {

    }

    @Override
    protected void onCreate() {
        contentView = new JFrameLogin();
        setContentView(contentView);

    }

    @Override
    protected void onPause() {

    }

    @Override
    protected void onStart() {
        getContentView().getBtnLogin().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("click");
                String username = getContentView().getTxtUsername().getText();
                String password = new String(getContentView().getPwdPassword().getPassword());
                try {
                    Utente utente = new C_UC_GestisciUtenti().login(username, password);
                    JFrameMain main = new JFrameMain();
                    main.welcome(utente.getNome() + " " + utente.getCognome());
                    main.setVisible(true);
                    getContentView().setVisible(false);
                } catch (LoginException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
            }
        });
    }

    @Override
    protected void onStop() {

    }

}
