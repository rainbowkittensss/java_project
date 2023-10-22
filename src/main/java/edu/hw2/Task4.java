package edu.hw2;

import java.util.Iterator;
import static edu.hw1.Main.LOGGER;

public class Task4 {
    public record CallingInfo(String className, String methodName) {}
    public static CallingInfo getCallingInfo(){
        Throwable throwable = new Throwable();
       StackTraceElement[] stacks = throwable.getStackTrace();
        return new CallingInfo(stacks[1].getClassName(),stacks[1].getMethodName());
    }

}
