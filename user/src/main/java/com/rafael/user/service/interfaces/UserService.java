package com.rafael.user.service.interfaces;

import com.rafael.user.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User  findUserById(Long id);
    User findUserByEmail(String email);
    User updateUserById(User user);
    void deleteUserById(Long id);
    List<User> findAllUsers();
}
