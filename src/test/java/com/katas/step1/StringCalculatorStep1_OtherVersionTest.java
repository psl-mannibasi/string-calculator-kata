package com.katas.step1;

import com.katas.calculator.step1.StringCalculatorStep1_OtherVersion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorStep1_OtherVersionTest {

    private final StringCalculatorStep1_OtherVersion calculator = new StringCalculatorStep1_OtherVersion();

    // STEP 1
    @DisplayName("Should return 0 when input is empty")
    @Test
    public void empty_input_return_0() {
        assertThat(calculator.add(""))
                .isEqualTo(0);
    }

    @DisplayName("Should return the same number when input is a single number")
    @Test
    public void empty_single_number_return_the_same_single_number() {
        assertThat(calculator.add("4"))
                .isEqualTo(4);
    }

    @DisplayName("Should return the sum when input is more than a single number")
    @Test
    public void input_two_numbers_return_sum() {
        assertThat(calculator.add("1,2"))
                .isEqualTo(3);
    }

    @Test
    public void test() {
        String input = "1,1,1.1";
        assertThat(calculator.add(input))
                .isEqualTo(3.1f);
    }

    @Test
    public void test_2() {
        String input = "134,1,1.1,88.054";
        assertThat(calculator.add(input))
                .isEqualTo(224.154f);
    }

}
