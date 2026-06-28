package com.login.igu;

import com.login.logic.Controller;
import com.login.logic.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PrimaryUser extends JFrame{
    private JButton btnRefresh;
    private JButton btnExit;
    private JTextField txtUserName;
    private JTable tblUsers;
    private JPanel panel1;
    private final Controller control;
    User usu;

    public PrimaryUser(Controller control, User usu) {
        setContentPane(panel1);
        setTitle("User panel");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        this.control = control;
        this.usu = usu;

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent e) {

                PrimaryUser.this.txtUserName.setText(usu.getUserName());
                loadTable();
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrimaryUser.this.dispose();
            }
        });
        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                loadTable();
            }
        });
    }

    private void loadTable() {

        String[] columns = {"ID", "Nombre", "Rol"};
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        model.setColumnIdentifiers(columns);

        List<User> userList = control.fetchUsers();

        if(userList != null){

            for( User usr : userList){
                Object[] obj = {usr.getId(), usr.getUserName(), usr.getRol().getRolName()};
                model.addRow(obj);
            }
        }

        tblUsers.setModel(model);
    }




}
