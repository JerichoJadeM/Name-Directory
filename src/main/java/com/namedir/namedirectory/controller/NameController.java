package com.namedir.namedirectory.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.namedir.namedirectory.entity.Person;
import com.namedir.namedirectory.service.PersonService;

@Controller
@RequestMapping("/persons")
public class NameController {

    private PersonService personService;

    public NameController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping("/list")
    public String personList(Model model){

        List<Person> list = personService.findAll();

        model.addAttribute("persons", list);
        
        return "person-list";
    }

    @GetMapping("/new")
    public String addNewPerson(Model model){

        model.addAttribute("person", new Person());

        return "person-form";
    }

    @GetMapping("/update")
    public String updatePerson(@RequestParam("personId") int id,  Model model){

        Person person = personService.findById(id);
       
        model.addAttribute("person", person);

        return "person-form";
    }


    @PostMapping("/save")
    public String savePerson(@ModelAttribute("person") Person person){

        personService.save(person);

        return "redirect:/persons/list";
    }

    @GetMapping("/delete")
    public String deletePerson(@RequestParam("personId") int id){

        personService.deleteById(id);

        return "redirect:/persons/list";

    }

    @GetMapping("/search")
    public String searchPerson(@RequestParam("query") String query, Model model){

        List<Person> searchResult = personService.seachByNameOrEmail(query);

        model.addAttribute("persons", searchResult);

        return "person-list";
    }

}
