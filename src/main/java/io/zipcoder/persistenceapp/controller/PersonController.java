package io.zipcoder.persistenceapp.controller;

import io.zipcoder.persistenceapp.models.Person;
import io.zipcoder.persistenceapp.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {


    private PersonService service;

    public PersonController(PersonService service) { this.service = service; }

    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/people/")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        return new ResponseEntity<>(service.addPerson(person), HttpStatus.CREATED);
    }

    @PutMapping("/people/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person) {
        if (service.findById(id) != null) {
            return new ResponseEntity<>(service.updatePerson(id, person), HttpStatus.OK);
        } else {
            return create(person);
        }
    }

    @DeleteMapping("/people/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return new ResponseEntity<>(service.deletePerson(id), HttpStatus.NOT_FOUND);
    }
}
