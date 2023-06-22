package com.java.fundamentals.designpatterns.creational.factory;

/**
 * Factory pattern is one of the most used design patterns in Java.
 * This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
 *
 * In Factory pattern, we create object without exposing the creation logic to the client and refer to newly created object using a common interface.
 */
public class Factory {

    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactoryImpl();
        Vehicle van = factory.getVehicle(VehicleTypeEnum.VAN);
        Vehicle truck = factory.getVehicle(VehicleTypeEnum.TRUCK);
        Vehicle bus = factory.getVehicle(VehicleTypeEnum.BUS);
        System.out.println("Types: " + van.getType() + ", " + truck.getType() + ", " + bus.getType());
    }

}

interface Vehicle {
    VehicleTypeEnum getType();
}

class Van implements Vehicle {
    public VehicleTypeEnum getType() {
        return VehicleTypeEnum.VAN;
    }
}

class Truck implements Vehicle {
    public VehicleTypeEnum getType() {
        return VehicleTypeEnum.TRUCK;
    }
}

class Bus implements Vehicle {
    public VehicleTypeEnum getType() {
        return VehicleTypeEnum.BUS;
    }
}

interface VehicleFactory {

    Vehicle getVehicle(VehicleTypeEnum vehicleTypeEnum);

}

class VehicleFactoryImpl implements VehicleFactory {
    @Override
    public Vehicle getVehicle(VehicleTypeEnum vehicleTypeEnum) {
        switch (vehicleTypeEnum) {
            case VAN: return new Van();
            case TRUCK: return new Truck();
            case BUS: return new Bus();
            default: return null;
        }
    }
}

enum VehicleTypeEnum {
    VAN, TRUCK, BUS
}