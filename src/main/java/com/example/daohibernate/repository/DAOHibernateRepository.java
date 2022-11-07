package com.example.daohibernate.repository;

import com.example.daohibernate.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class DAOHibernateRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Collection<Person> getPersonsByCity(String city) {
        var query = entityManager.createQuery("select p from Person p where p.cityOfLiving = :city");
        query.setParameter("city", city);
        return (Collection<Person>) query.getResultList();
    }
}
