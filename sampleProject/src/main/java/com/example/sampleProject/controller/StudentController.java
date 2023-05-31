package com.example.sampleProject.controller;

import com.example.sampleProject.model.Student;
import com.example.sampleProject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student stud = studentRepository.save(student);
        return  new ResponseEntity<>(stud, HttpStatus.CREATED);

    }

@GetMapping("/hii")
    public String welcome() {
        return "welcome";
    }
}
