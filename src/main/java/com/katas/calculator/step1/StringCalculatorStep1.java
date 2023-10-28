package com.katas.calculator.step1;

import com.katas.calculator.Calculator;

public class StringCalculatorStep1 implements Calculator {

    private static final int ZERO = 0;

    // STEP 1
    @Override
    public int add(final String numbers) {

        if (numbers.isEmpty()) {
            return ZERO;
        }

        int result = 0;
        for (String number : numbers.split(",")) {
            result += Integer.parseInt(number);
        }

        return result;
    }

}
