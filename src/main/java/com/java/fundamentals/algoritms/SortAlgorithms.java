package com.java.fundamentals.algoritms;

public class SortAlgorithms {

    public void bubbleSort(int[] arr) {
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

    public void selectionSort(int[] arr) {
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

    public void insertionSort(int[] arr) {
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

}
