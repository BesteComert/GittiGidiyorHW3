package com.besteco.secondhomework.service;

import com.besteco.secondhomework.models.Course;
import com.besteco.secondhomework.models.Instructor;
import com.besteco.secondhomework.repository.CourseRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    public Course findById(String id) {
        return courseRepository.findById(id).orElse(new Course());
    }

    @Transactional
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public void deleteById(String id) {
        courseRepository.deleteById(id);
    }

    public List<Course> findCoursesByCourseNameIsLike(String name){
        return findCoursesByCourseNameIsLike(name);
    }
}
