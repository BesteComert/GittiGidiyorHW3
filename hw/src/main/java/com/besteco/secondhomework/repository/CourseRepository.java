package com.besteco.secondhomework.repository;

import com.besteco.secondhomework.models.Course;
import com.besteco.secondhomework.models.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, String> {

    List<Course> findCoursesByCourseNameIsLike(String name);

}
