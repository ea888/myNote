package note.multithreading;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * The interrupt is just a flag
 * This flag will be check whenever checked exception "InterruptionException" is required
 * hence throw exception and terminate the tread.
 */
public class InterruptedSample {

    public static void main(String[] args) throws InterruptedException {

        /**
         * executor example, a normal thread example follows.
         */
        System.out.println("Starting.");

        ExecutorService exec = Executors.newCachedThreadPool();

        Future<?> fu = exec.submit((Callable<Void>) () -> {
            Random ran = new Random();

            for (int i = 0; i < 1E8; i++) {

                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Interrupted!");
                    break;
                }

                Math.sin(ran.nextDouble());
            }
            return null;
        });

        //This one will wait for all threads finishes
        exec.shutdown();


        Thread.sleep(500);

        //Set the interrupt flag to true
        exec.shutdownNow();
        //Set the interrupt flag to true
        //fu.cancel(true);

        exec.awaitTermination(1, TimeUnit.DAYS);

        System.out.println("Finished.");


        /**
         * normal thread example
         */
        System.out.println("Another example");
        Runnable r = () -> {
            Random ran = new Random();

            for (int i = 0; i < 1E8; i++) {

                /**
                 * This line throws checked Exception "InterruptedException"
                 * So this exception will be triggered if the interrupted flag is true.
                 */
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                if (Thread.currentThread().isInterrupted()) {
//                    System.out.println("Interrupted!");
//                    break;
//                }

                Math.sin(ran.nextDouble());
            }
        };

        Thread t2 = new Thread(r);
        t2.start();
        Thread.sleep(1000);
        t2.interrupt();
        t2.join();
        System.out.println("Completed!");
    }

}
