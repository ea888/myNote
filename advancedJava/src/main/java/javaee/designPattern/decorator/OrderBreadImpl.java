package com.ecvlearning.javaee.designPattern.decorator;

public class OrderBreadImpl extends OrderDecorator {
    public OrderBreadImpl(Order order) {
        super(order);
    }

    @Override
    public void prepare() {
        System.out.println("Prepare Bread!");
        this.order.prepare();
    }

    @Override
    public void cost() {
        System.out.println("$2!");
        this.order.cost();
    }
}
