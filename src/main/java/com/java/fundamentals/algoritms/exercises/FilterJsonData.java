package com.java.fundamentals.algoritms.exercises;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FilterJsonData {

    final static String jsonData = "\"{data\":\"key=name1, age=49, key=name2, age=51, key=name3, age=48, key=name4, age=52, key=name5, age=53}\"";

    public static String filterByAgeHigherThat(String json, int age) {

        String prefix = "\"{data\":\"";
        String suffix = "\"}";

        String valueWithoutQuotes = json.substring(9).replace("}\"", "");
        String[] values = valueWithoutQuotes.split(", k");

        String val = Arrays
                .stream(values)
                .map(line -> line.startsWith("k") ? line : "k" + line)
                .filter(line -> (Integer.valueOf(line.split("=")[2]) >= age))
                .collect(Collectors.joining(", "));

        return prefix + val + suffix;

    }

    public static void main(String[] args) {

        String jsonFiltered = filterByAgeHigherThat(jsonData, 50);
        System.out.println(jsonFiltered);

    }

}
