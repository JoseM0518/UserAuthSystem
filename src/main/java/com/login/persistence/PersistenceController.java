package com.login.persistence;

import com.login.logic.User;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class PersistenceController {

    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("LoginPU");
    private final UserJpaController userJpa;

    public PersistenceController() {
        this.userJpa = new UserJpaController(EMF);
    }


    public void createUser(User user) {
        try {
            userJpa.create(user);
        } catch (Exception e) {
            System.out.println("Error creating the user: " + e.getMessage());
        }
    }


    public void deleteUser(Long idUser) {
        try {
            userJpa.destroy(idUser);
        } catch (Exception e) {
            System.out.println("Error deleting: The user does not exist. ");
        }
    }


    public void editUser(User user) {
        try {
            userJpa.edit(user);
        } catch (Exception e) {
            System.out.println("Error while editing: The user does not exist or data is invalid.");
        }
    }

    //

    public User searchUser(Long idUser) {
        return userJpa.findById(idUser);
    }


    public User searchByName(String nombreUsuario) {
        List<User> todos = getUsers();
        if (todos != null) {
            for (User u : todos) {
                if (u.getUserName().equalsIgnoreCase(nombreUsuario.trim())) {
                    return u;
                }
            }
        }
        return null;
    }


    public static void closeEverything() {
        if (EMF != null && EMF.isOpen()) {
            EMF.close();
        }
    }

    public List<User> getUsers() {
        return userJpa.findAll();
    }
}