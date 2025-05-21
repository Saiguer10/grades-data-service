package com.example.demo.controller;

import com.example.demo.models.Grade;
import com.example.demo.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/grade")
public class GradeController {

    @Autowired
    private GradeRepository gradeRepository;

    @GetMapping
    public ResponseEntity<?> getAllGrades() {
        List<Grade> grades = gradeRepository.findAll();
        return ResponseEntity.ok(grades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGradeById(@PathVariable Long id) {
        return gradeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
