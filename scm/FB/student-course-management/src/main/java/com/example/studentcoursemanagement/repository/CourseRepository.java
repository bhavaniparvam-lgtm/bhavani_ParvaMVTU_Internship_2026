package com.example.studentcoursemanagement.repository;

import com.example.studentcoursemanagement.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}