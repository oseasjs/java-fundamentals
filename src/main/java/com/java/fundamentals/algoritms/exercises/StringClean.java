package com.java.fundamentals.algoritms.exercises;

import java.util.ArrayList;
import java.util.List;

public class StringClean {

    /**
     Given a string, return recursively a "cleaned" string where adjacent chars that are the same have been reduced to a single char. So "yyzzza" yields "yza".
     stringClean("yyzzza") → "yza"
     stringClean("abbbcdd") → "abcd"
     stringClean("Hello") → "Helo"
     stringClean("I") -> I
     stringClean("")
     */

    private static String stringClean(String text) {
        if (text.length() <= 1)
            return text;
        String firstChar = text.substring(0, 1);
        if (text.substring(1).contains(firstChar))
            return stringClean(text.substring(1));
        else
            return firstChar + stringClean(text.substring(1));
    }

    public static void main(String[] args) {
        List<String> textList = List.of("yyzzza", "abbbcdd", "Hello", "I");

        for (String text: textList) {
            System.out.println(stringClean(text));
        }

    }


}
