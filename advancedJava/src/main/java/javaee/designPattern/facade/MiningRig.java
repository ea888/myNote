package com.ecvlearning.javaee.designPattern.facade;

public class MiningRig {
    public void start(){
        System.out.println("Start "+this.getClass().getSimpleName());
    }

    public void shutdown(){
        System.out.println("Shutdown "+this.getClass().getSimpleName());
    }
}
