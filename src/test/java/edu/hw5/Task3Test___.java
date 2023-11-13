package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test___ {
    @Test
    void Task3Tests() {
        String[] dates = {
            "2020-10-10",
            "2020-12-2",
            "1/3/1976",
            "1/3/20",
            "tomorrow",
            "today",
            "yesterday",
            "1 day ago",
            "2234 days ago" };
        List<Optional<LocalDate>> answers = List.of(
            Optional.of(LocalDate.of(2020, 10, 10)),
            Optional.of(LocalDate.of(2020, 12, 2)),
            Optional.of(LocalDate.of(1976, 3, 1)),
            Optional.of(LocalDate.of(2020, 3, 1)),
            Optional.of(LocalDate.now().plusDays(1)),
            Optional.of(LocalDate.now()),
            Optional.of(LocalDate.now().minusDays(1)),
            Optional.of(LocalDate.now().minusDays(1)),
            Optional.of(LocalDate.now().minusDays(2234))
        );
        Optional<LocalDate> ans;
        for (int i = 0; i < dates.length; ++i) {
            ans = Task3.parseDate(dates[i]);

            assertThat(ans).isEqualTo(answers.get(i));
        }

    }
}
