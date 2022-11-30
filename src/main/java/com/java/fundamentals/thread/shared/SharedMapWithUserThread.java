package com.java.fundamentals.thread.shared;

import com.java.fundamentals.commons.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SharedMapWithUserThread implements Runnable {

    public static Map<Long, User> userConcurrentMap = new ConcurrentHashMap<>();
    private Long userId;

    public SharedMapWithUserThread(Long userId) {
        this.userId = userId;
    }

    @Override
    public void run() {
        userConcurrentMap.put(userId, new User(userId, "User " + userId));
        System.out.println("SharedMapWithUser - User name: " + SharedMapWithUserThread.userConcurrentMap.get(userId).getName());
    }

    public static void main(String[] args) {

        int maxThreads = 10;
        boolean enableJoin = true;

        SharedMapWithUserThread first = new SharedMapWithUserThread(1l);
        SharedMapWithUserThread second = new SharedMapWithUserThread(2l);

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
