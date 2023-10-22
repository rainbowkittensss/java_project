package edu.project1;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.SecureRandom;
import java.util.Scanner;

public class Hangman {
    private static final String[] dictionary = {"hedgehog", "submarine", "ghost", "pumpkin", "witch"};
    private static int selectedWord = -1;
    private static int maxAttempts;
    private static final int GIVE_UP = 1;
    private static final int SUCCESSFUL_TICK = 2;
    private static final int FAILED_TICK = 3;
    static StringBuilder currentStr;
    private static Scanner in = null;
    public static InputStream inpStream;
    public static PrintStream outStream;
    public static int successfullAttempts;

    public static int getSelectedWord() {
        return selectedWord;
    }

    public static String[] getDictionary() {
        return dictionary;
    }

    public static int getSuccessfullAttempts(){
    return successfullAttempts;
    }

    public static int setAndGetSelectedWord() {
        SecureRandom random = new SecureRandom(SecureRandom.getSeed(20));
        int newNumber = random.nextInt(0, dictionary.length);
        while (newNumber == selectedWord) {
            newNumber = random.nextInt(0, dictionary.length);
        }
        selectedWord = newNumber;
        return selectedWord;
    }

    private static int calculateMaxAttempts() {
        return (int) Math.max((dictionary[selectedWord].length() * 2 / 3), 5);
    }

    private static void processOfGame() throws IOException {
        outStream.println("Let's start the game! " +
            "Now you have " + maxAttempts + " attempts." +
            "The world: ".concat(String.valueOf(currentStr)) +
            "Write a letter that you want to check, or 'end game' to give up.");
        int tickResult = SUCCESSFUL_TICK;
        successfullAttempts=0;
        for (int attempts = 0; attempts < maxAttempts &&
            tickResult != GIVE_UP && successfullAttempts < currentStr.length(); ) {
            tickResult = tickGame();
            if (tickResult == FAILED_TICK) {
                attempts += 1;
                outStream.println("Now you have " + (maxAttempts - attempts) + " attempts");
            } else {
                successfullAttempts += 1;
            }
        }
        endGame(tickResult);
    }

    private static void endGame(int gameResult) throws IOException {
        if (String.valueOf(currentStr).equals(dictionary[selectedWord])) {
            outStream.println("You won! Congratulations c:" +
                "Do you want to start another round?");
        } else if (gameResult == GIVE_UP) {
            outStream.println("Do you want to give up?" +
                "Okay. How about another try?");
        } else {
            outStream.println("Oh no! Attempts were run out :c" +
                "The world was '" + dictionary[selectedWord] +
                "'Let's try again?");
        }
        outStream.println("Put 'yes' to try again, or something else to cancel.");
        if (in.nextLine().equals("yes")) {
            startGame(inpStream, outStream);
        } else {
            outStream.close();
            inpStream.close();
        }
    }

    static String alphabet = "qwertyuiopasdfghjklzxcvbnm";

    private static int tickGame() {
        String input = in.nextLine();
        if (input.equals("end game")) {
            return GIVE_UP;
        } else {
            while (input.length() > 1 || !alphabet.contains(input) ||
                String.valueOf(currentStr).contains(input)) {
                outStream.println("Oops! Input was incorrect. Please, try again:");
                input = in.nextLine();
            }

            if (dictionary[selectedWord].contains(input)) {
                for (int i = 0; i < dictionary[selectedWord].length(); ++i) {
                    if (dictionary[selectedWord].charAt(i) == input.charAt(0)) {
                        currentStr.replace(i, i + 1, input);
                    }
                }

                outStream.println("Nice! You find out right letter. " +
                    "Now the word looks like: " + currentStr);
                return SUCCESSFUL_TICK;
            } else {
                outStream.println("That letter is not exist in the word.");
                return FAILED_TICK;
            }
        }
    }

    static void startGame(InputStream inpStream_, PrintStream outStream_) throws IOException {
        if (in == null) {
            in = new Scanner(inpStream_);
        }
        inpStream = inpStream_;
        outStream = outStream_;
        if (selectedWord == -1) {
            setAndGetSelectedWord();
        }
        currentStr = new StringBuilder("_".repeat(dictionary[selectedWord].length()));
        maxAttempts = calculateMaxAttempts();
        processOfGame();
    }
}
