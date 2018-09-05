package com.ecvlearning.javaee.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericSample {
    public static void main(String[] args){
        List list = new ArrayList();
        list.add("I'm the first element.");
        list.add(50);
        list.add(new GenericMethods());
    }
}
