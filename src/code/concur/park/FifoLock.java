package code.concur.park;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public class FifoLock {

    private ConcurrentLinkedQueue<Thread> queue = new ConcurrentLinkedQueue<>();
    private AtomicBoolean locked = new AtomicBoolean(false);

    /**
     * Enqueue the current thread in the list of threads waiting to acquire the lock.
     * We'll use compare and set method to change the status of the FIFOLock to locked. Also, if the thread wakes up
     * from the park call we check for the predicate, that is the lock is available for acquiring and also whether
     * the woken-up thread is at the head of the queue. Note, that park() method can experience spurious wake-ups
     */
    public void lock() {
        queue.add(Thread.currentThread());
        while (queue.peek() != Thread.currentThread()
            || !locked.compareAndSet(false, true))
        {
            LockSupport.park(this);
        } // remove the head of the queue
        queue.remove();
    }

    /**
     * set the lock to false. Unpark the head of the queue
     */
    public void unlock() {
        locked.set(false);
        LockSupport.unpark(queue.peek());
    }
}
