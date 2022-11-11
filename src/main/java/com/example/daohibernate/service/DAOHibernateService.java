package com.example.daohibernate.service;

import com.example.daohibernate.entity.Person;
import com.example.daohibernate.repository.CustomizedPersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DAOHibernateService {
    private final CustomizedPersonsRepository repository;

    @Autowired
    public DAOHibernateService(CustomizedPersonsRepository repository) {
        this.repository = repository;
    }

    public String getPersonsByCity(String city) {
        return personsToStrings(repository.findPersonsByCityOfLiving(city));
    }

    public String getPersonsUnderAge(int age) {
        return personsToStrings(repository.findPersonsByAgeLessThan(age));
    }

    public String getPersonByFullName(String name, String surname) {
        var optional = repository.findPersonByNameAndSurname(name, surname);
        return (optional.isPresent()) ? optional.get().toString() : "There is no such person in database.";
    }

    private String personsToStrings(Collection<Person> persons) {
        var stringBuilder = new StringBuilder();
        for (Person person : persons) {
            stringBuilder.append("<br>")
                    .append(person.toString())
                    .append("</br>");
        }
        return stringBuilder.toString();
    }
}
