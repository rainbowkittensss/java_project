package edu.hw3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task4Test {
    @Test
    void convertToRomanTests(){
        //given
        int[] inputNumbers = {2,12,16,19,29,1951};
        String[] correctAnswers = {"II","XII","XVI","XIX","XXIX","MCMLI"};
        //when
        String[] answers = new String[inputNumbers.length];
        for(int i =0;i<inputNumbers.length;++i){
            answers[i] = Task4.convertToRoman(inputNumbers[i]);
        }
        //then
        assertThat(answers).isEqualTo(correctAnswers);

    }
}
