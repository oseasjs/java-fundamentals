package com.java.fundamentals.solid.ocp;

public class OpenClosePrinciple {

    public static void main(String[] args) {

        // If one more vehicle type is created, VehicleCalculator will be required
        VehicleCalculator vehicleWrong = new VehicleCalculator();
        vehicleWrong.calculateValue(new Car());
        vehicleWrong.calculateValue(new Bike());

        // Car is a Vehicle type and override calculateValue method
        Car car = new Car();
        car.calculateValue();

        // Bike is a Vehicle type and override calculateValue method
        Bike bike = new Bike();
        bike.calculateValue();

        // If a new vehicle type is created, just need to extend Vehicle class and override the calculateValue method
        // Truck truck = new Truck();
        // truck.calculateValue();


    }

}



class VehicleCalculator {

    public double calculateValue(Vehicle vehicle) {
        if (vehicle instanceof Car)
            return vehicle.getValue() * 0.8;
        if (vehicle instanceof Bike)
            return vehicle.getValue() * 0.5;
        return 0;
    }

}

class Vehicle {
    public double calculateValue() {
        return getValue() * 0.3;
    }
    protected double getValue() {
        return 10;
    }
}

class Car extends Vehicle {

    @Override
    public double calculateValue() {
        return getValue() * 0.8;
    }
}

class Bike extends Vehicle {

    @Override
    public double calculateValue() {
        return getValue() * 0.5;
    }
}