package com.example.studentcoursemanagement.service;

import com.example.studentcoursemanagement.entity.Course;
import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course saveCourse(Course course);
    Course getCourseById(Long id);
    void deleteCourseById(Long id);
}