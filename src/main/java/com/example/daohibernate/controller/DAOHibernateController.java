package com.example.daohibernate.controller;

import com.example.daohibernate.service.DAOHibernateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DAOHibernateController {
    private final DAOHibernateService service;

    @Autowired
    public DAOHibernateController(DAOHibernateService service) {
        this.service = service;
    }

    @GetMapping(value = "/persons/by-city")
    public String getPersonsByCityOfLiving(@RequestParam String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping(value = "/persons/under-age")
    public String getPersonsUnderAge(@RequestParam int age) {
        return service.getPersonsUnderAge(age);
    }

    @GetMapping(value = "/persons/by-full-name")
    public String getPersonsByNameAndSurname(@RequestParam(name = "name") String name,
                                             @RequestParam(name = "surname") String surname) {
        return service.getPersonByFullName(name, surname);
    }
}
