package com.java.fundamentals.thread.pool;

import com.java.fundamentals.thread.local.ThreadLocalCounter;

import java.util.concurrent.*;

public class ThreadPoolCounter {

    private void newSingleThreadExecutor(int totalThread) {

        System.out.println("### Executors.newSingleThreadExecutor");

        ThreadLocalCounter thread = new ThreadLocalCounter();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < totalThread; i++) {
            executorService.execute(thread);
        }
        executorService.shutdown();
    }
    private void newFixedThreadPool(int totalThread, int poolLimit) {

        System.out.println("### Executors.newFixedThreadPool");

        ThreadLocalCounter thread = new ThreadLocalCounter();

        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(poolLimit);
        for (int i = 0; i < totalThread; i++) {
            executorService.submit(thread);
            System.out.println("Thread pool size: " + executorService.getPoolSize());
            System.out.println("Task Count: " + executorService.getTaskCount());
        }
        executorService.shutdown();
    }

    private void newScheduledThreadPool(int totalThread, int poolSize) {

        System.out.println("### Executors.newScheduledThreadPool");

        ThreadLocalCounter thread = new ThreadLocalCounter();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(poolSize);
        for (int i = 0; i < totalThread; i++) {
            executorService.schedule(thread, 0, TimeUnit.MILLISECONDS);
        }
        executorService.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        int totalThread = 10;
        int poolLimit = 3;

        ThreadPoolCounter threadPoolCounter = new ThreadPoolCounter();
        threadPoolCounter.newSingleThreadExecutor(totalThread);
        threadPoolCounter.newFixedThreadPool(totalThread, poolLimit);
        threadPoolCounter.newScheduledThreadPool(totalThread, poolLimit);

    }

}
