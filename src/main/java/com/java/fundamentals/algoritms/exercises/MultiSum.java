package com.java.fundamentals.algoritms.exercises;

import java.util.Arrays;

public class MultiSum {

    private int simpleSum(int[] values) {
        return Arrays.stream(values).sum();
    }

    private String simpleSum(String[] values) {
        return Arrays.stream(values).reduce((s, s2) -> s + s2).get();
    }

    private int sum(int[] values) {
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            result += values[i];
        }
        return result;
    }

    private String sum(String[] values) {
        String result = "";
        for (int i = 0; i < values.length; i++) {
            result += values[i];
        }
        return result;
    }

    private Object objectSum(Object[] values) {
        Object result = (values instanceof String[]) ? "" : 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] instanceof String) {
                result += values[i].toString();
            }
            else {
                result = (Integer.valueOf(result.toString()) + Integer.valueOf(values[i].toString()));
            }
        }
        return result;
    }

    public static void main(String[] args) {

        MultiSum ms = new MultiSum();
        System.out.println("Simple Sum int: " + ms.simpleSum(new int[]{1, 2, 3, 4, 5}));
        System.out.println("Simple Sum String: " + ms.simpleSum(new String[]{"a", "b", "c"}));

        System.out.println("Sum int: " + ms.sum(new int[]{1, 2, 3, 4, 5}));
        System.out.println("Sum String: " + ms.sum(new String[]{"a", "b", "c"}));

        System.out.println("Object Sum Integer: " + ms.objectSum(new Integer[]{1, 2, 3, 4, 5}));
        System.out.println("Object Sum String: " + ms.objectSum(new String[]{"a", "b", "c"}));

    }
}
