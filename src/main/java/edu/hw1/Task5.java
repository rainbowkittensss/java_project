package edu.hw1;

public class Task5 {

    private Task5() {
    }

    static boolean isPalindromeStringBuilder(StringBuilder string, int length) {
        StringBuilder temporary = new StringBuilder(string);
        return length > 1 && string.substring(0, length / 2).equals(temporary.reverse().substring(0, length / 2));
    }

    static boolean isPalindromeDescendant(long number) {    //task_5
        StringBuilder strDigits = new StringBuilder(String.valueOf(number));
        StringBuilder resultString = new StringBuilder();
        int length = strDigits.length();
        if (length == 1) {
            return true;
        }
        while (length > 1 && !isPalindromeStringBuilder(strDigits, length)) {
            resultString.delete(0, length);
            int i;
            for (i = 0; i < length - 1; i += 2) {

                resultString.append(Integer.parseInt(strDigits.substring(i, i + 1))
                    + Integer.parseInt(strDigits.substring(i + 1, i + 2)));
            }
            if (i < length) {
                resultString.append(strDigits.charAt(i));
            }
            strDigits.delete(0, length);
            length = resultString.length();
            strDigits.append(resultString);

        }
        return isPalindromeStringBuilder(strDigits, length);
    }

}
