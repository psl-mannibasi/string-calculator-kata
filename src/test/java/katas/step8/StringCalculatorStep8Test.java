package katas.step8;

import com.katas.calculator.Calculator;
import com.katas.calculator.step8.StringCalculatorStep8;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StringCalculatorStep8Test {

    private final Calculator calculator = new StringCalculatorStep8();

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

    // STEP 2
    @DisplayName("Should return the sum when input as an arbitrary number size")
    @Test
    public void input_with_unknown_size_return_sum() {
        assertThat(calculator.add("1,2,3,4,5,6,7,8,9"))
                .isEqualTo(45);
    }

    // STEP 3
    @DisplayName("Should return the sum when input as a newline separator")
    @Test
    public void input_with_newline_separator_return_sum() {
        assertThat(calculator.add("1\n,2,3"))
                .isEqualTo(6);
    }

    // STEP 4
    @DisplayName("Should return the sum when input as custom separators")
    @Test
    public void input_with_custom_separators_return_sum() {
        assertThat(calculator.add("//;\n1;2"))
                .isEqualTo(3);
    }

    // STEP 5
    @DisplayName("Should throw exception when input negative number(s)")
    @Test
    public void input_with_negative_numbers_should_throw_exception() {
        Assertions.assertThatCode(() -> calculator.add("1,-2,-3"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("error: negatives not allowed: -2 -3");
    }

    // STEP 6
    @DisplayName("Should ignore numbers bigger then 1000 and sum the rest")
    @Test
    public void input_with_numbers_bigger_then_one_thousand_should_sum_only_numbers_less_then_one_thousand() {
        assertThat(calculator.add("1001, 2"))
                .isEqualTo(2);
    }

    // STEP 7
    @DisplayName("Should return sum when input has an arbitrary-length separators")
    @Test
    public void input_with_arbitrary_length_separators_return_sum() {
        assertThat(calculator.add("//[***]\n1***2***3"))
                .isEqualTo(6);
    }

    // STEP 8
    @DisplayName("Should return sum when input has an multiple single-length separators")
    @Test
    public void input_with_multiple_single_length_separators_return_sum() {
        assertThat(calculator.add("//[*][%]\n1*2%3"))
                .isEqualTo(6);
    }

}
