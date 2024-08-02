package com.bank.authorization.service;

import com.bank.authorization.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User findByUsername(String username);

    List<User> getAllUsers();

    User removeUserById(Long id);

    User findOne(Long id);

}
