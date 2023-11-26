package edu.hw7;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {
    static long factorial(int arg){
        List<Long> arr = new ArrayList<>(arg);
        for(int i=1;i<=arg;++i) arr.set(i-1, (long) i);
        return arr.parallelStream().reduce(1L, (x, y)->x*y);
    }
}
