package com.besteco.secondhomework.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Instructor {

    public Instructor() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String instructorId;

    private String instructorName;
    private String instructorPhoneNumber;
    private String instructorEmail;

    public Instructor(String instructorName, String instructorPhoneNumber, String instructorEmail) {
        this.instructorName = instructorName;
        this.instructorPhoneNumber = instructorPhoneNumber;
        this.instructorEmail = instructorEmail;
    }

    @OneToMany(mappedBy = "instructor")
    private Set<Course> courseList = new HashSet<>();

}
