package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import edu.hw4.AllTasks.Animal;
import edu.hw4.AllTasks.Animal.Type;
import edu.hw4.AllTasks.Animal.Sex;
import edu.hw4.AllTasks.AnimalOperations;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    AnimalOperations<List<Animal>> testObj = new AnimalOperations<>();
    @Test
    void countByTypeTest1(){
        List<Animal> animals = List.of(
            new Animal("Sharick", Type.DOG, Sex.M, 10, 40, 15, true),
            new Animal("Nemo", Type.FISH, Sex.M, 1, 2, 2, false),
            new Animal("Oatmeal", Type.CAT, Sex.F, 5, 30, 9, true),
            new Animal("Tails", Type.DOG, Sex.F, 1, 25, 12, false),
            new Animal("Star", Type.CAT, Sex.M, 4, 27, 20, true)
        );

        Map<Type, Long> ans = testObj.countByType(animals);

        assertThat(ans.size()).isEqualTo(3);
        assertThat(ans).isEqualTo(Map.of(Type.CAT, 2L, Type.DOG, 2L, Type.FISH, 1L));

    }
}
