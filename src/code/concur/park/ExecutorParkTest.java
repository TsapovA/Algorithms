package code.concur.park;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ExecutorParkTest {

    public static void main(String args[]) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        FifoLock fifoLock = new FifoLock();
        try {
            for (int i = 0; i < 5; i++) {
                executorService.submit(() -> {
                    for (int j = 0; j < 10; j++) {
                        fifoLock.lock();
                        System.out.println(Thread.currentThread().getName() + " acquires the lock.");
                        // simulate work by sleeping
                        try {
                            Thread.sleep(ThreadLocalRandom.current().nextInt(20));
                        } catch (InterruptedException ex) {
                            // ignore
                        }
                        fifoLock.unlock();
                    }
                });
            }
        } finally {
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        }
        System.out.println("Main thread exiting successfully");
    }
}
