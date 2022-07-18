package com.mangkyu.stream.Quiz2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Quiz2 {

    private static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    public Map<String, Integer> quiz1() {

        return WORDS.stream()
                .map(word -> word.substring(0,1))
                .collect(Collectors.toMap(prefix->prefix, prefix -> 1, (oldValue,newValue)-> oldValue+=newValue));
    }

    public String quiz2() {

        return WORDS.stream()
                .filter(word -> word.length() >= 2)
                .map(word -> word.toUpperCase().substring(0,1))
                .collect(Collectors.joining(" "));
    }

}
