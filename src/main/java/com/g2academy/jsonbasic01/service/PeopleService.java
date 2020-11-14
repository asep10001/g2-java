package com.g2academy.jsonbasic01.service;

import com.g2academy.jsonbasic01.domain.People;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleService {

    public List<People> makePeople() {
        List<People> person = new ArrayList<>();

        People a = new People(1, "asep", LocalDate.now(), "Adress 1", "hei@mail", "tes");
        People b = new People(2, "Andi", LocalDate.now(), "Adress 2", "hei@mail", "yas");

        person.add(a);
        person.add(b);
        return person;

    }

}
