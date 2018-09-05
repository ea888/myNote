package com.ecvlearning.javaee.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account {
    private int balance = 100000000;

    static Lock l1 = new ReentrantLock();
    static Lock l2 = new ReentrantLock();


    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transferDeadLock(Account acc1, Account acc2, int amount) throws InterruptedException {
        synchronized (acc1) {
            System.out.println(acc1+" Acc1 lock acquired.");
            acc1.withdraw(amount);
//            Thread.sleep(1);
            synchronized (acc2) {
                System.out.println(acc2+" Acc2 lock acquired.");
                acc2.deposit(amount);
            }
            System.out.println(acc2+" Acc2 lock released.");
        }
        System.out.println(acc1+" Acc1 lock released.");
    }

    public static void transfer(Account acc1, Account acc2, int amount) throws InterruptedException {
        synchronized (acc1) {
            acc1.withdraw(amount);
        }

        synchronized (acc2) {
            acc2.deposit(amount);
        }
    }

    public static void transfer2(Account acc1, Account acc2, int amount) throws InterruptedException {
        l1.lock();
        acc1.withdraw(amount);
        l2.lock();
        acc2.deposit(amount);
        l2.unlock();
        l1.unlock();
    }
}