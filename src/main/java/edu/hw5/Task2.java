package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    static final int THE13TH = 13;

    static String[] findFridays13thInYear(int year) {
        List<String> ans = new ArrayList<>();
        LocalDateTime date = LocalDateTime.now();
        for (int i = 1; i < THE13TH; ++i) {
            date = LocalDateTime.of(year, i, THE13TH, 0, 0);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                ans.add(date.toLocalDate().toString());
            }
        }
        return ans.toArray(String[]::new);
    }

    static TemporalAdjuster nextFriday13th = TemporalAdjusters.ofDateAdjuster(date -> {
        LocalDate dateCopy = date;
        if (dateCopy.getDayOfMonth() <= THE13TH) {
            dateCopy = dateCopy.plusDays(THE13TH - dateCopy.getDayOfMonth());
        } else {
            dateCopy = dateCopy.plusMonths(1);
        }
        while (dateCopy.getDayOfWeek() != DayOfWeek.FRIDAY) {
            dateCopy = dateCopy.plusMonths(1);
        }
        return dateCopy;
    });

    static LocalDate whenNextFriday13th(LocalDate currentDate) {
        return currentDate.with(nextFriday13th);
    }

}
