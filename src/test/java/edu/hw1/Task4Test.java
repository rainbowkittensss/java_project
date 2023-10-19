package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    @Test
    @DisplayName("task_4_testing")
    void task_4Testing() {

        String[] lines = {"ъСше ьще ётэхим гяикх", "рфнауцсзик хуболк", "адв пыйеч юа", "bacaa"};
        String[] correct_answers = {"Съешь ещё этих мягких", "французских булок", "да выпей чаю", "abaca"};

        String[] answers = new String[correct_answers.length];
        for (int i = 0; i < lines.length; ++i) {
            answers[i] = Task4.fixString(lines[i]);
        }

        assertThat(answers).isEqualTo(correct_answers);
    }


}
