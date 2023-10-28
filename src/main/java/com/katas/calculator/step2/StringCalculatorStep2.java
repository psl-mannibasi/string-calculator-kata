package com.katas.calculator.step2;

import com.katas.calculator.Calculator;

public class StringCalculatorStep2 implements Calculator {

    private static final int ZERO = 0;
    private static final String COMMA = ",";

    // STEP 2
    @Override
    public int add(final String numbers) {

        if (numbers.isEmpty()) {
            return ZERO;
        }

        int result = 0;
        for (String number : numbers.split(COMMA)) {
            result += Integer.parseInt(number);
        }

        return result;
    }

}
