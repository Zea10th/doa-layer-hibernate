package com.example.daohibernate.repository;

import com.example.daohibernate.entity.Person;
import com.example.daohibernate.entity.PersonID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomizedPersonsRepository extends JpaRepository<Person, PersonID> {
    List<Person> findPersonsByCityOfLiving(String city);

    List<Person> findPersonsByAgeLessThan(int age);

    Optional<Person> findPersonByNameAndSurname(String name, String surname);
}
