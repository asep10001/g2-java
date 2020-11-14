package com.g2academy.springdatatutorial1.service;

import com.g2academy.springdatatutorial1.domain.Students;
import com.g2academy.springdatatutorial1.repository.StudentRepository;
import com.g2academy.springdatatutorial1.service.dto.StudentsDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository repository;

//    injection repository
    StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    private Students save(Students entity) {
        return repository.save(entity);
    }

    public Students add(StudentsDto studentsDto) {
        Students entity = Students.builder()
                .name(studentsDto.getName())
                .address(studentsDto.getAddress())
                .semester(studentsDto.getSemester())
                .build();
        return this.save(entity);
    }

    public List<Students> findAll() {
        return repository.findAll();
    }

    public Optional<Students> findById(Long id) {
        return repository.findById(id);
    }

    public Students edit(StudentsDto studentDto) {
        Optional<Students> entity = repository.findById(studentDto.getId());

        if (entity.isPresent()) {
            Students student = entity.get();
            student.setName(studentDto.getName());
            student.setAddress(studentDto.getAddress());
            student.setSemester(studentDto.getSemester());

            return repository.save(student);
        } else {
            return null;
        }
    }

    public void delete(StudentsDto studentsDto) {
        Optional<Students> entity = repository.findById(studentsDto.getId());
        if (entity.isPresent()) {
            repository.delete(entity.get());
        }
    }

    //semua bentuk method menggunakan repository
}
