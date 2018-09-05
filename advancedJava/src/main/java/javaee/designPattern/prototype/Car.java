package com.ecvlearning.javaee.designPattern.prototype;

public class Car implements Cloneable{
    String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        super.clone();

        Car car =new Car();
        car.name = this.name;
        return car;
    }
}
