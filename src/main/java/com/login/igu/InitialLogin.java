package com.login.igu;

import com.login.logic.Controller;
import com.login.logic.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialLogin extends JFrame{
    private JPanel panel1;
    private JTextField txtUser;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnClear;
    private JTextArea txtMessage;
    private JButton signUpButton;

    private final Controller control;
    Registration regis;



    public InitialLogin(Controller control) {
        setTitle("Control panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);

        this.control = control;

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
                User usu = control.userValidation(user,password);
                if(usu != null ){

                    String rol = usu.getRol().getRolName();
                    if (rol.equals("admin")){

                        PrimaryAdmin prAdmin = new PrimaryAdmin(control, usu);
                        prAdmin.setVisible(true);
                        prAdmin.setLocationRelativeTo(null);
                    }
                    else {

                        PrimaryUser prUser = new PrimaryUser(control, usu);
                        prUser.setVisible(true);
                        prUser.setLocationRelativeTo(null);
                    }
                }
                else{

                    txtMessage.setText("Incorrect User or Password ");
                }

                txtUser.setText("");
                txtPassword.setText("");
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (regis == null) {
                    regis = new Registration(control);
                }

                regis.setVisible(true);
            }
        });
    }
}
