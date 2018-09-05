package com.ecvlearning.javaee.designPattern.builder;

public class CarBuilderImpl implements CarBuilder{
    private void setEngine() {
        System.out.println("Install engine.");
    }


    private void setBody() {
        System.out.println("Install body.");
    }


    private void setChassis() {
        System.out.println("Install chassis.");
    }


    private void setInterior() {
        System.out.println("Install interior decoration.");
    }

    @Override
    public Car assemble(String name, String brand) {

        setChassis();
        setEngine();
        setBody();
        setInterior();

        Car car = new Car();
        car.setBrand(brand);
        car.setModel(name);
        return car;
    }
}
