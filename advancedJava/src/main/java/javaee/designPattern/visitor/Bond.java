package com.ecvlearning.javaee.designPattern.visitor;

public class Bond extends FixedIncomeTransaction {

    private String symbol;
    private String action;
    private int price;
    private int transactionFee;


    @Override
    public void accept(TradeStrategy ts) {
        ts.trade(this);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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

    public int getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(int transactionFee) {
        this.transactionFee = transactionFee;
    }
}
