package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    private Task2() {
    }

    public static final String COPY_STR = " -- копия";
    public static String endStr = ".txt";

    public static void cloneFile(Path path) throws IOException {
        StringBuilder newFileName = new StringBuilder();
        String source = String.valueOf(path.getFileName());
        Pattern patternEnd = Pattern.compile("^.+(\\..+)$");
        Matcher endMatcher = patternEnd.matcher(source);
        if (endMatcher.find()) {
            endStr = endMatcher.group(1);
        }
        Pattern pattern = Pattern.compile(".*\\((\\d+)\\)" + endStr);
        if (source.contains(COPY_STR)) {
            if (source.contains(COPY_STR + " (")) {
                Matcher matcher = pattern.matcher(source);
                if (matcher.find()) {
                    newFileName.append(source, 0, source.indexOf(COPY_STR))
                        .append(COPY_STR + " (")
                        .append(Integer.parseInt(matcher.group(1)) + 1)
                        .append(")").append(endStr);
                }
            } else {
                newFileName.append(source, 0, source.indexOf(endStr)).append(" (1)").append(endStr);
            }
        } else {
            newFileName.append(source, 0, source.indexOf(endStr))
                .append(COPY_STR).append(endStr);
        }

        Files.createFile(path.getParent().resolve(newFileName.toString()));
        Files.writeString(path.getParent().resolve(newFileName.toString()), Files.readString(path));
    }
}
