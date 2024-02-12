package com.movie.springboot2.controller;

import com.movie.springboot2.model.Person;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    private final List<Person> persons = new ArrayList<>();

    @PostMapping("/addPerson")
    void addPerson(@RequestBody Person person) {
        persons.add(person);
    }

    @PutMapping("/updatePerson/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable int id) {
        if (id >= 0 && id < persons.size()) {
            persons.set(id, person);
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/person")
    public List<Person> getPerson() {
        return persons;
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Object> getPersons(@PathVariable int id) {
        Person person = persons.get(id);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @DeleteMapping("/person/{name}")
    public ResponseEntity<Object> deletePersons(@PathVariable String name) {
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                persons.remove(person);
                return new ResponseEntity<>(person.getName() + " Person got deleted", HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>("Person didn't been found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/person/search")
    ResponseEntity<Object> searchPerson(@RequestParam String name) {
        List<Person> foundedPersons = new ArrayList<>();
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                foundedPersons.add(person);
            }
        }
        if (!foundedPersons.isEmpty()) {
            return new ResponseEntity<>(foundedPersons, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Nothing Found", HttpStatus.NOT_FOUND);
        }
    }
}
