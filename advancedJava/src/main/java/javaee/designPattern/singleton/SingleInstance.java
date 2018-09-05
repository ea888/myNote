package com.ecvlearning.javaee.designPattern.singleton;

public class SingleInstance {
    private static final SingleInstance si = new SingleInstance();
    public String name = "Singleton";
    private SingleInstance(){
        //empty constructor
    }

    public static SingleInstance getSi() {
        return si;
    }

    public void print(){
        System.out.println("I'm singleton");
    }

}
