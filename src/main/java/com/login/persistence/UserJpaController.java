package com.login.persistence;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import com.login.logic.User;

public class UserJpaController implements Serializable {

    private final EntityManagerFactory emf;

    public UserJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //  (INSERT)
    public void create(User user) {
        validateUser(user);
        try (EntityManager em = getEntityManager()) {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException("Error creating the user", e);
        }
    }

    // (DELETE)
    public void destroy(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        try (EntityManager em = getEntityManager()) {
            em.getTransaction().begin();
            User user = em.find(User.class, id);
            if (user == null) {
                throw new EntityNotFoundException("User with ID " + id + " does not exist");
            }
            em.remove(user);
            em.getTransaction().commit();
        }
    }

    // (UPDATE)
    public void edit(User user) {
        validateUser(user);
        try (EntityManager em = getEntityManager()) {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findById(user.getId()) == null) {
                throw new EntityNotFoundException("User with ID " + user.getId() + " does not exist");
            }
            throw new RuntimeException("Error editing user", ex);
        }
    }

    // (SELECT *)
    public List<User> findAll() {
        try (EntityManager em = getEntityManager()) {
            CriteriaQuery<User> cq = em.getCriteriaBuilder().createQuery(User.class);
            Root<User> root = cq.from(User.class);
            cq.select(root);
            return em.createQuery(cq).getResultList();
        }
    }

    // Search by ID
    public User findById(Long id) {
        if (id == null || id <= 0) {
            return null;
        }
        try (EntityManager em = getEntityManager()) {
            return em.find(User.class, id);
        }
    }

    // Internal validation
    private void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("The user cannot be null");
        }
    }
}