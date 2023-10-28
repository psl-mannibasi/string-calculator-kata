package com.katas.calculator.step5;

import com.katas.calculator.Calculator;

public class StringCalculatorStep5 implements Calculator {

    private static final int ZERO = 0;
    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static final String NON_DIGITS = "\\D++";
    private static final String NEGATIVE_NUMBER = ".*?(-\\d++).*";


    // STEP 5 - V1
//    @Override
//    public int add(final String numbers) throws NumberFormatException {
//
//        if (numbers.isEmpty()) {
//            return ZERO;
//        }
//
//        String rgx = ".*?(-\\d++).*";
//        if (numbers.matches(rgx)) {
//            throw new NumberFormatException(throwExceptionWithNegativeNumbers(numbers, rgx).toString());
//        }
//
//        final String[] numbersArray = numbers.replaceAll("\\D++", " ")
//                .trim()
//                .split(" ");
//
//        int result = 0;
//        for (String number : numbersArray) {
//            result += Integer.parseInt(number);
//        }
//
//        return result;
//    }
//
//    private static StringBuilder throwExceptionWithNegativeNumbers(final String numbers, final String rgx) {
//        String str = numbers;
//        StringBuilder stringBuilder = new StringBuilder("error: negatives not allowed: ");
//
//        do {
//            String negativeNumber = str.replaceFirst(rgx, "$1");
//            stringBuilder.append(negativeNumber);
//
//            boolean stillHasNegativeNumber = (str = str.replaceFirst(negativeNumber, "")).matches(rgx);
//            if (stillHasNegativeNumber) {
//                stringBuilder.append(' ');
//            }
//        } while (str.matches(rgx));
//
//        return stringBuilder;
//    }

    // STEP 5 - V2
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
            result += Integer.parseInt(number);
        }

        return result;
    }

}
