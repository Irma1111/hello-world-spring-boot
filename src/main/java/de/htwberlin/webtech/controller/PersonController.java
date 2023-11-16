package de.htwberlin.webtech.controller;

import de.htwberlin.webtech.entity.Person;
import de.htwberlin.webtech.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @PostMapping("/persons")
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    // Weitere Methoden für Update und Delete
}
