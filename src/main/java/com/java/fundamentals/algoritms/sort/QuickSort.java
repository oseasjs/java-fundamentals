package com.java.fundamentals.algoritms.sort;

import java.util.Arrays;

public class QuickSort {

    private static int partition(int[] data, int low, int high) {

        // get the most high element on array
        int pivot = data[high];

        // grater element
        int i = low -1;

        // go through all elements comparing each element with the pivot
        for (int j = low; j < high; j++) {

            if (data[j] <= pivot) {

                // if element is smaller than pivot is found
                i++;

                // swapping element at i with element at j
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;

            }

        }

        // swap the pivot element with the greater element specified in i
        int temp = data[i+1];
        data[i+1] = data[high];
        data[high] = temp;

        // return the position where the partition is done
        return i+1;


    }

    /**
     * 1. Worst Case Complexity [Big-O]: O(n2)
     *       It occurs when the pivot element picked is either the greatest or the smallest element.
     *       This condition leads to the case in which the pivot element lies in an extreme end of the sorted array. One sub-array is always empty and another sub-array contains n - 1 elements. Thus, quicksort is called only on this sub-array.
     *       However, the quicksort algorithm has better performance for scattered pivots.
     *
     *  2. Best Case Complexity [Big-omega]: O(n*log n)
     *      It occurs when the pivot element is always the middle element or near to the middle element.
     *      Average Case Complexity [Big-theta]: O(n*log n)
     *      It occurs when the above conditions do not occur.
     *
     *  3. Space Complexity
     *      The space complexity for quicksort is O(log n).
     * @param data
     * @param low
     * @param high
     */
    public static void quickSort(int[] data, int low, int high) {

        if (low < high) {

            // find the pivot
            int pivot = partition(data, low, high);

            // recursive call for the left of pivot
            quickSort(data, low, pivot -1);

            // recursive call for the right of pivot
            quickSort(data, pivot +1, high);

        }

    }

    public static void main(String[] args) {
        int[] data = {8,7,6,1,0,9,2};
        System.out.println("Data unsorted: " + Arrays.toString(data));
        QuickSort.quickSort(data, 0, data.length -1);
        System.out.println("Data sorted: " + Arrays.toString(data));
    }

}
