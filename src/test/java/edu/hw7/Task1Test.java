package edu.hw7;

import org.assertj.core.api.AtomicIntegerAssert;
import org.assertj.core.api.CompletableFutureAssert;
import org.junit.jupiter.api.Test;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.function.Supplier;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static edu.hw7.Task1.*;

public class Task1Test {
    @Test
    void Test1() {
        int threadsNum = 3;
        AtomicIntegerAssert assrt = new AtomicIntegerAssert(counter);
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> lotOfTreads(threadsNum));
        CompletableFuture<Boolean> check = CompletableFuture.supplyAsync(() -> {
            if (threads != null &&
                (!threads.isEmpty() && threads.get(0).isAlive() || threads.size() > 1 && threads.get(1).isAlive() ||
                    threads.size() > 2 && threads.get(2).isAlive())) {
                assrt.hasValueLessThan(3);
            }
            if (threads != null && !threads.isEmpty() && !threads.get(0).isAlive() && threads.size() > 1 &&
                !threads.get(1).isAlive()
                && threads.size() > 2 && !threads.get(2).isAlive()) {
                assrt.hasValue(3);
            }
            return true;
        });
        check.join();
        check = CompletableFuture.supplyAsync(() -> {
            if (threads != null &&
                (!threads.isEmpty() && threads.get(0).isAlive() || threads.size() > 1 && threads.get(1).isAlive() ||
                    threads.size() > 2 && threads.get(2).isAlive())) {
                assrt.hasValueLessThan(3);
            }
            if (threads != null && !threads.get(0).isAlive() && !threads.get(1).isAlive() &&
                !threads.get(2).isAlive()) {
                assrt.hasValue(3);
            }
            return true;
        });
        check.join();
        assertThat(future.join()).isEqualTo(threadsNum);
    }
}
