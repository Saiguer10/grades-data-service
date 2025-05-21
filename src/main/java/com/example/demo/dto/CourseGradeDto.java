package com.example.demo.dto;


import com.example.demo.models.Grade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseGradeDto {
    private String courseName;
    private List<Grade> grades;


}