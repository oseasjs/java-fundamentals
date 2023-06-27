package com.java.fundamentals.algoritms.bigO;

/**
 * O(n) - O(ok)
 *
 * The growing operations number is directly related to the number of items.
 *
 * This function runs in O(n) time (or "linear time"), where n is the number of items in the array.
 * If the array has 10 items, we have to print 10 times. If it has 1000 items, we have to print 1000 times.
 *
 * Ex.: print all numbers from an array
 */
public class BigON {

    public static void main(String[] args) {
        print(new int[] {0, 1, 2, 3, 4, 5});
    }

    private static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i);
        }
    }

}
