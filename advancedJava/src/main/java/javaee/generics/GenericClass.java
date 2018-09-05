package com.ecvlearning.javaee.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericClass<I> {
    List<I> test(List<I> list){
        return null;
    }




    public static void main(String[] args){
        GenericClass<String> gt = new GenericClass<>();
//        List<Integer> list = gt.test(new ArrayList<>());
        List<String> list = gt.test(new ArrayList<>());

        GenericClass gt2 = new GenericClass();
        List<String> list2 = gt.test(new ArrayList());
    }
}
