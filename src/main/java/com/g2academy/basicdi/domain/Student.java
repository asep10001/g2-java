package com.g2academy.basicdi.domain;

public class Student {
    private Long id;
    private String name;
    private String address;
    private Integer score;

    public Student(Long id, String name, String address, Integer score) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
