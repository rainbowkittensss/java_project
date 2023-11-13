package edu.hw5;

import java.util.regex.Pattern;

public class Task7 {
    static Pattern pattern;
    static Pattern patternAdditional;

    boolean stringThirdIsZero(String string) {
        pattern = Pattern.compile("^\\d{2}0*");
        return pattern.matcher(string).matches();
    }

    boolean firstAndLastIsSame(String string) {
        pattern = Pattern.compile("1*1");
        patternAdditional = Pattern.compile("0*0");
        return pattern.matcher(string).matches() || patternAdditional.matcher(string).matches();
    }

    boolean stringRightLength(String string) {
        pattern = Pattern.compile("\\d{1,3}");
        return pattern.matcher(string).matches();
    }
}
