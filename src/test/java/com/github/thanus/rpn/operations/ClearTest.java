package com.github.thanus.rpn.operations;

import com.github.thanus.rpn.CalculatorContext;
import com.github.thanus.rpn.Operand;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class ClearTest {

    @Test
    void shouldClearCalculatorContext() {
        final var calculatorContext = new CalculatorContext();
        calculatorContext.push(new Operand(new BigDecimal(5)));
        calculatorContext.push(new Operand(new BigDecimal(2)));

        new Clear().operate(calculatorContext);

        assertThat(calculatorContext.size()).isEqualTo(0);
    }
}
