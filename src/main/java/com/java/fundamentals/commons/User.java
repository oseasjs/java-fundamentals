package com.java.fundamentals.commons;

public class User {
    private Long id;
    private String name;
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
