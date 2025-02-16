package com.annotations.exercises;

import java.util.ArrayList;

public class SuppressUncheckedExample {

    // method to process list without generics
    @SuppressWarnings("unchecked")
    public void processList() {
        ArrayList list = new ArrayList();
        list.add("Hello");
        // cast to String to simulate unchecked operation
        String value = (String) list.get(0);
        System.out.println(value);
    }

    // main method to run the example
    public static void main(String[] args) {
        new SuppressUncheckedExample().processList();
    }
}