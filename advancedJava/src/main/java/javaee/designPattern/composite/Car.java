package com.ecvlearning.javaee.designPattern.composite;

public class Car {
    private String name;

    private Engine engine;

    private Tire tire;

    public Car(String name, Engine engine, Tire tire){

    }

    public Car(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Tire getTire() {
        return tire;
    }

    public void setTire(Tire tire) {
        this.tire = tire;
    }
}
