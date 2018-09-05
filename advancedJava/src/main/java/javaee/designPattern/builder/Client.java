package com.ecvlearning.javaee.designPattern.builder;

public class Client {
    public static void main(String[] args){
        Car car = new Car();
        car.setBrand("bmw");
        car.setEngine("turbo");
        car.setModel("3");
        car.setTire("run flat");
        car.setWheel("heating wheel");

        //logic to deal with car

        CarBuilder cb =new CarBuilderImpl();
        car = cb.assemble("bmw","3");
    }
}
