package com.login;

import com.login.igu.InitialLogin;
import com.login.logic.Controller;

public class Main {
    public static void main(String[] args) {

        Controller control = new Controller();

        InitialLogin initialLogin = new InitialLogin(control);
        initialLogin.setVisible(true);

    }
}