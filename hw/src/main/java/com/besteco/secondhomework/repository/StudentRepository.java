package com.besteco.secondhomework.repository;

import com.besteco.secondhomework.models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

    List<Student> findStudentsByStudentNameIsLike(String name);

    @Query("select * from Student s group by studentGender")
    List<Student> groupByGender();

    @Query("select count(s) from Student s group by studentGender")
    List<Student> groupByGenderCount();
}
