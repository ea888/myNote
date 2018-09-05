package com.ecvlearning.javaee.designPattern.cor;

public class Chain2 implements Chain{

    Chain chain;
    @Override
    public void setNextChain(Chain c) {
        this.chain = c;
    }

    @Override
    public void run() {
        System.out.println("Chain2 is running...");
        //busines logic
    }
}
