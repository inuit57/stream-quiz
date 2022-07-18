package com.mangkyu.stream.Quiz5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz5 {

    private static final String[] STRING_ARR = {"aaa", "bb", "c", "dddd"};

    public int quiz1() {
        return Arrays.stream(STRING_ARR)
                .collect(Collectors.joining())
                .length();
    }

    public int quiz2() {
        return Arrays.stream(STRING_ARR)
                .map(String::length)
                .reduce(Integer::max)
                .orElse(-1);
    }

    public List<Integer> quiz3() {
        return Collections.emptyList();
    }

    public List<Integer[]> quiz4() {
        return Collections.emptyList();
    }

}
