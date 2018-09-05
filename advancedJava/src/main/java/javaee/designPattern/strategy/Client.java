package com.ecvlearning.javaee.designPattern.strategy;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args){
        Sort sort = SortAlgrithmFactory.getAlgorithm(args[0]);
        sort.sort(new ArrayList<>());
    }
}
