package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

public class Task3 {
    static DateTimeFormatter formatterDashes = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    static DateTimeFormatter formatterDashesShort = DateTimeFormatter.ofPattern("yyyy-MM-d");
    static DateTimeFormatter formatterSlashes = DateTimeFormatter.ofPattern("d/M/yyyy");
    static DateTimeFormatter formatterSlashesShort = DateTimeFormatter.ofPattern("d/M/yy");
    static DateTimeFormatter formatterDaysAgo = DateTimeFormatter.ofPattern("d day[] ago");

    static Optional<LocalDate> parseDate(String string) {
        List<DateTimeFormatter> formatters =
            List.of(formatterDashes, formatterDaysAgo, formatterDashesShort, formatterDashes, formatterSlashesShort,
                formatterSlashes
            );
        LocalDate ans = LocalDate.now();
        int counter = 0;
        for (DateTimeFormatter formatter
            : formatters) {
            try {
                ans = LocalDate.parse(string, formatter);
            } catch (DateTimeParseException exc) {
                counter += 1;
            }
        }
        if (counter == formatters.size()) {
            return switch (string) {
                case "today" -> Optional.of(LocalDate.now());
                case "tomorrow" -> Optional.of(LocalDate.now().plusDays(1));
                case "yesterday" -> Optional.of(LocalDate.now().minusDays(1));
                default -> Optional.empty();
            };
        } else {
            return Optional.of(ans);
        }
    }
}
