package com.java.fundamentals.algoritms.bigO;

/**
 * O(1) - O(yeah)
 *
 * Better scenario.
 * There is no growing because it does not depend on the input volume
 *
 * This function runs in O(1) time (or "constant time") relative to its input.
 * The input array could be 1 item or 1,000 items, but this function would still just require one step.
 *
 * Ex.: Simple function or getting specific element from an array by index
 */
public class BigO1 {

    public static void main(String[] args) {

        System.out.println("isEven? " + isEven(3));
        System.out.println("FirstElementFromArray: " + printFirstElementFromArray(new int[]{1, 2, 3, 4, 5}));

    }

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }

    private static int printFirstElementFromArray(int[] nums) {
        return nums[0];
    }

}
