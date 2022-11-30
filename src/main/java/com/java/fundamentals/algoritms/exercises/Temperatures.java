package com.java.fundamentals.algoritms.exercises;

import java.util.Arrays;

public class Temperatures {

    public int[] minMax(int[] temperatures) {

        int min = temperatures[0];
        int max = temperatures[0];

        for (int i = 0; i < temperatures.length; i++) {

            if (min > temperatures[i])
                min = temperatures[i];

            if (max < temperatures[i])
                max = temperatures[i];

        }

        return new int[] {min, max};

    }

    public static void main(String[] args) {
        Temperatures temperature = new Temperatures();
        int[] minMax = temperature.minMax(new int[]{6, -9, 0, 3, -5});
        System.out.println("Min Max Temperatures: " + Arrays.toString(minMax));
    }

}
