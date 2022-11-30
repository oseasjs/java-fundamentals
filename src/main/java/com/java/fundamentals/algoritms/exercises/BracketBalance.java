package com.java.fundamentals.algoritms.exercises;

public class BracketBalance {

    public boolean isBalance(String values) {

        while (true) {

            int originalLength = values.length();

            values = values.replace("[]", "");
            values = values.replace("{}", "");
            values = values.replace("()", "");

            int modifiedLength = values.length();

            if (originalLength == modifiedLength) {
                break;
            }

            if (values.length() == 0) {
                return true;
            }

        }

        return values.length() == 0 ? true : false;

    }

    public static void main(String[] args) {
        BracketBalance bb = new BracketBalance();
        System.out.println("isBalanced: " +
            bb.isBalance("{}()") + "\n" +
            bb.isBalance("({()})") + "\n" +
            bb.isBalance("{}(")
        );
    }

}
