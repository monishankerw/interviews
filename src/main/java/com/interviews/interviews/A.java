package com.interviews.interviews;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class A {

    public static void main(String[] args) {
        String arr="monishanker";
        String [] arr1=arr.split("");
        List<String> collect = Arrays.stream(arr1).distinct().collect(Collectors.toList());


        System.out.println(collect);


    }
}


