package edu.hw3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.Map;

public class Task3Test {
    @Test
    void stringArrDictTest() {
        //given
        String[] strArr = {"abc", "kek", "heheheheh", "abc", "hello", "hello", "hello"};
        Map<String, Integer> correctAns = Map.of("abc", 2, "kek", 1, "heheheheh", 1, "hello", 3);
        //when
        Task3<String> testObj = new Task3<>();
        Map<String, Integer> ans = testObj.freqDict(strArr);
        //then
        assertThat(ans).isEqualTo(correctAns);
    }

    @Test
    void intArrDictTest() {
        //given
        Integer[] intArr = {1, 2, 3, 4, 2, 1, 3, 4, 5, 8, 7, 77, 77, 77, 77};
        Map<Integer, Integer> correctAns = Map.of(2, 2, 3, 2,
            1, 2, 4, 2,   5, 1,
            8, 1, 7, 1, 77, 4);
        //when
        Task3<Integer> testObj = new Task3<>();
        Map<Integer, Integer> ans = testObj.freqDict(intArr);
        //then
        assertThat(ans).isEqualTo(correctAns);
    }
}
