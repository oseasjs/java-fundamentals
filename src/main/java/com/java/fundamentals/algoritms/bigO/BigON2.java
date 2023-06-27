package com.java.fundamentals.algoritms.bigO;

/**
 * O(n^2) - O(my)
 *
 * Here we're nesting two loops.
 * If our array has n items, our outer loop runs n times and our inner loop runs n times for each iteration of the outer loop, giving us n2 total prints.
 * Thus this function runs in O(n2) time (or "quadratic time").
 * If the array has 10 items, we have to print 100 times. If it has 1000 items, we have to print 1000000 times.
 *
 * Ex.: nesting 2 loops, Selection Sort
 */
public class BigON2 {
    public static void main(String[] args) {
        printAllPossiblePairs(new int[]{0, 1, 2, 3, 4, 5});
    }

    private static void printAllPossiblePairs(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.println("Pair: " + nums[i] + "|" + nums[j]);
            }
        }
    }
}
