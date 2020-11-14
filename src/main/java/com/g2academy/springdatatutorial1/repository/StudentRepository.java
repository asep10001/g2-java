package com.g2academy.springdatatutorial1.repository;

import com.g2academy.springdatatutorial1.domain.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

//anotate ini berfungsi untuk mengcreate repositoryy dan metadata oleh ioc tinggal di pakkai di service
public interface StudentRepository extends JpaRepository<Students, Long> {
}


//crudRepository
//Spring data itu sebetulanya memudahkan kita berinteraksi dengan database
//
//JpaRepository
//sama satu lagi