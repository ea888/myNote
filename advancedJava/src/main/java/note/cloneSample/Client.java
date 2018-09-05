package com.ecvlearning.javaee.cloneSample;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        TradeVO tv = new TradeVO();
        tv.setPrice(100);
        tv.setTicker("IBM");
        List<String> list = new ArrayList<>();
        list.add("Butterfly");
        list.add("Longshort");
        tv.setStrategy(list);

        tv.print();

        TradeVO tv2 = (TradeVO)tv.clone();
        tv2.print();


        List<String> strategy1 = tv.getStrategy();
        strategy1.add("ShortLong");
        tv.setPrice(200);

        tv.print();
        tv2.print();

    }
}
