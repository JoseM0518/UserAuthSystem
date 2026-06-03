package com.login.logic;

import com.login.persistence.PersistenceController;


public class Controller {

    PersistenceController persisControl = new PersistenceController();

    public String userValidation(String user, String password) {

        User usu = persisControl.searchByName(user);

        if (usu == null) {
            return "User not found";
        }

        if (usu.getPassword().equals(password)) {
            return "Correct User and Password, Welcome " + usu.getUserName();
        } else {
            return "Incorrect Password";
        }
    }
}