package com.ecvlearning.javaee.multithreading;


public class DeadLockRunner {
    private Account acc1 = new Account();
    private Account acc2 = new Account();

    boolean deadLock = false;

    public DeadLockRunner(boolean deadLock) {
        this.deadLock = deadLock;
    }


    public void firstThread() throws InterruptedException {
        for (int i = 0; i < 1000000; i++) {
            if(this.deadLock) {
                Account.transferDeadLock(acc1, acc2, 1);
            }else{
                Account.transfer(acc1, acc2, 1);
            }
        }
    }

    public void secondThread() throws InterruptedException {
        for (int i = 0; i < 1000000; i++) {
            if(this.deadLock) {
                Account.transferDeadLock(acc2, acc1, 2);
            }else{
                Account.transfer(acc2, acc1, 2);
            }
        }
    }

    public void finished() {
        System.out.println("Account 1 balance: " + acc1.getBalance());
        System.out.println("Account 2 balance: " + acc2.getBalance());
        System.out.println("Total balance: "
                + (acc1.getBalance() + acc2.getBalance()));
    }
}


