package com.katas.calculator.step3;

import com.katas.calculator.Calculator;

public class StringCalculatorStep3 implements Calculator {

    private static final int ZERO = 0;
    private static final String COMMA = ",";
    private static final String NEWLINE = "\n";
    private static final String EMPTY = "";

    // STEP 3
    @Override
    public int add(final String numbers) {

        if (numbers.isEmpty()) {
            return ZERO;
        }

        int result = 0;
        for (String number : numbers.replace(NEWLINE, EMPTY).split(COMMA)) {
            result += Integer.parseInt(number);
        }

        return result;
    }

}
