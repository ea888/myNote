package com.ecvlearning.javaee.multithreading;



public class UserRequest implements Runnable{
    int count = 0;
    Object lock = new Object();

    boolean synchrionized = false;

    public UserRequest(boolean sync){
        this.synchrionized = sync;
    }

    @Override
    public void run() {
        //complicated logic
        //heavy calculation

        for(int i =0; i<100000000;i++){
            this.increment();
        }

    }

    private void increment(){
        if(this.synchrionized) {
            synchronized (lock) {
                count++;
            }
        }else {
            count++;
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
