package com.bank.services;

import com.bank.models.User;
import com.bank.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

//Service to implement the own methods from user repository
@Service
public class UserServiceImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        return query.getResultList();
    }

    @Override
    public User getUserById(int id) {
        String jpql = "SELECT u FROM User u WHERE u.userId=:id";
        TypedQuery<User> query = entityManager.createQuery(jpql,User.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Transactional
    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }
}
