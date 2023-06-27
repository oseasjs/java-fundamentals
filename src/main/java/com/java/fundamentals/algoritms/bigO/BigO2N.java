package com.java.fundamentals.algoritms.bigO;

/**
 * O(2^n) - O(my)
 *
 * An example of an O(2n) function is the recursive calculation of Fibonacci numbers.
 * O(2n) denotes an algorithm whose growth doubles with each addition to the input data set.
 * The growth curve of an O(2n) function is exponential - starting off very shallow, then rising meteorically.
 *
 * Ex.: Fibonacci
 */
public class BigO2N {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Fibonacci: " + fibonacci(i));
            System.out.println("Fibonacci Recursive: " + fibonacciRecursive(i));
        }
    }

    private static int fibonacci(int num) {
        int current = 0;
        int before = 0;

        for (int i = 0; i <= num; i++) {
            if (i == 1) {
                current = 1;
                before = 0;
            }
            else {
                current += before;
                before = current - before;
            }
        }

        return current;

    }
    private static int fibonacciRecursive(int num) {
        if (num < 2) {
            return num;
        }
        else {
            return fibonacciRecursive(num -1) + fibonacciRecursive(num -2);
        }
    }
}
