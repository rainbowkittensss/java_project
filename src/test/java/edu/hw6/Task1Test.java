package edu.hw6;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import static edu.hw6.Task1.DiskMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    void Task1TestUploadingExistingStorage() {

    Path pathToStorage = Paths.get(DiskMap.ROOT_DIR,DiskMap.PATH_TO_MAPS).resolve("mapNumber661bbdba-12bc-4cfc-8a83-77d57b20b4bc.json");

    DiskMap secondDiskMap = DiskMap.uploadAndUseOldStorage(pathToStorage);

    assertThat(secondDiskMap.entrySet()).isEqualTo(Map.of("first","test", "second","test2","to be","or not to be").entrySet());
    }
    @Test
    void Task1TestChangingOfStorage() throws IOException {
        DiskMap diskMap = new DiskMap(true);

        diskMap.put("a","a1");
        diskMap.put("b", "b1");
        diskMap.dump();
        diskMap.remove("a");
        diskMap.put("c","c1");
        diskMap.dump();
        DiskMap secondDiskMap = DiskMap.uploadAndUseOldStorage(diskMap.getStoragePath());

        assertThat(secondDiskMap.entrySet()).isEqualTo(Map.of("b","b1","c","c1").entrySet());
        Files.delete(diskMap.getStoragePath());
        }
}
