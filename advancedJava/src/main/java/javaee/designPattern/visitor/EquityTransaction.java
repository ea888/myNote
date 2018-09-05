package com.ecvlearning.javaee.designPattern.visitor;

public class EquityTransaction implements Transaction {
    private String ticker;
    private String action;
    private int price;

    @Override
    public void accept(TradeStrategy ts) {
        ts.arbitrage(this);
    }

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
}
