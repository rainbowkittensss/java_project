package edu.hw2;

public class Task2 {
    public class Rectangle {
        private int width;
       protected int height;

        boolean setWidth(int width) {
            this.width = width;
            return false;
        }

        final void setHeight(int height) {
            this.height = height;
        }

        double area() {
            return width * height;
        }
    }

    public class Square extends Rectangle {
        private int length;

    }
}
