package com.example.demo.controller;

import com.example.demo.dto.CourseGrade;
import com.example.demo.models.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/{courseCode}")
    public ResponseEntity<Course> getCourseByCode(@PathVariable String courseCode) {
        return courseService.getCourseByCode(courseCode)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{courseCode}/grades")
    public ResponseEntity<List<CourseGrade>> getGradesByCourseCode(@PathVariable String courseCode) {
        List<CourseGrade> grades = courseService.getGradesByCourseCode(courseCode);
        if (grades.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(grades);
    }
}