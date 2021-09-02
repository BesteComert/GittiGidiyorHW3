package com.besteco.secondhomework.models;


import com.besteco.secondhomework.models.enums.Gender;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Data
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private String studentId;

    private String studentName;
    private LocalDate studentDateOfBirth;
    private String studentAddress;
    private Gender studentGender;

    public Student(String studentName, LocalDate studentDateOfBirth, String studentAddress, Gender studentGender) {
        this.studentName = studentName;
        this.studentDateOfBirth = studentDateOfBirth;
        this.studentAddress = studentAddress;
        this.studentGender = studentGender;
    }

    @ManyToMany
    @JoinTable(name = "students-courses", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courseList = new HashSet<>();

    public Student() {

    }
}