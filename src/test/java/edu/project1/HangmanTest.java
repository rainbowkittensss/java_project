package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;
import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class HangmanTest {
    public static final Logger LOGGER = LogManager.getLogger();
    public static int word;

    @Test
    @DisplayName("project1_test1")
    public void HangmanTest() throws IOException {
        word = Hangman.setAndGetSelectedWord();
        String nameOfFile = switch (word) {
            case 0 -> Hangman.getDictionary()[0];
            case 1 -> Hangman.getDictionary()[1];
            case 2 -> Hangman.getDictionary()[2];
            case 3 -> Hangman.getDictionary()[3];
            case 4 -> Hangman.getDictionary()[4];
            default -> "";
        };
        File test1File = new File("src/test/java/edu/project1/textsForStream/".concat(nameOfFile));
        boolean opened = true;
        InputStream inputStream = InputStream.nullInputStream();
        PrintStream out = System.out;
        FileReader reader = null;
        try {
            inputStream = new FileInputStream(test1File);
            out = new PrintStream("src/test/java/edu/project1/outputTexts/out1");
        } catch (FileNotFoundException exc) {
            LOGGER.info("file for testing not found :c");
            opened = false;
        }
        if (opened) {
            try {
                Hangman.startGame(inputStream, out);
            } catch (NoSuchElementException exc) {
                LOGGER.info("Text of test is too short to end the algorithm\n" +
                    "it does not matter.");
            }
            try {
                inputStream = new FileInputStream(test1File);
                reader = new FileReader("src/test/java/edu/project1/outputTexts/out1");
            } catch (FileNotFoundException exc) {
                LOGGER.info("Data from output file is unreadable.");
                return;
            }
            Scanner scanOut = new Scanner(reader);
            Scanner scanIn = new Scanner(inputStream);
            Vector<String> textOut = new Vector<>();
            Vector<String> textIn = new Vector<>();
            boolean contin = true;
            while (contin) {
                try {
                    textOut.addLast(scanOut.nextLine());
                    textIn.addLast(scanIn.nextLine());
                } catch (NoSuchElementException exc) {
                    contin = false;
                }
            }
            assertThat(textOut.contains("You won! Congratulations c:Do you want to start another round?")).isTrue();
            for (int i = 0; i < textIn.size(); ++i) {
                if (textIn.get(i).length() > 1 &&
                    !(textOut.get(i - 1).equals("Put 'yes' to try again, or something else to cancel."))||
                textIn.get(i).equals("yes")||textIn.get(i).equals("end game")) {
                    assertThat(textOut.get(i)).isEqualTo("Oops! Input was incorrect. Please, try again:");
                }
            }
        }
    }
}
