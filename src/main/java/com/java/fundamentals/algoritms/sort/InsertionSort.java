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

    /**
     * Time Complexities
     *
     *     Worst Case Complexity: O(n2)
     *     Suppose, an array is in ascending order, and you want to sort it in descending order. In this case, worst case complexity occurs.
     *     Each element has to be compared with each of the other elements so, for every nth element, (n-1) number of comparisons are made.
     *     Thus, the total number of comparisons = n*(n-1) ~ n2
     *
     *     Best Case Complexity: O(n)
     *     When the array is already sorted, the outer loop runs for n number of times whereas the inner loop does not run at all. So, there are only n number of comparisons. Thus, complexity is linear.
     *
     *     Average Case Complexity: O(n2)
     *     It occurs when the elements of an array are in jumbled order (neither ascending nor descending).
     *
     * Space Complexity
     *
     *     Space complexity is O(1) because an extra variable key is used.
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] values = new int[]{-3, 5, 7, 2, -9, 9};
        new InsertionSort().sort(values);
        int[] expected = new int[]{-9, -3, 2, 5, 7, 9};

        if (!Arrays.toString(values).equals(Arrays.toString(expected)))
            throw new RuntimeException(String.format("Invalid result. Expected %s, but found %s",
                Arrays.toString(expected), Arrays.toString(values)));
    }

}
