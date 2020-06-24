package com.liquibase.liquibase;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("person")
public class Controller {

    private PersonRepository personRepository;
    
    @PostMapping
    public String createPerson(@RequestParam String name){

        Person p = new Person();
        p.setName(name);
        personRepository.save(p);

        return personRepository.findByName(name) + " Saved sucessfuly";

    }

    @GetMapping
    public List<Person> getAllPeople(){

        return (List<Person>) personRepository.findAll();
        
    }
 



}