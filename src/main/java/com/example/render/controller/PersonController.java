package com.example.render.controller;

import com.example.render.entity.Person;
import com.example.render.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @GetMapping
    public List<Person> getAll() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        personService.deletePerson(id);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable Long id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }
}