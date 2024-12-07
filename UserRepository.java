package com.klef.jfsd.ps48.repository;

import com.klef.jfsd.ps48.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailAndPassword(String email, String password);
}
