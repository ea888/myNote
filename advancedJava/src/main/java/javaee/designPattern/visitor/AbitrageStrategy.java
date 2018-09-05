package com.ecvlearning.javaee.designPattern.visitor;

public class AbitrageStrategy implements TradeStrategy{

    private boolean filter(EquityTransaction transaction) {
        return transaction.getPrice() > 100;
    }

    @Override
    public void arbitrage(EquityTransaction transaction) {
        if(filter(transaction)) {
            System.out.println(transaction.getAction() + " " + transaction.getTicker() + " @ " + transaction.getPrice());
        }
    }

    @Override
    public void trade(FixedIncomeTransaction transaction) {

    }
}
