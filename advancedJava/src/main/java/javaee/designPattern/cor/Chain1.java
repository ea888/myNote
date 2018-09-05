package com.ecvlearning.javaee.designPattern.cor;

public class Chain1 implements Chain{
    Chain chain;

    @Override
    public void setNextChain(Chain c) {
        this.chain = c;
    }

    @Override
    public void run() {
        System.out.println("Chain1 is running....");
        //.....
        //business logic

        this.chain.run();
    }
}
