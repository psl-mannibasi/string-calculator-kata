package com.katas.calculator.step8;

import com.katas.calculator.Calculator;

public class StringCalculatorStep8 implements Calculator {

    private static final int ZERO = 0;
    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static final String NON_DIGITS = "\\D++";
    private static final String NEGATIVE_NUMBER = ".*?-\\d++.*";

    // STEP 8
    @Override
    public int add(final String numbers) throws NumberFormatException {

        if (numbers.isEmpty()) {
            return ZERO;
        }

        if (numbers.matches(NEGATIVE_NUMBER)) {
            StringBuilder builder = new StringBuilder("error: negatives not allowed: ");

            final String[] numbersArray = numbers.split(COMMA);
            String negativeNumber;
            for (int idx = 0, arrLength = numbersArray.length; idx < arrLength; idx++) {

                if ((negativeNumber = numbersArray[idx]).matches(NEGATIVE_NUMBER)) {
                    if (idx == arrLength - 1) {
                        builder.append(negativeNumber);
                    } else {
                        builder.append(negativeNumber).append(SPACE);
                    }
                }
            }

            throw new NumberFormatException(builder.toString().trim());
        }

        final String[] numbersArray = numbers.replaceAll(NON_DIGITS, SPACE)
                .trim()
                .split(SPACE);

        int result = 0;
        for (int parsedInt, idx = 0; idx < numbersArray.length; idx++) {

            if ((parsedInt = Integer.parseInt(numbersArray[idx])) <= 1000) {
                result += parsedInt;
            }
        }

        return result;
    }
}
