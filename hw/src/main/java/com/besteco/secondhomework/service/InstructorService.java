package com.besteco.secondhomework.service;

import com.besteco.secondhomework.models.Instructor;
import com.besteco.secondhomework.repository.InstructorRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public List<Instructor> findAll() {
        return (List<Instructor>)instructorRepository.findAll();
    }

    public Instructor findById(String id) {
        return instructorRepository.findById(id).orElse(new Instructor());
    }

    @Transactional
    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public void deleteById(String id) {
        instructorRepository.deleteById(id);
    }

    public List<Instructor> findInstructorsByInstructorNameIsLike(String name){
        return instructorRepository.findInstructorsByInstructorNameIsLike(name);
    }

    public List<Instructor> findTop3Salary(){
        return instructorRepository.findTop3Salary();
    }

    public List<Instructor> findLast3Salary(){
        return instructorRepository.findLast3Salary();
    }
}
