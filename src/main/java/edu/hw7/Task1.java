package edu.hw7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class Task1 {
    static AtomicInteger counter = new AtomicInteger(0);
    static final Logger logger = Logger.getLogger("logger");
    public static List<Thread> threads = null;

    static public int lotOfTreads(int numberOfThreads) {
        threads = new ArrayList<>(numberOfThreads);
        for (int i = 0; i < numberOfThreads; ++i) {
            threads.add(new Thread(() -> {
                counter.getAndIncrement();

            }, String.valueOf(i)));
            threads.get(i).start();
        }
        for (Thread thread
            : threads) {
            try {
                thread.join();
            } catch (InterruptedException exc) {
                logger.info("One of threads interrupted :c");
            }
        }
        return counter.get();
    }
}
