package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    void Task4Tests() {
        String[] words = {"hehe~","la!lala@@##","meh","badPassword"};
        boolean[] correctAnswer = {true,true,false,false};

        boolean ans;
        for(int i = 0;i<words.length;++i){
            ans = Task4.checkThePassword(words[i]);

            assertThat(ans).isEqualTo(correctAnswer[i]);
        }

    }
}
