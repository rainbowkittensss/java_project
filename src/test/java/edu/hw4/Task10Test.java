package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import edu.hw4.AllTasks.Animal;
import edu.hw4.AllTasks.Animal.Type;
import edu.hw4.AllTasks.Animal.Sex;
import edu.hw4.AllTasks.AnimalOperations;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task10Test {
    AnimalOperations<List<Animal>> testObj = new AnimalOperations<>();

    @Test
    void onesBiggestWeightTest1() {
        List<Animal> animals = List.of(
            new Animal("Sharickk", Type.DOG, Sex.M, 10, 40, 15, true),
            new Animal("Nemo", Type.FISH, Sex.M, 1, 2, 2, false),
            new Animal("Oatmeal", Type.CAT, Sex.F, 4, 30, 9, true),
            new Animal("Tails", Type.DOG, Sex.F, 4, 25, 12, false),
            new Animal("Big", Type.DOG, Sex.F, 1, 25, 30, false),
            new Animal("Huge", Type.DOG, Sex.F, 1, 25, 40, false),
            new Animal("Star", Type.CAT, Sex.F, 4, 27, 20, true),
            new Animal("Kotishe", Type.CAT, Sex.F, 5, 27, 60, true),
            new Animal("Dory", Type.FISH, Sex.M, 2, 2, 3, false),
            new Animal("Spidey", Type.SPIDER, Sex.M, 8, 2, 6, false)
        );

        List<Animal> ans = testObj.differentPawsAndAge(animals);

        assertThat(ans).isEqualTo(List.of(animals.get(0),
            animals.get(1),
            animals.get(4),
            animals.get(5),
            animals.get(7),
            animals.get(8)));
    }
}

