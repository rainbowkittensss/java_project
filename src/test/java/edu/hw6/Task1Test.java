package edu.hw6;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;
import static edu.hw6.Task1.DiskMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    static Path pathDir;

    static void createEnvironment() throws IOException {
        pathDir = Paths.get(
            "C:\\Users\\mrpop\\java-course-2023\\project-template\\src\\main\\java\\edu\\hw6\\task1Sources");
        Files.createDirectory(pathDir);
        Files.createFile(pathDir.resolve("mapNumberOne.json"));
        Files.writeString(
            pathDir.resolve("mapNumberOne.json"),
            "{\"size\":3,\"keys\":[\"to be\",\"first\",\"second\"],\"values\":[\"or not to be\",\"test\",\"test2\"]}"
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
        if (!pathDir.toFile().delete()) {
            throw new IOException();
        }
    }

    @Test
    void Task1TestUploadingExistingStorage() throws IOException {
        createEnvironment();
        Path pathToStorage = pathDir.resolve("mapNumberOne.json");

        DiskMap secondDiskMap = DiskMap.uploadAndUseOldStorage(pathToStorage);

        assertThat(secondDiskMap.entrySet()).isEqualTo(Map.of(
            "first",
            "test",
            "second",
            "test2",
            "to be",
            "or not to be"
        ).entrySet());
        deleteEnvironment();
    }

    @Test
    void Task1TestChangingOfStorage() throws IOException {
        createEnvironment();
        DiskMap diskMap = new DiskMap(true);

        diskMap.put("a", "a1");
        diskMap.put("b", "b1");
        diskMap.dump();

        diskMap.remove("a");
        diskMap.put("c", "c1");
        diskMap.dump();
        DiskMap secondDiskMap = DiskMap.uploadAndUseOldStorage(diskMap.getStoragePath());

        assertThat(secondDiskMap.entrySet()).isEqualTo(Map.of("b", "b1", "c", "c1").entrySet());
        Files.delete(diskMap.getStoragePath());

        deleteEnvironment();

    }
}
