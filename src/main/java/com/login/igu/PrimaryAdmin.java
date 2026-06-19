package com.login.igu;

import com.login.logic.Controller;
import com.login.logic.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimaryAdmin extends JFrame {
    private JPanel panel1;
    private JTable table1;
    private JButton btnCreateU;
    private JButton btnDelete;
    private JButton btnRefresh;
    private JButton btnExit;
    private JButton btnEditU;
    private JTextField txtUserName;
    Controller control;
    User usu;

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
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrimaryAdmin.this.dispose();
            }
        });
    }





    private void configTable() {
        String[] columnas = {"ID", "Nombre", "Rol"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        table1.setModel(modelo);
    }
}

