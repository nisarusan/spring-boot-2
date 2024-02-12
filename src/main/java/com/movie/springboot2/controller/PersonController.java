package com.movie.springboot2.controller;

import com.movie.springboot2.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    private List<Person> persons = new ArrayList<>();

    //list with users add
//    @PostMapping("/addPersons")
//    public void addPersons(@RequestBody List<Person> persons) {
//
//    }

    @PostMapping("/addPerson")
    void addPerson(@RequestBody Person person) {
        persons.add(person);
    }
    @GetMapping("/person")
    public List<Person> getPerson() {
        return persons;
    }

}
