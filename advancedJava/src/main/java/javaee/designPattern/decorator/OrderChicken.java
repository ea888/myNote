package com.ecvlearning.javaee.designPattern.decorator;

public class OrderChicken extends OrderDecorator {

    public OrderChicken(Order order) {
        super(order);
    }

    @Override
    public void prepare() {
        System.out.println("Order Chicken!");
        this.order.prepare();
    }

    @Override
    public void cost() {
        System.out.println("$5!");
        this.order.cost();
    }
}
