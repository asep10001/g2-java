package com.g2academy.basicdi.server;

import com.g2academy.basicdi.domain.Student;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
//untuk mengakses library yang sama di library spring
public class StudentService {

    private List<Student> students = new ArrayList<>();

    @PostConstruct
    public void initStudent(){
        Student student1 = new Student(1L, "Student 1", "Address 1", 1);
        Student student2 = new Student(2L, "Student 2", "Address 2", 1);
        Student student3 = new Student(3L, "Student 3", "Address 3", 1);
        Student student4 = new Student(4L, "Student 4", "Address 4", 1);
        Student student5 = new Student(5L, "Student 5", "Address 5", 1);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

    }

    public List<Student> findAll(){
        return  students;
    }

    public  void addStudent(Student request){
        students.add(request);
    }

}
