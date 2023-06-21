package com.java.fundamentals.solid.dip;

public class DependenceInversionPrinciple {

    public static void main(String[] args) {

        EngineWrong engineWrong = new EngineWrong();
        CarWrong carWrong = new CarWrong(engineWrong);
        carWrong.start();

        // WRONG: If we need to create a new Engine, we will need to update the Car class because de concrete dependence of Engine class

        Engine petrolEngine = new PetrolEngine();
        Car petrolCar = new Car(petrolEngine);
        petrolCar.start();

        Engine dieselEngine = new DieselEngine();
        Car dieselCar = new Car(dieselEngine);
        dieselCar.start();

        // CORRECT: If we need to create a new car based on Electric engine, any change will be required on Car
        // because it's depends on Engine interface. So, we only need to create the ElectricEngine class
        // Engine electricEngine = new ElectricEngine();
        // Car electricCar = new Car(electricEngine);

    }
}

class CarWrong {

    private EngineWrong engineWrong;

    public CarWrong(EngineWrong engineWrong) {
        this.engineWrong = engineWrong;
    }

    public void start() {
        engineWrong.start();
    }

}

class EngineWrong {
    public void start() {

    }
}

class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.start();
    }
}

interface Engine {
    void start();
}

class PetrolEngine implements Engine {

    @Override
    public void start() {

    }
}

class DieselEngine implements Engine {

    @Override
    public void start() {

    }
}