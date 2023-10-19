package edu.hw1;

public class Task1 {
    static final int SECONDS = 60;
    static final long MAX_MINUTES = 1000000000000000000L - SECONDS;

    private Task1() {
    }

    static long minutesToSeconds(String inp) { //task_1
        double minutes;
        double seconds;
        if (inp.contains(":")) {
            try {
                minutes = Double.parseDouble(inp.split(":")[0]);
                seconds = Double.parseDouble(inp.split(":")[1]);
            } catch (NumberFormatException | NullPointerException ex) {
                return -1;
            }
            if (seconds == (int) seconds
                && minutes == (long) minutes
                && seconds < SECONDS
                && minutes <= MAX_MINUTES) {
                return (long) (minutes * SECONDS) + (long) (seconds);
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}
