package com.java.fundamentals.designpatterns.behavioral.mediator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Mediator pattern is used to reduce communication complexity between multiple objects or classes.
 * This pattern provides a mediator class which normally handles all the communications between different classes and supports easy maintenance of the code by loose coupling.
 * Mediator pattern falls under behavioral pattern category.
 */
public class Mediator {

    public static void main(String[] args) {
        User user = new User("John");
        user.sendMessage("My Message");
    }

}

class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + " | User: " + user.getName() + " - message: " + message);
    }
}

class User {
    private String name;
    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}