package com.g2academy.onlinebookstore.model;
        import lombok.*;

        import javax.persistence.*;
        import java.time.LocalDate;
        import java.util.ArrayList;
        import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @Id
    @Column(name = "age", nullable = false)
    private String address;

    @Column(name = "birth_date", nullable = false)
    private String url;

}
