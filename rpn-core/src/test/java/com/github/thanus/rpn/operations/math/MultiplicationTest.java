package com.github.thanus.rpn.operations.math;

import com.github.thanus.rpn.CalculatorContext;
import com.github.thanus.rpn.CalculatorException;
import com.github.thanus.rpn.Operand;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MultiplicationTest {

    @Test
    void shouldMultiplyTwoNumbers() throws CalculatorException {
        final var calculatorContext = new CalculatorContext();
        calculatorContext.push(new Operand(new BigDecimal(5)));
        calculatorContext.push(new Operand(new BigDecimal(2)));

        new Multiplication().operate(calculatorContext, new ArrayDeque<>());

        assertThat(calculatorContext.size()).isEqualTo(1);
        assertThat(calculatorContext.peek()).isEqualTo(new Operand(new BigDecimal(10)));
    }

    @Test
    void shouldFailWhenMultiplicationWithoutOperands() {
        assertThatThrownBy(() ->
                new Multiplication().operate(new CalculatorContext(), new ArrayDeque<>())
        );
    }

}
