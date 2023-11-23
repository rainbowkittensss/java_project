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
        Path pathDir = Paths.get(
            "src\\main\\java\\edu\\hw6\\task4Sources");
        Files.createDirectory(pathDir);
        Path pathFile = pathDir.resolve("resultFile");

        Task4.useManyStreamFeatures(pathFile);

        assertThat(Files.readString(pathFile)).isEqualTo("Programming is learned by writing programs. ― Brian Kernighan");
        Files.delete(pathFile);
        if(!pathDir.toFile().delete())throw new IOException();
    }
}
