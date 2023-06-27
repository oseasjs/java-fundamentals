package com.java.fundamentals.algoritms.exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.stream.Collectors;

public class FilterJsonData {

    private static String filterByAgeGraterThanEquals(String json, int age) {

        String jsonFiltered = Arrays.stream(json.substring(9, json.length() -2).split(", k"))
                .filter(item -> Integer.valueOf(item.split("age=") [1]) >= age)
                .map(item -> item.startsWith("k") ? item : "k" + item)
                .collect(Collectors.joining(", "));

        return json.substring(0, 9)
                .concat(jsonFiltered)
                .concat(json.substring(json.length() -2));
    }

    public static void main(String[] args) {

        final String jsonData = "{\"data\":\"key=name1, age=49, key=name2, age=51, key=name3, age=48, key=name4, age=52, key=name5, age=53\"}";
        System.out.println(jsonData);
        String jsonFiltered = filterByAgeGraterThanEquals(jsonData, 50);
        System.out.println(jsonFiltered);

    }

}