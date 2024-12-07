package com.klef.jfsd.ps48.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klef.jfsd.ps48.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByEmail(String email);
}
