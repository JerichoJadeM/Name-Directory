package com.namedir.namedirectory.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.namedir.namedirectory.entity.Person;
import com.namedir.namedirectory.service.PersonService;

@RestController
@RequestMapping("/api/persons")
@CrossOrigin(origins = "*")
public class NameControllerRest {
    
    private PersonService personService;

    public NameControllerRest(PersonService personService){
        this.personService = personService;
    }

    @GetMapping("/list")
    public List<Person> getPersonList(){
        
        return personService.findAll();
    }

    @GetMapping
    public List<Person> getPersonListDefault(){
        
        return personService.findAll();
    }


    @GetMapping("/{personId}")
    public Person getPerson(@PathVariable int personId){
        return personService.findById(personId);
    }


    @PostMapping()
    public Person savePerson(@RequestBody Person person){

        return personService.save(person);
    }

    @PutMapping("/{personId}")
    public Person updatePerson(@PathVariable int personId, @RequestBody Person updatePerson){
        updatePerson.setId(personId);
        return personService.save(updatePerson);
    }

    @DeleteMapping("/{personId}")
    public void deletePerson(@PathVariable int personId){
        personService.deleteById(personId);
    }

}
