package note.multithreading;
import java.util.Scanner;

/**
 * volatile statiscAndInstance tells Java to store the Object in main memory instead of cpu cache which is available throughout all threads
 */
class VolatileSample extends Thread {

    private volatile boolean running = true;

    public void run() {

        while(running) {
            System.out.println("Running");

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}

 class App {

    public static void main(String[] args) {
        VolatileSample pro = new VolatileSample();
        pro.start();

        // Wait for the enter key
        new Scanner(System.in).nextLine();

        pro.shutdown();
    }

}
