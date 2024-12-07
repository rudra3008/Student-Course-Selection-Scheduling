package com.klef.jfsd.ps48.service;

import com.klef.jfsd.ps48.model.User;
import com.klef.jfsd.ps48.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
