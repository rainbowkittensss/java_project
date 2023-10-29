package edu.hw3;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.Test;

public class Task1Test {
    @Test
    void atbashCheck(){
        //given
        String[] inputPhrases = {"hello","Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler",
        "another example!"};
        String[] correctAnswers = {"svool","Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi",
        "zmlgsvi vcznkov!"};
        //when
        String[] answers = new String[inputPhrases.length];
        for(int i =0;i<answers.length;++i){
            answers[i] = Task1.atbash(inputPhrases[i]);
        }
        //then
        assertThat(answers).isEqualTo(correctAnswers);
    }
}
