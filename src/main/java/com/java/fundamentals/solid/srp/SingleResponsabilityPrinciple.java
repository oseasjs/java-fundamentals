package com.java.fundamentals.solid.srp;

public class SingleResponsabilityPrinciple {

    public static void main(String[] args) {

        VehicleTooManyResponsability vehicleWrong = new VehicleTooManyResponsability();
        vehicleWrong.printDetails();
        vehicleWrong.calculateValue();
        vehicleWrong.addVehicleToDB();

        VehicleDetailsPrinter vehicleDetailsPrinter = new VehicleDetailsPrinter();
        vehicleDetailsPrinter.printDetails();

        VehicleValueCalculator vehicleValueCalculator = new VehicleValueCalculator();
        vehicleValueCalculator.calculateValue();

        VehicleRepository vehicleRepository = new VehicleRepository();
        vehicleRepository.addVehicleToDB();

    }

}

class VehicleTooManyResponsability {

    public void printDetails() {

    }

    public void calculateValue() {

    }

    public void addVehicleToDB() {

    }

}

class VehicleDetailsPrinter {
    public void printDetails() {

    }
}

class VehicleValueCalculator {
    public void calculateValue() {

    }
}

class VehicleRepository {

    public void addVehicleToDB() {

    }

}
