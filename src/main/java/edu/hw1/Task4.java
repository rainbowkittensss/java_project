package edu.hw1;

public class Task4 {

    private Task4() {
    }

    static String fixString(String str) {   //task_4
        char[] ans = new char[str.length()];
        if (str.length() == 1) {
            return String.valueOf(str.charAt(0));
        } else {
            int i;
            for (i = 0; i < str.length() - 2; i += 2) {
                ans[i] = str.charAt(i + 1);
                ans[i + 1] = str.charAt(i);
            }
            if (i == str.length() - 1) {
                ans[i] = str.charAt(i);
            } else {
                ans[i] = str.charAt(i + 1);
                ans[i + 1] = str.charAt(i);

            }
        }
        return String.copyValueOf(ans);
    }

}
