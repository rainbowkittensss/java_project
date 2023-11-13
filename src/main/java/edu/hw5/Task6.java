package edu.hw5;

import java.util.regex.Pattern;

public class Task6 {
    static Pattern pattern;

    boolean checkThePassword(String subsequence, String string) {
        StringBuilder patternString = new StringBuilder("*");
        for (char symbol
            : subsequence.toCharArray()) {
            patternString.append(symbol).append("*");
        }
        pattern = Pattern.compile(patternString.toString());
        return pattern.matcher(string).matches();
    }
}
