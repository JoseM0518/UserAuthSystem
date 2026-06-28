package com.login.igu;

import javax.swing.*;

public class Messages {

    public static void showMessage(String message, String tipe, String title) {
        JOptionPane optionPane = new JOptionPane(message);

        if (tipe.equalsIgnoreCase("Info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if (tipe.equalsIgnoreCase("Error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }

        JDialog dialog = optionPane.createDialog(title);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

}
