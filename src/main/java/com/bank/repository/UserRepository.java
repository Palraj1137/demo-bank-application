package com.bank.repository;

import com.bank.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

//Repository to declare the own methods for users
@Repository
public interface UserRepository {

    List<User> getAllUsers();
    User getUserById(int id);
    void createUser(User user);
}
