package com.example.daohibernate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Person implements Serializable {
    @Id
    @Column(nullable = false)
    private String name;

    @Id
    @Column(nullable = false)
    private String surname;

    @Id
    private int age;

    private String phoneNumber;

    @Column(nullable = false)
    private String cityOfLiving;

    public Person() {
    }

    public Person(String name, String surname, int age, String phoneNumber, String cityOfLiving) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.cityOfLiving = cityOfLiving;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCityOfLiving() {
        return cityOfLiving;
    }

    public void setCityOfLiving(String cityOfLiving) {
        this.cityOfLiving = cityOfLiving;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %s %s",
                name, surname, age, phoneNumber, cityOfLiving);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && surname.equals(person.surname) && Objects.equals(phoneNumber, person.phoneNumber) && Objects.equals(cityOfLiving, person.cityOfLiving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, phoneNumber, cityOfLiving);
    }
}
