package lpi.edu.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static lpi.edu.concurrency.ConcurrentUtils.stop;

public class SyncExample {

    private int unsyncCount;
    private int syncCount;
    private AtomicInteger atomicCount = new AtomicInteger(0);

    void increment() {
        unsyncCount = unsyncCount + 1;
    }

    synchronized void syncrement() {
        syncCount = syncCount + 1;
    }

    void atomincrement() {
        atomicCount.incrementAndGet();
    }

    void example() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(
                        () -> {
                            increment();
                            syncrement();
                            atomincrement();
                        }
                ));
        stop(executor);
        //first will be some random number near to but less than 10000, both sync and atomic will be exactly 10k
        System.out.println("Result for unsynchronized: " + unsyncCount + ", synchronized: " + syncCount + " and atomic: " + atomicCount.get());

    }

    public static void main(String[] args) {
        new SyncExample().example();
    }
}
