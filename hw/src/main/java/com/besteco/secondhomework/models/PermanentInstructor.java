package com.besteco.secondhomework.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Data
public class PermanentInstructor extends Instructor {

    private Double fixedSalary;

    public PermanentInstructor(String instructorName, String instructorPhoneNumber, String instructorEmail) {
        super(instructorName, instructorPhoneNumber, instructorEmail);
    }

    public PermanentInstructor() {
        super();
    }
}