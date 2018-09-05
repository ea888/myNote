package com.ecvlearning.javaee.designPattern.fpVisitor;

import java.util.function.Consumer;

public class EquityTransaction implements Transaction{
    private String ticker;
    private String action;
    private int price;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void accept(Consumer<Transaction> consumer) {
        consumer.accept(this);
    }
}
