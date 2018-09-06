package note.multithreading;

import java.util.Scanner;

/**
 * low level wait and notify example
 */
public class WaitAndNotify {

    public void produce() throws InterruptedException {
        /**
         * Note that the wait and notify must be called in Synchronized block,
         * and the synchronized blocks must lock on the SAME object
         */
        synchronized (this) {
            System.out.println("Producer thread running ....");
            wait();
            System.out.println("Resumed.");
        }
    }

    public void consume() throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);

        synchronized (this) {
            System.out.println("Waiting for return key.");
            scanner.nextLine();
            System.out.println("Return key pressed.");
            /**
             * notify will not give up lock and resume the waiting thread immediately
             */
            notify();
            Thread.sleep(3000);
            System.out.println("Finish the notify thread");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        final WaitAndNotify waitAndNotify = new WaitAndNotify();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    waitAndNotify.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    waitAndNotify.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
