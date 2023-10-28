package com.katas.calculator.step4;

import com.katas.calculator.Calculator;

public class StringCalculatorStep4 implements Calculator {

    private static final int ZERO = 0;
    private static final String SPACE = " ";
    private static final String NON_DIGITS = "\\D++";

    // STEP 4
    @Override
    public int add(final String numbers) {

        if (numbers.isEmpty()) {
            return ZERO;
        }

        final String[] numbersArray = numbers.replaceAll(NON_DIGITS, SPACE)
                .trim()
                .split(SPACE);

        int result = 0;
        for (String number : numbersArray) {
            result += Integer.parseInt(number);
        }

        return result;
    }

}
