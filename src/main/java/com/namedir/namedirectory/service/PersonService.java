package com.namedir.namedirectory.service;

import java.util.List;

import com.namedir.namedirectory.entity.Person;

public interface PersonService {
    List<Person> findAll();

    Person save(Person person);

    Person findById(Integer id);

    void deleteById(Integer id);

    List<Person> seachByNameOrEmail(String keyword);
}
