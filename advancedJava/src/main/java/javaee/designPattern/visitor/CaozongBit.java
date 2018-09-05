package com.ecvlearning.javaee.designPattern.visitor;

public class CaozongBit extends FixedIncomeTransaction{
    private int price;


    @Override
    public void accept(TradeStrategy ts) {
        ts.trade(this);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
