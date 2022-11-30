package com.java.fundamentals.thread.simple;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimpleThread {

    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
            return input * input;
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SimpleThread simpleThread = new SimpleThread();
        Future<Integer> result = simpleThread.calculate(10);

        while (!result.isDone()) {
            System.out.println("Calculating....");
            Thread.sleep(2000);
        }
        System.out.println("Result: " + result.get());
    }

}
