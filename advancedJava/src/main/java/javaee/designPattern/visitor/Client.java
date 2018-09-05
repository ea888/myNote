package com.ecvlearning.javaee.designPattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args){
//        TradeStrategy tsEquity = new AbitrageStrategy();
        TradeStrategy tsFixedIncome = new RiskAverseStrategy();

//        EquityTransaction equity = new EquityTransaction();
        FixedIncomeTransaction fixedIncome = new FixedIncomeTransaction();
        Gic gic1 = new Gic();
        Gic gic2 = new Gic();
        Gic gic3 = new Gic();
        gic1.setSymbol("TD1");
        gic1.setPrice(2);
        gic2.setSymbol("CIBC1");
        gic2.setPrice(3);
        gic3.setSymbol("RBC1");
        gic3.setPrice(4);

        List<Gic> gics = new ArrayList<>();
        gics.add(gic1);
        gics.add(gic2);
        gics.add(gic3);

        Bond bond1 = new Bond();
        bond1.setSymbol("Canada 2 yrs");
        bond1.setPrice(20);
        bond1.setTransactionFee(1);
        List<Bond> bonds = new ArrayList<>();
        bonds.add(bond1);

//        equity.setPrice(800);
//        equity.setAction("Buy");
//        equity.setTicker("AAPL");
//        equity.accept(tsEquity);

        fixedIncome.setGics(gics);
        fixedIncome.setBond(bonds);

        CaozongBit cb = new CaozongBit();
        cb.setPrice(30000);
        fixedIncome.setCb(cb);

        fixedIncome.accept(tsFixedIncome);
    }
}
