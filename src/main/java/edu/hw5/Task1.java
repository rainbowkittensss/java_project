package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Task1 {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
    private static final int MAXLEN = 10;
    static String[] startAndEndTimes = new String[MAXLEN];
    static LocalDateTime startTime;
    static LocalDateTime endTime;
    static Duration duration = Duration.ZERO;

    public static String midTime(String[] input) {
        long correctLines = 0;
        for (String line
            : input) {
            startAndEndTimes = line.split(" - ", MAXLEN);
            if (startAndEndTimes.length == 2) {
                correctLines += 1;
                try {
                    startTime = LocalDateTime.parse(startAndEndTimes[0], formatter);
                    endTime = LocalDateTime.parse(startAndEndTimes[1], formatter);
                } catch (DateTimeParseException exc) {
                    continue;
                }
                if (startTime.isBefore(endTime)) {
                    duration = duration.plus(Duration.between(startTime, endTime));
                }
            }
        }
        duration = Duration.ofSeconds(duration.getSeconds() / correctLines);
        StringBuilder ans = new StringBuilder();
        ans.append(duration.toHoursPart()).append("ч ").append(duration.toMinutesPart()).append("м");
        return ans.toString();
    }
}
