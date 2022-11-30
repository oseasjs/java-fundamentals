package com.java.fundamentals.algoritms.exercises;

import java.util.Arrays;

public class StairCase {

    private String repeatValue(int start, int end, String value) {
        String result = "";
        for (int n = start; n < end; n++) {
            result += value;
        }
        return result;
    }
    public String generate(int num, boolean invert) {

        String value = "";

        for (int i = 1; i <= num; i++) {

            if (invert)
                value += repeatValue(0, num-i, " ");

            value += repeatValue(0, i, "#");

            if (i < num)
                value += "\n";

        }

        return value;

    }

    public static void main(String[] args) {
        StairCase stairCase = new StairCase();
        System.out.println(stairCase.generate(7, false));
        System.out.println(stairCase.generate(7, true));
    }

}
