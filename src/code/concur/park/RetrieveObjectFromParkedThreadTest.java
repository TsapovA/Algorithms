package code.concur.park;

import java.util.concurrent.locks.LockSupport;

public class RetrieveObjectFromParkedThreadTest {

    public static void main(String[] args) throws InterruptedException {
        FifoLock fifoLock = new FifoLock();
        // main thread locks the FIFLock instance so that the spawned
        // thread parks itself when invoking lock()
        fifoLock.lock();
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " about to park itself.");
            fifoLock.lock();
        });
        thread.start();
        // wait for the child thread to get blocked
        Thread.sleep(2000);
        // now retrieve the blocker object associated with the thread
        Object blocker = LockSupport.getBlocker(thread);
        System.out.println(blocker);
        // unlock so spawned thread can make progress
        fifoLock.unlock();
    }
}
