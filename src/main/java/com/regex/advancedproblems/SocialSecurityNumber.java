package com.regex.advancedproblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SocialSecurityNumber {

    public static boolean isNumberValidOrNot(String result) {
        //Regex pattern
        String regex = "\\d{3}-\\d{2}-\\d{4}";

        //Create a pattern object
        Pattern pattern = Pattern.compile(regex);

        //Create a matcher object
        Matcher matcher = pattern.matcher(result);

        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] answer = {"123-45-6789", "123456789"};
        for (String result : answer) {
            System.out.println(result + ": " + (isNumberValidOrNot(result) ? "valid" : "invalid"));
        }
    }
}