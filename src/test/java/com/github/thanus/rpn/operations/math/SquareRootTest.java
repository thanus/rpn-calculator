package com.github.thanus.rpn.operations.math;

import com.github.thanus.rpn.CalculatorContext;
import com.github.thanus.rpn.Operand;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class SquareRootTest {

    @Test
    void shouldSquareRootNumber() {
        final var calculatorContext = new CalculatorContext();
        calculatorContext.push(new Operand(new BigDecimal(2)));

        new SquareRoot().operate(calculatorContext);

        assertThat(calculatorContext.size()).isEqualTo(1);
        assertThat(calculatorContext.peek().getValue().toString()).isEqualTo("1.414213562373095");
    }
}
