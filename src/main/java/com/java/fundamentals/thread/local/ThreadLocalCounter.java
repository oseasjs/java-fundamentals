package com.java.fundamentals.thread.local;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ThreadLocalCounter implements Runnable {

    private int counter = 1;
    private AtomicInteger counterAtomic = new AtomicInteger(1);
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    @Override
    public void run() {

        if (threadLocal.get() != null) {
            threadLocal.set(threadLocal.get().intValue() + 1);
        }
        else {
            threadLocal.set(0);
        }

        StringBuffer textBuffer = new StringBuffer();
        textBuffer.append("Thread Name: " + Thread.currentThread().getName());
        textBuffer.append(" | ");
        textBuffer.append("TD: " + LocalDateTime.now());
        textBuffer.append(" | ");
        textBuffer.append("counter: " + counter++);
        textBuffer.append(" | ");
        textBuffer.append("AtomicInteger: " + counterAtomic.incrementAndGet());
        textBuffer.append(" | ");
        textBuffer.append("ThreadLocal<Integer>: " + threadLocal.get());

        System.out.println(textBuffer);

    }

    public static void main(String[] args) {

        int totalThread = 9;
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
