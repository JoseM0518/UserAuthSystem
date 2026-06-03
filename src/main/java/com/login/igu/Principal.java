package com.login.igu;

import com.login.logic.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame{
    private JPanel panel1;
    private JTextField txtUser;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnClear;
    private JTextArea txtMessage;

    Controller control;



    public Principal() {
        setTitle("Control panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);

        control = new Controller();

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtUser.setText("");
                txtPassword.setText("");
                txtMessage.setText("");
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String user = txtUser.getText();
                String password = new String(txtPassword.getPassword());
                String message = control.userValidation(user,password);
                txtMessage.setText(message);
            }
        });
    }
}
