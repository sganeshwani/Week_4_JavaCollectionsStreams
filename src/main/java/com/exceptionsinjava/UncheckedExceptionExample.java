package com.exceptionsinjava;

import java.util.*;

public class UncheckedExceptionExample {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter dividend: ");
            int number1 = input.nextInt(); // user input for dividend
            System.out.println("Enter divisor: ");
            int number2 = input.nextInt(); // user input for divisor
            System.out.println(number1/number2);
        } catch (ArithmeticException e) { // executes when divisor is 0
            System.out.println("Division by zero is not possible");
        } catch (InputMismatchException e) { // executes when there is incorrect value
            System.out.println("Please enter a valid value");
        }
    }
}
