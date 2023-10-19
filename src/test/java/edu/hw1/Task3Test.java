package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    @Test
    @DisplayName("task_3_testing")
    void task_3Testing() {

        double[][] first_arrays = {{1, 2, 3, 4}, {0}, {1, 4, 16}, {1, 2}};
        double[][] second_arrays = {{0, 3, 5}, {0, 1}, {1, 2, 1, 1}, {14}};
        boolean[] correct_answers = {true, false, false, false};

        boolean[] answers = new boolean[correct_answers.length];
        for (int i = 0; i < first_arrays.length; ++i) {
            answers[i] = Task3.isNestable(first_arrays[i], second_arrays[i]);
        }

        assertThat(answers).isEqualTo(correct_answers);
    }

}
