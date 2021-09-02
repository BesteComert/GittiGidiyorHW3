package com.besteco.secondhomework.controller;

import com.besteco.secondhomework.models.Course;
import com.besteco.secondhomework.models.Instructor;
import com.besteco.secondhomework.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> findAll() {
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/courses/{find}")
    public ResponseEntity<List<Course>> findCoursesByCourseNameIsLike(@RequestParam String name){
        return (ResponseEntity<List<Course>>)courseService.findCoursesByCourseNameIsLike(name);
    }

    @PostMapping("/courses")
    public Course saveCourse(@RequestBody Course course) {
        return courseService.save(course);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable String id) {
        return new ResponseEntity<>(courseService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {
        return courseService.save(course);
    }

    @DeleteMapping("/courses/{id}")
    public String deleteCourseById(@PathVariable String id) {
        courseService.deleteById(id);
        return "Deleted...";
    }
}
