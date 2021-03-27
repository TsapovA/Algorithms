package alg.other;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Task from Yandex. Create custom variant of Java Atomic incrementAndGet.
 */
public class AtomicCustomIncrementAndGet {

    private static final int incrementAndGet() {
        while(true) {
            int current = get();
            int next = current + 1;             // Only difference
            if (compareAndSet(current, next))
                return next;
        }
    }

    // mock implementation
    private static boolean compareAndSet(int current, int next) {
        return true;
    }

    // mock implementation
    private static int get() {
        return ThreadLocalRandom.current().nextInt();
    }


}
