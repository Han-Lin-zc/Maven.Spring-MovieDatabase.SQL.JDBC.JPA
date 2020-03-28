package io.zipcoder.persistenceapp.controller;

import io.zipcoder.persistenceapp.models.Person;
import io.zipcoder.persistenceapp.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class PersonController {


    private PersonService service;

    public PersonController(PersonService service) { this.service = service; }

    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping("/people/")
    public ResponseEntity<Iterable<Person>> getAllPeople() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping("/people/")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        return new ResponseEntity<>(service.createPerson(person), HttpStatus.CREATED);
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

    @GetMapping("/people/firstName/{firstName}")
    public ResponseEntity<Iterable<Person>> getAllPeopleFirstName(@PathVariable String firstName) {
        return new ResponseEntity<>(service.findAllWithFirstName(firstName), HttpStatus.OK);
    }

    @GetMapping("/people/firstName/{lastName}")
    public ResponseEntity<Iterable<Person>> getAllPeopleLastName(@PathVariable String lastName) {
        return new ResponseEntity<>(service.findAllWithLastName(lastName), HttpStatus.OK);
    }

    @GetMapping("/people/firstName/{birthday}")
    public ResponseEntity<Iterable<Person>> getAllPeopleBirthday(@PathVariable String birthday) {
        return new ResponseEntity<>(service.findAllWithBirthday(birthday), HttpStatus.OK);
    }

    @GetMapping("/people/lastName")
    public ResponseEntity<Map<String, List<Person>>> getMappingOfLastName() {
        return new ResponseEntity<>(service.findLastNameMap(), HttpStatus.OK);
    }

    @GetMapping("/people/lastName")
    public ResponseEntity<Map<String, List<Person>>> getMappingOfFirstName() {
        return new ResponseEntity<>(service.findFirstNameMap(), HttpStatus.OK);
    }

}
