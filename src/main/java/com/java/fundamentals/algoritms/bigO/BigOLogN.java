package com.java.fundamentals.algoritms.bigO;

/**
 * O(log n) - O(nice)
 *
 * The growing operation number is shorter than the number of repetitions.
 * This function runs in O(log n) time (or "logarithm"), where n is the number of items in the array.
 *
 * Ex.: Binary Search
 */
public class BigOLogN {

    public static void main(String[] args) {
        System.out.println("Binary Search for number 5: " + binarySearch(new int[] {0, 1, 2, 3, 4, 5}, 6));
    }

    private static int binarySearch(int[] sortedNums, int target) {

        if (sortedNums == null) {
            throw new IllegalArgumentException("Invalid sortedNums content");
        }

        if (sortedNums[0] > target) {
            return -1;
        }

        if (target > sortedNums[sortedNums.length -1]) {
            return -1;
        }

        int upperBound = sortedNums.length;
        int lowerBound = 0;

        while (lowerBound < upperBound) {

            int mid = (upperBound + lowerBound) / 2;
            if (sortedNums[mid] < target) {
                lowerBound = mid;
            }
            else if (sortedNums[mid] > target) {
                upperBound = mid;
            }
            else {
                return mid;
            }

        }

        return -1;

    }

}
