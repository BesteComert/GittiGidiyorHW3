package com.besteco.secondhomework.repository;

import com.besteco.secondhomework.models.Instructor;
import com.besteco.secondhomework.models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, String> {
    List<Instructor> findInstructorsByInstructorNameIsLike(String name);

    @Query("select top 3 from PermanentInstructor order by fixedSalary desc")
    List<Instructor> findTop3Salary();

    @Query("select top 3 from PermanentInstructor order by fixedSalary asc")
    List<Instructor> findLast3Salary();
}
