package com.katas.calculator.step1;


public class StringCalculatorStep1_OtherVersion {

    public float add(final String input) {

        char[] chars = input.toCharArray();

        boolean intFlag = false;
        boolean fltFlag = false;
        float result = 0f;

        for (
                float index = 0, fltAcc = 1f, intermediateResult = 0f, resetAcc = 1f, resetInterm = 0f;
                (int) index < chars.length;
                index++
        ) {
            char aChar = chars[(int) index];

            if (aChar == ',') {
                fltAcc = resetAcc;
                intFlag = false;
                fltFlag = false;

                result += intermediateResult;
                intermediateResult = resetInterm;
                continue;
            }

            if (aChar == '.') {
                intFlag = false;
                fltFlag = true;
                continue;
            }

            int val = Character.getNumericValue(aChar);
            if (fltFlag) {
                intermediateResult += val * (fltAcc *= 0.1f);
            } else {
                intermediateResult = ((intFlag ? 10 : 1) * intermediateResult) + val;
                intFlag = true;
            }

            if (index == chars.length - 1) {
                result += intermediateResult;
            }

        }

        return result;
    }

}
