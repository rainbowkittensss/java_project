package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    @DisplayName("task_1_testing")
    void task_1Testing() {

        String[] times = {"1:23", "1000000080:23", "14:60", "there_is_no_time_:D",
            "0;1", "0:1", "1.23:1.23", "9999999999999:11", "0:0"};
        long[] correct_answers = {83, 60000004823L, -1, -1, -1, 1, -1, 599999999999951L, 0};

        long[] seconds = new long[correct_answers.length];
        for (int i = 0; i < times.length; ++i) {
            seconds[i] = Task1.minutesToSeconds(times[i]);
        }

        assertThat(seconds).isEqualTo(correct_answers);
    }

}
