package com.ecvlearning.javaee.lambda;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample {
    public static void main(String args[]){
        FunctionalIF fi = (s) -> {System.out.println(s);};
        fi.print("I'm the functional interface");


        ExecutorService exec = Executors.newCachedThreadPool();

        //lambda callable
        String a = "abc";
        Callable<String> c = () -> {Thread.sleep(1000);return a.substring(1);};

        Callable<String> cc = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return a.substring(1);
            }
        };

        try {
            System.out.println(exec.submit(c).get());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Runnable r = () -> {System.out.println("I'm a thread!");};
        Runnable rr = new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm a thread!");
            }
        };

        r.run();
        rr.run();
    }
}
