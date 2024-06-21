package com.alexeyyuditsky.test.example;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

    }

    public static void setListener(MyListener listener) {
        arrayList.add(listener);
        System.out.println(listener.getClass());
    }

    public static void removeListener(MyListener listener) {
        arrayList.add(listener);
        System.out.println(listener.hashCode());
    }

    static ArrayList arrayList = new ArrayList<MyListener>();

}

interface MyListener {
    boolean apply(String value);
}