package com.ecvlearning.javaee.cloneSample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TradeVO implements Cloneable {
    private int price;
    private String ticker;
    private List<String> strategy = new ArrayList<>();
    private Set<String> strategySet = new HashSet();

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public List<String> getStrategy() {
        return strategy;
    }

    public void setStrategy(List<String> strategy) {
        this.strategy = strategy;
    }

    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public TradeVO clone1(){
        return null;
    }

    public void print(){
        System.out.println("Tikcer:"+this.ticker);
        System.out.println("Price:"+this.price);
        this.strategy.forEach(item -> System.out.println(item));
        System.out.println();
    }
}
