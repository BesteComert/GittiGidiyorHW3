package com.besteco.secondhomework;

import com.besteco.secondhomework.models.Course;
import com.besteco.secondhomework.models.Instructor;
import com.besteco.secondhomework.models.Student;
import com.besteco.secondhomework.models.enums.Gender;
import com.besteco.secondhomework.service.CourseService;
import com.besteco.secondhomework.service.InstructorService;
import com.besteco.secondhomework.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class SecondHomeworkApplication implements CommandLineRunner {

    private final StudentService studentService;
    private final CourseService courseService;
    private final InstructorService instructorService;

    public SecondHomeworkApplication(StudentService studentService, CourseService courseService, InstructorService instructorService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.instructorService = instructorService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SecondHomeworkApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Override
    public void run(String... args) throws Exception {
        Instructor instructor1 = new Instructor("Ömer Kahveci", "05516528787", "omergokgoz@gmail.com");
        Instructor instructor2 = new Instructor("Aybüke Coşkun", "05576519805", "aybukecoskun@gmail.com");
        Instructor instructor3 = new Instructor("Sare Keser", "05467284615", "sarekeser@gmail.com");

        Course course1 = new Course("Calculus-1", 1101, 5);
        Course course2 = new Course("Calculus-2", 1102, 5);
        Course course3 = new Course("Physics-1", 2101, 4);
        Course course4 = new Course("Physics-2", 2102, 4);
        Course course5 = new Course("Chemistry-1", 3101, 5);
        Course course6 = new Course("Chemistry-2", 3104, 5);

        Student student1 = new Student("Tuna Savran", LocalDate.of(1996, Month.JANUARY, 13), "Ankara", Gender.FEMALE);
        Student student2 = new Student("Sertel Kolat", LocalDate.of(1998, Month.JULY, 18), "İstanbul", Gender.MALE);
        Student student3 = new Student("Ata Ozyilmaz", LocalDate.of(1997, Month.SEPTEMBER, 6), "Bursa", Gender.MALE);

        instructor1.setCourseList(new HashSet<>(Arrays.asList(course1, course3)));
        instructor2.setCourseList(new HashSet<>(Arrays.asList(course2, course4)));
        instructor3.setCourseList(new HashSet<>(Arrays.asList(course6, course5)));

        student1.setCourseList((new HashSet<>(Arrays.asList(course1, course6))));
        student2.setCourseList((new HashSet<>(Arrays.asList(course2, course5))));
        student3.setCourseList((new HashSet<>(Arrays.asList(course3, course4))));

        studentService.save(student1);
        studentService.save(student2);
        studentService.save(student3);

        courseService.save(course1);
        courseService.save(course2);
        courseService.save(course3);
        courseService.save(course4);
        courseService.save(course5);
        courseService.save(course6);

        instructorService.save(instructor1);
        instructorService.save(instructor2);
        instructorService.save(instructor3);
    }
}
