package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import edu.hw4.AllTasks.Animal;
import edu.hw4.AllTasks.Animal.Type;
import edu.hw4.AllTasks.Animal.Sex;
import edu.hw4.AllTasks.AnimalOperations;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task16Test {
    AnimalOperations<List<Animal>> testObj = new AnimalOperations<>();

    @Test
    void complicatedSortTest1() {
        Animal sharickk =  new Animal("Sharickk", Type.DOG, Sex.M, 10, 140, 15, true);
        Animal nemo = new Animal("Nemo", Type.FISH, Sex.M, 1, 2, 2, false);
        Animal oatmeal = new Animal("Oatmeal", Type.CAT, Sex.F, 4, 130, 9, true);
        Animal tails =new Animal("Tails", Type.DOG, Sex.F, 4, 25, 12, false);
        Animal big =new Animal("Big", Type.DOG, Sex.F, 1, 25, 30, false);
        Animal huge = new Animal("Huge", Type.DOG, Sex.F, 1, 25, 40, false);
        Animal star = new Animal("Star", Type.CAT, Sex.F, 4, 127, 20, true);
        Animal kotishe= new Animal("Kotishe", Type.CAT, Sex.F, 5, 27, 60, true);
        Animal dory = new Animal("Dory", Type.FISH, Sex.M, 2, 2, 3, false);
        Animal spidey =  new Animal("Spidey", Type.SPIDER, Sex.M, 8, 2, 6, false);
        List<Animal> animals = List.of(
            sharickk, nemo, oatmeal, big,huge,star, kotishe, dory, spidey, tails
        );

        List<Animal> ans = testObj.complicatedSort(animals);

        assertThat(ans).isEqualTo(List.of(kotishe,oatmeal,star,sharickk,big, huge,tails,dory,nemo, spidey));
    }
}
