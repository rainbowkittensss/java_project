package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import edu.hw4.AllTasks.Animal;
import edu.hw4.AllTasks.Animal.Type;
import edu.hw4.AllTasks.Animal.Sex;
import edu.hw4.AllTasks.AnimalOperations;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task2Test {
    AnimalOperations<List<Animal>> testObj = new AnimalOperations<>();
    @Test
    @DisplayName("task 2 default")
    void sortByWeightTest1(){
        List<Animal> animals = List.of(
            new Animal("Sharick", Type.DOG, Sex.M, 10, 40, 15, true),
            new Animal("Nemo", Type.FISH, Sex.M, 1, 2, 2, false),
            new Animal("Oatmeal", Type.CAT, Sex.F, 5, 30, 9, true),
            new Animal("Chompy", Type.SPIDER, Sex.F, 100, 6, 5, true)
        );

        List<Animal> ans = testObj.sortByWeight(animals,2);

        assertThat(ans.size()).isEqualTo(2);
        assertThat(ans).isEqualTo(List.of(animals.get(0), animals.get(2)));
    }
    @Test
    @DisplayName("task 2 empty list")
    void sortByWeightTest2(){
        assertThat(testObj.sortByWeight(List.of(), 2)).isEqualTo(List.of());
    }

}
