package concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable {
    private CountDownLatch latch;  //its a thread-safe class

    public Processor(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        System.out.println("Started");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        latch.countDown();
    }
}

public class CountdownLaches {
    public static void main(String[] args) {

        //it lets threads wait until lach reaches zero
        //one or more threads can count down the lach
        //when its zero those waiting can proceed
        CountDownLatch latch = new CountDownLatch(3);

        ExecutorService exec = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++)
            exec.submit(new Processor(latch)); //you pass the latch in the constructor

        try {
            latch.await();
        } catch (InterruptedException e) {
        }

        System.out.println("Completed");

    }
}
