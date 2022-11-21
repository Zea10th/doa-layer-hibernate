package com.example.daohibernate.service;

import com.example.daohibernate.entity.Person;
import com.example.daohibernate.repository.CustomizedPersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CRUDService {

    private final CustomizedPersonsRepository repository;

    @Autowired
    public CRUDService(CustomizedPersonsRepository repository) {
        this.repository = repository;
    }

    public String createPerson(Person person) {
        var newPerson = repository.save(person);
        return String.format("Person %s %s was created in database.",
                newPerson.getName(), newPerson.getSurname());
    }

    public String findPerson(String name, String surname) {
        var optionalPerson = repository.findPersonByNameAndSurname(name, surname);
        return (optionalPerson.isPresent()) ?
                optionalPerson.get().toString() :
                "There is no such person in database.";
    }

//    public String movePerson(String name, String surname, String city) {
//        var optionalPerson = repository.findPersonByNameAndSurname(name, surname);
//        if (optionalPerson.isPresent()) {
//            var person = repository.save(optionalPerson.get());
//            person.setCityOfLiving(city);
//            repository.save(person);
//            return "Person has been moved:\n" + person;
//        } else {
//            return "There is no such person in database.";
//        }
//    }

    public String deletePerson(String name, String surname) {
        var optionalPerson = repository.findPersonByNameAndSurname(name, surname);
        if (optionalPerson.isPresent()) {
            var person = optionalPerson.get();
            repository.delete(person);
            return "Person has been deleted:\n" + person;
        } else {
            return "There is no such person in database.";
        }
    }
}
