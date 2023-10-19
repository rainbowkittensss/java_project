package edu.hw1;

public class Task3 {

    private Task3() {
    }

    static double min(double[] arr) {
        double min = arr[0];
        for (double value
            : arr) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    static double max(double[] arr) {
        double max = arr[0];
        for (double value
            : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    static boolean isNestable(double[] arr1, double[] arr2) {   //task_3
        return arr2.length > 1
            && arr1.length > 0
            && max(arr1) < max(arr2)
            && min(arr1) > min(arr2);
    }
}
