package edu.hw3;

import java.util.HashMap;

public class Task1 {
    private Task1() {}

    static HashMap<Character, Character> compliance = new HashMap<>();

    static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    static void fillCompliance() {
        if (compliance.isEmpty()) {
            for (int i = 0; i < alphabet.length; ++i) {
                compliance.put(alphabet[i], alphabet[alphabet.length - 1 - i]);
                compliance.put(
                    Character.toUpperCase(alphabet[i]),
                    Character.toUpperCase(alphabet[alphabet.length - 1 - i])
                );
            }
        }
    }

    public static String atbash(String phrase) {
        fillCompliance();
        StringBuilder ans = new StringBuilder();
        char[] temp = phrase.toCharArray();
        for (char symbol
            : temp) {
            if (compliance.containsKey(symbol)) {
                ans.append(compliance.get(symbol));
            } else {
                ans.append(symbol);
            }
        }
        return ans.toString();
    }
}
