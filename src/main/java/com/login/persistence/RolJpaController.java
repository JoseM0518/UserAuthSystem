package com.login.persistence;

import com.login.logic.Rol;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public class RolJpaController implements Serializable {

    private final EntityManagerFactory emf;

    public RolJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Rol rol) {
        try (EntityManager em = getEntityManager()) {
            em.getTransaction().begin();
            em.persist(rol);
            em.getTransaction().commit();
        }
    }

    public void edit(Rol rol) {
        try (EntityManager em = getEntityManager()) {
            em.getTransaction().begin();
            em.merge(rol);
            em.getTransaction().commit();
        }
    }

    public void destroy(Long id) throws EntityNotFoundException {
        try (EntityManager em = getEntityManager()) {
            em.getTransaction().begin();
            Rol rol = em.find(Rol.class, id);
            if (rol == null) {
                throw new EntityNotFoundException("The Rol with ID " + id + " doesn't exist.");
            }
            em.remove(rol);
            em.getTransaction().commit();
        }
    }

    public List<Rol> findAll() {
        try (EntityManager em = getEntityManager()) {
            CriteriaQuery<Rol> cq = em.getCriteriaBuilder().createQuery(Rol.class);
            Root<Rol> root = cq.from(Rol.class);
            cq.select(root);
            return em.createQuery(cq).getResultList();
        }
    }

    public Rol findById(Long id) {
        try (EntityManager em = getEntityManager()) {
            return em.find(Rol.class, id);
        }
    }
}