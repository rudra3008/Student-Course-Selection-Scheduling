package com.klef.jfsd.ps48.service;

import java.util.List;
import com.klef.jfsd.ps48.model.Course;
import com.klef.jfsd.ps48.model.Registration;

public interface AdminService {
    void addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(Long courseId);
    List<Registration> viewAllRegistrations();
    List<Course> findConflictingCourses();
}
