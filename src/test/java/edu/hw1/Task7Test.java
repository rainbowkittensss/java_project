package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    @Test
    @DisplayName("task_7_testing")
    void task_7Testing() {

        int[][] numbers_and_moves = {{135, 12, 108, 111, 65, 9, -1} //значения
            , {5, 1, 11, 6, 10, 5, 5, -1}}; //сдвиги
        int[][] results_left_right = {{240, 9, 77, 119, 12, 3, -1}, //ответы для rotateLeft
            {60, 6, 102, 95, 24, 12, -1}};  //ответы для rotateRight

        int[][] answers_left_right = new int[2][results_left_right[0].length];
        for (int i = 0; i < results_left_right[0].length; ++i) {
            answers_left_right[0][i] = Task7.rotateLeft(numbers_and_moves[0][i], numbers_and_moves[1][i]);
            answers_left_right[1][i] = Task7.rotateRight(numbers_and_moves[0][i], numbers_and_moves[1][i]);
        }

        assertThat(answers_left_right).isEqualTo(results_left_right);
    }

}
