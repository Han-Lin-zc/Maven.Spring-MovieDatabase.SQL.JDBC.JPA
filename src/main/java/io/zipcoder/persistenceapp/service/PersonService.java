package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.models.Person;
import io.zipcoder.persistenceapp.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersonService {

    PersonRepository repo;

    public Person addPerson(Person person) {
        return repo.save(person);
    }

    public Person updatePerson(Long id, Person newPersonData) {
        Person originalPerson = repo.findOne(id);
        originalPerson.setFirst_Name(newPersonData.getFirst_Name());
        originalPerson.setLast_Name(newPersonData.getLast_Name());
        originalPerson.setMobile(newPersonData.getMobile());
        originalPerson.setBirthday(newPersonData.getBirthday());
        originalPerson.setHome_id(newPersonData.getHome_id());
        return repo.save(originalPerson);
    }

    public Boolean deletePerson(Long id) {
        repo.delete(id);
        return true;
    }

    public Person findById(Long id) {
        return repo.findOne(id);
    }

    public List<Person> findAllWithFirstName(String firstName) {
        return null;
    }

    public List<Person> findAllWithLastName(String lastName) {
        return null;
    }

    public List<Person> findAllWithBirthday(String birthday) {
        return null;
    }

    public Map<String, List<Person>> findLastNameMap() {
        return null;
    }

    public Map<String, List<Person>> findFirstNameMap() {
        return null;
    }
}
