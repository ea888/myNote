package com.ecvlearning.javaee.designPattern.singleton;

public class LazySingleInstance {
    private static volatile LazySingleInstance si = null;
    private LazySingleInstance(){
        //empty constructor
    }

    public static synchronized LazySingleInstance getSi() {
        if(si == null) {
            si = new LazySingleInstance();
        }

        return si;
    }
}
