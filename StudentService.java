package com.klef.jfsd.ps48.service;

import com.klef.jfsd.ps48.model.Student;

public interface StudentService {
    Student registerStudent(Student student);
    Student login(String email, String password);
}
