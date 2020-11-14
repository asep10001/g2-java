package com.g2academy.basicdi.component;

import com.g2academy.basicdi.domain.Student;
import com.g2academy.basicdi.server.StudentService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//untuk mengakses library di luar spring
public class    StudentComponent {
    private final StudentService service;

    StudentComponent(StudentService service){
        this.service = service;
    }

    public Student findStudentById(Long id){
        List<Student> students = service.findAll();
        Student result = null;
        for(Student student: students ){
            if(student.getId() == id){
                result = student;
                break;
            }
        }
        return result;
    }
}
