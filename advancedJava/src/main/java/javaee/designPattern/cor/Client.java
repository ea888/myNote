package com.ecvlearning.javaee.designPattern.cor;

public class Client {
    public static void main(String[] args){
        Chain chain1 = new Chain1();
        Chain chain2 = new Chain2();
        chain1.setNextChain(chain2);
//        chain2.setNextChain(chain3);
        chain1.run();
    }
}
