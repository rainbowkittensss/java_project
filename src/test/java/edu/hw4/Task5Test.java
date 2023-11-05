package edu.hw4;
import org.junit.jupiter.api.Test;
import java.util.List;
import edu.hw4.AllTasks.Animal;
import edu.hw4.AllTasks.Animal.Type;
import edu.hw4.AllTasks.Animal.Sex;
import edu.hw4.AllTasks.AnimalOperations;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task5Test {
    AnimalOperations<List<Animal>> testObj = new AnimalOperations<>();
    @Test
    void mostCommonSexTest1(){
        List<Animal> animals = List.of(
            new Animal("Sharickk", Type.DOG, Sex.M, 10, 40, 15, true),
            new Animal("Nemo", Type.FISH, Sex.M, 1, 2, 2, false),
            new Animal("Oatmeal", Type.CAT, Sex.F, 5, 30, 9, true),
            new Animal("Tails", Type.DOG, Sex.F, 1, 25, 12, false),
            new Animal("Star", Type.CAT, Sex.F, 4, 27, 20, true)
        );

        Sex ans = testObj.mostCommonSex(animals);

        assertThat(ans).isEqualTo(Sex.F);
    }
}
