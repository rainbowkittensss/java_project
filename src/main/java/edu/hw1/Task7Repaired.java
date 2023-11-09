package edu.hw1;

public class Task7Repaired {

    private Task7Repaired() {
    }

    static int rotateLeft(int n, int shift) { //task_7
        if (n < 0 || shift < 0) {
            return -1;
        }
        String binDigits = Integer.toBinaryString(n);
        int finalShift = shift % binDigits.length();
        return Integer.parseInt(binDigits.substring(finalShift).concat(binDigits.substring(0, finalShift)), 2);
    }

    static int rotateRight(int n, int shift) {  //task_7
        if (n < 0 || shift < 0) {
            return -1;
        }
        String binDigits = Integer.toBinaryString(n);
        int finalShift = shift % binDigits.length();
        return Integer.parseInt(binDigits.substring(binDigits.length() - finalShift)
            .concat(binDigits.substring(0, binDigits.length() - finalShift)), 2);
    }
}
