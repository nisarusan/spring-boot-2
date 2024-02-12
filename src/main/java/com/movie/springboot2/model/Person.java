package com.movie.springboot2.model;

import java.time.LocalDate;
import java.util.Date;

public class Person {

    private String name;
    private LocalDate dob;
    private char gender;

    public Person(String name, LocalDate dob, char gender) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
