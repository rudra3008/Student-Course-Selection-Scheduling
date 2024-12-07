package com.klef.jfsd.ps48.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.klef.jfsd.ps48.model.Admin;
import com.klef.jfsd.ps48.repository.AdminRepository;

@Component
public class DataSeeder implements CommandLineRunner {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public void run(String... args) throws Exception {
        if (adminRepository.findByUsername("admin") == null) {
            Admin admin = new Admin();
            admin.setUsername("admin");
            admin.setPassword("admin123"); // Ideally, hash the password for security
            adminRepository.save(admin);
            System.out.println("Admin account seeded!");
        }
    }
}
