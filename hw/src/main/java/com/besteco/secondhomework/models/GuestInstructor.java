package com.besteco.secondhomework.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
public class GuestInstructor extends Instructor {

    private Double hourlySalary;


    public GuestInstructor(String instructorName, String instructorPhoneNumber, String instructorEmail) {
        super(instructorName, instructorPhoneNumber, instructorEmail);
    }

    public GuestInstructor() {
        super();
    }
}