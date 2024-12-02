package com.alexeyyuditsky.test.example.java;

import com.alexeyyuditsky.test.example.other.Test;

public class Java1 {
    public static void main(String[] args) {
        Test.Companion.getValue();
        Test.Companion.test();

        new Test().getClass();
    }
}
