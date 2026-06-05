package com.login.igu;

import com.login.logic.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration extends JFrame {
    private JPanel panel1;
    private JTextField txtUser;
    private JPasswordField txtPassword;
    private JButton btnSave;
    private JButton btnClear;
    private JTextArea txtMessage;

    Controller control;



    public Registration() {
        setTitle("Sign up panel");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);

        control = new Controller();

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String user = txtUser.getText().trim();
                String password = new String(txtPassword.getPassword());
                if (user.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error Please, fill in all the fields.", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String signUp = control.userRegistration(user,password);

                JOptionPane.showMessageDialog(null, signUp, "Registration Status", JOptionPane.INFORMATION_MESSAGE);

                txtUser.setText("");
                txtPassword.setText("");
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtUser.setText("");
                txtPassword.setText("");
            }
        });
    }
}
