package com.katas.calculator.step3;

import com.katas.calculator.Calculator;

public class StringCalculatorStep3 implements Calculator {



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
