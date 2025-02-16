package com.annotations.exercises;

// Class with legacy and new methods
public class LegacyAPI {

    // old method marked deprecated
    @Deprecated
    public void oldFeature() {
        System.out.println("Old feature used");
    }

    // new method to use
    public void newFeature() {
        System.out.println("New feature used");
    }

    // main method to demonstrate usage
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();  // warning expected for deprecated method
        api.newFeature();
    }
}