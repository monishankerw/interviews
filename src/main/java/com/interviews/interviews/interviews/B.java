package com.interviews.interviews.interviews;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class B {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(1, 2, 1, 3, 4, 6, 7, 9, 7, 5);
        String[] str= new String[]{"moni Shanker"};
        List<Integer> result = num.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        System.out.println("remove duplicate and show in reverse order"+result);

        List<String> list = Arrays.stream(str).distinct().sorted(Comparator.reverseOrder()).toList();
        System.out.println(list);

    }
}
