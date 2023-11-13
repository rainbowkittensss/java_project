package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    void Task2Tests() {
        int[] years = {1925,2024,2023};
        String[][] answers = {{"1925-02-13", "1925-03-13", "1925-11-13"},{"2024-09-13", "2024-12-13"},{"2023-01-13","2023-10-13"}};

        String[] ans;
        for (int i = 0;i<years.length;++i){
            ans = Task2.findFridays13thInYear(years[i]);

            assertThat(ans).isEqualTo(answers[i]);
        }

    }
    @Test
    void Task2TestsNextFriday() {
        LocalDate now = LocalDate.now();
        LocalDate correctAnswer = LocalDate.of(2024,9,13);

        LocalDate ans = Task2.whenNextFriday13th(now);

        assertThat(ans).isEqualTo(correctAnswer);


    }
}
