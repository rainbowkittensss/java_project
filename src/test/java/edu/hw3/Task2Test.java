package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task2Test {
    @Test
    void CorrectBracketsTest() {
        //given
        String[] bracketStrings = {"()()()", "((()))", "((()))(())()()(()())", "((())())(()(()()))"};
        String[][] correctAnswers =
            {{"()", "()", "()"}, {"((()))"}, {"((()))", "(())", "()", "()", "(()())"}, {"((())())", "(()(()()))"}};
        //when
        ArrayList<String[]> answers = new ArrayList<>(bracketStrings.length);
        for (String bracketString : bracketStrings) {
            answers.add(Task2.clusterize(bracketString));
        }
        //then
        assertThat(correctAnswers).isEqualTo(answers.toArray(new String[0][]));
    }
}
