package com.login.igu;

import com.login.logic.Controller;
import com.login.logic.Rol;
import com.login.logic.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EditUser extends JFrame{
    private JPanel panel1;
    private JTextField txtUser;
    private JPasswordField txtPassword;
    private JComboBox cmdRol;
    private JButton btnSave;
    private JTextArea txtMessage;
    private JButton btnClear;
    Controller control;
    Long userId;
    User usu;

    public EditUser(Controller control, Long userId ) {
        setTitle("Edit User panel");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        this.control = control;
        this.userId = userId;

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent e) {

                usu = control.getUser(userId);
                txtUser.setText(usu.getUserName());
                txtPassword.setText(usu.getPassword());
                String rol = usu.getRol().getRolName();
                List<Rol> rolList = control.getRoles();
                if (rolList != null){

                    for(Rol rol1 : rolList){

                        cmdRol.addItem(rol1.getRolName());
                    }
                }


                int rolCant = cmdRol.getItemCount();
                for (int i = 0; i < rolCant; i++){

                    if (String.valueOf(cmdRol.getItemAt(i)).equals(rol)){

                        cmdRol.setSelectedIndex(i);
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
                String signUp = control.editUser(usu,user,password,rol);

                Messages.showMessage("User edited successfully","Info","Successful edition");
            }
        });
    }


}
