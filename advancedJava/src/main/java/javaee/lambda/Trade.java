package com.ecvlearning.javaee.lambda;

public class Trade {
    String ticker;
    int price;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void trade(String action){
        System.out.println(action+" "+ticker+" at price:"+price);
    }
}
