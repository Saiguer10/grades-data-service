package com.example.demo.controller;

import com.example.demo.models.Grade;
import com.example.demo.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    @Autowired
    private GradeRepository gradeRepository;

    @GetMapping
    public ResponseEntity<List<Grade>> getAllGrades() {
        List<Grade> grades = gradeRepository.findAll();
        if (grades.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(grades);
    }
}
