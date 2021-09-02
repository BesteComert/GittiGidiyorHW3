package com.besteco.secondhomework.service;

import com.besteco.secondhomework.models.Course;
import com.besteco.secondhomework.models.Student;
import com.besteco.secondhomework.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService{

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return (List<Student>)studentRepository.findAll();
    }

    public Student findById(String id) {
        return studentRepository.findById(id).orElse(new Student());
    }

    @Transactional
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void deleteById(String id) {
        studentRepository.deleteById(id);
    }

    public List<Student> findStudentsByStudentNameIsLike(String name){
        return studentRepository.findStudentsByStudentNameIsLike(name);
    }

    public List<Student> groupByGenderCount(){
        return studentRepository.groupByGenderCount();
    }

    public List<Student> groupByGender(){
        return studentRepository.groupByGender();
    }
}
