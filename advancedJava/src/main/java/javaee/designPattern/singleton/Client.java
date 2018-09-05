package com.ecvlearning.javaee.designPattern.singleton;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Client implements Serializable {
    public static void main(String[] args){
        SingleInstance si = SingleInstance.getSi();
        si.print();
        si.name = "abc";
        System.out.println(si.name);

        si = null;
//        si.print();

        si = SingleInstance.getSi();
        si.print();

        final Map map = new HashMap();
        map.put("1","1");

//        EnumSingleton es = new EnumSingleton();
        EnumSingleton es = EnumSingleton.INSTANCE;
        System.out.println(es.getInfo());
        System.out.println(EnumSingleton.INS.getInfo());
    }
}
