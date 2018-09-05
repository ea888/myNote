package com.ecvlearning.javaee.lambda;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredicateConsumerExample {

    public static void main(String[] args){
//        Trade t = new Trade();

        //Supplier instance with lambda expression
        Supplier<Trade> s = () -> new Trade();
        Trade t = new Trade(); //s.get();

        //Supplier instance using method reference to default constructor
//        Supplier<Trade> s2 = Trade::new;
//        t = s2.get();

        t.setPrice(6);
        t.setTicker("IBM");

        Predicate<Trade> p = (trade) -> trade.price < 10 || trade.price > 50;
        Predicate<Trade> p2 = (trade) -> trade.price < 5 || trade.price > 60;
        if(p.or(p2).test(t)){
            Consumer<Trade> c = trade -> {trade.trade("Buy"); trade.trade("Sell");};
            c.accept(t);
        }

        PredicateConsumerExample pce = new PredicateConsumerExample();
        pce.doTrade(p,trade -> {trade.trade("Buy"); trade.trade("Sell");}, t);

    }

    public void doTrade(Predicate<Trade> p, Consumer<Trade> c, Trade t){
        if(p.test(t)){
            c.accept(t);
        }
    }
}
