package edu.hw1;

import java.util.Arrays;

public class Task6 {

    private Task6() {
    }

    static char[] maxNumberStr;
    static char[] minNumberStr;
    static final int FINAL_VALUE = 6174;
    static final int MIN = 1000;
    static final int MAX = 10000;
    static final int LENGTH_OF_NUMBER = 4;
    static final int FACTOR = 10;

    static int countKIterations(int number) {
        if (number == FINAL_VALUE) {
            return 0;
        }
        minNumberStr = String.valueOf(number).toCharArray();
        if (minNumberStr.length < LENGTH_OF_NUMBER) {
            minNumberStr =
                String.valueOf(number * (int) Math.pow(FACTOR, LENGTH_OF_NUMBER - minNumberStr.length)).toCharArray();
        }
        Arrays.sort(minNumberStr);
        maxNumberStr = new StringBuilder(String.valueOf(minNumberStr)).reverse().toString().toCharArray();
        return countKIterations(Integer.parseInt(String.valueOf(maxNumberStr))
            - Integer.parseInt(String.valueOf(minNumberStr))) + 1;
    }

    static int countK(int number) { //task_6
        if (number <= MIN || number >= MAX) {
            return -1;
        }
        minNumberStr = String.valueOf(number).toCharArray();
        if (minNumberStr[0] == minNumberStr[1]
            && minNumberStr[0] == minNumberStr[2]
            && minNumberStr[0] == minNumberStr[LENGTH_OF_NUMBER - 1]) {
            return -1;
        }
        return countKIterations(number);
    }

}
