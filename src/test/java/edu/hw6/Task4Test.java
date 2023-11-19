package edu.hw6;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    void Task4Test1() throws IOException {
        Path path = Paths.get(
            "C:\\Users\\mrpop\\java-course-2023\\project-template\\src\\main\\java\\edu\\hw6\\task4Sources\\resultFile");

        Task4.useManyStreamFeatures(path);

        assertThat(Files.readString(path)).isEqualTo("Programming is learned by writing programs. ― Brian Kernighan");
        Files.delete(path);
    }
}
