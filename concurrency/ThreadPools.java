package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Proc implements Runnable {
    private int id;

    public Proc(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Starting " + id);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        System.out.println("Finished " + id);
    }
}

public class ThreadPools {
    public static void main(String[] args) {

        //we recycle threads - no overhead when creating new thread
        ExecutorService exec = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++)
            exec.submit(new Proc(i)); //submit()!!

        exec.shutdown(); //will wait for all the threads to finish
        System.out.println("All tasks submited");

        try {
            exec.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
        }

        System.out.println("All tasks completed.");
    }
}
