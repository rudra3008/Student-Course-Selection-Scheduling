package com.klef.jfsd.ps48.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klef.jfsd.ps48.model.Course;
import com.klef.jfsd.ps48.model.Registration;
import com.klef.jfsd.ps48.repository.CourseRepository;
import com.klef.jfsd.ps48.repository.RegistrationRepository;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public List<Registration> viewAllRegistrations() {
        return registrationRepository.findAll();
    }

    @Override
    public List<Course> findConflictingCourses() {
        List<Course> courses = courseRepository.findAll();
        // Example logic to detect conflicts
        return courses.stream()
                .filter(c1 -> courses.stream()
                    .anyMatch(c2 -> !c1.equals(c2) && c1.getSchedule().equals(c2.getSchedule())))
                .toList();
    }
}
