package concurrency;
import java.util.concurrent.Semaphore;

public class Semaphoress {

    public static void main(String[] args) throws InterruptedException {
        Semaphore sem = new Semaphore(1); //the specified number is the number of permits

        sem.release(); //adds permit
        sem.acquire(); //removes permit - will wait if none available

        System.out.println("Available permist: " + sem.availablePermits());
    }
}
