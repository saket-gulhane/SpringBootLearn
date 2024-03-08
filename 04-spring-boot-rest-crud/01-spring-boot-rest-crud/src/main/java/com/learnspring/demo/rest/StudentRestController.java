package com.learnspring.demo.rest;
import java.util.ArrayList;
import java.util.List;
import com.learnspring.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Poor", "p"));
        theStudents.add(new Student("Mario", "R"));
        theStudents.add(new Student("Mary", "S"));
    }

    //define endpoint for "/student" - return a list of student
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    //define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // check the studentId against list size
        if(studentId >= theStudents.size() || studentId < 0){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);
    }
}


