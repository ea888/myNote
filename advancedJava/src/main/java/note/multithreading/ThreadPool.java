package note.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


class ThreadPool implements Runnable {

    private int id;

    public ThreadPool(int id) {
        this.id = id;
    }

    public void run() {
        System.out.println("Starting: " + id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        System.out.println("Completed: " + id);
    }


    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            executor.submit(new ThreadPool(i));
        }

        executor.shutdown();

        System.out.println("All tasks submitted.");

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
        }

        System.out.println("All tasks completed.");
    }
}
