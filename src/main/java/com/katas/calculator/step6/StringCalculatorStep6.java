package com.katas.calculator.step6;

import com.katas.calculator.Calculator;

import java.util.Optional;

public class StringCalculatorStep6 implements Calculator {

    @Override
    public int add(final String input) {

        if (input.isEmpty()) {
            return 0;
        }

        char[] chars = input.toCharArray();

        Optional<StringBuilder> errorMessage = Optional.empty();
        int result = 0;

        for (int idx = 0, prevIdx = idx - 1, nextIdx = idx + 1, lastIdx = chars.length - 1, currentNumber = 0, digit;
             idx <= lastIdx;
             ++idx, ++prevIdx, ++nextIdx)
        {

            char aChar = chars[idx];
            if (Character.isDigit(aChar)) {

                digit = Character.getNumericValue(aChar);

                if (prevIdx >= 0 && chars[prevIdx] == '-') {

                    if (!errorMessage.isPresent()) {
                        errorMessage = Optional.of(new StringBuilder("error: negatives not allowed:"));
                    }

                    errorMessage.get().append(' ').append('-').append(digit);

                } else {

                    currentNumber = (currentNumber * 10) + digit;

                    if (idx == lastIdx || !Character.isDigit(chars[nextIdx])) {

                        if (currentNumber <= 1000) {
                            result += currentNumber;
                        }

                        currentNumber = 0;
                    }
                }
            }
        }

        if (errorMessage.isPresent()) {
            throw new NumberFormatException(errorMessage.get().toString());
        }

        return result;
    }

}
