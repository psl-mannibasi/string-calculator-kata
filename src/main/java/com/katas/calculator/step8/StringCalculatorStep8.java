package com.katas.calculator.step8;

import com.katas.calculator.Calculator;

public class StringCalculatorStep8 implements Calculator {

    private static final int ZERO = 0;
    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static final String NON_DIGITS = "\\D++";
    private static final String NEGATIVE_NUMBER = ".*?(-\\d++).*";

    // STEP 8
    @Override
    public int add(final String numbers) throws NumberFormatException {

        if (numbers.isEmpty()) {
            return ZERO;
        }

        if (numbers.matches(NEGATIVE_NUMBER)) {
            StringBuilder builder = new StringBuilder("error: negatives not allowed: ");

            for (String number : numbers.split(COMMA)) {
                int num = Integer.parseInt(number);

                if (num < 0) {
                    builder.append(num).append(SPACE);
                }
            }
            throw new NumberFormatException(builder.toString().trim());
        }

        final String[] numbersArray = numbers.replaceAll(NON_DIGITS, SPACE)
                .trim()
                .split(SPACE);

        int result = 0;
        for (String number : numbersArray) {
            int parsedInt;
            result += (parsedInt = Integer.parseInt(number)) > 1000
                    ? 0
                    : parsedInt;
        }

        return result;
    }
}
