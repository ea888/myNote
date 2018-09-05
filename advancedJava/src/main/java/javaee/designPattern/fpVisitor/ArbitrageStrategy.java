package com.ecvlearning.javaee.designPattern.fpVisitor;

import java.util.function.Consumer;

public class ArbitrageStrategy implements TradeStrategy{

    private Consumer<Transaction> etc = et -> {
        System.out.println("This is equity etc");
        System.out.println(((EquityTransaction)et).getAction()+" "+((EquityTransaction)et).getTicker()+" @ "+((EquityTransaction)et).getPrice());
    };


    @Override
    public void changeArbitrageStrategy(Consumer<Transaction> consumer) {
        etc = consumer;
    }

    @Override
    public Consumer<Transaction> makeArbitrageStrategy() {
        return etc;
    }
}
