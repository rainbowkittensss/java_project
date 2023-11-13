package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    void Task1Tests() {
    String[] inp = {"2022-03-12, 20:20 - 2022-03-12, 23:50",
        "2022-04-01, 21:30 - 2022-04-02, 01:20","some incorrect string"};

    var ans = Task1.midTime(inp);

    assertThat(ans).isEqualTo("3ч 40м");
    }
}
