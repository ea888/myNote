package com.ecvlearning.javaee.designPattern.fpStrategy;

import java.util.function.Consumer;

public class TradeStrategy {
    Consumer<EquityTransaction> consumer;

    public Consumer<EquityTransaction> getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer<EquityTransaction> consumer) {
        this.consumer = consumer;
    }

    void trade(EquityTransaction et){
        consumer.accept(et);
    }
}
