package com.github.thanus.rpn.operations.math;

import com.github.thanus.rpn.CalculatorContext;
import com.github.thanus.rpn.Operand;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class SubtractionTest {

    @Test
    void operate() {
        final var calculatorContext = new CalculatorContext();
        calculatorContext.push(new Operand(new BigDecimal(5)));
        calculatorContext.push(new Operand(new BigDecimal(2)));

        new Subtraction().operate(calculatorContext);

        assertThat(calculatorContext.size()).isEqualTo(1);
        assertThat(calculatorContext.peek()).isEqualTo(new Operand(new BigDecimal(3)));
    }
}
