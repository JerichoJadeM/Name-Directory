package com.namedir.namedirectory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.namedir.namedirectory.dao.PersonRepository;
import com.namedir.namedirectory.entity.Person;

@Service
public class PersonServiceImpl implements PersonService{

    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        
        return personRepository.findAll();
    }

    @Override
    public Person save(Person person) {

        return personRepository.save(person);
    }

    @Override
    public Person findById(Integer id) {
        
        Optional<Person> result = personRepository.findById(id);

        Person person = null;

        if (result.isPresent()) {
            person = result.get();
        } else {
            throw new RuntimeException("Id not found");
        }

        return person;
    }

    @Override
    public void deleteById(Integer id) {
        
        personRepository.deleteById(id);
    }

    @Override
    public List<Person> seachByNameOrEmail(String keyword) {
         if (keyword == null || keyword.isBlank()) {
            return findAll(); // return all if empty
        }

        return personRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(keyword, keyword, keyword);
    }   

}
