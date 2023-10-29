package edu.hw3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    //given
    String[] inputArrFirst = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
    String[] inputArrSecond = {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};

    Task5.Contact[] correctAnsFirstASC = {
        new Task5.Contact("Thomas","Aquinas"),
        new Task5.Contact("Rene","Descartes"),
        new Task5.Contact("David","Hume"),
        new Task5.Contact("John","Locke"),
    };

    Task5.Contact[] correctAnsSecondDESC = {
        new Task5.Contact("Carl","Gauss"),
        new Task5.Contact("Leonhard","Euler"),
        new Task5.Contact("Paul","Erdos"),
    };
    Task5.Contact[] correctAnsFirstDESC = {
        new Task5.Contact("John","Locke"),
        new Task5.Contact("David","Hume"),
        new Task5.Contact("Rene","Descartes"),
        new Task5.Contact("Thomas","Aquinas"),
    };

    Task5.Contact[] correctAnsSecondASC = {
        new Task5.Contact("Paul","Erdos"),
        new Task5.Contact("Leonhard","Euler"),
        new Task5.Contact("Carl","Gauss"),
    };
    Task5.Contact[] correctAnsNull = new Task5.Contact[0];

    void runTest(String[] inpArr, Task5.Contact[] correctAns, String mode){
        //when
        Task5.Contact[] ans = Task5.parseContacts(inpArr,mode);
        //then
        assertThat(ans).isEqualTo(correctAns);
    }
    @Test
    void ASCSortTesting(){
       runTest(inputArrFirst,correctAnsFirstASC,"ASC");
       runTest(inputArrSecond,correctAnsSecondASC,"ASC");
       runTest(null,correctAnsNull,"ASC");
    }
    @Test
    void DESCSortTesting(){
        runTest(inputArrFirst,correctAnsFirstDESC,"DESC");
        runTest(inputArrSecond,correctAnsSecondDESC,"DESC");
        runTest(null,correctAnsNull,"DESC");
    }
}
