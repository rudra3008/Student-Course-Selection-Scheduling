package com.klef.jfsd.ps48.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klef.jfsd.ps48.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}
