package com.login.logic;

import com.login.persistence.PersistenceController;


public class Controller {

    PersistenceController persisControl = new PersistenceController();

    public User userValidation(String user, String password) {


        User usu = persisControl.searchByName(user);

        if (usu != null && usu.getPassword().equals(password)) {
            return usu;
        }
        return null;

    }

    public String userRegistration(String user, String password) {


        User existingUser = persisControl.searchByName(user);
        if (existingUser != null) {
            return "Error: The username " + user + " is already taken.";
        }

        Rol rolDefault = persisControl.searchRol(2L);
        User usu = new User();
        usu.setUserName(user);
        usu.setPassword(password);
        usu.setRol(rolDefault);
        persisControl.createUser(usu);

        return "User registered successfully!";
    }



}