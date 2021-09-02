package com.besteco.secondhomework.controller;

import com.besteco.secondhomework.models.Instructor;
import com.besteco.secondhomework.models.Money;
import com.besteco.secondhomework.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> findAll() {
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/instructors/{find}")
    public ResponseEntity<List<Instructor>> findInstructorsByInstructorNameIsLike(@RequestParam String name){
        return (ResponseEntity<List<Instructor>>)instructorService.findInstructorsByInstructorNameIsLike(name);
    }

    @PostMapping("/instructors")
    public Instructor saveInstructor(@RequestBody Instructor instructor) {
        return instructorService.save(instructor);
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity<Instructor> findInstructorById(@PathVariable String id) {
        return new ResponseEntity<>(instructorService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/instructors")
    public Instructor updateInstructor(@RequestBody Instructor instructor) {
        return instructorService.save(instructor);
    }

    @DeleteMapping("/instructors/{id}")
    public String deleteInstructorById(@PathVariable String id) {
        instructorService.deleteById(id);
        return "Deleted...";
    }

    @GetMapping("/instructors/top3")
    public List<Instructor> findTop3Salary(){
        return instructorService.findTop3Salary();
    }

    @GetMapping("/instructors/last3")
    public List<Instructor> findLast3Salary(){
        return instructorService.findLast3Salary();
    }




}
