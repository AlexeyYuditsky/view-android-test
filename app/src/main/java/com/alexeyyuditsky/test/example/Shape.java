package com.alexeyyuditsky.test.example;

public abstract class Shape {
    private Shape() {}

    public abstract void draw();

    public static Shape createCircle() {
        return new Circle();
    }

    public static Shape createSquare() {
        return new Square();
    }

    private static class Circle extends Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a circle");
        }
    }

    private static class Square extends Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a square");
        }
    }
}
