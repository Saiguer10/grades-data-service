package com.example.demo.service;

import com.example.demo.dto.CourseGrade;
import com.example.demo.models.Course;
import com.example.demo.models.Grade;
import com.example.demo.repositories.CourseRepository;
import com.example.demo.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private GradeRepository gradeRepository;

    public Optional<Course> getCourseByCode(String courseCode) {
        return courseRepository.findById(courseCode);
    }

    public List<CourseGrade> getGradesByCourseCode(String courseCode) {
        List<Grade> grades = gradeRepository.findByCourseCode(courseCode);

        return grades.stream()
                .map(grade -> new CourseGrade(
                        grade.getCourse().getCourseCode(),
                        grade.getCourse().getCourseName(),
                        grade.getStudentId(),
                        grade.getGrade()
                ))
                .collect(Collectors.toList());
    }
}