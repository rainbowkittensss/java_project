package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class Task3<E> {
    public Map<E, Integer> freqDict(E[] list) {
        Map<E, Integer> ans = new HashMap<>();
        for (var element
            : list) {
            if (!ans.containsKey(element)) {
                ans.put(element, 1);
            } else {
                ans.replace(element, ans.get(element) + 1);
            }
        }
        return ans;
    }

}
