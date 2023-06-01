package com.example.sampleProject.controller;

import com.example.sampleProject.model.Student;
import com.example.sampleProject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/student/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student stud = studentRepository.save(student);
        return new ResponseEntity<>(stud, HttpStatus.CREATED);

    }

    @GetMapping("/hii")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/student/{rollno}")
    public ResponseEntity<Student> getStudentDetails(@PathVariable int rollno) {
        List<Student> stud = studentRepository.findByRollno(rollno);
        if (stud.contains(rollno)) {
            return new ResponseEntity<>(stud.get(rollno), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/students")
    public List<Student> listOfStudents(@RequestParam String stuname){
        List<Student> student = studentRepository.findByStuName(stuname);
       return student;
    }


}
