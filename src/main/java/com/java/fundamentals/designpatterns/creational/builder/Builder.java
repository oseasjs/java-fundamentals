package com.java.fundamentals.designpatterns.creational.builder;

/**
 * Builder pattern builds a complex object using simple objects and using a step by step approach.
 * This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
 *
 * A Builder class builds the final object step by step. This builder is independent of other objects.
 */
public class Builder {

    public static void main(String[] args) {

        Person person = Person.builder()
                .name("John")
                .age(10)
                .build();

        System.out.println("Person name: " + person.getName() + " - age: " + person.getAge());

    }

}

class Person {

    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public static PersonBuild builder() {
        return new PersonBuild();
    }

}

class PersonBuild {

    private String name;
    private int age;

    public PersonBuild name(String name) {
        this.name = name;
        return this;
    }

    public PersonBuild age(int age) {
        this.age = age;
        return this;
    }

    public Person build() {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        return person;
    }

}