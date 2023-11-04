package com.katas.calculator.step4;

import com.katas.calculator.Calculator;

public class StringCalculatorStep4 implements Calculator {



    @Override
    public int add(final String input) {

        if (input.isEmpty()) {
            return 0;
        }

        int result = 0;
        for (char aChar: input.toCharArray()) {

            if(Character.isDigit(aChar)) {
                result += Character.getNumericValue(aChar);
            }

        }

        return result;
    }

}
