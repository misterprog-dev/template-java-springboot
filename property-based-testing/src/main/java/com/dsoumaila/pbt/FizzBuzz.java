package com.dsoumaila.pbt;

public class FizzBuzz {

    public static final String FIZZBUZZ = "fizzbuzz";
    public static final String FIZZ = "fizz";
    public static final String BUZZ = "buzz";

    public String display(int value) {
        if (isMultipleOfThree(value) && isMultipleOfFive(value)) return FIZZBUZZ;
        if (isMultipleOfThree(value)) return FIZZ;
        if (isMultipleOfFive(value)) return BUZZ;
        return String.valueOf(value);
    }

    private boolean isMultipleOfFive(int value) {
        return value % 5 == 0;
    }

    private boolean isMultipleOfThree(int value) {
        return value % 3 == 0;
    }
}
