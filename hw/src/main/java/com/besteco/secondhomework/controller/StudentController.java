package com.besteco.secondhomework.controller;

import com.besteco.secondhomework.models.Student;
import com.besteco.secondhomework.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/students/{find}")
    public ResponseEntity<List<Student>> findStudentsByStudentNameIsLike(@RequestParam String name){
        return (ResponseEntity<List<Student>>)studentService.findStudentsByStudentNameIsLike(name);
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable String id) {
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudentById(@PathVariable String id) {
        studentService.deleteById(id);
        return "Deleted...";
    }

    @GetMapping("/students/genderNumber")
    public List<Student> groupByGenderCount(){
        return studentService.groupByGenderCount();
    }

    @GetMapping("/students/gender")
    public List<Student> groupByGender(){
        return studentService.groupByGender();
    }

}
