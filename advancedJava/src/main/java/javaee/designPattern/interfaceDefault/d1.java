package com.ecvlearning.javaee.designPattern.interfaceDefault;

public interface d1 {
    default void print(){
        System.out.println("I'm default1.");
    }
}
