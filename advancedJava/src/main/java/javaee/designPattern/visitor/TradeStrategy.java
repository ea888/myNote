package com.ecvlearning.javaee.designPattern.visitor;

/**
 * Can we avoid declaring two methods?
 */
public interface TradeStrategy {
    void arbitrage(EquityTransaction transaction);
    void trade(FixedIncomeTransaction transaction);
}
