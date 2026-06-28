package com.login.igu;

import com.login.logic.Controller;
import com.login.logic.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PrimaryAdmin extends JFrame {
    private JPanel panel1;
    private JTable tblAdmin;
    private JButton btnCreateU;
    private JButton btnDelete;
    private JButton btnRefresh;
    private JButton btnExit;
    private JButton btnEditU;
    private JTextField txtUserName;
    private final Controller control;
    User usu;
    CreateUser create;

    public PrimaryAdmin(Controller control, User usu) {
        setContentPane(panel1);
        setTitle("admin panel");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        configTable();
        this.control = control;
        this.usu = usu;

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent e) {

                PrimaryAdmin.this.txtUserName.setText(usu.getUserName());
                loadTable();
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrimaryAdmin.this.dispose();
            }
        });
        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadTable();
            }
        });

        btnCreateU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (create == null) {
                    create = new CreateUser(control);
                }

                create.setVisible(true);
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (tblAdmin.getRowCount() > 0){

                    if (tblAdmin.getSelectedRow() != -1){

                        Long userId =Long.parseLong (String.valueOf(tblAdmin.getValueAt(tblAdmin.getSelectedRow(),0)));
                        control.deleteUser(userId);

                        Messages.showMessage("The user was successfully deleted", "Info","correct elimination");

                        loadTable();
                    }
                    else {

                        Messages.showMessage("No records selected","Error", "Error deleting");
                    }
                }
                else {

                    Messages.showMessage("Empty table","Error", "Error deleting");
                }

            }
        });
        btnEditU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (tblAdmin.getRowCount() > 0){

                    if (tblAdmin.getSelectedRow() != -1){

                        Long userId =Long.parseLong (String.valueOf(tblAdmin.getValueAt(tblAdmin.getSelectedRow(),0)));
                        EditUser ptEdit = new EditUser(control, userId);
                        ptEdit.setVisible(true);



                    }
                    else {

                        Messages.showMessage("No records selected","Error", "Error editing");
                    }
                }
                else {

                    Messages.showMessage("Empty table","Error", "Error editing");
                }
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

        List<User> adminList = control.fetchUsers();

        if(adminList != null){

            for( User usr : adminList){
                Object[] obj = {usr.getId(), usr.getUserName(), usr.getRol().getRolName()};
                model.addRow(obj);
            }
        }

        tblAdmin.setModel(model);
    }




    private void configTable() {
        String[] columnas = {"ID", "Nombre", "Rol"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        tblAdmin.setModel(modelo);
    }
}

