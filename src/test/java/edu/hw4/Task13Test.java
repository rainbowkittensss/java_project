package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import edu.hw4.AllTasks.Animal;
import edu.hw4.AllTasks.Animal.Type;
import edu.hw4.AllTasks.Animal.Sex;
import edu.hw4.AllTasks.AnimalOperations;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task13Test {
    AnimalOperations<List<Animal>> testObj = new AnimalOperations<>();

    @Test
    void longNamesTest1() {
        List<Animal> animals = List.of(
            new Animal("Sharickk", Type.DOG, Sex.M, 10, 140, 15, true),
            new Animal("Nemo", Type.FISH, Sex.M, 1, 2, 2, false),
            new Animal("Oatmeal Cristopher Second", Type.CAT, Sex.F, 4, 130, 9, true),
            new Animal("Miles Tails Prower", Type.DOG, Sex.F, 4, 25, 12, false),
            new Animal("Big", Type.DOG, Sex.F, 1, 25, 30, false),
            new Animal("Huge", Type.DOG, Sex.F, 1, 25, 40, false),
            new Animal("Starry Sky", Type.CAT, Sex.F, 4, 127, 20, true),
            new Animal("Kotishe", Type.CAT, Sex.F, 5, 27, 60, true),
            new Animal("Dory", Type.FISH, Sex.M, 2, 2, 3, false),
            new Animal("Spidey", Type.SPIDER, Sex.M, 8, 2, 6, false)
        );

        List<Animal> ans = testObj.longNames(animals);

        assertThat(ans).isEqualTo(List.of(
            animals.get(2),
            animals.get(3)
            ));
    }
}
