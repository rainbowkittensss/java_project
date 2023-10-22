package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    @Test
    @DisplayName("task4_testing")
    void task_4Test() {
        assertThat(Task4.getCallingInfo()).isEqualTo(new Task4.CallingInfo("edu.hw2.Task4Test", "task_4Test"));
        assertThat(Main.forTestOfTask4()).isEqualTo(new Task4.CallingInfo("edu.hw2.Main", "forTestOfTask4"));
        //Указанный выше метод возвращает результат getCallingInfo()
    }

}
