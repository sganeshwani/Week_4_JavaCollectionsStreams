package com.regex.basicregexproblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HexColorValidator {

    public static boolean isValidHexColor(String hexColor) {
        String regex = "^#[0-9A-Fa-f]{6}$";
        //Create a pattern object
        Pattern pattern = Pattern.compile(regex);

        //Create a matcher object
        Matcher matcher = pattern.matcher(hexColor);

        //Check if the hexColor matches the regex
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] hexColors = {"#FFA500", "#ff4500", "#123"};
        for (String hexColor : hexColors) {
            System.out.println(hexColor + ": " + (isValidHexColor(hexColor) ? "valid" : "invalid"));
        }
    }
}