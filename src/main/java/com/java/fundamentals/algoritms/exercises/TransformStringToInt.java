package com.java.fundamentals.algoritms.exercises;

public class TransformStringToInt {

    private static Integer transform(String value) {
        byte[] values = value.getBytes();
        int size = value.length();
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] < 48 || values[i] > 57) {
                throw new IllegalArgumentException("Value is not convertible to integer");
            }

            int v0 = values[i];
            int v1 = v0 - 48;
            int v2 = size - (i+1);
            double v3 = Math.pow(10, v2);
            double v4 = v1 * v3;
            double v5 = (values[i] - 48) * ( Math.pow(10, size - (i+1)));

            result += v5;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(transform("0123456789"));
    }
}
