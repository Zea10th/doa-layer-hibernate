package com.example.daohibernate.controller;

import com.example.daohibernate.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping(value = "/persons")
public class CRUDController {
    private final CRUDService service;

    @Autowired
    public CRUDController(CRUDService service) {
        this.service = service;
    }

    @GetMapping(value = "create-person")
    @RolesAllowed(value = "WRITE")
    public String createPerson(@RequestParam(name = "name") String name) {
        return "Person " + name + " has been added to database.";
    }

    @GetMapping(value = "find-person")
    @Secured(value = {"READ", "WRITE", "ROLE_USER"})
    public String findPerson(@RequestParam(name = "name") String name,
                             @RequestParam(name = "surname") String surname) {
        return service.findPerson(name, surname);
    }

    @GetMapping(value = "greetings")
    @PreAuthorize("#username == authentication.principal.username")
    public String userGreetings (@RequestParam(name = "username") String name) {
        return "Greetings, " + name + ". Welcome to secured app.";
    }

//    @PostMapping(value = "move-person")
//    public String movePerson(@RequestParam(name = "name") String name,
//                             @RequestParam(name = "surname") String surname,
//                             @RequestParam(name = "city") String city) {
//        return service.movePerson(name, surname, city);
//    }

    @PostMapping(value = "delete-person")
    @PreAuthorize("hasRole('READ') or hasRole('WRITE')")
    public String deletePerson(@RequestParam(name = "name") String name,
                               @RequestParam(name = "surname") String surname) {
        return service.deletePerson(name, surname);
    }
}
