package com.java.fundamentals.solid.isp;

public class InterfaceSegregationPrinciple {

    public static void main(String[] args) {

        VehicleTooManyMethods carWrong = new CarWrong();
        carWrong.drive();
        carWrong.stop();
        carWrong.refuel();
        carWrong.openDoors();

        VehicleTooManyMethods bikeWrong = new BikeWrong();
        bikeWrong.drive();
        bikeWrong.stop();
        bikeWrong.refuel();
        bikeWrong.openDoors(); // WRONG: Bike DO NOT have doors

        VehicleWithDoor car = new Car();
        car.drive();
        car.stop();
        car.refuel();
        car.openDoors();

        Vehicle bike = new Bike();
        bike.drive();
        bike.stop();
        bike.refuel();
        // CORRECT: bike DO NOT have openDoors method because Vehicle DO NOT require this method implementation

    }

}

interface VehicleTooManyMethods {

    void drive();
    void stop();
    void refuel();
    void openDoors();

}

class CarWrong implements VehicleTooManyMethods {
    @Override
    public void drive() {}

    @Override
    public void stop() {}

    @Override
    public void refuel() {}

    @Override
    public void openDoors() {}
}

class BikeWrong implements VehicleTooManyMethods {
    @Override
    public void drive() { }

    @Override
    public void stop() {}

    @Override
    public void refuel() {}

    @Override
    public void openDoors() { /** Bike DO NOT have doors */ }
}

interface Vehicle {
    void drive();

    void stop();

    void refuel();
}

interface VehicleWithDoor extends Vehicle {
    void openDoors();
}

class Car implements VehicleWithDoor {

    @Override
    public void drive() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void refuel() {

    }

    @Override
    public void openDoors() {

    }
}

class Bike implements Vehicle {

    @Override
    public void drive() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void refuel() {

    }
}

