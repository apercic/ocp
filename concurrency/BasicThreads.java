package concurrency;

import java.lang.*;
import java.time.LocalTime;

//public class concurrency.BasicThreads {
//    public static void main(String[] args) {
//        Runnable x = () -> System.out.println("in separate thread helllo");
//        Function s = (q) -> (int)q+1;
//        new Thread(x).start();
//
//        System.out.println("In main method");
//    }
//}

class RunnnRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) System.out.println(i + " ");
    }
}

class RunnnTread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) System.out.println(i + " ");
    }

    @Override
    public void interrupt() {
        System.out.println("an example why you'd extend Thread - override the interrupt() method");
    }
}

public class BasicThreads {
    public static void main(String[] args) {
        //Extends Thread
        RunnnTread rr = new RunnnTread();
        rr.start();

        //Implements Runnable
        Thread xx = new Thread(new RunnnRunnable());
        xx.start();

        //Inline Runnable
        Runnable yy = () -> {
            for (int i = 0; i < 10; i++) System.out.println(i);
        };
        Thread qq = new Thread(yy);
        qq.start();

    }
}