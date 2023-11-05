package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import edu.hw4.AllTasks.Animal;
import edu.hw4.AllTasks.Animal.Type;
import edu.hw4.AllTasks.Animal.Sex;
import edu.hw4.AllTasks.AnimalOperations;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task15Test {
    AnimalOperations<List<Animal>> testObj = new AnimalOperations<>();

    @Test
    void sumOfWeightTest1() {
        List<Animal> animals = List.of(
            new Animal("Sharickk", Type.DOG, Sex.M, 10, 140, 15, true),
            new Animal("Nemo", Type.FISH, Sex.M, 6, 2, 2, false),
            new Animal("Oatmeal", Type.CAT, Sex.F, 11, 130, 9, true),
            new Animal("Tails", Type.DOG, Sex.F, 4, 25, 12, false),
            new Animal("Big", Type.DOG, Sex.F, 1, 25, 30, false),
            new Animal("Huge", Type.DOG, Sex.F, 3, 25, 40, false),
            new Animal("Star", Type.CAT, Sex.F, 4, 127, 20, true),
            new Animal("Kotishe", Type.CAT, Sex.F, 5, 27, 60, true),
            new Animal("Dory", Type.FISH, Sex.M, 2, 2, 3, false),
            new Animal("Spidey", Type.FISH, Sex.M, 8, 2, 6, false)
        );

        Map<Type,Integer> ans = testObj.sumOfWeight(animals, 2,7);

        assertThat(ans).isEqualTo(
            Map.of(Type.DOG, 52,Type.CAT,80, Type.FISH, 5));
    }
}
