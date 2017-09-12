/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.activities
 * Type: MainActivity
 * Last update: 13-set-2017 0.23.54
 * 
 */

package main.org.bdc.activities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.org.bdc.service.activities.Activity;
import main.org.bdc.view.JFrameLogin;

public class MainActivity extends Activity {

    // private JFrameLogin contentView;

    @Override
    protected void onClose() {

    }

    @Override
    protected void onCreate() {
        // contentView = new JFrameLogin();
        // FIXME is it possible remove setContentView(contentView)?
        setContentView(new JFrameLogin());

    }

    @Override
    protected void onPause() {

    }

    @Override
    protected void onStart() {
        JFrameLogin c = (JFrameLogin) getContentView();
        c.getBtnLogin().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                c.getTxtUsername().getText();
                new String(c.getPwdPassword().getPassword());
            }
        });
    }

    @Override
    protected void onStop() {

    }

}
