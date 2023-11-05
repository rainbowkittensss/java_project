package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import edu.hw4.AllTasks.Animal;
import edu.hw4.AllTasks.Animal.Type;
import edu.hw4.AllTasks.Animal.Sex;
import edu.hw4.AllTasks.AnimalOperations;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task18Test {
    AnimalOperations<List<Animal>> testObj = new AnimalOperations<>();

    @Test
    void biggestFishTest1() {
        List<Animal>[] animals = new List[] {List.of(
            new Animal("Sharickk", Type.DOG, Sex.M, 10, 140, 15, true),
            new Animal("Nemo", Type.FISH, Sex.M, 6, 2, 2, false),
            new Animal("Dory", Type.FISH, Sex.M, 2, 2, 3, false)
        ),
            List.of(
                new Animal("Azzy", Type.FISH, Sex.M, 2, 2, 10, false),
                new Animal("Crowley", Type.FISH, Sex.M, 2, 2, 11, false)
            )};


        Animal ans = testObj.biggestFish(animals);

        assertThat(ans).isEqualTo(animals[1].get(1));
    }
}

