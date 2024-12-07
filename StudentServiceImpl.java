package com.klef.jfsd.ps48.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klef.jfsd.ps48.model.Student;
import com.klef.jfsd.ps48.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student login(String email, String password) {
        Student student = studentRepository.findByEmail(email);
        return (student != null && student.getPassword().equals(password)) ? student : null;
    }
}
