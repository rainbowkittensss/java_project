package edu.hw6;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    public static Path pathDir;

    static void createEnvironment() throws IOException {
        pathDir = Paths.get(
            "C:\\Users\\mrpop\\java-course-2023\\project-template\\src\\main\\java\\edu\\hw6\\task2Sources");
        Files.createDirectory(pathDir);
        Files.createFile(pathDir.resolve("fileForTask2Test.txt"));
        Files.createFile(pathDir.resolve("anotherFile -- копия.csv"));
        Files.createFile(pathDir.resolve("the third file -- копия (3).xml"));
        Files.writeString(
            pathDir.resolve("the third file -- копия (3).xml"),
            "<?xml version=\"1.0\" encoding=\"utf-8 ?>\n"
                + "    <some tags here>"
        );
    }

    static void deleteEnvironment() throws IOException {
        try (Stream<Path> stream = Files.list(pathDir)) {
            stream.forEach(path -> {
                try {
                    Files.delete(path);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        if(!pathDir.toFile().delete())throw new IOException();
    }

    @Test
    void Task2CreateFirstCopy() throws IOException {
        createEnvironment();

        Path path = pathDir.resolve("fileForTask2Test.txt");

        Task2.cloneFile(path);

        assertThat(Files.isRegularFile(path.resolveSibling("fileForTask2Test -- копия.txt"))).isTrue();
        assertThat(Files.readString(path)).isEqualTo(Files.readString(path.resolveSibling(
            "fileForTask2Test -- копия.txt")));

        Files.delete(path.resolveSibling("fileForTask2Test -- копия.txt"));
        deleteEnvironment();
    }

    @Test
    void Task2CreateNumberOneCopy() throws IOException {
        createEnvironment();

        Path path = pathDir.resolve("anotherFile -- копия.csv");

        Task2.cloneFile(path);

        assertThat(Files.isRegularFile(path.resolveSibling("anotherFile -- копия (1).csv"))).isTrue();
        assertThat(Files.readString(path)).isEqualTo(Files.readString(path.resolveSibling(
            "anotherFile -- копия (1).csv")));

        Files.delete(path.resolveSibling("anotherFile -- копия (1).csv"));
        deleteEnvironment();
    }

    @Test
    void Task2CreateNumberICopy() throws IOException {
        createEnvironment();

        Path path = pathDir.resolve("the third file -- копия (3).xml");

        Task2.cloneFile(path);

        assertThat(Files.isRegularFile(path.resolveSibling("the third file -- копия (4).xml"))).isTrue();
        assertThat(Files.readString(path)).isEqualTo(Files.readString(path.resolveSibling(
            "the third file -- копия (4).xml")));

        Files.delete(path.resolveSibling("the third file -- копия (4).xml"));
        deleteEnvironment();
    }
}
