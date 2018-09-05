package com.ecvlearning.javaee.designPattern.fpStrategy;

public class Client {
    public static void main(String[] args){
        EquityTransaction et = new EquityTransaction();
        et.setAction("Buy");
        et.setPrice(100);
        et.setTicker("AAPL");

        TradeStrategy ts = new TradeStrategy();
        ts.setConsumer(transaction-> System.out.println("Action:"+transaction.getAction()+" "+transaction.getTicker()+" @ "+transaction.getPrice()));
        ts.trade(et);

        ts.setConsumer(transaction-> System.out.println("Action:"+transaction.getAction()));
        ts.trade(et);
    }
}
