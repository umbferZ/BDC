/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.view
 * Type: JFrameMain
 * Last update: 12-mar-2017 16.27.09
 * 
 */

package org.bdc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * The Class JFrameMain.
 */
public class JFrameMain extends JFrame {

    JLabel lblWelcome;

    private JPanel contentPane;

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                JFrameMain frame = new JFrameMain();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Instantiates a new j frame main.
     */
    public JFrameMain() {
        setTitle("Welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblWelcome = new JLabel("Welcome...");
        lblWelcome.setBounds(139, 130, 170, 15);
        contentPane.add(lblWelcome);
    }

    /**
     * Welcome.
     *
     * @param name the name
     */
    public void welcome(String name) {
        lblWelcome.setText("Welcome " + name);
    }

}
