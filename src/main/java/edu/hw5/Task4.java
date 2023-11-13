package edu.hw5;

import java.util.regex.Pattern;

public class Task4 {
    static Pattern pattern = Pattern.compile("[~!@#$%^&*|]+");

    static boolean checkThePassword(String password) {
        return pattern.matcher(password).matches();
    }
}
