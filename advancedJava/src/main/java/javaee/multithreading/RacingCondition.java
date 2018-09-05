package com.ecvlearning.javaee.multithreading;

public class RacingCondition implements Runnable {
    private int balance = 0;
    Object lock = new Object();

    public int getBalance() {
        return balance;
    }

    @Override
    public void run() {
        for(int i= 0 ; i<1000000000; i++){
            debit();
        }
    }

    private void debit(){
        synchronized(lock){
            this.balance++;
        }
    }
}
