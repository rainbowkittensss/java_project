package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    @Test
    @DisplayName("task_5_testing")
    void task_5Testing() {

        int[] numbers = {101010, 10101, 23532, 1221, 1113, 5479876, 23452, 9876, 0};
        boolean[] correct_answers = {true, true, true, true, false, true, false, false, true};

        boolean[] answers = new boolean[correct_answers.length];
        for (int i = 0; i < numbers.length; ++i) {
            answers[i] = Task5.isPalindromeDescendant(numbers[i]);
        }

        assertThat(answers).isEqualTo(correct_answers);
    }
}
