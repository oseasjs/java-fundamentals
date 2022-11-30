package com.java.fundamentals.thread.local;

import com.java.fundamentals.commons.User;

import java.util.ArrayList;
import java.util.List;

public class ThreadLocalWithUser implements Runnable {

    private ThreadLocal<User> userThreadLocal = new ThreadLocal<>();
    private Long userId;

    public ThreadLocalWithUser(Long userId) {
        this.userId = userId;
    }

    @Override
    public void run() {
        userThreadLocal.set(new User(userId, "User " + userId));
        System.out.println("ThreadLocalWithUser - User name: " + userThreadLocal.get().getName());
    }

    public static void main(String[] args) {
        int maxThreads = 10;
        boolean enableJoin = true;

        ThreadLocalWithUser first = new ThreadLocalWithUser(1l);
        ThreadLocalWithUser second = new ThreadLocalWithUser(2l);

        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < maxThreads; i++) {
            list.add(i % 2 == 0 ? new Thread(first) : new Thread(second));
        }

        list.forEach(t -> {
            t.start();
            if (enableJoin) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }
}
