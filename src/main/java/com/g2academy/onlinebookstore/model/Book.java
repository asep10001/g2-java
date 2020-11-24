package com.g2academy.onlinebookstore.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "books")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "pubisher_name", nullable = false)
    private String publisherName;

    @Column(name = "author_name", nullable = false)
    private String authorName;

    @Column(name = "author_address", nullable = false)
    private String authorAddress;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "price", nullable = false)
    private Double price;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "author_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_books_authors_id"
            )
    )
    private Book book;

}
