package com.java.fundamentals.algoritms;

public class SearchAlgorithms {

    public int binarySearch(int[] arr, int value, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == value)
                return mid;
            if (arr[mid] < value)
                low = mid +1;
            else
                high = mid -1;
        }
        return -1;
    }

    public int binaryRecursiveRecursive(int[] arr, int value, int low, int high) {
        if (high > low) {
            int mid = low + (high - low) /2;
            if (arr[mid] == value)
                return mid;
            if (arr[mid] > value)
                return binaryRecursiveRecursive(arr, value, low, mid -1);
            else
                return binaryRecursiveRecursive(arr, value, mid +1, high);
        }
        return -1;
    }

    public int linearSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length -1; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

}
