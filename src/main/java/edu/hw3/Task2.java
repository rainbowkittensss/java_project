package edu.hw3;

import java.util.ArrayList;
import java.util.Stack;

public class Task2 {
    private Task2() {
    }



    public static String[] clusterize(String brackets) {
        Stack<Character> stack = new Stack<>();
        StringBuilder currentStringForAns = new StringBuilder();
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < brackets.length(); ++i) {
            currentStringForAns.append(brackets.charAt(i));
            if ('(' == brackets.charAt(i)) {
                stack.push('(');
            } else {
                stack.pop();
            }
            if (stack.empty()) {
                ans.add(currentStringForAns.toString());
                currentStringForAns = new StringBuilder();
            }
        }
        return ans.toArray(new String[0]);
    }
}
