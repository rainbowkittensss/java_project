package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task8Test {
    @Test
    void iteratorTest(){
        //given
        List<Integer> list = new ArrayList<>(4);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        //when
        Task8.BackIterator<List,Integer> iter = new Task8.BackIterator<>(list);
        //then
        assertThat(iter.hasNext()).isTrue();
        assertThat(iter.next()).isEqualTo(4);
        assertThat(iter.next()).isEqualTo(3);
        assertThat(iter.next()).isEqualTo(2);
        assertThat(iter.next()).isEqualTo(1);
        assertThat(iter.hasNext()).isFalse();

    }
}
