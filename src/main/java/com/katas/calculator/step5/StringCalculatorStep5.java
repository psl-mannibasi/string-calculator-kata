package com.katas.calculator.step5;

import com.katas.calculator.Calculator;

import java.util.Optional;

public class StringCalculatorStep5 implements Calculator {

    @Override
    public int add(final String input) {

        if (input.isEmpty()) {
            return 0;
        }

        char[] chars = input.toCharArray();

        Optional<StringBuilder> errorMessage = Optional.empty();
        int result = 0;

        for (int idx = 0, prevChar = idx - 1, digit; idx < chars.length; ++idx, ++prevChar) {

            char aChar = chars[idx];
            if (Character.isDigit(aChar)) {

                digit = Character.getNumericValue(aChar);

                if (prevChar >= 0 && chars[prevChar] == '-') {

                    if (!errorMessage.isPresent()) {
                        errorMessage = Optional.of(new StringBuilder("error: negatives not allowed:"));
                    }

                    errorMessage.get().append(' ').append('-').append(digit);

                } else {
                    result += digit;
                }
            }
        }

        if (errorMessage.isPresent()) {
            throw new NumberFormatException(errorMessage.get().toString());
        }

        return result;
    }

}
