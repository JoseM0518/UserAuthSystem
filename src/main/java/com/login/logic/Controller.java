package com.login.logic;

import com.login.persistence.PersistenceController;

import java.util.List;


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

    public String adminRegistration(String user, String password, String rol) {


        User existingUser = persisControl.searchByName(user);
        if (existingUser != null) {
            return "Error: The username " + user + " is already taken.";
        }


        User usu = new User();
        usu.setUserName(user);
        usu.setPassword(password);
        Rol rol2 = this.getRol(rol);

        if(rol2 != null){

            usu.setRol(rol2);
        }


        persisControl.createUser(usu);

        return "User registered successfully!";
    }


    private Rol getRol(String rol) {

        List<Rol> rolList = persisControl.getRoles();

        for(Rol r : rolList){
            if(r.getRolName().equals(rol)){
                return r;
            }
        }

        return null;
    }


    public List<User> fetchUsers() {

        return persisControl.getUsers();
    }

    public List<Rol> getRoles() {

        return  persisControl.getRoles();
    }

    public void deleteUser(Long userId) {

        persisControl.deleteUser(userId);
    }


    public User getUser(Long userId) {
        return persisControl.searchUser(userId);
    }

    public String editUser(User usu, String user, String password, String rol) {
        usu.setUserName(user);
        usu.setPassword(password);
        Rol rol2 = this.getRol(rol);

        if(rol2 != null){

            usu.setRol(rol2);
        }

        boolean correct = persisControl.editUser(usu);

        if (correct) {
            return "User updated successfully!";
        } else {
            return "Error: Could not update user.";
        }

    }
}