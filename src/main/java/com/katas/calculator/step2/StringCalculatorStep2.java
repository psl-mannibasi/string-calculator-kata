package com.katas.calculator.step2;

import com.katas.calculator.Calculator;

public class StringCalculatorStep2 implements Calculator {



    @Override
    public int add(final String input) {

        if (input.isEmpty()) {
            return 0;
        }

        char[] chars = input.toCharArray();

        int result = 0;
        for (char aChar: chars ) {

            if(Character.isDigit(aChar)) {
                result += Character.getNumericValue(aChar);
            }

        }

        return result;
    }

}
