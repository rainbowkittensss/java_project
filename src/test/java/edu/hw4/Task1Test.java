package edu.hw4;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import edu.hw4.AllTasks.Animal;
import edu.hw4.AllTasks.Animal.Type;
import edu.hw4.AllTasks.Animal.Sex;
import edu.hw4.AllTasks.AnimalOperations;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    AnimalOperations<List<Animal>> testObj = new AnimalOperations<>();

    @Test
    @DisplayName("task 1 default")
    void sortByHeightTest1() {
        List<Animal> animals = List.of(
            new Animal("Sharick", Type.DOG, Sex.M, 10, 40, 15, true),
            new Animal("Nemo", Type.FISH, Sex.M, 1, 2, 2, false),
            new Animal("Oatmeal", Type.CAT, Sex.F, 5, 30, 9, true),
            new Animal("Chompy", Type.SPIDER, Sex.F, 100, 6, 5, true)
        );

        List<Animal> ans = testObj.sortByHeight(animals);

        assertThat(ans).isEqualTo(List.of(animals.get(1), animals.get(3), animals.get(2), animals.get(0)));

    }

    @Test
    @DisplayName("task 1 empty list")
    void sortByHeightTest2() {
        assertThat(testObj.sortByHeight(List.of())).isEqualTo(List.of());
    }

}
