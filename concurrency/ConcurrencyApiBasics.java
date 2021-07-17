package concurrency;

import java.util.concurrent.*;

public class ConcurrencyApiBasics {
    public static void main(String[] args) {
        ExecutorService service = null;
        Runnable task1 = () -> System.out.println("Printing zoo inventory");
        Runnable task2 = () -> {
            for (int i = 0; i < 3; i++)
                System.out.println("Printing record: " + i);
        };
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            service.execute(task1);
            service.execute(task2);
            Future<Integer> aa = service.submit(() -> 77);
            System.out.println("end");
        } finally {
            if (service != null) service.shutdown();
        }
    }
}