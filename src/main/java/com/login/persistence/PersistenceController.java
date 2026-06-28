package com.login.persistence;

import com.login.logic.Rol;
import com.login.logic.User;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class PersistenceController {

    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("LoginPU");
    private final UserJpaController userJpa;
    private final RolJpaController rolJpa;


    public PersistenceController() {
        this.userJpa = new UserJpaController(EMF);
        this.rolJpa = new RolJpaController(EMF);
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


    public boolean editUser(User usu) {
        try {
            userJpa.edit(usu);
            return true;
        } catch (Exception e) {
            System.out.println("Error while editing: The user does not exist or data is invalid.");
            return false;
        }
    }

    //

    public User searchUser(Long idUser) {
        return userJpa.findById(idUser);
    }


    public User searchByName(String nombreUsuario) {

        return userJpa.findByUsername(nombreUsuario);
    }

    public void createRol(Rol rol) {
        rolJpa.create(rol);
    }

    public List<Rol> getRoles() {
        return rolJpa.findAll();
    }

    public Rol searchRol(Long id) {
        return rolJpa.findById(id);
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