package com.ecvlearning.javaee.designPattern.strategy;

import java.util.Collection;

public class Quicksort implements Sort{
    @Override
    public <E> Collection sort(Collection<E> collection) {
        System.out.println("Using "+this.getClass().getSimpleName());
        return null;
    }
}
