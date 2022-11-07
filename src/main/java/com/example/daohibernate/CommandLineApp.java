package com.example.daohibernate;

import com.example.daohibernate.entity.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Random;

@Component
public class CommandLineApp implements CommandLineRunner {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var cities = List.of(
                "Athens",
                "Berlin",
                "Istanbul",
                "London",
                "Madrid",
                "Moscow",
                "Paris",
                "Rome"
        );

        var names = List.of(
                "Anna",
                "Ira",
                "Kirill",
                "Masha",
                "Olya",
                "Sergey",
                "Sveta",
                "Vasya"
        );

        var surnames = List.of(
                "Bobkova",
                "Ivanova",
                "Kozlova",
                "Kuznetsova",
                "Malinina",
                "Petrov",
                "Popov",
                "Sidorov"
        );

        var random = new Random();

        for (int i = 0; i < 100; i++) {
            entityManager.persist(new Person(
                            names.get(random.nextInt(names.size())),
                            surnames.get(random.nextInt(surnames.size())),
                            random.nextInt(60),
                            String.format("+79%9d", random.nextInt(999_999_999)),
                            cities.get(random.nextInt(cities.size()))
                    )
            );
        }
    }
}
