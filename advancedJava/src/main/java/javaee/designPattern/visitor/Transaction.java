package com.ecvlearning.javaee.designPattern.visitor;

public interface Transaction {

    void accept(TradeStrategy ts);
}
