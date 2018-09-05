package com.chandler.exp.inheritance;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args){
        Parent parent = new Parent();
        Parent child = new Child();
        Child realChild = new Child();

        parent.setGender("N/A");

        child.setName("A");
        child.setGender("M");

        realChild.setGender("F");

        System.out.println(child.getName());
        System.out.println(child.getGender());
        System.out.println(realChild.getGender());

        List<String> list = new ArrayList<>();
        list.addAll(null);



    }
}
