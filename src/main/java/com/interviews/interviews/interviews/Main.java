package com.interviews.interviews.interviews;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String input = "moni Shanker";

        List<Character> list = input.chars()
            .filter(ch -> ch != ' ') // remove space if needed
            .mapToObj(c -> (char) c)
            .distinct()
            .sorted(Comparator.reverseOrder())
            .toList();

        // Optional: convert List<Character> back to String
        String result = list.stream()
            .map(String::valueOf)
            .reduce("", String::concat);

        System.out.println("Result: " + result);
    }
}