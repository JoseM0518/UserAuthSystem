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

    public String userRegistration(String user, String password) {


        User existingUser = persisControl.searchByName(user);
        if (existingUser != null) {
            return "Error: The username " + user + " is already taken.";
        }
        User usu = new User();
        usu.setUserName(user);
        usu.setPassword(password);
        persisControl.createUser(usu);

        return "User registered successfully!";
    }
}