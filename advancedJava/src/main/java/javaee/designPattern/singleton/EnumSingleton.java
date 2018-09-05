package com.ecvlearning.javaee.designPattern.singleton;

public enum EnumSingleton {

    INSTANCE("Initial class info"),
    INS("haha");

    private String info;

    private EnumSingleton(String info) {
        this.info = info;
        System.out.println("Enum Constructor:"+info);
    }

//    public EnumSingleton getInstance() {
//        return INSTANCE;
//    }

    // getters and setters
    public String getInfo(){
        return this.info;
    }
}
