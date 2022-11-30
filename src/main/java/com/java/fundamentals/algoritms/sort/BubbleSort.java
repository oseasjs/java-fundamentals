package com.java.fundamentals.algoritms.sort;

import java.util.Arrays;

public class BubbleSort {

    public void sort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size -1; i++) {
            for (int j = 0; j < size -i -1; j++) {
                if (arr[j] > arr[j +1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j +1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] values = new int[]{-3, 5, 7, 2, -9, 9};
        new BubbleSort().sort(values);
        int[] expected = new int[]{-9, -3, 2, 5, 7, 9};

        if (!Arrays.toString(values).equals(Arrays.toString(expected)))
            throw new RuntimeException(String.format("Invalid result. Expected %s, but found %s",
                Arrays.toString(expected), Arrays.toString(values)));
    }

}
