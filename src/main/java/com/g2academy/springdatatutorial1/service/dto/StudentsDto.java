package com.g2academy.springdatatutorial1.service.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentsDto {

    private Long id;
    private String name;
    private String address;
    private Integer semester;
}

//dto adalah object yang di passing oleh client
//ini merupakan jakson api agar menjadi json