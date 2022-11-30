package com.java.fundamentals.algoritms.sort;

import java.util.Arrays;

public class InsertionSort {

    public void sort(int[] arr) {
        int size = arr.length;
        for (int step = 1; step < size; step++) {
            int key = arr[step];
            int j = step -1;
            while (j >= 0 && key < arr[j]) {
                arr[j +1] = arr[j];
                j--;
            }
            arr[j +1] = key;
        }
    }

    public static void main(String[] args) {
        int[] values = new int[]{-3, 5, 7, 2, -9, 9};
        new InsertionSort().sort(values);
        int[] expected = new int[]{-9, -3, 2, 5, 7, 9};

        if (!Arrays.toString(values).equals(Arrays.toString(expected)))
            throw new RuntimeException(String.format("Invalid result. Expected %s, but found %s",
                Arrays.toString(expected), Arrays.toString(values)));
    }

}
