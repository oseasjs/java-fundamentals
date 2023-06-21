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

    /**
     * Time Complexities:
     *
     *     Worst Case Complexity: O(n2)
     *     If we want to sort in ascending order and the array is in descending order then, the worst case occurs.
     *     Best Case Complexity: O(n2)
     *     It occurs when the array is already sorted
     *     Average Case Complexity: O(n2)
     *     It occurs when the elements of the array are in jumbled order (neither ascending nor descending).
     *
     *     The time complexity of the selection sort is the same in all cases. At every step, you have to find the minimum element and put it in the right place. The minimum element is not known until the end of the array is not reached.
     *
     * Space Complexity:
     *
     *     Space complexity is O(1) because an extra variable temp is used.
     * @param args
     */
    public static void main(String[] args) {
        int[] values = new int[]{-3, 5, 7, 2, -9, 9};
        new SelectionSort().sort(values);
        int[] expected = new int[]{-9, -3, 2, 5, 7, 9};

        if (!Arrays.toString(values).equals(Arrays.toString(expected)))
            throw new RuntimeException(String.format("Invalid result. Expected %s, but found %s",
                Arrays.toString(expected), Arrays.toString(values)));
    }

}
