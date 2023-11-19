package edu.hw6;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    void Task2CreateFirstCopy() throws IOException {
        Path path = Paths.get(
            "C:\\Users\\mrpop\\java-course-2023\\project-template\\src\\main\\java\\edu\\hw6\\task2Sources\\fileForTask2Test.txt");

        Task2.cloneFile(path);

        assertThat(Files.isRegularFile( path.resolveSibling("fileForTask2Test -- копия.txt"))).isTrue();
        assertThat(Files.readString(path)).isEqualTo(Files.readString(path.resolveSibling("fileForTask2Test -- копия.txt")));
        Files.delete(path.resolveSibling("fileForTask2Test -- копия.txt"));
    }
    @Test
    void Task2CreateNumberOneCopy()throws IOException{
        Path path = Paths.get(
            "C:\\Users\\mrpop\\java-course-2023\\project-template\\src\\main\\java\\edu\\hw6\\task2Sources\\anotherFile -- копия.csv");

        Task2.cloneFile(path);

        assertThat(Files.isRegularFile( path.resolveSibling("anotherFile -- копия (1).csv"))).isTrue();
        assertThat(Files.readString(path)).isEqualTo(Files.readString(path.resolveSibling("anotherFile -- копия (1).csv")));
        Files.delete(path.resolveSibling("anotherFile -- копия (1).csv"));
    }

    @Test
    void Task2CreateNumberICopy()throws IOException{
        Path path = Paths.get(
            "C:\\Users\\mrpop\\java-course-2023\\project-template\\src\\main\\java\\edu\\hw6\\task2Sources\\the third file -- копия (3).xml");

        Task2.cloneFile(path);

        assertThat(Files.isRegularFile( path.resolveSibling("the third file -- копия (4).xml"))).isTrue();
        assertThat(Files.readString(path)).isEqualTo(Files.readString(path.resolveSibling("the third file -- копия (4).xml")));
        Files.delete(path.resolveSibling("the third file -- копия (4).xml"));
    }
}
