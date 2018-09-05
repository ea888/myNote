package com.ecvlearning.javaee.designPattern.visitor;

public class RiskAverseStrategy implements TradeStrategy{
    @Override
    public void arbitrage(EquityTransaction transaction) {

    }

    @Override
    public void trade(FixedIncomeTransaction transaction) {
        if(transaction instanceof Gic) {
            System.out.println("Trade " + ((Gic)transaction).getSymbol() + " @ " + ((Gic)transaction).getPrice());
        }else if(transaction instanceof Bond){
            System.out.println("Trade " + ((Bond)transaction).getSymbol() + " @ " + ((Bond)transaction).getPrice() + " fee:"+((Bond)transaction).getTransactionFee());
        }else if(transaction instanceof CaozongBit){
            System.out.println("Trade CaozongBit @ " + ((CaozongBit)transaction).getPrice());
        }
    }
}
