package edu.hw6;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    void Task3Test1() throws IOException {
        Path pathToDir = Paths.get(
            "src\\main\\java\\edu\\hw6\\task3files");
        Files.createDirectory(pathToDir);
        Path pathToFile1 = pathToDir.resolve("file1.txt");
        Files.createFile(pathToFile1);
        Files.writeString(pathToFile1, "there is some info");
        Files.createFile(pathToFile1.resolveSibling("AAAfile5.csv"));
        Files.createFile(pathToDir.resolve("file2.csv"));
        Files.createFile(pathToDir.resolve("file3.xml"));
        Files.createFile(pathToDir.resolve("another1.txt"));


        try (
            DirectoryStream<Path> filteredByType = Files.newDirectoryStream(pathToDir, new Task3.FilterFileType("txt"));
            DirectoryStream<Path> filteredByFileName = Files.newDirectoryStream(
                pathToDir, new Task3.FilterFileName("file.*"));
            DirectoryStream<Path> filteredByAttribute = Files.newDirectoryStream(pathToDir, new Task3.FilterAtrributes(
                Task3.FilterAtrributes.TypeOfAttribute.READABLE));
            DirectoryStream<Path> filteredBySize = Files.newDirectoryStream(
                pathToDir,
                new Task3.FilterSize(Task3.FilterSize.TypeOfCompare.LESS_THAN, 1)
            )
        ) {
            filteredByType.forEach(path1 -> assertThat(path1.endsWith("txt")).isTrue());
            filteredByFileName.forEach(path1 -> {
                Pattern pattern = Pattern.compile("file.*");
                assertThat(pattern.matcher(String.valueOf(path1.getFileName())).matches()).isTrue();
            });
            filteredBySize.forEach(path1 -> {
                try {
                    assertThat(Files.size(path1) < 1).isTrue();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            filteredByAttribute.forEach(path1 -> assertThat(Files.isReadable(path1)).isTrue());
            Task3.AbstractFilter filter =
                new Task3.FilterFileName("^file.*")
                    .and(new Task3.FilterFileType("csv"));
            DirectoryStream<Path> complexTestStream = Files.newDirectoryStream(pathToDir, filter);
            complexTestStream.forEach(path1 -> {
                Pattern pattern = Pattern.compile("^file.*");
                assertThat(path1.endsWith("csv") && pattern.matcher(String.valueOf(path1)).matches()).isTrue();
            });
        }
        Files.delete(pathToDir.resolve("file1.txt"));
        Files.delete(pathToDir.resolve("AAAfile5.csv"));
        Files.delete(pathToDir.resolve("file2.csv"));
        Files.delete(pathToDir.resolve("file3.xml"));
        Files.delete(pathToDir.resolve("another1.txt"));
        if(!pathToDir.toFile().delete())throw new IOException();
    }
}
