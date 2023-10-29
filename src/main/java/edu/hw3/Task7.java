package edu.hw3;

import java.util.Comparator;


public class Task7 {
    private Task7() {}

    static Comparator<String> compWithNull = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            if (o1 == null || o2 == null) {
                if (o2 == null && o1 == null) {
                    return 0;
                } else if (o1 == null) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return o1.compareTo(o2);
        }
    };
}
