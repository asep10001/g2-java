package com.g2academy.basicdi.rest;

import com.g2academy.basicdi.component.StudentComponent;
import com.g2academy.basicdi.domain.Student;
import com.g2academy.basicdi.server.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService service;
    private final StudentComponent sComponent;

    StudentController(StudentService service, StudentComponent sComponent){
        this.service = service;
        this.sComponent = sComponent;
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return this.service.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Long id){
        return this.sComponent.findStudentById(id);
    }
}
