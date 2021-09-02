package com.besteco.secondhomework.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String courseId;

    private String courseName;

    private Integer courseCode;

    private Integer courseScore;

    public Course(String courseName, Integer courseCode, Integer courseScore) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseScore = courseScore;
    }

    public Course() {
    }

    @ManyToOne
    private Instructor instructor;

    @ManyToMany(mappedBy = "courseList")
    private List<Student> studentList;

}
