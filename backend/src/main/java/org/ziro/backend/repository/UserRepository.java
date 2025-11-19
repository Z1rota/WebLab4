package org.ziro.backend.repository;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.ziro.backend.models.Users;

import java.util.Optional;

@Stateless
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public Users save(Users user) {
        if (user.getId() == null || user.getId() == 0) {
            entityManager.persist(user);
            return user;
        } else {
            return entityManager.merge(user);
        }
    }
    @Transactional
    public Optional<Users> findById(Long id) {
        Users user = entityManager.find(Users.class, id);
        return Optional.ofNullable(user);
    }
    @Transactional
    public Optional<Users> findByUsername(String username) {
        TypedQuery<Users> query = entityManager.createQuery(
                "SELECT u FROM Users u WHERE u.username = :username", Users.class);
        query.setParameter("username", username);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
    @Transactional
    public String getPassword(String username) {
        TypedQuery<String> query = entityManager.createQuery(
                "SELECT u.password FROM Users u WHERE u.username = :username", String.class);
        query.setParameter("username", username);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    @Transactional
    public boolean existsByUsername(String username) {
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT COUNT(u) FROM Users u WHERE u.username = :username", Long.class);
        query.setParameter("username", username);
        return query.getSingleResult() > 0;
    }
    @Transactional
    public void delete(Users user) {
        if (entityManager.contains(user)) {
            entityManager.remove(user);
        } else {
            Users managedUser = findById(user.getId()).orElse(null);
            if (managedUser != null) {
                entityManager.remove(managedUser);
            }
        }
    }
}