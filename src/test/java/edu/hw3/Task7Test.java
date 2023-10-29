package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    void nullableComparatorTest(){
        //given
        TreeMap<String,String> tree = new TreeMap<>(Task7.compWithNull);
        //when
        tree.put(null,"hehehe");
        //then
        assertThat(tree.containsKey(null)).isTrue();
        assertThat(tree.get(null)).isEqualTo("hehehe");
        tree.remove(null);
        assertThat(tree.get(null)).isEqualTo(null);
    }
}
