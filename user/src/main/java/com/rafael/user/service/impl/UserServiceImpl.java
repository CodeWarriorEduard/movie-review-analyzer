package com.rafael.user.service.impl;

import com.rafael.user.entity.User;
import com.rafael.user.exception.UserNotFoundException;
import com.rafael.user.repository.UserRepository;
import com.rafael.user.service.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User with email " + email + " not found"));
    }

    @Override
    public User updateUserById(User user) {

        User foundUser = findUserById(user.getId());

        if(user.getEmail() != null) {
            foundUser.setEmail(user.getEmail());
        } else if (user.getPassword() != null) {
            foundUser.setPassword(user.getPassword());
        }else if (user.getFirstName() != null) {
            foundUser.setFirstName(user.getFirstName());
        }else if (user.getLastName() != null) {
            foundUser.setLastName(user.getLastName());
        }

        userRepository.save(foundUser);

        return foundUser;
    }

    @Override
    public void deleteUserById(Long id) {
        User foundUser = findUserById(id);
        userRepository.delete(foundUser);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
