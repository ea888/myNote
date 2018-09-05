package com.ecvlearning.javaee.multithreading;

import java.util.concurrent.*;

public class Client {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Thread me = new MultithreadingExample();
//        me.run();
        me.start();

        System.out.println("I'm the end of the programme.");

        Thread me2 = new Thread(new MultithreadingExample2());
        me2.start();
        System.out.println("I'm the end of the programme2.");


        RacingCondition rc = new RacingCondition();
        Thread company1 = new Thread(rc);
        Thread company2 = new Thread(rc);
        company1.start();
        company2.start();


        company1.join();
        company2.join();
        System.out.println(rc.getBalance());







        //Synchronize
//        Runnable userRequest = new UserRequest(true);
//        Thread userRequestThread = new Thread(userRequest);
//        Thread userRequestThread2 = new Thread(userRequest);
//        userRequestThread.start();
//        userRequestThread2.start();
//
//        userRequestThread.join();
//        userRequestThread2.join();
//
//        System.out.println(((UserRequest)userRequest).count);

        //Callable example
//        Callable response = new Response();
//        ExecutorService executor = Executors.newFixedThreadPool(10);
//        Future<String> future = executor.submit(response);
//        System.out.println(future.get());
//        executor.shutdown();

//        //dead lock
//        final DeadLockRunner deadLockRunner = new DeadLockRunner(true);
//
//        Thread t1 = new Thread(new Runnable() {
//            public void run() {
//                try {
//                    deadLockRunner.firstThread();
//                } catch (InterruptedException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        Thread t2 = new Thread(new Runnable() {
//            public void run() {
//                try {
//                    deadLockRunner.secondThread();
//                } catch (InterruptedException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
//
//        deadLockRunner.finished();
    }

}

