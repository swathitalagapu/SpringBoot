package com.example.sampleProject.repository;

import com.example.sampleProject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByRollno(long rollno);
}
