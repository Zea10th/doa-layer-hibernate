package com.example.daohibernate.service;

import com.example.daohibernate.entity.Person;
import com.example.daohibernate.repository.DAOHibernateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DAOHibernateService {
    private final DAOHibernateRepository repository;

    @Autowired
    public DAOHibernateService(DAOHibernateRepository repository) {
        this.repository = repository;
    }

    public String getPersonsByCity(String city) {
        var persons = repository.getPersonsByCity(city);
        var stringBuilder = new StringBuilder();
        for (Person person : persons) {
            stringBuilder.append("<br>")
                    .append(person.toString())
                    .append("</br>");
        }
        return stringBuilder.toString();
    }
}
