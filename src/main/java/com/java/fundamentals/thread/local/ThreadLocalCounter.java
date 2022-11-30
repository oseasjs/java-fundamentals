package com.java.fundamentals.thread.local;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ThreadLocalCounter implements Runnable {

    private int counter = 0;
    private AtomicInteger counterAtomic = new AtomicInteger(0);
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    @Override
    public void run() {

        if (threadLocal.get() != null) {
            threadLocal.set(threadLocal.get().intValue() + 1);
        }
        else {
            threadLocal.set(0);
        }

        System.out.println("ThreadLocal Counter - Thread Name: " + Thread.currentThread().getName() + " | current time: " + LocalDateTime.now());
        System.out.println("ThreadLocal Counter - int: " + counter++);
        System.out.println("ThreadLocal Counter - AtomicInteger: " + counterAtomic.incrementAndGet());
        System.out.println("ThreadLocal Counter - ThreadLocal<Integer>: " + threadLocal.get());

    }

    public static void main(String[] args) {

        int totalThread = 10;
        boolean enableJoin = false;

        Runnable thread = new ThreadLocalCounter();

        Stream
            .generate(() -> new Thread(thread))
            .limit(totalThread)
            .forEach(t -> {
                t.start();
                if (enableJoin) {
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            })
            ;

    }
}
