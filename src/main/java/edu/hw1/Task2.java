package edu.hw1;

public class Task2 {

    private Task2() {
    }

    //final static int LIMIT_OF_CAPACITY = 16;
    final static int DIVIDER = 10;

    static int countDigits(double number) { //task_2
        int ans = 0;
        double numberCopy = Math.abs(number);
        if (number == 0) {
            return 1;
        }
        while (numberCopy >= 1) {
            numberCopy /= DIVIDER;
            ans += 1;
        }
//        number -= (long) number;
//        while (Math.abs(number - (int) number) > 1e-16 && ans <= LIMIT_OF_CAPACITY) {
//        /*если число нецелое, то в double оно
//        хранится в виде мантиссы и степени, при этом в мантиссе может быть
//        максимум шестнадцать знаков (по крайней мере на моем компьютере),
//        так что продолжать цикл дальше бесполезно для нецелых чисел большей длины)*/
//            number *= DIVIDER;
//            ans += 1;
//        }
//        if (Math.abs(number - (int) number) > 1e-16 && ans == LIMIT_OF_CAPACITY) {
//            return -1;
//        }
        return ans;
    }
}
