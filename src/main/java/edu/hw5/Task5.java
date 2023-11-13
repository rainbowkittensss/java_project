package edu.hw5;

import java.util.regex.Pattern;

public class Task5 {
    static Pattern pattern = Pattern.compile("^[А-Я]\\d{3}[А-Я]{2}\\d{3}$");

    boolean checkThePassword(String number) {
        return pattern.matcher(number).matches();
    }
}
