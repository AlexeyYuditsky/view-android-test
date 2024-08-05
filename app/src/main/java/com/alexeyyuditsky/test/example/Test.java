package com.alexeyyuditsky.test.example;

public class Test {
    public static void main(String[] args) {
        Shape circle = Shape.createCircle();
        Shape square = Shape.createSquare();

        circle.draw();
        square.draw();
    }
}

