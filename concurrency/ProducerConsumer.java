package concurrency;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumer {

    private static ArrayBlockingQueue<Integer> que = new ArrayBlockingQueue<>(10); //must give it max size
    public static void main(String[] args) {
         Thread t1 = new Thread(() -> {
             try {
                 producer();
             } catch (InterruptedException e) {
             }
         });

         Thread t2 = new Thread(() -> {
             try {
                 consumer();
             } catch (InterruptedException e) {
             }
         });

         t1.start();
         t2.start();
    }
    private static void producer() throws InterruptedException {
        Random rand = new Random();
        while(true) {
            que.put(rand.nextInt(100)); //because size of que is 10 - it waits for something to be removed
        }
    }

    private static void consumer() throws InterruptedException {
        Random rand = new Random();
        while(true) {
            Thread.sleep(100);

            if (rand.nextInt(10) == 0) {
                Integer value = que.take(); //if que is empty it waits for something to be added to it

                System.out.println("Taken value " + value + " que size is " + que.size());
            }
        }
    }
}
