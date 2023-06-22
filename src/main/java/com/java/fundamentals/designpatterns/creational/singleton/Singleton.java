package com.java.fundamentals.designpatterns.creational.singleton;

/**
 * Singleton pattern is one of the simplest design patterns in Java.
 * This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
 *
 * This pattern involves a single class which is responsible to create an object while making sure that only single object gets created.
 * This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class.
 */
public class Singleton {

    public static void main(String[] args) {
        Car car = Car.getInstance();
        System.out.println(car);
        Car sameInstance = Car.getInstance();
        System.out.println(sameInstance);
    }

}

class Car {

    private static Car car;

    private Car() {

    }

    public static Car getInstance() {
        if (car == null) {
            car = new Car();
        }
        return car;
    }

}
