package com.ecvlearning.javaee.designPattern.facade;

public class QiuFacade {
    private Alarm a = new Alarm();;
    private Door door = new Door();
    private Light light = new Light();;
    private MiningRig mr = new MiningRig();

    public void goodMorning(){
        a.shutdown();
        door.start();
        light.start();
        mr.start();
    }

    public void bye(){
        door.shutdown();
        light.shutdown();
        mr.shutdown();
        a.start();
    }
}
