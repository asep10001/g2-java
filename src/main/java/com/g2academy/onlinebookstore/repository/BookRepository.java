package com.g2academy.onlinebookstore.repository;

import com.g2academy.onlinebookstore.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findByAuthorId(Long authorId, Pageable pageable);

    Optional<Book> findByIdAndAuthorId(Long id, Long authorId);
}
