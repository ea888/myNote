package com.ecvlearning.javaee.designPattern.facade;

public class Light {
    public void start(){
        System.out.println("Start "+this.getClass().getSimpleName());
    }

    public void shutdown(){
        System.out.println("Shutdown "+this.getClass().getSimpleName());
    }
}
