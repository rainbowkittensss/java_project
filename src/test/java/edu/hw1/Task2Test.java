package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @Test
    @DisplayName("task_2_testing")
    void task_2Testing() {

        double[] numbers = {12345678, 0, -23467345678999999999999999999999997654322D, 0.123456789123456, 1, -1234.1234,
            1.12345612345623456};
        int[] correct_answers = {8, 1, 41, 0, 1, 4, 1};
        //для нецелых чисел постоянно получаются неправильные ответы,
        //поэтому считается только целая часть. Можете, пожалуйста,
        //подсказать как посчитать цифры после точки?

        int[] answers = new int[correct_answers.length];
        for (int i = 0; i < numbers.length; ++i) {
            answers[i] = Task2.countDigits(numbers[i]);
        }

        assertThat(answers).isEqualTo(correct_answers);
    }

}
