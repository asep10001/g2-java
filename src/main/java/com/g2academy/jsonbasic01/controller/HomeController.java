package com.g2academy.jsonbasic01.controller;


import com.g2academy.jsonbasic01.domain.People;
import com.g2academy.jsonbasic01.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private PeopleService service;

    @GetMapping(value = "/")
    public String getFoosBySimplePath() {
        return "Welcome to Home Page";
    }

    @GetMapping(value = "/people")
    public String tes() {
        String results = "";
        for (People person : service.makePeople()) {
            results += "<div style=\"\n" +
                    "    color: blue;\n" +
                    "    text-align: center;\n" +
                    "    border: solid 1px #FFC107;\n" +
                    "    padding-bottom: 20px;\n" +
                    "    width: 100%;\n" +
                    "    justify-content: center;\n" +
                    "    align-items: center;\n" +
                    "\"><h1> Nama: " + person.getName().toUpperCase() + "</h1> " + "Date : " + person.getDob() + "<br></div>";
        }
        return results;
    }

    @GetMapping(value = "/nama")
    public String nama() {
        String results = "";
        for (People person : service.makePeople()) {
            results += person.getName().toUpperCase() + "<br>";
        }
        return results;
    }

    @GetMapping(value = "/findAll")
    public List<People> find() {
        List<People> results = new ArrayList<>();
        for (People person : service.makePeople()) {
            results.add(person);
        }
        return results;
    }

}
