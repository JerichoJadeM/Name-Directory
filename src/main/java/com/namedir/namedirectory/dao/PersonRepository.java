package com.namedir.namedirectory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.namedir.namedirectory.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

    List<Person> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
        String firstName, String lastName, String email
    );

}
