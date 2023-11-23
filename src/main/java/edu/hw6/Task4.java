package edu.hw6;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Checksum;

public class Task4 {
    private Task4() {
    }

    public static void useManyStreamFeatures(Path path) {
        Path newPath = null;
        try {
            newPath = Files.createFile(path);
        } catch (IOException exc) {
            return;
        }
        if (Files.isRegularFile(newPath)) {
            Checksum checksum = new CRC32();
            try (
                OutputStream firstPartStream = new FileOutputStream(newPath.toFile());
                CheckedOutputStream checkedOutputStream = new CheckedOutputStream(firstPartStream, checksum);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                    bufferedOutputStream,
                    StandardCharsets.UTF_8
                );
                PrintWriter printWriter = new PrintWriter(outputStreamWriter)
            ) {
                printWriter.print("Programming is learned by writing programs. ― Brian Kernighan");
            } catch (IOException ignored) {
            }
        }

    }
}
