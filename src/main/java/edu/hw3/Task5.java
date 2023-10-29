package edu.hw3;

import java.util.ArrayList;
import java.util.Comparator;

public class Task5 {
    private Task5() {
    }

    static Comparator<Contact> lexicalASCComp = new Comparator<Contact>() {
        int comparingNullableSurnames(Contact oNullSurname, Contact o2) {
            if (oNullSurname.name.compareTo(o2.surname) < 0
                || oNullSurname.name.compareTo(o2.surname) == 0
                && oNullSurname.name.compareTo(o2.name) < 0) {
                return -1;
            } else if (oNullSurname.name.compareTo(o2.surname) > 0
                || oNullSurname.name.compareTo(o2.surname) == 0
                && oNullSurname.name.compareTo(o2.name) > 0
            ) {
                return 1;
            } else {
                return 0;
            }

        }

        @Override
        public int compare(Contact o1, Contact o2) {
            int ans = 0;
            if (o1.surname != null && o2.surname != null) {
                if (o1.surname.compareTo(o2.surname) > 0
                    || o1.surname.compareTo(o2.surname) == 0
                    && o1.name.compareTo(o2.name) > 0) {
                    return 1;
                } else if (o1.surname.compareTo(o2.surname) < 0
                    || o1.surname.compareTo(o2.surname) == 0
                    && o1.name.compareTo(o2.name) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            } else if (o1.surname == null) {
                ans = comparingNullableSurnames(o1, o2);
            } else {
                ans = comparingNullableSurnames(o2, o1);
            }
            return ans;
        }
    };
    static Comparator<Contact> lexicalDESCComp = new Comparator<Contact>() {
        @Override
        public int compare(Contact o1, Contact o2) {
            return -1 * lexicalASCComp.compare(o1, o2);
        }
    };

    public static Contact[] parseContacts(String[] input, String mode) {
        if (input == null || input.length < 1) {
            return new Contact[0];
        }
        ArrayList<Contact> ans = new ArrayList<>(input.length);
        String currentName;
        String currentSurname;
        for (int i = 0; i < input.length; ++i) {
            currentSurname = null;
            if (!input[i].isEmpty()) {
                currentName = input[i].split(" ")[0];
                if (input[i].split(" ").length > 1) {
                    currentSurname = input[i].split(" ")[1];
                }
                ans.add(new Contact(currentName, currentSurname));
            }
        }
        switch (mode) {
            case "ASC" -> ans.sort(lexicalASCComp);
            case "DESC" -> ans.sort(lexicalDESCComp);
            default -> {
                return new Contact[0];
            }
        }
        Contact[] tempArr = new Contact[ans.toArray().length];
        return ans.toArray(tempArr);
    }

    record Contact(String name, String surname) {
    }
}
