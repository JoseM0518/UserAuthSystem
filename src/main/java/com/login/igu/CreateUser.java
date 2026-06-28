package com.login.igu;

import com.login.logic.Controller;
import com.login.logic.Rol;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CreateUser extends JFrame {
    private JPanel panel1;
    private JTextField txtUser;
    private JPasswordField txtPassword;
    private JButton btnSave;
    private JButton btnClear;
    private JTextArea txtMessage;
    private JComboBox cmdRol;
    Controller control;

    public CreateUser(Controller control) {
        setTitle("Create User panel");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        this.control = control;
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = txtUser.getText().trim();
                String password = new String(txtPassword.getPassword());
                String rol = (String) cmdRol.getSelectedItem();


                if (user.isEmpty() || password.isEmpty()) {
                    Messages.showMessage("Please, fill in all the fields.", "Warning", "Warning");
                    return;
                }
                String signUp = control.adminRegistration(user,password,rol);

                if (signUp.startsWith("Error")) {
                    Messages.showMessage(signUp, "Error", "Registration Failed");
                } else {
                    Messages.showMessage(signUp, "Info", "Registration Status");
                    txtUser.setText("");
                    txtPassword.setText("");
                }
            }
        });
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent e) {

                List<Rol> rolList = control.getRoles();
                if (rolList != null){

                    for(Rol rol : rolList){

                        cmdRol.addItem(rol.getRolName());
                    }
                }

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
