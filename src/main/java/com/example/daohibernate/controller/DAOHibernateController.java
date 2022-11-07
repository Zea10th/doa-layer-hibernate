package com.example.daohibernate.controller;

import com.example.daohibernate.service.DAOHibernateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DAOHibernateController {
    private DAOHibernateService service;

    @Autowired
    public DAOHibernateController(DAOHibernateService service) {
        this.service = service;
    }

    @GetMapping(value = "/persons/by-city")
    public String getProductName(@RequestParam String city) {
        return service.getPersonsByCity(city);
    }
}
