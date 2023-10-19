package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {


    @Test
    @DisplayName("task_6_testing")
    void task_6Testing() {

        int[] numbers =
            {1000, 1001, 9999, 10000, 1234, 6174, 7777, 6666, 6777, 8352, 8082, 8991, 9099, 2088, 7998, 1393, 5994,
                8442, 9721, 1089};
        int[] correct_answers = {-1, 4, -1, -1, 3, 0, -1, -1, 5, 1, 2, 3, 4, 2, 3, 6, 5, 6, 7};

        int[] answers = new int[correct_answers.length];
        for (int i = 0; i < correct_answers.length; ++i) {
            answers[i] = Task6.countK(numbers[i]);
        }

        assertThat(answers).isEqualTo(correct_answers);
    }

}
