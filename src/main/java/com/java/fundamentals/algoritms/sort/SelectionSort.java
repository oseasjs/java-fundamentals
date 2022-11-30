package com.java.fundamentals.algoritms.sort;

import java.util.Arrays;

public class SelectionSort {

    public void sort(int[] arr) {
        int size = arr.length;
        for (int step = 0; step < size-1; step++) {
            int minIdx = step;
            for (int i = step +1; i < size-1; i++) {
                if (arr[i] < arr[minIdx]) {
                    minIdx = i;
                }
            }
            int tmp = arr[step];
            arr[step] = arr[minIdx];
            arr[minIdx] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] values = new int[]{-3, 5, 7, 2, -9, 9};
        new SelectionSort().sort(values);
        int[] expected = new int[]{-9, -3, 2, 5, 7, 9};

        if (!Arrays.toString(values).equals(Arrays.toString(expected)))
            throw new RuntimeException(String.format("Invalid result. Expected %s, but found %s",
                Arrays.toString(expected), Arrays.toString(values)));
    }

}
