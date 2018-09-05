package com.ecvlearning.javaee.designPattern.composite;

public class Client {
    public static void main(String[] args){
        Car car = new Car();
        car.setEngine(new Engine());
    }
}
