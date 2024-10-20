package com.alexeyyuditsky.test.example.java;

public class ListenerManager {

    public void addListener(Runnable listener) {
        System.out.println("added: " + listener);
    }

    public void removeListener(Runnable listener) {
        System.out.println("removed: " + listener);
    }

}

