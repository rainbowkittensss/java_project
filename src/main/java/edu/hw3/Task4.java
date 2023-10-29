package edu.hw3;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Task4 {
    private Task4() {}

    static Comparator<Integer> negateComparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return -Integer.compare(o1, o2);
        }
    };
    static TreeMap<Integer, String> symbolsAndValues = new TreeMap<>(negateComparator);

    @SuppressWarnings("all")
    static void makeMapFull() {
        if (!symbolsAndValues.containsKey(1)) {
            symbolsAndValues.putAll(Map.of(1, "I", 5, "V", 10, "X", 50, "L",
                100, "C", 500, "D", 1000, "M", 900, "CM", 90, "XC", 9, "IX"
            ));
        }
        if (!symbolsAndValues.containsKey(4)) {
            symbolsAndValues.putAll(Map.of(4, "IV", 40, "XL", 400, "LD"));
        }

    }

    static String convertToRoman(int value) {
        int tempValue = value;
        StringBuilder ans = new StringBuilder();
        makeMapFull();
        for (int key
            : symbolsAndValues.keySet()) {
            while (tempValue - key >= 0) {
                tempValue -= key;
                ans.append(symbolsAndValues.get(key));
            }
        }
        return ans.toString();
    }

}
