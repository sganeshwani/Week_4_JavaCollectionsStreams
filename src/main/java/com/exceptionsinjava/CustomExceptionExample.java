package com.exceptionsinjava;

// Create a Custom Exception
class CustomException extends Exception{
    public CustomException(String message){
        super(message);
    }
}

// Main class
public class CustomExceptionExample{
    public static void main(String[] args) {
        // Check for exception
        try{
            validAge(18); // Check whether age is valid or not
            System.out.println("Access granted!");
        }
        // Handle the exception
        catch (CustomException e){
            System.out.println("Custom Exception Caught : " + e.getMessage());
        }
    }

    // Method to check whether age is valid or not
    private static void validAge(int age) throws CustomException{
        if(age < 18) {
            throw new CustomException("Age must be 18 or above");
        }
    }
}
